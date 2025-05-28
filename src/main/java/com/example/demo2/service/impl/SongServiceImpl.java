package com.example.demo2.service.impl;

import com.example.demo2.mapper.SongMapper;
import com.example.demo2.model.Song;
import com.example.demo2.model.User;
import com.example.demo2.service.SongService;
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

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongMapper songMapper;

    //前端检查过了 这里方便起见默认返回true
    @Override
    public boolean checkFormat(MultipartFile song, MultipartFile cover) {
        return true;
    }

    /**
     * 上传戏曲
     * @param request
     * @param song
     * @param cover
     * @param songname
     * @param selection
     * @return
     */
    @Override
    public boolean addSong(HttpServletRequest request, MultipartFile song, MultipartFile cover, String songname,String songartist, String selection) {
        //传到七牛云 回调路径信息利用songmapper插入数据库
        boolean isInsertSuccessful=false;
        int affectedRows=-1;
        if(song.isEmpty()){
            return isInsertSuccessful;
        }
        if(cover.isEmpty()) {
            //给个静态图片当封面
            int num = (int) (Math.random()*(22-0));
            String coverAddress="images/m"+num+".jpg";
            //保存戏曲文件
            String songAddress=saveFile(song);
            affectedRows=songMapper.insertSongWithCover(new Song(songname,songAddress,coverAddress,selection,songartist,new Date()));
        }else {
            String songAddress=saveFile(song);
            String coverAddress=saveFile(cover);
            affectedRows=songMapper.insertSongWithCover(new Song(songname,songAddress,coverAddress,selection,songartist,new Date()));
        }
        if(affectedRows>0) {
            isInsertSuccessful=true;
        }
        return isInsertSuccessful;
    }

    @Override
    public Integer getTotalCount(String search) {
        if(search==null)
            return songMapper.selectCount();
        else
            return songMapper.selectCountByName(search);
    }

    @Override
    public List<Song> list(Integer page, Integer size, String search) {
        int offset = size*(page-1);
        if(offset<0)
            offset=0;
        List<Song> songList = new ArrayList<>();
        if(search==null)
            songList = songMapper.listByPage(offset,size);
        else
            songList = songMapper.SearchByPage(offset,size,search);
        return songList;
    }


    @Override
    public boolean deleteUserByName(String songid) {
        boolean isDeleteSuccessful=false;
        int affectedRows=songMapper.deleteUserByName(songid);
        if(affectedRows>0) {
            isDeleteSuccessful=true;
        }
        return isDeleteSuccessful;
    }

    @Override
    public Integer getTotalCountByType(String search,String type) {
        if(search==null)
            return songMapper.selectCountByType(type);
        else
            return songMapper.selectCountByTypeAndName(search,type);
    }

    @Override
    public List<Song> listByType(Integer page, Integer size, String search, String songType) {
        int offset = size*(page-1);
        if(offset<0)
            offset=0;
        List<Song> songList = new ArrayList<>();
        if(search==null)
            songList = songMapper.listByTypeAndPage(offset,size,songType);
        else
            songList = songMapper.SearchByPage(offset,size,search);
        return songList;
    }

    @Override
    public List<Integer> getAllSongIdRecords() {
        return songMapper.selectAllSongId();
    }

    @Override
    public List<Song> getNewSong() {
        return songMapper.getNewSong();
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
