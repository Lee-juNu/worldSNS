package com.team.worlds.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


public interface SearchMapper {

	public List<User_o> getOtherProfile(String searchWord);


	
	
}
