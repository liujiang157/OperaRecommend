package com.example.demo2.model;

import java.util.Date;

/**
 * @Author: Liujiang
 * @Date: 2020/4/5 14:11
 */

public class DownloadRecord {
    private int downloadId;
    private int userId;
    private int songId;
    private Date downloadTime;

    public DownloadRecord() {

    }

    public DownloadRecord(int userId, int songId) {
        this.userId = userId;
        this.songId = songId;
        this.downloadTime =new Date();
    }

    public int getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(int downloadId) {
        this.downloadId = downloadId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public Date getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(Date downloadTime) {
        this.downloadTime = downloadTime;
    }


}