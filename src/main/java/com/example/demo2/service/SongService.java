package com.example.demo2.service;

import com.example.demo2.model.Song;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SongService {
    boolean checkFormat(MultipartFile song, MultipartFile cover);

    boolean addSong(HttpServletRequest request, MultipartFile song, MultipartFile cover, String songname,String songartist, String selection);

    Integer getTotalCount(String search);

    List<Song> list(Integer page, Integer size, String search);

    boolean deleteUserByName(String songid);

    Integer getTotalCountByType(String search,String type);

    List<Song> listByType(Integer page, Integer size, String search, String songType);

    List<Integer> getAllSongIdRecords();

    List<Song> getNewSong();
}
