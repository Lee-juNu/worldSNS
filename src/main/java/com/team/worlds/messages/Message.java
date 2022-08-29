package com.team.worlds.messages;

import java.util.Date;
import java.util.Map;

public class Message {

	
	private String cr_Num;
	private String cr_ownerID;
	private Date cr_date;
	
	private String rm_roomNum;
	private String rm_userID;
	private int rm_lastIndex;
	
	private String msg_Num;
	private String msg_RoomNum;
	private String msg_sendUserID;
	private String msg_receiverUserID;
	private Date msg_sendTime;
	private int msg_index;
	private String msg_img;
	private String msg_Contents;
	
	
	public Message() {
		// TODO Auto-generated constructor stub
	}

	public String getCr_Num() {
		return cr_Num;
	}

	public void setCr_Num(String cr_Num) {
		this.cr_Num = cr_Num;
	}

	public String getCr_ownerID() {
		return cr_ownerID;
	}

	public void setCr_ownerID(String cr_ownerID) {
		this.cr_ownerID = cr_ownerID;
	}

	public Date getCr_date() {
		return cr_date;
	}

	public void setCr_date(Date cr_date) {
		this.cr_date = cr_date;
	}

	public String getRm_roomNum() {
		return rm_roomNum;
	}

	public void setRm_roomNum(String rm_roomNum) {
		this.rm_roomNum = rm_roomNum;
	}

	public String getRm_userID() {
		return rm_userID;
	}

	public void setRm_userID(String rm_userID) {
		this.rm_userID = rm_userID;
	}

	public int getRm_lastIndex() {
		return rm_lastIndex;
	}

	public void setRm_lastIndex(int rm_lastIndex) {
		this.rm_lastIndex = rm_lastIndex;
	}

	public String getMsg_Num() {
		return msg_Num;
	}

	public void setMsg_Num(String msg_Num) {
		this.msg_Num = msg_Num;
	}

	public String getMsg_RoomNum() {
		return msg_RoomNum;
	}

	public void setMsg_RoomNum(String msg_RoomNum) {
		this.msg_RoomNum = msg_RoomNum;
	}

	public String getMsg_sendUserID() {
		return msg_sendUserID;
	}

	public void setMsg_sendUserID(String msg_sendUserID) {
		this.msg_sendUserID = msg_sendUserID;
	}

	public String getMsg_receiverUserID() {
		return msg_receiverUserID;
	}

	public void setMsg_receiverUserID(String msg_receiverUserID) {
		this.msg_receiverUserID = msg_receiverUserID;
	}

	public Date getSendTime() {
		return msg_sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.msg_sendTime = sendTime;
	}

	public int getMsg_index() {
		return msg_index;
	}

	public void setMsg_index(int msg_index) {
		this.msg_index = msg_index;
	}

	public String getMsg_img() {
		return msg_img;
	}

	public void setMsg_img(String msg_img) {
		this.msg_img = msg_img;
	}

	public String getMsg_Contents() {
		return msg_Contents;
	}

	public void setMsg_Contents(String msg_Contents) {
		this.msg_Contents = msg_Contents;
	}

	public Message(String cr_Num, String cr_ownerID, Date cr_date, String rm_roomNum, String rm_userID,
			int rm_lastIndex, String msg_Num, String msg_RoomNum, String msg_sendUserID, String msg_receiverUserID,
			Date sendTime, int msg_index, String msg_img, String msg_Contents) {
		super();
		this.cr_Num = cr_Num;
		this.cr_ownerID = cr_ownerID;
		this.cr_date = cr_date;
		this.rm_roomNum = rm_roomNum;
		this.rm_userID = rm_userID;
		this.rm_lastIndex = rm_lastIndex;
		this.msg_Num = msg_Num;
		this.msg_RoomNum = msg_RoomNum;
		this.msg_sendUserID = msg_sendUserID;
		this.msg_receiverUserID = msg_receiverUserID;
		this.msg_sendTime = sendTime;
		this.msg_index = msg_index;
		this.msg_img = msg_img;
		this.msg_Contents = msg_Contents;
	}

	public Message(String cr_Num, String cr_ownerID, Date cr_date) {
		super();
		this.cr_Num = cr_Num;
		this.cr_ownerID = cr_ownerID;
		this.cr_date = cr_date;
	}

	public Message(String rm_roomNum, String rm_userID, int rm_lastIndex) {
		super();
		this.rm_roomNum = rm_roomNum;
		this.rm_userID = rm_userID;
		this.rm_lastIndex = rm_lastIndex;
	}

	public Message(String msg_Num, String msg_RoomNum, String msg_sendUserID, String msg_receiverUserID, Date sendTime,
			int msg_index, String msg_img, String msg_Contents) {
		super();
		this.msg_Num = msg_Num;
		this.msg_RoomNum = msg_RoomNum;
		this.msg_sendUserID = msg_sendUserID;
		this.msg_receiverUserID = msg_receiverUserID;
		this.msg_sendTime = sendTime;
		this.msg_index = msg_index;
		this.msg_img = msg_img;
		this.msg_Contents = msg_Contents;
	}

	public Message(Object send) {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
