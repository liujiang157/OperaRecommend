package com.example.demo2.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo2.model.User;
import com.example.demo2.service.UserService;
import com.example.demo2.utils.ReturnMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Liujiang
 * @Date: 2020/4/9 17:35
 */

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "login.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String login(HttpServletRequest request, User u) {
        boolean isUserExisted = userService.findLogin(u);
        if (!isUserExisted) {
            return ReturnMsg.msg(HttpServletResponse.SC_BAD_REQUEST, "帐号或密码错误");
        } else {
            request.getSession().setAttribute("user", u.getEmail());
            return ReturnMsg.msg(HttpServletResponse.SC_OK, JSONObject.toJSON(u).toString());
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/signin";
    }

}
