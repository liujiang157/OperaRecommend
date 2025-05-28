package com.example.demo2.controller;

import com.example.demo2.model.Video;
import com.example.demo2.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Liujiang
 * @Date: 2020/4/10 16:52
 */

@Controller
public class CommunityVideoController {
    @Autowired
    private VideoService videoService;

    //社区MV页面
    @RequestMapping("/video")
    public String genres(HttpServletRequest request, Model model,
                         @RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "size", defaultValue = "12") Integer size,
                         @RequestParam(value = "search", required = false) String search,
                         @RequestParam(value = "songtype",defaultValue = "") String songType){
        int totalpage = videoService.getTotalCount(search) % size == 0 ? videoService.getTotalCount(search) / size : videoService.getTotalCount(search) / size + 1;
        if (page < 1) {
            page = 1;
        }
        if (page > totalpage) {
            page = totalpage;
        }
        List<Integer> pagelist = new ArrayList<>();
        for (int i = 1; i <= totalpage; i++) {
            pagelist.add(i);
        }
        List<Video> videoList = videoService.list(page, size, search);
        List<Video> videorecList = videoService.listrec();
        model.addAttribute("videoList", videoList);
        model.addAttribute("pagelist", pagelist);
        model.addAttribute("currentpage", page);
        model.addAttribute("videorecList", videorecList);
        return "video";
    }



    @RequestMapping("/videodetail")
    public String videodetail(Model model,@RequestParam(value = "videoid") String videoid) {
        Video video = videoService.slectVideoById(videoid);
        model.addAttribute("video", video);
        return "video-detail";
    }



}
