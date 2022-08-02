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
			System.out.println(dbUser.getUser_id());
			System.out.println(dbUser.getUser_nickName());
			req.setAttribute("user", dbUser);
		}
		else
		{
			System.out.println("실패");
		}
	}
	
}
