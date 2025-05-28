package com.example.demo2.service;

import com.example.demo2.model.Like;
import com.example.demo2.model.Song;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LikeSongService {

    void addlikeSong(HttpServletRequest request, String songname);

    void deletelikeSong(HttpServletRequest request, String songname);

    List<Song> selectAllLike(HttpServletRequest request);

    List<Like> getAllRecords();

}
