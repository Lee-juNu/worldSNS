package com.team.worlds.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class SearchController {

	@Autowired
	private UserDAO uDAO;
	@Autowired
	private SearchDAO seaDAO;
	
	
	@RequestMapping(value = "/Search.user", method = RequestMethod.GET)
	public String goSearchUser( Profile p, User_o u_o, HttpServletRequest req) {
		
		uDAO.loginCheck(req);
		seaDAO.getUserSearchResult(req,u_o);
		
		
		req.setAttribute("profilePage", "profileMini.jsp");
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/Search/Search.jsp");
		req.setAttribute("searchPage", "SearchUser.jsp");
		
		
		
		return "home";
	}
	
	
	/*	@RequestMapping(value = "/Search.user?searchWord={user_ID_o}", method = RequestMethod.GET)
	public String goSearchUser(@PathVariable("user_ID_o") String searchWord,  Profile p, User_o u_o, HttpServletRequest req) {
		
		uDAO.loginCheck(req);
		seaDAO.getUserSearchResult(req,u_o);
		
		
		req.setAttribute("profilePage", "profileMini.jsp");
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/Search/Search.jsp");
		req.setAttribute("searchPage", "SearchUser.jsp");
		
		
		
		
		
		
		return "home";
	}*/
	
	
	
	
	
	@RequestMapping(value = "/Search.post", method = RequestMethod.GET)
	public String goSearchPost(Profile p, User u, HttpServletRequest req) {
		
		uDAO.loginCheck(req);
		
		
		
		req.setAttribute("profilePage", "profileMini.jsp");
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/Search/Search.jsp");
		req.setAttribute("searchPage", "SearchPost.jsp");
		
		return "home";
	}
	
	
}
