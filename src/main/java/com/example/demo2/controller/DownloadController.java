package com.example.demo2.controller;

import com.example.demo2.service.RecordDownloadService;
import com.example.demo2.utils.Static;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * @Author: Liujiang
 * @Date: 2020/4/7 4:10
 */

@Controller
public class DownloadController {
    @Autowired
    private RecordDownloadService recordDownloadService;


    @RequestMapping(value = "download.do", method = { RequestMethod.GET})
    public void download(HttpServletRequest request, HttpServletResponse response, String songAddress, int songId) throws IOException {
        System.out.println(songId);
        //对于登录用户，记录其下载记录
        recordDownloadService.recordDownload(request, songId);
        response.setContentType("audio/mp3");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(System.currentTimeMillis()+"xxxxxx.mp3", "utf8"));
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        InputStream bis=null;
        bis=new BufferedInputStream(new FileInputStream("/Users/maybelence/Downloads/demo2/target/classes/static/"+songAddress));
        int len = 0;
        assert bis != null;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
        bis.close();

    }

}
