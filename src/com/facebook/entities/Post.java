package com.facebook.entities;

import java.sql.Timestamp;

public class Post {
	// Fields
	private int pId;
	private String pContent;
	private String pPic;
	private Timestamp dateTime;
	private int uId;
	
	// default constructor
	public Post() {
		super();
	}
	
	// parameter constructor 
	public Post(int pId,String pContent, String pPic,Timestamp dateTime, int uId) {
		this.pId = pId;
		this.pContent = pContent;
		this.pPic = pPic;
		this.dateTime = dateTime;
		this.uId = uId;
	}
	
	// parameter constructor without PId
	public Post(String pContent, String pPic,Timestamp dateTime, int uId) {
		this.pContent = pContent;
		this.pPic = pPic;
		this.dateTime = dateTime;
		this.uId = uId;
	}
	
	// setters & getters
	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public String getpPic() {
		return pPic;
	}

	public void setpPic(String pPic) {
		this.pPic = pPic;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
