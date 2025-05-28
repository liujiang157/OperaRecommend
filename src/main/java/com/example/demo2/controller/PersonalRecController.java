package com.example.demo2.controller;

import com.example.demo2.model.Song;
import com.example.demo2.service.LikeSongService;
import com.example.demo2.service.PersonalRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Liujiang
 * @Date: 2020/4/7 21:06
 */
@Controller
public class PersonalRecController {
    @Autowired
    private PersonalRecService personalRecService;
    @Autowired
    private LikeSongService likeSongService;

    @RequestMapping(value = "personalizedRecFrameLoad.do",method = { RequestMethod.GET })
    public String personalizedRecFrameLoad(HttpServletRequest request,Model model) {
        List<Song> personalRecSongList=personalRecService.getPersonalDailyRecWithCollectionFlag(request);
        List<Song> likelist = likeSongService.selectAllLike(request);
        List<String> songNamelist = new ArrayList<>();
        if(likelist!=null){
            for (Song song : likelist) {
                songNamelist.add(song.getSongName());
            }
        }
        model.addAttribute("likelist", songNamelist);
        model.addAttribute("personalRecSongList",personalRecSongList);
        return "index::personalizedRecFrame";
    }
}
