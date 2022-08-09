package com.team.worlds.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@Autowired
	private UserDAO uDAO;
	
	
	
	
	@RequestMapping(value = "/user.login", method = RequestMethod.POST)
	public String userLogin(User u, HttpServletRequest req) {
		
		//System.out.println(u.getUser_ID());
		//System.out.println(u.getUser_PW());
		
		// 로그인
		uDAO.login(u, req);
		
		User u2 = (User) req.getSession().getAttribute("loginMember");
		if (u2 != null) {
			req.setAttribute("menuPage", "jy/menu.jsp");
			req.setAttribute("contentsPage", "sik/board.jsp");
			req.setAttribute("profilePage", "profileMini.jsp");
			
			return "home";
			
		}else {
			req.setAttribute("loginPage", "jy/login.jsp");
			return "index";
		}
		
		
	}
	
	
	@RequestMapping(value = "/user.joinus.go", method = RequestMethod.GET)
	public String joinusGo(HttpServletRequest req) {
		
		
		req.setAttribute("joinusPage", "joinus1.jsp");

		
		return "jy/joinusMain";
		
	}
	
	@RequestMapping(value = "/user.joinus.go2", method = RequestMethod.POST)
	public String joinusGo2(HttpServletRequest req) {
		
		
		req.setAttribute("joinusPage", "joinus2.jsp");
		
		
		return "jy/joinusMain";
		
	}
	@RequestMapping(value = "/user.joinus.go3", method = RequestMethod.POST)
	public String joinusGo3(HttpServletRequest req) {
		
		
		req.setAttribute("joinusPage", "joinus3.jsp");
		
		
		return "jy/joinusMain";
		
	}
	@RequestMapping(value = "/user.joinus.go4", method = RequestMethod.POST)
	public String joinusGo4(HttpServletRequest req) {
		
		
		req.setAttribute("joinusPage", "joinus4.jsp");
		
		
		return "jy/joinusMain";
		
	}
	@RequestMapping(value = "/user.joinus.go5", method = RequestMethod.POST)
	public String joinusGo5(User u,HttpServletRequest req) {
		
		
		uDAO.joinus(u, req);
		req.setAttribute("joinusPage", "joinus5.jsp");
		
		
		return "jy/joinusMain";
		
	}
	@RequestMapping(value = "/setting.go", method = RequestMethod.GET)
	public String temp_goSetting(User u, HttpServletRequest req) {
				
		//세션 만들고
		//로그인 체크하고
		uDAO.templogin(req);
		
		req.setAttribute("profilePage", "profileMini.jsp");
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/setting.jsp");
		
		return "home";
	}
	
	

}
