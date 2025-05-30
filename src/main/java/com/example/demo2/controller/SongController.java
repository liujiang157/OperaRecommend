package com.example.demo2.controller;

import com.example.demo2.model.Song;
import com.example.demo2.model.User;
import com.example.demo2.service.AdminService;
import com.example.demo2.service.SongService;
import com.example.demo2.utils.ReturnMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SongController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private SongService songService;

    @RequestMapping("/addmusic")
    public String addmusic(HttpServletRequest request){
        if(!adminService.isHasPrivilege(request)) {
            return "admin/adminlogin";
        }
        return "admin/addsong"; }

    @PostMapping(value = "addsong.do")
    @ResponseBody
    public String addSong(HttpServletRequest request, MultipartFile song, MultipartFile cover, String songname,String songartist, String selection) {
        if(songService.checkFormat(song,cover)) {
            boolean isSuccessful=songService.addSong(request,song,cover,songname,songartist,selection);
            if(isSuccessful) {
                return ReturnMsg.msg(HttpServletResponse.SC_OK, "上传成功");
            }else {
                return ReturnMsg.msg(HttpServletResponse.SC_BAD_REQUEST, "上传失败");
            }
        }
        return ReturnMsg.msg(HttpServletResponse.SC_BAD_REQUEST, "格式错误");
    }




    /**
     * 戏曲列表
     *
     * @param request
     * @param model
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/songlist")
    public String songlist(HttpServletRequest request, Model model,
                           @RequestParam(value = "page", defaultValue = "1") Integer page,
                           @RequestParam(value = "size", defaultValue = "5") Integer size,
                           @RequestParam(value = "search", required = false) String search) {
        if(!adminService.isHasPrivilege(request)) {
            return "admin/adminlogin";
        }
        int totalpage = songService.getTotalCount(search) % size == 0 ? songService.getTotalCount(search) / size : songService.getTotalCount(search) / size + 1;
        if (page < 1) {
            page = 1;
        }
        if (page > totalpage) {
            page = totalpage;
        }
        List<Integer> pagelist = new ArrayList<>();
        if(totalpage<=5){
            for (int i = 1; i <=totalpage ; i++) {
                pagelist.add(i);
            }
        }else {
            if (page>=3&&page<=totalpage-2){
                pagelist.add(page-2);
                pagelist.add(page-1);
                pagelist.add(page);
                pagelist.add(page+1);
                pagelist.add(page+2);
            }
            else if(page<3){
                pagelist.add(1);
                pagelist.add(2);
                pagelist.add(3);
                pagelist.add(4);
                pagelist.add(5);
            }
            else {
                pagelist.add(totalpage-4);
                pagelist.add(totalpage-3);
                pagelist.add(totalpage-2);
                pagelist.add(totalpage-1);
                pagelist.add(totalpage);
            }
        }
        List<Song> songlist = songService.list(page, size, search);
        model.addAttribute("songlist", songlist);
        model.addAttribute("pagelist", pagelist);
        model.addAttribute("totalpage", totalpage);
        model.addAttribute("currentpage", page);
        return "admin/songlist";
    }

    @RequestMapping("/deletesong")
    public String deletesong(@RequestParam(value = "songid") String songid) {
        boolean IsDeleted = songService.deleteUserByName(songid);
        if (IsDeleted)
            return "redirect:/songlist";
        return "/fail";
    }

}
