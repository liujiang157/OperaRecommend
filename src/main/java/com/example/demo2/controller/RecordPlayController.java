package com.example.demo2.controller;

import com.example.demo2.service.RecordPlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RecordPlayController {

    @Autowired
    private RecordPlayService recordPlayService;

    @GetMapping(value = "recordPlay.do")
    @ResponseBody
    public void recordPlay(HttpServletRequest request,@RequestParam(value = "title") String title) {
        recordPlayService.recordPlay(request,title);

    }

}

