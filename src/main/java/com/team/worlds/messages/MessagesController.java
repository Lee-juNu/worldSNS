package com.team.worlds.messages;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.worlds.user.User;

@Controller
public class MessagesController {
	
	
	@Autowired
	private MessageDAO mDAO;
	
	@RequestMapping(value = "/messages.go", method = RequestMethod.GET)
	public String home(HttpServletRequest req, User u) {
		
		//로그인완성되면 체크 필수
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "su/message.jsp");
		mDAO.get(req);
		mDAO.getUser(req, u);
		mDAO.getMsg(req);
		return "home";
	}

	@RequestMapping(value = "/messages.send", method = RequestMethod.POST)
	public String send(HttpServletRequest req, Message M) {
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "su/message.jsp");
		mDAO.send(req, M);
		mDAO.get(req);
		mDAO.getMsg(req);
		return "home";
	}

	@RequestMapping(value = "/messages.open", method = RequestMethod.GET)
	public String open(HttpServletRequest req, Message M) {

		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "su/message.jsp");
		mDAO.open(req, M);
		mDAO.join(req, M);
		mDAO.get(req);
		mDAO.getMsg(req);
		return "home";
	}

	@RequestMapping(value = "/messages.join", method = RequestMethod.GET)
	public String join(HttpServletRequest req, Message M) {
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "su/message.jsp");
		mDAO.join(req, M);
		mDAO.get(req);
		mDAO.getMsg(req);
		return "home";
	}

	@RequestMapping(value = "/messages.select", method = RequestMethod.GET)
	public String select(HttpServletRequest req, Message M) {
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "su/message.jsp");
		mDAO.select(req, M);
		mDAO.get(req);
		mDAO.getMsg(req);
		return "home";
	}
}
