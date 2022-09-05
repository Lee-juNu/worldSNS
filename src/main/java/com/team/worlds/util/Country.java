package com.team.worlds.util;

public class Country {
	private String country_id;
	private String country_Name;
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Country(String country_id, String country_Name) {
		super();
		this.country_id = country_id;
		this.country_Name = country_Name;
	}
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	public String getCountry_Name() {
		return country_Name;
	}
	public void setCountry_Name(String country_Name) {
		this.country_Name = country_Name;
	}
	
	
	
}
