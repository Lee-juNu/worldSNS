package com.team.worlds.testP;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FakeController {
	@RequestMapping(value = "/fake.login", method = RequestMethod.POST)
	public String home(HttpServletRequest req) {
		
		System.out.println(req.getParameter("user_ID"));
		req.getSession().setAttribute("user_ID",req.getParameter("user_ID")); 
		req.setAttribute("roomNum", req.getParameter("roomNum"));

		return "jw/testJSP/test";
	}
	
	@RequestMapping(value = "/fake.home", method = RequestMethod.GET)
	public String fakeHome(HttpServletRequest req) {
		
		return "jw/fakeHome";
	}
}
