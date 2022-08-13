package com.team.worlds.aram;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AramController {

	
	@RequestMapping(value = "/aram.go", method = RequestMethod.GET)
	public String goAram(HttpServletRequest req) {
		
		
		req.setAttribute("profilePage", "profileMini.jsp");
		
		//로그인완성되면 체크 필수
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "sik/aram.jsp");
		
		return "home";
	}
}
