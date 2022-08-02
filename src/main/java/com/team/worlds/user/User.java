package com.team.worlds.user;



public class User {
	private String  user_id;
	private String  user_pw;
	private String 	user_nickName;
	private String 	user_phoneNum;
	private String 	user_name;
	private String 	user_email;
	private String 	user_regDate;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String user_id, String user_pw, String user_nickName, String user_phoneNum, String user_name,
			String user_email, String user_regDate) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_nickName = user_nickName;
		this.user_phoneNum = user_phoneNum;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_regDate = user_regDate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_nickName() {
		return user_nickName;
	}
	public void setUser_nickName(String user_nickName) {
		this.user_nickName = user_nickName;
	}
	public String getUser_phoneNum() {
		return user_phoneNum;
	}
	public void setUser_phoneNum(String user_phoneNum) {
		this.user_phoneNum = user_phoneNum;
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
	public String getUser_regDate() {
		return user_regDate;
	}
	public void setUser_regDate(String user_regDate) {
		this.user_regDate = user_regDate;
	}
	
	
}
