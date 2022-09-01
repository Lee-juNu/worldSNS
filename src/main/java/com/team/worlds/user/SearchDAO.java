package com.team.worlds.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchDAO {

	@Autowired
	private SqlSession ss;
	
	
	public void getUserSearchResult(HttpServletRequest req, User_o u_o) {

		
		try {
			req.setAttribute("otherMember", ss.getMapper(SearchMapper.class).getOtherProfile());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
