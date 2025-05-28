package com.example.demo2.model;

import java.util.Date;

/**
 * @Author: Liujiang
 * @Date: 2020/4/9 17:37
 */

public class Video {
    public Video(int id, String videoname, String songAddress, String description, Date date) {
        this.id = id;
        this.videoname = videoname;
        this.songAddress = songAddress;
        this.description = description;
        this.date = date;

    }

    public Video(int id, String videoname, String songAddress, String description, Date date,boolean isrec) {
        this.isrec = isrec;
        this.id = id;
        this.videoname = videoname;
        this.songAddress = songAddress;
        this.description = description;
        this.date = date;
    }

    public boolean isIsrec() {
        return isrec;
    }

    public void setIsrec(boolean isrec) {
        this.isrec = isrec;
    }

    boolean isrec;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    private String videoname;

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname;
    }

    public String getSongAddress() {
        return songAddress;
    }

    public void setSongAddress(String songAddress) {
        this.songAddress = songAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private String songAddress;
    private String description;
    private Date date;
    public Video(String videoname, String songAddress, String description, Date date) {
        this.videoname = videoname;
        this.songAddress = songAddress;
        this.description = description;
        this.date = date;
    }





}
