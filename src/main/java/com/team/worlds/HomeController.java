package com.team.worlds;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.worlds.board.FakeBoardDAO;
import com.team.worlds.server.wsFileManager;
import com.team.worlds.user.User;
import com.team.worlds.user.UserDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	UserDAO uDAO;
	
	@Autowired
	FakeBoardDAO bDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String temp_home(HttpServletRequest req) {
		
		
		
		
		bDAO.getBoardByUserID("admin");
		
		uDAO.templogin(req);
		req.setAttribute("loginPage", "jy/login.jsp");
		return "fakeIndex";
	}
	

	@RequestMapping(value = "/index.go", method = RequestMethod.GET)
	public String go_index(HttpServletRequest req) {
		uDAO.templogin(req);
		req.setAttribute("loginPage", "jy/login.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/home.go", method = RequestMethod.GET)
	public String temp_goHome(User u, HttpServletRequest req) {
				
		//세션 만들고
		//로그인 체크하고
		req.setAttribute("profilePage", "profileMini.jsp");
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jw/fakeBoard.jsp");

		return "home";
	}
	@RequestMapping(value = "/profile.go", method = RequestMethod.GET)
	public String temp_goProfile(User u, HttpServletRequest req) {
		//세션 만들고
		//로그인 체크하고
		uDAO.templogin(req);
		uDAO.loginCheck(req);
		
		req.setAttribute("profilePage", "profileMini.jsp");
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/profile.jsp");
		
		return "home";
	}

}
