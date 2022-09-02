package com.team.worlds.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class FollowController {

	@Autowired
	private UserDAO uDAO;
/*	@Autowired
	private SearchDAO seaDAO;*/
	@Autowired
	private FollowDAO fDAO;
	
	
	@RequestMapping(value = "/follow.follow/{user_ID_o}", method = RequestMethod.POST)
	public String follow(@PathVariable("user_ID_o") String user_ID_o, User u, HttpServletRequest req,Follow f) {
		
		System.out.println("되나?되나?되나?되나?되나?");

		uDAO.loginCheck(req);
		fDAO.follow(req,u,user_ID_o,f);
		fDAO.follow_count(req,u,user_ID_o,f);
		fDAO.follower_count(req,u,user_ID_o,f);
		
		req.setAttribute("profilePage", "profileMini.jsp");
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/Search/Search.jsp");
		req.setAttribute("searchPage", "SearchPost.jsp");
		
		
		return "home";
	}

	/*@RequestMapping(value = "/follow.unfollow/", method = RequestMethod.GET)
	public String unfollow(Profile p, User u, HttpServletRequest req) {
		
		uDAO.loginCheck(req);
		
		
		
		req.setAttribute("profilePage", "profileMini.jsp");
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/Search/Search.jsp");
		req.setAttribute("searchPage", "SearchPost.jsp");
		
		return "home";
	}*/
	
	
}
