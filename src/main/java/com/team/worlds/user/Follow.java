package com.team.worlds.user;

import java.sql.Date;

public class Follow {
	
	private String Flw_num;
	private String Flw_FromId;
	private String Flw_ToId;
	private Date Flw_time;
	
	public Follow() {
		// TODO Auto-generated constructor stub
	}

	public Follow(String flw_num, String flw_FromId, String flw_ToId, Date flw_time) {
		super();
		Flw_num = flw_num;
		Flw_FromId = flw_FromId;
		Flw_ToId = flw_ToId;
		Flw_time = flw_time;
	}

	public String getFlw_num() {
		return Flw_num;
	}

	public void setFlw_num(String flw_num) {
		Flw_num = flw_num;
	}

	public String getFlw_FromId() {
		return Flw_FromId;
	}

	public void setFlw_FromId(String flw_FromId) {
		Flw_FromId = flw_FromId;
	}

	public String getFlw_ToId() {
		return Flw_ToId;
	}

	public void setFlw_ToId(String flw_ToId) {
		Flw_ToId = flw_ToId;
	}

	public Date getFlw_time() {
		return Flw_time;
	}

	public void setFlw_time(Date flw_time) {
		Flw_time = flw_time;
	}

	
	
	
	
	
	
	
	
}
