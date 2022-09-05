package com.team.worlds.util;

public class Region {
	String region_name;
	String region_country;
	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Region(String region_name, String region_country) {
		super();
		this.region_name = region_name;
		this.region_country = region_country;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public String getRegion_country() {
		return region_country;
	}
	public void setRegion_country(String region_country) {
		this.region_country = region_country;
	}
	
	
}
