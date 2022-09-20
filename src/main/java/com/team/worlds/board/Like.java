package com.team.worlds.board;

public class Like {
	private String like_Num;
	private String like_SenderID;
	private String like_ReceiverID;
	private String like_BoardNum;
	
	
	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Like(String like_Num, String like_SenderID, String like_ReceiverID, String like_BoardNum) {
		super();
		this.like_Num = like_Num;
		this.like_SenderID = like_SenderID;
		this.like_ReceiverID = like_ReceiverID;
		this.like_BoardNum = like_BoardNum;
	}
	public String getLike_Num() {
		return like_Num;
	}
	public void setLike_Num(String like_Num) {
		this.like_Num = like_Num;
	}
	public String getLike_SenderID() {
		return like_SenderID;
	}
	public void setLike_SenderID(String like_SenderID) {
		this.like_SenderID = like_SenderID;
	}
	public String getLike_ReceiverID() {
		return like_ReceiverID;
	}
	public void setLike_ReceiverID(String like_ReceiverID) {
		this.like_ReceiverID = like_ReceiverID;
	}
	public String getLike_BoardNum() {
		return like_BoardNum;
	}
	public void setLike_BoardNum(String like_BoardNum) {
		this.like_BoardNum = like_BoardNum;
	}
	
	
	
	
	
	
}
