package com.example.demo2.service.impl;

import com.example.demo2.mapper.*;
import com.example.demo2.model.Like;
import com.example.demo2.model.Song;
import com.example.demo2.model.User;
import com.example.demo2.service.PersonalRecService;
import com.example.demo2.utils.Static;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;

/**
 * @Author: Liujiang
 * @Date: 2020/4/5 14:37
 */

@Service
public class PersonalRecServiceImpl implements PersonalRecService {
    @Autowired
    private PersonalRecMapper personalRecMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SongMapper songMapper;

    public List<Song> getPersonalDailyRecWithCollectionFlag(HttpServletRequest request) {
        List<Song> personalRecList = new ArrayList<Song>();
        List<Song> resultList = new ArrayList<>();
        User user = userMapper.selectByEmail((String) request.getSession().getAttribute("user"));
        /* =============================================================== */
        personalRecList=selectPersonalRec(user);
        if (null!= personalRecList && personalRecList.size()>0){
            for (int i = 0; i <personalRecList.size() ; i++) {
                resultList.add(songMapper.selectSongById(personalRecList.get(i).getSongId()));
            }
        }
        return resultList;
    }

    /**
     * 每天早上6点更新个性化推荐列表，从更新后的表中读取记录
     * 这里采用两张表交替的方式来实现：
     * （1）	6点之后就从另外一张表中读取记录
     * （2）	重新开始计算新的个性化推荐列表存放于原来的表中的
     * @param user
     * @return
     */
    private List<Song> selectPersonalRec(User user) {
        if(user==null) return null;
        List<Song> personalRecList = new ArrayList<Song>();
        if(!Static.isFromA) {
            personalRecList= personalRecMapper.selectPersonalRecFromA(user);
        }else {
            personalRecList= personalRecMapper.selectPersonalRecFromB(user);
        }
        return personalRecList;
    }

    public void initializePersonalRecList(HttpServletRequest request) {
        final User user =  userMapper.selectByEmail((String) request.getSession().getAttribute("user"));
        List<Song> initialRecListA;
        List<Song> initialRecListB = new ArrayList<Song>();
        //从新歌中随机获取12首，作为初始化列表
        initialRecListA= songMapper.getManyNewSong();
        for(int i=0;i<48;i++) {
            int len=initialRecListA.size();
            Random random=new Random();
            int index=random.nextInt(len);
            if(i<12) {
                initialRecListB.add(initialRecListA.get((index+1)%len));
            }
            initialRecListA.remove(index);
        }
        if(Static.isFromA) {
            personalRecMapper.insertListIntoRecA(initialRecListA,user.getId());
        }else {
            personalRecMapper.insertListIntoRecB(initialRecListB,user.getId());
        }

    }

    public void updatePersonalRecIntoB(Map<Integer, Integer[]> user2song) {
        // TODO Auto-generated method stub
        user2song.forEach(new BiConsumer<Integer,Integer[]>(){

            public void accept(Integer userId, Integer[] recSongIds) {
                // TODO Auto-generated method stub
                personalRecMapper.deleteBByUserId(userId);
                //批量插入
                personalRecMapper.insertArrayIntoRecB(recSongIds,userId);

            }

        });

    }

    public void updatePersonalRecIntoA(Map<Integer, Integer[]> user2song) {
        // TODO Auto-generated method stub
        user2song.forEach(new BiConsumer<Integer,Integer[]>(){

            public void accept(Integer userId, Integer[] recSongIds) {
                // TODO Auto-generated method stub
                personalRecMapper.deleteAByUserId(userId);
                //批量插入
                personalRecMapper.insertArrayIntoRecA(recSongIds,userId);

            }

        });

    }


}
