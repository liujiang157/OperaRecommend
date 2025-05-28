package com.example.demo2.service.impl;

import com.example.demo2.mapper.RecordDownloadMapper;
import com.example.demo2.mapper.UserMapper;
import com.example.demo2.model.DownloadRecord;
import com.example.demo2.model.User;
import com.example.demo2.service.RecordDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Liujiang
 * @Date: 2020/4/5 14:31
 */

@Service("recordDownloadService")
public class RecordDownloadServiceImpl implements RecordDownloadService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RecordDownloadMapper recordDownloadMapper;

    public void recordDownload(HttpServletRequest request, int songId) {
        if(request.getSession().getAttribute("user")==null) {
            return;
        }

        int uerId = userMapper.selectByEmail((String) request.getSession().getAttribute("user")).getId();
        DownloadRecord downloadRecord= new DownloadRecord(uerId,songId);
        recordDownloadMapper.insert(downloadRecord);
    }

    public List<DownloadRecord> getAllRecords() {
        return recordDownloadMapper.selectAll();
    }

}