package com.example.demo2.service.impl;

import com.example.demo2.mapper.PlayRecordMapper;
import com.example.demo2.mapper.SongMapper;
import com.example.demo2.mapper.UserMapper;
import com.example.demo2.model.PlayRecord;
import com.example.demo2.model.Song;
import com.example.demo2.model.User;
import com.example.demo2.service.RecordPlayService;
import com.sun.org.apache.xpath.internal.objects.XNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecordPlayServiceImpl implements RecordPlayService {

    @Autowired
    private SongMapper songMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PlayRecordMapper playRecordMapper;


    @Override
    public void recordPlay(HttpServletRequest request, String title) {
        if(request.getSession().getAttribute("user")==null)
            return;
        int songId = songMapper.selectIdByName(title);
        int uerId = userMapper.selectByEmail((String) request.getSession().getAttribute("user")).getId();
        PlayRecord playRecord = new PlayRecord(uerId,songId,new Date());
        playRecordMapper.insert(playRecord);
    }

    @Override
    public List<Song> selectAllRecord(HttpServletRequest request) {
        if(request.getSession().getAttribute("user")==null)
            return null;
        else {
            int userId = userMapper.selectByEmail((String) request.getSession().getAttribute("user")).getId();

            List<Integer> songIdList = playRecordMapper.selectRecordById(userId);
            List<Song> songList = new ArrayList<>();
            for (Integer integer : songIdList) {
                songList.add(songMapper.selectSongById(integer));
            }
            return songList;
        }
    }

    @Override
    public List<PlayRecord> getAllRecords() {
        return playRecordMapper.selectAll();
    }

    @Override
    public List<Song> getTopRecords() {
        List<Integer> songIdList = playRecordMapper.selectTopSongs();
        List<Song> songList = new ArrayList<>();
        for (Integer integer : songIdList) {
            songList.add(songMapper.selectSongById(integer));
        }
        return songList;
    }
}
