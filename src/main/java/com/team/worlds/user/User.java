package com.team.worlds.user;



public class User {
	private String user_ID;
	private String user_PW;
	private String user_nickName;
	private String user_phoneNumber;
	private String user_name;
	private String user_email;
	private String user_city;
	private String user_birthDay;
	private int level;
	private String regDate;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(String user_ID, String user_PW, String user_nickName, String user_phoneNumber, String user_name,
			String user_email, String user_city, String user_birthDay, int level, String regDate) {
		super();
		this.user_ID = user_ID;
		this.user_PW = user_PW;
		this.user_nickName = user_nickName;
		this.user_phoneNumber = user_phoneNumber;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_city = user_city;
		this.user_birthDay = user_birthDay;
		this.level = level;
		this.regDate = regDate;
	}



	public String getUser_ID() {
		return user_ID;
	}



	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}



	public String getUser_PW() {
		return user_PW;
	}



	public void setUser_PW(String user_PW) {
		this.user_PW = user_PW;
	}



	public String getUser_nickName() {
		return user_nickName;
	}



	public void setUser_nickName(String user_nickName) {
		this.user_nickName = user_nickName;
	}



	public String getUser_phoneNumber() {
		return user_phoneNumber;
	}



	public void setUser_phoneNumber(String user_phoneNumber) {
		this.user_phoneNumber = user_phoneNumber;
	}



	public String getUser_name() {
		return user_name;
	}



	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}



	public String getUser_email() {
		return user_email;
	}



	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}



	public String getUser_city() {
		return user_city;
	}



	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}



	public String getUser_birthDay() {
		return user_birthDay;
	}



	public void setUser_birthDay(String user_birthDay) {
		this.user_birthDay = user_birthDay;
	}



	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}



	public String getRegDate() {
		return regDate;
	}



	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	
	
	
}
