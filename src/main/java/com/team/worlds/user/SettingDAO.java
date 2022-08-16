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
		
		
		u = (User) req.getSession().getAttribute("loginMember");
		
		
		
		if (settingPassword1.equals(u.getUser_PW())) {
			
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword2.jsp");

		} else {
			req.setAttribute("result", "비밀번호가 틀렸습니다!");
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword4.jsp");

		}
		
		
		
	}

	

	public void SettingPW2(User u, HttpServletRequest req) {


		
		String settingPassword1 = req.getParameter("settingPassword1");
		String settingPassword2 = req.getParameter("settingPassword2");
		u = (User) req.getSession().getAttribute("loginMember");
		
		
		if (settingPassword2 == settingPassword1) {
			req.setAttribute("result", "ㅇㅇㅇ를 포함한 새로운 비밀번호를 만들어 주세요!");
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword4.jsp");
			System.out.println("뭐가달라");
			
		} else if (settingPassword2 != settingPassword1) {
			System.out.println("1달라");
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword3.jsp");

		} else {
			req.setAttribute("result", "비밀번호가 틀렸습니다!");
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword4.jsp");

		}
		
		
		
	}

	
	
	public void SettingPW3(User u, HttpServletRequest req) {
		

		
		String settingPassword2 = req.getParameter("settingPassword2");
		String settingPassword3 = req.getParameter("settingPassword3");
		u = (User) req.getSession().getAttribute("loginMember");
		//System.out.println("마지막"+settingPassword2);
		System.out.println("마지막"+settingPassword3);
		
		u.setUser_PW(settingPassword3);
		
		System.out.println("1"+u.getUser_PW());
		
		if (ss.getMapper(UserMapper.class).updatePW(u) == 1) {
			
			
			req.setAttribute("result", "비밀번호 변경 성공!");
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword4.jsp");
			System.out.println("2"+u.getUser_PW());
			
		} else {
			req.setAttribute("result", "새로운 비밀번호와 같은 비밀번호를 다시 입력해 주세요!");
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword4.jsp");
			
		}
		
		
		
	}
	
	
	


}
