package com.team.worlds.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingDAO {

	@Autowired
	SqlSession ss;


	public void SettingPW1(User u, HttpServletRequest req) {


		
		String settingPassword1 = req.getParameter("settingPassword1");
		
		System.out.println("어\n\\n\\n\\n\\n어" + settingPassword1);
		
		u = (User) req.getSession().getAttribute("loginMember");
		
		
		System.out.println("ㄴㅇㅃㅃㄹ" + u.getUser_PW());

		if (settingPassword1.equals(u.getUser_PW())) {
			
			System.out.println("여기까진 옴");
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword2.jsp");

		} else {
			req.setAttribute("r", "비밀번호가 틀렸습니다!");
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword4.jsp");

		}
		
		
		
	}

	
	
	


}
