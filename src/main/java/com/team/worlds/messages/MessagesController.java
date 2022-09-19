package com.team.worlds.messages;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.RemoteEndpoint.Basic;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
	public String home(HttpServletRequest req, User u, Message M) {
		req.setAttribute("profilePage", "profileMini.jsp");
		
		//로그인완성되면 체크 필수
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "su/message.jsp");
		mDAO.get(req);
		mDAO.getUser(req, u);
		mDAO.indexcheck(M, req);
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
		return mDAO.getMsg;
	}

	@RequestMapping(value = "/messages.searchUser", method = RequestMethod.GET)
	public @ResponseBody List<User> search(User u) {
		String name = u.getUser_ID();
		System.out.println(name);
		mDAO.search(name);
		return mDAO.search(name);
	}

	@RequestMapping(value = "/messages.searchbyUser", method = RequestMethod.GET)
	public @ResponseBody List<Message> searchbyUser(Message m) {
		String name = m.getRm_userID();
		System.out.println(name);
		mDAO.searchbyUser(name);
		return mDAO.searchbyUser(name);
	}

	@RequestMapping(value = "/messages.inviteUser", method = RequestMethod.GET)
	public @ResponseBody void invite(Message msg, HttpServletRequest req) {
		String name = msg.getRm_roomNum();
		System.out.println(msg);
		System.out.println(name);
		mDAO.inviteUser(msg);
		mDAO.get(req);
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

	@RequestMapping(value = "/messages.out", method = RequestMethod.GET)
	public String out(HttpServletRequest req, Message M) {
		req.setAttribute("profilePage", "profileMini.jsp");
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "su/message.jsp");
		mDAO.get(req);
		mDAO.out(req, M);
		if (mDAO.checkRoom(req, M) == null) {
			mDAO.destroy(req, M);
			return "home";
		} else {
			return "home";
		}
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
		mDAO.indexcheck(M, req);
//		mDAO.updateIndex(req, M);
		return "home";
	}

	@RequestMapping(value = "/messages.getroomuser", method = RequestMethod.GET)
	public @ResponseBody List<Message> getroomuser(HttpServletRequest req, Message M) {
		System.out.println(req.getParameter("rm_RoomNum"));
		System.out.println(M.getRm_roomNum());
		String roomno = M.getRm_roomNum();
		mDAO.getroomuser(roomno);
		return mDAO.getroomuser(roomno);
	}
	
	
}
