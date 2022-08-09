package com.team.worlds.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SettingController {


@Controller
public class UserController {
	@Autowired
	private UserDAO uDAO;
	
	@RequestMapping(value = "/setting.go.info", method = RequestMethod.GET)
	public String SettingInfo(User u, HttpServletRequest req) {
	
		uDAO.templogin(req);
		
		req.setAttribute("profilePage", "profileMini.jsp");
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/setting/SettingInfo.jsp");
		
		return "home";
	}
	
	
}
}