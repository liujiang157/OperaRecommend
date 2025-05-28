package com.example.demo2.service.impl;

import com.example.demo2.mapper.VideoMapper;
import com.example.demo2.model.Song;
import com.example.demo2.model.Video;
import com.example.demo2.service.VideoService;
import com.example.demo2.utils.Static;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Liujiang
 * @Date: 2020/4/9 17:41
 */

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    //前端检查过了 这里方便起见默认返回true
    @Override
    public boolean checkFormat(MultipartFile song) {
        return true;
    }

    @Override
    public int getTotalCount(String search) {
        if(search==null)
            return videoMapper.selectCount();
        else
            return videoMapper.selectCountByName(search);
    }

    @Override
    public List<Video> list(Integer page, Integer size, String search) {
        int offset = size*(page-1);
        if(offset<0)
            offset=0;
        List<Video> songList = new ArrayList<>();
        if(search==null)
            songList = videoMapper.listByPage(offset,size);
        else
            songList = videoMapper.SearchByPage(offset,size,search);
        return songList;
    }

    @Override
    public boolean deleteVideoByName(String songid) {
        boolean isDeleteSuccessful=false;
        int affectedRows=videoMapper.deleteVideoByName(songid);
        if(affectedRows>0) {
            isDeleteSuccessful=true;
        }
        return isDeleteSuccessful;
    }

    @Override
    public boolean recVideoByName(String songid) {
        boolean isDeleteSuccessful=false;
        int affectedRows=videoMapper.addrecVideo(songid,new Date());
        if(affectedRows>0) {
            isDeleteSuccessful=true;
        }
        return isDeleteSuccessful;
    }

    @Override
    public boolean deleterecVideoByName(String songid) {
        boolean isDeleteSuccessful=false;
        int affectedRows=videoMapper.deleterecVideo(songid,new Date());
        if(affectedRows>0) {
            isDeleteSuccessful=true;
        }
        return isDeleteSuccessful;
    }

    @Override
    public List<Video> listrec() {
        List<Video> songList = new ArrayList<>();
        songList = videoMapper.listRec();
        return songList;
    }

    @Override
    public Video slectVideoById(String videoid) {
        return videoMapper.slectVideoById(videoid);
    }

    /**
     * 上传戏曲
     *
     * @param request
     * @param video
     * @param songname
     * @param description
     * @return
     */
    @Override
    public boolean addVideo(HttpServletRequest request, MultipartFile video, String songname, String description) {
        //传到七牛云 回调路径信息利用songmapper插入数据库
        boolean isInsertSuccessful = false;
        int affectedRows = -1;
        if (video.isEmpty()) {
            return isInsertSuccessful;
        }

        String songAddress = saveFile(video);
        affectedRows = videoMapper.insertVideo(new Video(songname, songAddress, description, new Date()));

        if (affectedRows > 0) {
            isInsertSuccessful = true;
        }
        return isInsertSuccessful;
    }


    //七牛云上传文件
    private String saveFile(MultipartFile multipartFile) {
        String uploadDir = "/Users/maybelence/Downloads/demo2/target/classes/static/images/"; // 本地保存路径（确保这个目录已存在，且有写权限）
        String originalFilename = multipartFile.getOriginalFilename();
        String fileName = System.currentTimeMillis() + "_" + originalFilename;
        File dest = new File(uploadDir + fileName);

        try {
            multipartFile.transferTo(dest);
            return "images/" + fileName;  // 返回相对路径或URL前缀
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
