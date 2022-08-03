package com.team.worlds;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.worlds.user.UserDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	UserDAO uDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		
		uDAO.login(req);
		
		return "index";
	}
	@RequestMapping(value = "/home.go", method = RequestMethod.GET)
	public String goHome(HttpServletRequest req) {
				
		//세션 만들고
		//로그인 체크하고
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "sik/board.jsp");
		
		return "home";
	}
}
