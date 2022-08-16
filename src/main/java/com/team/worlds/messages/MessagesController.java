package com.team.worlds.messages;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.worlds.user.User;

@Controller
public class MessagesController {
	
	
	@Autowired
	private MessageDAO mDAO;
	
	@RequestMapping(value = "/messages.go", method = RequestMethod.GET)
	public String home(HttpServletRequest req, User u) {
		req.setAttribute("profilePage", "profileMini.jsp");
		
		//로그인완성되면 체크 필수
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "su/message.jsp");
		mDAO.get(req);
		mDAO.getUser(req, u);
//		mDAO.getMsg(req);
		return "home";
	}

/*	@RequestMapping(value = "/messages.send", method = RequestMethod.POST)
	public String send(HttpServletRequest req, Message M) {
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "su/message.jsp");
		mDAO.send(req, M);
		mDAO.get(req);
		mDAO.getMsg(req);
		mDAO.updateIndex(req, M);
		return "home";
	}
*/	
	@RequestMapping(value = "/messages.send", method = RequestMethod.GET)
	public @ResponseBody Message send(HttpServletRequest req, Message M) {
		mDAO.send(M);
		System.out.println("dd");
		return mDAO.send;
	}

	@RequestMapping(value = "/messages.getMsg", method = RequestMethod.GET)
	public @ResponseBody Message getMsg(HttpServletRequest req, Message M) {
		mDAO.getMsg(M);
		System.out.println("d2d");
		return mDAO.getMsg;
	}

	@RequestMapping(value = "/messages.open", method = RequestMethod.GET)
	public String open(HttpServletRequest req, Message M) {
		req.setAttribute("profilePage", "profileMini.jsp");
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "su/message.jsp");
		mDAO.open(req, M);
		mDAO.join(req, M);
		mDAO.join2(req, M);
		mDAO.get(req);
//		mDAO.getMsg(req);
		return "home";
	}

	@RequestMapping(value = "/messages.join", method = RequestMethod.GET)
	public String join(HttpServletRequest req, Message M) {
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "su/message.jsp");
		mDAO.join(req, M);
		mDAO.get(req);
//		mDAO.getMsg(req);
		return "home";
	}

	@RequestMapping(value = "/messages.select", method = RequestMethod.GET)
	public String select(HttpServletRequest req, Message M) {
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "su/message.jsp");
		mDAO.select(req, M);
		mDAO.get(req);
//		mDAO.getMsg(req);
		mDAO.getRoom(req, M);
		mDAO.updateIndex(req, M);
		return "home";
	}
}
