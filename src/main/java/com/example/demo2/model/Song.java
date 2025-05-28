package com.example.demo2.model;

import java.util.Date;

public class Song {
	private int songId;
	private String songName;
	private String songAddress;

	public Song(String songName, String songAddress, String songCoverAddress, String songType, String songartist, Date upTime) {
		this.songName = songName;
		this.songAddress = songAddress;
		this.songCoverAddress = songCoverAddress;
		this.songType = songType;
		this.songartist = songartist;
		this.upTime = upTime;
	}

	private String songCoverAddress;
	private String songType;

	public Song(String songName, String songAddress, String songType, String songartist, Date upTime) {
		this.songName = songName;
		this.songAddress = songAddress;
		this.songType = songType;
		this.songartist = songartist;
		this.upTime = upTime;
	}

	private int songLength;

	public String getSongartist() {
		return songartist;
	}

	public Date getUpTime() {
		return upTime;
	}

	private String songartist;
	private Date upTime;
	private int trendingCoefficient;
	private boolean whetherCollected;

	public Song(String songName, String songAddress) {
		this.songName=songName;
		this.songAddress=songAddress;
	}



	public Song() {}



    public int getTrendingCoefficient() {
		return trendingCoefficient;
	}

	public void setTrendingCoefficient(int trendingCoefficient) {
		this.trendingCoefficient = trendingCoefficient;
	}

	public boolean isWhetherCollected() {
		return whetherCollected;
	}

	public void setWhetherCollected(boolean whetherCollected) {
		this.whetherCollected = whetherCollected;
	}

	public String getSongCoverAddress() {
		return songCoverAddress;
	}

	public void setSongCoverAddress(String songCoverAddress) {
		this.songCoverAddress = songCoverAddress;
	}

	public String getSongType() {
		return songType;
	}

	public void setSongType(String songType) {
		this.songType = songType;
	}

	public int getSongLength() {
		return songLength;
	}

	public void setSongLength(int songLength) {
		this.songLength = songLength;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongAddress() {
		return songAddress;
	}

	public void setSongAddress(String songAddress) {
		this.songAddress = songAddress;
	}

}
