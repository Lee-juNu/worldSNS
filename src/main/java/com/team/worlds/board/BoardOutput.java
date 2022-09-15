package com.team.worlds.board;

import java.sql.Date;

public class BoardOutput
{
	private String board_Num;
	private String board_ParentNum;
	private String board_userID;
	private String board_img1;
	private String board_img2;
	private String board_img3;
	private String board_img4;	
	private String board_Contents;	
	private String board_Country;	
	private String board_City;
	private Date board_regDate;
	private String user_nickName;
	public BoardOutput() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardOutput(String board_Num, String board_ParentNum, String board_userID, String board_img1,
			String board_img2, String board_img3, String board_img4, String board_Contents, String board_Country,
			String board_City, Date regDate, String user_nickName) {
		super();
		this.board_Num = board_Num;
		this.board_ParentNum = board_ParentNum;
		this.board_userID = board_userID;
		this.board_img1 = board_img1;
		this.board_img2 = board_img2;
		this.board_img3 = board_img3;
		this.board_img4 = board_img4;
		this.board_Contents = board_Contents;
		this.board_Country = board_Country;
		this.board_City = board_City;
		this.board_regDate = regDate;
		this.user_nickName = user_nickName;
	}
	public String getBoard_Num() {
		return board_Num;
	}
	public void setBoard_Num(String board_Num) {
		this.board_Num = board_Num;
	}
	public String getBoard_ParentNum() {
		return board_ParentNum;
	}
	public void setBoard_ParentNum(String board_ParentNum) {
		this.board_ParentNum = board_ParentNum;
	}
	public String getBoard_userID() {
		return board_userID;
	}
	public void setBoard_userID(String board_userID) {
		this.board_userID = board_userID;
	}
	public String getBoard_img1() {
		return board_img1;
	}
	public void setBoard_img1(String board_img1) {
		this.board_img1 = board_img1;
	}
	public String getBoard_img2() {
		return board_img2;
	}
	public void setBoard_img2(String board_img2) {
		this.board_img2 = board_img2;
	}
	public String getBoard_img3() {
		return board_img3;
	}
	public void setBoard_img3(String board_img3) {
		this.board_img3 = board_img3;
	}
	public String getBoard_img4() {
		return board_img4;
	}
	public void setBoard_img4(String board_img4) {
		this.board_img4 = board_img4;
	}
	public String getBoard_Contents() {
		return board_Contents;
	}
	public void setBoard_Contents(String board_Contents) {
		this.board_Contents = board_Contents;
	}
	public String getBoard_Country() {
		return board_Country;
	}
	public void setBoard_Country(String board_Country) {
		this.board_Country = board_Country;
	}
	public String getBoard_City() {
		return board_City;
	}
	public void setBoard_City(String board_City) {
		this.board_City = board_City;
	}
	public Date getRegDate() {
		return board_regDate;
	}
	public void setRegDate(Date regDate) {
		this.board_regDate = regDate;
	}
	public String getUser_nickName() {
		return user_nickName;
	}
	public void setUser_nickName(String user_nickName) {
		this.user_nickName = user_nickName;
	}

	
	
}
