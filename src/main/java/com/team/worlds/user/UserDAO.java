package com.team.worlds.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {

	
	@Autowired
	SqlSession ss;
	
	public void login(HttpServletRequest req)
	{
		User dbUser = ss.getMapper(UserMapper.class).tempSelectUser();
		
		if(dbUser != null)
		{
			System.out.println(dbUser.getUser_nickName());
		}
		else
		{
			System.out.println("실패");
		}
	}

	
	public void tempLogin(HttpServletRequest req) {

		String user_id = "yorunohosi";
		
		User dbUser = ss.getMapper(UserMapper.class).tempSelectUser();
		
	//	User U = new User();

		req.getSession().setAttribute("loginMember", dbUser);
	//	req.getSession().setMaxInactiveInterval(60 * 10);
		
		if(dbUser != null)
		{
			System.out.println(dbUser.getUser_nickName());
		}
		else
		{
			System.out.println("실패");
		}
	}
	
}




