package com.team.worlds.alarm;

import java.util.Date;

public class AlarmDetail {
	String 	almDetail_Num;
	String 	almDetail_LinkNum;
	Date 	almDetail_regDate;
	public AlarmDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlarmDetail(String almDetail_Num, String almDetail_LinkNum, Date almDetail_regDate) {
		super();
		this.almDetail_Num = almDetail_Num;
		this.almDetail_LinkNum = almDetail_LinkNum;
		this.almDetail_regDate = almDetail_regDate;
	}
	public String getAlmDetail_Num() {
		return almDetail_Num;
	}
	public void setAlmDetail_Num(String almDetail_Num) {
		this.almDetail_Num = almDetail_Num;
	}
	public String getAlmDetail_LinkNum() {
		return almDetail_LinkNum;
	}
	public void setAlmDetail_LinkNum(String almDetail_LinkNum) {
		this.almDetail_LinkNum = almDetail_LinkNum;
	}
	public Date getAlmDetail_regDate() {
		return almDetail_regDate;
	}
	public void setAlmDetail_regDate(Date almDetail_regDate) {
		this.almDetail_regDate = almDetail_regDate;
	}
	
	
}
