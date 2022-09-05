package com.team.worlds.board;

public class Board {

	private String Board_Num;
	private String Board_ParentNum;
	private String Board_userID;
	private String Board_img1;
	private String Board_img2;
	private String Board_img3;
	private String Board_img4 	;	
	private String Board_Contents ;	
	private String Board_Country ;	
	private String Board_City 	;
	
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(String board_Num, String board_ParentNum, String board_userID, String board_img1, String board_img2,
			String board_img3, String board_img4, String board_Contents, String board_Country, String board_City) {
		super();
		Board_Num = board_Num;
		Board_ParentNum = board_ParentNum;
		Board_userID = board_userID;
		Board_img1 = board_img1;
		Board_img2 = board_img2;
		Board_img3 = board_img3;
		Board_img4 = board_img4;
		Board_Contents = board_Contents;
		Board_Country = board_Country;
		Board_City = board_City;
	}
	public String getBoard_Num() {
		return Board_Num;
	}
	public void setBoard_Num(String board_Num) {
		Board_Num = board_Num;
	}
	public String getBoard_ParentNum() {
		return Board_ParentNum;
	}
	public void setBoard_ParentNum(String board_ParentNum) {
		Board_ParentNum = board_ParentNum;
	}
	public String getBoard_userID() {
		return Board_userID;
	}
	public void setBoard_userID(String board_userID) {
		Board_userID = board_userID;
	}
	public String getBoard_img1() {
		return Board_img1;
	}
	public void setBoard_img1(String board_img1) {
		Board_img1 = board_img1;
	}
	public String getBoard_img2() {
		return Board_img2;
	}
	public void setBoard_img2(String board_img2) {
		Board_img2 = board_img2;
	}
	public String getBoard_img3() {
		return Board_img3;
	}
	public void setBoard_img3(String board_img3) {
		Board_img3 = board_img3;
	}
	public String getBoard_img4() {
		return Board_img4;
	}
	public void setBoard_img4(String board_img4) {
		Board_img4 = board_img4;
	}
	public String getBoard_Contents() {
		return Board_Contents;
	}
	public void setBoard_Contents(String board_Contents) {
		Board_Contents = board_Contents;
	}
	public String getBoard_Country() {
		return Board_Country;
	}
	public void setBoard_Country(String board_Country) {
		Board_Country = board_Country;
	}
	public String getBoard_City() {
		return Board_City;
	}
	public void setBoard_City(String board_City) {
		Board_City = board_City;
	}	

	
	
	
}
