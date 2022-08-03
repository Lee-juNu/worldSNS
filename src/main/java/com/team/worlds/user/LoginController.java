package com.team.worlds.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	
	
	@Autowired
	UserDAO uDAO;
	
	@RequestMapping(value = "/member.login.temp", method = RequestMethod.GET)
	public String tempLogin(User u, HttpServletRequest req) {
		
		uDAO.tempLogin(req);
		
		return "index";
	}
}
