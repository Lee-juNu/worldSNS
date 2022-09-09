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
			String searchWord = req.getParameter("searchWord");
			System.out.println("거엄색어"+ searchWord);
			
			
		/*	List<MemberBoardDTO> list = memberboardservice.listAll(search_option, keyword, start, end);
		  */      
			req.setAttribute("otherMember", ss.getMapper(SearchMapper.class).getOtherProfile(searchWord));
			
			System.out.println("거엄색어2"+ searchWord);
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
