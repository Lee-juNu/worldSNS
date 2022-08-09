package com.team.worlds.user;

import java.io.File;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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



	public void joinus(User u, HttpServletRequest req) {
		// TODO Auto-generated method stub
	

		String juser_ID = req.getParameter("user_ID");
		String juser_PW = req.getParameter("user_PW");
		String juser_nickName = req.getParameter("user_nickName");
		String juser_phoneNumber = req.getParameter("user_phoneNumber");
		String juser_name = req.getParameter("user_name");
		String juser_email = req.getParameter("user_email");
		String juser_city = req.getParameter("user_city");
		String juser_birthDay = req.getParameter("user_birthDay");
		int jlevel = Integer.parseInt(req.getParameter("level"));
	//	String jregDate = req.getParameter("regDate");
	//	jm_photo = URLEncoder.encode(jm_photo, "utf-8");
	//	jm_photo = jm_photo.replace("+", " ");

		
		u.setUser_ID(juser_ID);
		u.setUser_PW(juser_PW);
		u.setUser_nickName(juser_nickName);
		u.setUser_phoneNumber(juser_phoneNumber);
		u.setUser_name(juser_name);
		u.setUser_email(juser_email);
		u.setUser_city(juser_city);
		u.setUser_birthDay(juser_birthDay);
		u.setLevel(jlevel);
	//	u.setRegDate(jregDate);
		

		if (ss.getMapper(UserMapper.class).joinus(u) == 1) {
			req.setAttribute("result", "성공적으로 가입이 완료되었습니다!");
		} else {
			req.setAttribute("result", "가입에 실패하였습니다.. 잠시 후 다시 시도해 주세요!");
		
	} 
		
	}
		
	}



	
		
	




