package com.example.demo2.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo2.model.User;
import com.example.demo2.service.PersonalRecService;
import com.example.demo2.service.UserService;
import com.example.demo2.utils.ReturnMsg;
import com.example.demo2.utils.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private PersonalRecService personalRecService;

    @PostMapping(value = "register.do")
    @ResponseBody
    public String register(HttpServletRequest request
            , @RequestParam(value = "email") String email
            , @RequestParam(value = "password") String password
            , @RequestParam(value = "username") String username
            , @RequestParam(value = "validateCode") String validateCode) {
        boolean isNameExisted = userService.isNameExisted(username);
        String code = (String) request.getSession().getAttribute("code");
        if (code == null || !code.equals(validateCode)) {
            return ReturnMsg.msg(HttpServletResponse.SC_BAD_REQUEST, "验证码错误");
        } else {
            User u = new User(username, password, email);
            boolean isInserted = userService.insert(u);
            if (isInserted) {
                request.getSession().setAttribute("user", u.getEmail());
                personalRecService.initializePersonalRecList(request);
                return ReturnMsg.msg(HttpServletResponse.SC_OK, JSONObject.toJSON(u).toString());
            } else {
                return ReturnMsg.msg(HttpServletResponse.SC_BAD_REQUEST, "注册失败");
            }
        }
    }

    @PostMapping(value = "getValidateCode.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getValidateCode(HttpServletRequest request, String email) {
        //邮箱是否已经存在
        boolean isExisted = userService.isEmailExisted(email);
        if (isExisted) {
            return ReturnMsg.msg(HttpServletResponse.SC_BAD_REQUEST, "该用户已存在");
        }
        //防止疯狂发送...，这里简单的限制一下1分钟只发发送一次
//        if (userService.tooQuickly(request, 1)) {
//            return ReturnMsg.msg(HttpServletResponse.SC_BAD_REQUEST, "发送频率太快");
//        }
        String code = (int) (Math.random() * 10000) + "";
//		boolean isSuccessful=SendEmail.sendemail("邮箱验证", "您的验证码为："+code, email);
        String content = "Welcome to 戏曲网站, your email verified code is：" + code + "\n\n" + "Sincerely,";
        boolean isSuccessful = SendEmail.sendemail("Email Validation", content, email);
        if (isSuccessful) {
            request.getSession().setAttribute("code", code);
            return ReturnMsg.msg(HttpServletResponse.SC_OK, "发送成功");
        } else {
            return ReturnMsg.msg(HttpServletResponse.SC_BAD_REQUEST, "发送失败");
        }
    }




}
