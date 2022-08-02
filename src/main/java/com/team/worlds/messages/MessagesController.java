package com.team.worlds.messages;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MessagesController {
	@RequestMapping(value = "/messages.go", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		
		//로그인완성되면 체크 필수
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "su/message.jsp");
		
		return "home";
	}
}
