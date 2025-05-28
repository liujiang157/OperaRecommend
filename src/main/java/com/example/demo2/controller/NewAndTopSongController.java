package com.example.demo2.controller;

import com.example.demo2.model.Song;
import com.example.demo2.service.LikeSongService;
import com.example.demo2.service.RecordPlayService;
import com.example.demo2.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: Liujiang
 * @Date: 2020/4/10 18:25
 */
@Controller
public class NewAndTopSongController {
    @Autowired
    private SongService songService;

    @Autowired
    private RecordPlayService recordPlayService;

    @RequestMapping(value = "NewAndTopSongFrame.do",method = { RequestMethod.GET })
    public String personalizedRecFrameLoad( Model model) {
        List<Song> newSongList=songService.getNewSong();
        List<Song> topSongList = recordPlayService.getTopRecords();
        model.addAttribute("newSongList",newSongList);
        model.addAttribute("topSongList",topSongList);
        return "index::NewAndTopSongFrame";
    }


}
