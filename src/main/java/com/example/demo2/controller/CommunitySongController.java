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

/**
 * @Author: Liujiang
 * @Date: 2020/4/7 13:43
 */

@Controller
public class CommunitySongController {
    @Autowired
    private SongService songService;

    @Autowired
    private LikeSongService likeSongService;

    //社区戏曲页面
    @RequestMapping("/genres")
    public String genres(HttpServletRequest request, Model model,
                         @RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "size", defaultValue = "18") Integer size,
                         @RequestParam(value = "search", required = false) String search,
                         @RequestParam(value = "songtype",defaultValue = "") String songType){
        int totalpage = songService.getTotalCountByType(search,songType) % size == 0 ? songService.getTotalCountByType(search,songType) / size : songService.getTotalCountByType(search,songType) / size + 1;
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
        List<Song> songlist = songService.listByType(page, size, search,songType);
        List<Song> likelist = likeSongService.selectAllLike(request);
        List<String> songNamelist = new ArrayList<>();
        if(likelist!=null){
            for (Song song : likelist) {
                songNamelist.add(song.getSongName());
            }
        }
        model.addAttribute("likelist", songNamelist);
        model.addAttribute("songlist", songlist);
        model.addAttribute("pagelist", pagelist);
        model.addAttribute("currentpage", page);
        model.addAttribute("songtype",songType);
        return "genres";
    }


    @RequestMapping("refresh.do")
    public String refresh(HttpServletRequest request, Model model,
                         @RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "size", defaultValue = "18") Integer size,
                         @RequestParam(value = "search", required = false) String search,
                         @RequestParam(value = "songType",defaultValue = "") String songType){
        int totalpage = songService.getTotalCountByType(search,songType) % size == 0 ? songService.getTotalCountByType(search,songType) / size : songService.getTotalCountByType(search,songType) / size + 1;
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
        List<Song> songlist = songService.listByType(page, size, search,songType);
        List<Song> likelist = likeSongService.selectAllLike(request);
        List<String> songNamelist = new ArrayList<>();
        if(likelist!=null){
            for (Song song : likelist) {
                songNamelist.add(song.getSongName());
            }
        }
        model.addAttribute("likelist", songNamelist);
        model.addAttribute("songlist", songlist);
        model.addAttribute("pagelist", pagelist);
        model.addAttribute("currentpage", page);
        model.addAttribute("songtype",songType);
        return "genres::genres-list-fragment";
    }

}
