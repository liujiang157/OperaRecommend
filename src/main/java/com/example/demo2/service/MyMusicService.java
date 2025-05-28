package com.example.demo2.service;

import com.example.demo2.model.Song;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MyMusicService {
    /**
     * 获取当前用户的喜欢列表
     * @param request
     * HttpServletRequest
     * @return
     * 如果没有过喜欢
     */
    List<Song> getMyCollectionWithCollectionFlag(HttpServletRequest request);
    /**
     * 获取当前用户的最近的播放里表，带收藏标记
     * @param request
     * @return
     */
    List<Song> getMyRecentPlayListWithCollectionFlag(HttpServletRequest request);
}
