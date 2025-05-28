package com.example.demo2.controller;

import com.example.demo2.model.Song;
import com.example.demo2.service.LikeSongService;
import com.example.demo2.service.RecordPlayService;
import com.example.demo2.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;





@Controller
public class MyMusicController {

    @Autowired
    private LikeSongService likeSongService;

    @Autowired
    private RecordPlayService recordPlayService;




    //个人戏曲中心
    @RequestMapping("/listen")
    public String listen(HttpServletRequest request,Model model){
        List<Song> likelist = likeSongService.selectAllLike(request);
        List<Song> recordlist = recordPlayService.selectAllRecord(request);
        model.addAttribute("likelist", likelist);
        model.addAttribute("recordlist", recordlist);
        return "listen";
    }











}
