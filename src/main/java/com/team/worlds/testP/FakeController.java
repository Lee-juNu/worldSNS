package com.team.worlds.testP;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.worlds.user.User;
import com.team.worlds.user.UserDAO;

@Controller
public class FakeController {
	
	@Autowired
	UserDAO uDAO = new UserDAO();
	
	
	@RequestMapping(value = "/fake.login", method = RequestMethod.POST)
	public String home(HttpServletRequest req) {
		
		System.out.println(req.getParameter("user_ID"));
		req.getSession().setAttribute("user_ID",req.getParameter("user_ID")); 
		req.setAttribute("roomNum", req.getParameter("roomNum"));

		return "jw/testJSP/test";
	}
	@RequestMapping(value = "/fakeHome.Go", method = RequestMethod.POST)
	public String homeGo(HttpServletRequest req) {
		return "home";
	}
	
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public @ResponseBody boolean joinDo(HttpServletRequest req, User u) {
			
		if(uDAO.joinUs(u, req))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@RequestMapping(value = "/loginTest", method = RequestMethod.GET)
	public @ResponseBody boolean testLogin(HttpServletRequest req, User u) {
		if(uDAO.login2(u,req))
		{
			
			req.setAttribute("profilePage", "profileMini.jsp");
			
			req.setAttribute("menuPage", "jy/menu.jsp");
			req.setAttribute("contentsPage", "fakePage");
			return true;			
		}
		else
			return false;
	}
	
	
	@RequestMapping(value = "{profile}", method = RequestMethod.GET)
	public String goProfile(HttpServletRequest req, @PathVariable("profile") String profile) {

		uDAO.loginCheck(req);
		
		
		uDAO.getUserByID(profile, req);
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jw/fakeProfile.jsp");
		
		return "home";
	}
	
}
