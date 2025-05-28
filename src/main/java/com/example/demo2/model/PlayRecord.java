package com.example.demo2.model;

import java.util.Date;

public class PlayRecord {
	private int playId;
	private int userId;
	private int songId;
	private Date playTime;

	public PlayRecord(int userId, int songId, Date playTime) {
		this.userId = userId;
		this.songId = songId;
		this.playTime = playTime;
	}



	public Date getPlayTime() {
		return playTime;
	}

	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}

	public PlayRecord() {
		
	}
	public PlayRecord(int userId, int songId) {
		this.userId=userId;
		this.songId=songId;
	}
	public int getPlayId() {
		return playId;
	}
	public void setPlayId(int playId) {
		this.playId = playId;
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
	
	

}
