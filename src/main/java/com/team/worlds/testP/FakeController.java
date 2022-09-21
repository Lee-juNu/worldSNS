package com.team.worlds.testP;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.worlds.user.Follow;
import com.team.worlds.user.FollowDAO;
import com.team.worlds.user.User;
import com.team.worlds.user.UserDAO;

@Controller
public class FakeController {
	
	@Autowired
	UserDAO uDAO = new UserDAO();
	

	@Autowired
	FollowDAO fDAO = new FollowDAO();
	
	
	
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
	
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public @ResponseBody boolean joinDo(HttpServletRequest req, User u) {
			System.out.println("안되냐?");
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
		System.out.println("되나?fakecontroller");
	
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
	
	
	/*	원래 profile
	 * @RequestMapping(value = "{profile}", method = RequestMethod.GET)
	public String goProfile(HttpServletRequest req, @PathVariable("profile") String profile) {
		
		uDAO.loginCheck(req);
		
		
		uDAO.getUserByID(profile, req);
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jw/fakeProfile.jsp");
		
		return "home";
	}
	 */	
	
	@RequestMapping(value = "{profile}", method = RequestMethod.GET)
	public String goProfile(HttpServletRequest req, @PathVariable("profile") String profile
			,User u, Follow f, @PathVariable("profile") String user_ID_o // jy수정 : 팔로워 수를 위한
			) {
										
		uDAO.loginCheck(req);
		
		
		uDAO.getUserByID(profile, req);
		
		
		// jy수정 : 팔로워 수를 위한
		fDAO.follow_count(req,u,user_ID_o,f);
		fDAO.follower_count(req,u,user_ID_o,f);
		
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jw/fakeProfile.jsp");
		
		return "home";
	}

}
