package com.example.demo2.service;

import com.example.demo2.model.Video;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface VideoService {

    boolean addVideo(HttpServletRequest request, MultipartFile video, String videoname, String description);

    boolean checkFormat(MultipartFile song);

    int getTotalCount(String search);

    List<Video> list(Integer page, Integer size, String search);

    boolean deleteVideoByName(String songid);

    boolean recVideoByName(String songid);

    boolean deleterecVideoByName(String songid);

    List<Video> listrec();

    Video slectVideoById(String videoid);
}
