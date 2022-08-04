package com.team.worlds.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {

	
	@Autowired
	SqlSession ss;
	
	public void templogin(HttpServletRequest req)
	{
		
		
		
		User dbUser = ss.getMapper(UserMapper.class).tempSelectUser();
		
		if(dbUser != null)
		{
			System.out.println(dbUser.getUser_nickName());
		}
		else
		{
		}
	}

	

	public void login(User u, HttpServletRequest req) {

	
	
		
		User dbUser = ss.getMapper(UserMapper.class).getMemberByID(u.getUser_ID());

		
		
		
		if (dbUser != null) {
			if (u.getUser_PW().equals(dbUser.getUser_PW())) {
				req.getSession().setAttribute("loginMember", dbUser);
				req.getSession().setMaxInactiveInterval(600 * 10);
				System.out.println(dbUser.getUser_nickName());
			
			} else {
				System.out.println("실패");
				req.setAttribute("result", "로그인을 다시 시도해 주세요.");
			}
		} else {
			System.out.println("실패");
			req.setAttribute("result", "로그인을 다시 시도해 주세요.");
		}

		
		
		
		
		
	}


	public boolean loginCheck(HttpServletRequest req) {
		User u = (User) req.getSession().getAttribute("loginMember");
		if (u != null) {
			req.setAttribute("profileMini", "jy/profileMini.jsp");
			return true;
		}else {
			
			return false;
		}
		

	
}

}


