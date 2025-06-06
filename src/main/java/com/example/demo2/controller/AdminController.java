package com.example.demo2.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo2.mapper.AdminMapper;
import com.example.demo2.model.Admin;
import com.example.demo2.model.User;
import com.example.demo2.service.AdminService;
import com.example.demo2.service.UserService;
import com.example.demo2.utils.ReturnMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request){
        if(!adminService.isHasPrivilege(request)) {
            return "admin/adminlogin";
        }
        else
            return "admin/admin";
    }


    @RequestMapping("/adduser")
    public String adduser(HttpServletRequest request){
        if(!adminService.isHasPrivilege(request)) {
            return "admin/adminlogin";
        }
        return "admin/adduser";

    }

    @RequestMapping("/updateuser")
    public String updateuser(HttpServletRequest request,@RequestParam("id") Integer id,Model model){
        User user = userService.selectUserById(id);
        model.addAttribute("user",user);
        return "admin/updateuser";

    }


    @PostMapping(value = "adminlogin.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String login(HttpServletRequest request, Admin admin)
    {
        Admin result = adminService.selectAdmin(admin);
        if (result != null) {
            request.getSession().setAttribute("admin",admin);
            return ReturnMsg.msg(HttpServletResponse.SC_OK, JSONObject.toJSON(admin).toString());
        }
        else
            return ReturnMsg.msg(HttpServletResponse.SC_BAD_REQUEST,"管理员密码错误");
    }




}
