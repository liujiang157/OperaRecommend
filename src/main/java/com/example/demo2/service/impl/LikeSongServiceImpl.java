package com.example.demo2.service.impl;

import com.example.demo2.mapper.LikeMapper;
import com.example.demo2.mapper.PlayRecordMapper;
import com.example.demo2.mapper.SongMapper;
import com.example.demo2.mapper.UserMapper;
import com.example.demo2.model.Like;
import com.example.demo2.model.Song;
import com.example.demo2.service.LikeSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LikeSongServiceImpl implements LikeSongService {
    @Autowired
    private SongMapper songMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LikeMapper likeMapper;
    @Override
    public void addlikeSong(HttpServletRequest request, String songname) {
        if(request.getSession().getAttribute("user")==null)
            return;
        int songId = songMapper.selectIdByName(songname);
        int uerId = userMapper.selectByEmail((String) request.getSession().getAttribute("user")).getId();
        Like like = new Like(uerId,songId);
        if(likeMapper.selectrepeat(like)==null)
            likeMapper.insert(like);
    }

    @Override
    public void deletelikeSong(HttpServletRequest request, String songname) {
        if(request.getSession().getAttribute("user")==null)
            return;
        int songId = songMapper.selectIdByName(songname);
        int uerId = userMapper.selectByEmail((String) request.getSession().getAttribute("user")).getId();
        Like like = new Like(uerId,songId);
        //检查是都有收藏 因为有部分bug  不得而已为之的验证 来避免bug  已修复 去掉也可以
        if(likeMapper.selectrepeat(like)!=null)
            likeMapper.delete(like);
    }

    @Override
    public List<Song> selectAllLike(HttpServletRequest request) {
        if(request.getSession().getAttribute("user")==null)
            return null;
        else{
            int uerId = userMapper.selectByEmail((String) request.getSession().getAttribute("user")).getId();
            List<Integer> songIdList = likeMapper.selectAllByUserId(uerId);
            List<Song> songList = new ArrayList<>();
            for (Integer integer : songIdList) {
                songList.add(songMapper.selectSongById(integer));
            }
            return songList;
        }

    }

    @Override
    public List<Like> getAllRecords() {
        return likeMapper.selectAll();
    }

}
