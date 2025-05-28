package com.example.demo2.controller;

import com.example.demo2.model.Song;
import com.example.demo2.model.Video;
import com.example.demo2.service.AdminService;
import com.example.demo2.service.VideoService;
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

/**
 * @Author: Liujiang
 * @Date: 2020/4/9 17:33
 */

@Controller
public class VideoController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private VideoService videoService;

    @RequestMapping("/addvideo")
    public String addvideo(HttpServletRequest request){
        if(!adminService.isHasPrivilege(request)) {
            return "admin/adminlogin";
        }
        return "admin/addvideo"; }

    @PostMapping(value = "addvedio.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addVideo(HttpServletRequest request, MultipartFile video, String songname, String description) {
        if(videoService.checkFormat(video)) {
            boolean isSuccessful=videoService.addVideo(request,video,songname,description);
            if(isSuccessful) {
                return ReturnMsg.msg(HttpServletResponse.SC_OK, "上传成功");
            }else {
                return ReturnMsg.msg(HttpServletResponse.SC_BAD_REQUEST, "上传失败");
            }
        }
        return ReturnMsg.msg(HttpServletResponse.SC_BAD_REQUEST, "格式错误");
    }


    @RequestMapping("/videolist")
    public String videolist(HttpServletRequest request, Model model,
                           @RequestParam(value = "page", defaultValue = "1") Integer page,
                           @RequestParam(value = "size", defaultValue = "5") Integer size,
                           @RequestParam(value = "search", required = false) String search) {
        if(!adminService.isHasPrivilege(request)) {
            return "admin/adminlogin";
        }
        int totalpage = videoService.getTotalCount(search) % size == 0 ? videoService.getTotalCount(search) / size : videoService.getTotalCount(search) / size + 1;
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
        List<Video> songlist = videoService.list(page, size, search);
        model.addAttribute("videolist", songlist);
        model.addAttribute("pagelist", pagelist);
        model.addAttribute("totalpage", totalpage);
        model.addAttribute("currentpage", page);
        return "admin/videolist";
    }

    @RequestMapping("/deletevideo")
    public String deletevideo(@RequestParam(value = "videoid") String songid) {
        boolean IsDeleted = videoService.deleteVideoByName(songid);
        if (IsDeleted)
            return "redirect:/videolist";
        return "/fail";
    }


    @RequestMapping("/recvideo")
    public String recvideo(@RequestParam(value = "videoid") String songid) {
        boolean IsDeleted = videoService.recVideoByName(songid);
        if (IsDeleted)
            return "redirect:/videolist";
        return "/fail";
    }



    @RequestMapping("/deleterecvideo")
    public String deleterecvideo(@RequestParam(value = "videoid") String songid) {
        boolean IsDeleted = videoService.deleterecVideoByName(songid);
        if (IsDeleted)
            return "redirect:/videolist";
        return "/fail";
    }


}
