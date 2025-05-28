package com.example.demo2.model;

public class Like {
	private int likeId;
	private int userId;
	private int songId;
	
	public Like() {}
	
	public Like(int userId, int reviewId) {
		this.userId=userId;
		this.songId =reviewId;
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
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
