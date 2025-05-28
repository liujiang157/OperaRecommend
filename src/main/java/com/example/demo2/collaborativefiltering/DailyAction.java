package com.example.demo2.collaborativefiltering;

import com.example.demo2.model.DownloadRecord;
import com.example.demo2.model.Like;
import com.example.demo2.model.PlayRecord;
import com.example.demo2.service.*;
import com.example.demo2.utils.Static;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Liujiang
 * @Date: 2020/4/5 14:21
 */
@Component
public class DailyAction implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private PersonalRecService personalRecService;
    @Autowired
    private RecordDownloadService recordDownloadService;
    @Autowired
    private RecordPlayService recordPlayService;
    @Autowired
    private LikeSongService collectionService;
    @Autowired
    private UserService userService;

    @Autowired
    private SongService songService;
    /**
     * 是否第一次初始化
     */
    private static volatile boolean isFirtTimeInit=true;

    public void onApplicationEvent(ApplicationReadyEvent arg0) {
        System.out.println("###-----Spring 容器加载完毕_-_-----###");
        init(arg0);
    }

    private void init(ApplicationReadyEvent arg0) {
        if(isFirtTimeInit) {
            System.out.println("###-----开始Listener_-_-----###");
            ConfigurableApplicationContext applicationContext = arg0.getApplicationContext();
            userService = applicationContext.getBean(UserService.class);
            songService = applicationContext.getBean(SongService.class);
            collectionService =  applicationContext.getBean(LikeSongService.class);
            recordPlayService = applicationContext.getBean(RecordPlayService.class);
            recordDownloadService = applicationContext.getBean(RecordDownloadService.class);
            personalRecService =  applicationContext.getBean(PersonalRecService.class);
            Listener listener=new Listener(new TimerTask() {

                @Override
                public void run() {
                    System.out.println("------------开始执行任务-------------");
                    try {
                        //等待10s再开始执行任务
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    userService.getAllRecords();
                    //更换推荐列表
                    Static.isFromA=!Static.isFromA;
                    //用户-戏曲 推荐列表
                    Map<Integer,Integer[]> user2songRecMatrix=new HashMap<Integer, Integer[]>();
                    //获取用户的下载记录
                    List<DownloadRecord> downloadList=recordDownloadService.getAllRecords();
                    //获取用户的播放记录
                    List<PlayRecord> playList=recordPlayService.getAllRecords();
                    //获取用户的收藏记录
                    List<Like> collectionList=collectionService.getAllRecords();
                    //获取用户
                    List<Integer> userIdList=userService.getAllUserIdRecords();
                    //获取戏曲
                    List<Integer> songIdList=songService.getAllSongIdRecords();
                    //用户-戏曲 “评分”矩阵
                    Map<Integer, float[]> user2songRatingMatrix=UserRating.getFrequencyMatrix(userIdList,songIdList,
                            downloadList,playList,collectionList);
                    //用户相似性计算，获取用户的k个近邻用户
                    Map<Integer,Integer[]> userKNNMatrix=UserKNN.getKNN(userIdList,user2songRatingMatrix,Static.K);
                    //基于用户相似性的协同过滤
                    user2songRecMatrix=CollaborativeFiltering.userKNNBasedCF(userIdList,userKNNMatrix,
                            user2songRatingMatrix,songIdList,Static.N);
                    System.out.println("------------执行任务完成-------------");
                    if(Static.isFromA) {
                        //向B中更新写数据
                        personalRecService.updatePersonalRecIntoB(user2songRecMatrix);
                    }else {
                        //向A中更新写数据
                        personalRecService.updatePersonalRecIntoA(user2songRecMatrix);
                    }
                }

            });
            //开始执行监听
            listener.listen(Static.START_HOUR, Static.START_MINUTE,
                    Static.START_SECOND, Static.PERIOD_DAY, Static.IS_START_TOMORROW);
        }
        isFirtTimeInit=false;
    }

}

