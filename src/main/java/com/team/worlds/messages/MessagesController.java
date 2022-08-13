package com.team.worlds.messages;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MessagesController {
	
	
	@Autowired
	private MessageDAO mDAO;
	
	@RequestMapping(value = "/messages.go", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		req.setAttribute("profilePage", "profileMini.jsp");
		
		//로그인완성되면 체크 필수
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "su/message.jsp");
		mDAO.get(req);
		
		return "home";
	}

	@RequestMapping(value = "/messages.send", method = RequestMethod.POST)
	public String send(HttpServletRequest req, Message M) {
		mDAO.send(req, M);
		mDAO.get(req);
		return "home";
	}

	@RequestMapping(value = "/messages.open", method = RequestMethod.GET)
	public String open(HttpServletRequest req, Message M) {
		req.setAttribute("profilePage", "profileMini.jsp");
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "su/message.jsp");
		mDAO.open(req, M);
		mDAO.get(req);
		return "home";
	}
}
