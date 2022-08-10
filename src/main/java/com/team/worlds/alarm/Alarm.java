package com.team.worlds.alarm;

public class Alarm {
	private String alam_Num;
	private String alam_ReceiverID;
	private String alam_type;
	
	public Alarm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alarm(String alam_Num, String alam_ReceiverID, String alam_type) {
		super();
		this.alam_Num = alam_Num;
		this.alam_ReceiverID = alam_ReceiverID;
		this.alam_type = alam_type;
	}
	public String getAlam_Num() {
		return alam_Num;
	}
	public void setAlam_Num(String alam_Num) {
		this.alam_Num = alam_Num;
	}
	public String getAlam_ReceiverID() {
		return alam_ReceiverID;
	}
	public void setAlam_ReceiverID(String alam_ReceiverID) {
		this.alam_ReceiverID = alam_ReceiverID;
	}
	public String getAlam_type() {
		return alam_type;
	}
	public void setAlam_type(String alam_type) {
		this.alam_type = alam_type;
	}
}
