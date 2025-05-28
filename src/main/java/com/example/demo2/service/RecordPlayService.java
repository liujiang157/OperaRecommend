package com.example.demo2.service;

import com.example.demo2.model.PlayRecord;
import com.example.demo2.model.Song;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface RecordPlayService {

    void recordPlay(HttpServletRequest request, String title);

    List<Song> selectAllRecord(HttpServletRequest request);

    List<PlayRecord> getAllRecords();

    List<Song> getTopRecords();
}
