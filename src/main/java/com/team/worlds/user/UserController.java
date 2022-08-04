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
		
		// 로그인
		uDAO.login(u, req);
		
		User u2 = (User) req.getSession().getAttribute("loginMember");
		if (u2 != null) {
			req.setAttribute("menuPage", "jy/menu.jsp");
			req.setAttribute("contentsPage", "sik/board.jsp");
			
			return "home";
			
		}else {
			req.setAttribute("loginPage", "jy/login.jsp");
			return "index";
		}
		
		
	}
}
