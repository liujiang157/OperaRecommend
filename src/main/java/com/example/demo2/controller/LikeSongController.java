package com.example.demo2.controller;

import com.example.demo2.model.Song;
import com.example.demo2.service.LikeSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LikeSongController {
    @Autowired
    private LikeSongService likeSongService;

    //添加收藏
    @PostMapping(value = "addlikeSong.do")
    @ResponseBody
    public void addLikeSong(HttpServletRequest request,@RequestParam(value = "name") String songname) {
        likeSongService.addlikeSong(request,songname);
    }

    //删除收藏戏曲
    @PostMapping(value = "deletelikeSong.do")
    @ResponseBody
    public void deleteLikeSong(HttpServletRequest request,@RequestParam(value = "name") String songname) {
        likeSongService.deletelikeSong(request,songname);

    }




    //删除收藏戏曲
    @PostMapping(value = "deletelike.do")
    public String deleteLike(Model model,HttpServletRequest request, @RequestParam(value = "name") String songname) {
        likeSongService.deletelikeSong(request,songname);
        List<Song> likelist = likeSongService.selectAllLike(request);
        model.addAttribute("likelist", likelist);
        return "listen::list-likefragment";

    }


}
