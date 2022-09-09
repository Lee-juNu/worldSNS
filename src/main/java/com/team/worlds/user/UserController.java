package com.team.worlds.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.worlds.server.wsFileManager;

@Controller
public class UserController {
	@Autowired
	private UserDAO uDAO;
	/*
	
	@RequestMapping(value = "/profile/go/ID={user_ID_o}", method = RequestMethod.GET)
	public String goOtherProfile(@PathVariable("user_ID_o") String user_ID_o,
			User u, HttpServletRequest req, User_o u_o, Profile_o p_o) {
		
		//세션 만들고
		//로그인 체크하고

		uDAO.loginCheck(req);
		uDAO.goProfile(user_ID_o, u, u_o,p_o, req);
		
		
		
		req.setAttribute("profilePage", "profileMini.jsp");
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/profile_o.jsp");
		
		return "index";
	}
	
	*/
	
	

	
	 
/*	@RequestMapping(value = "/profile.go/ID={user_ID_o}", method = RequestMethod.GET)
	public String temp_gootherdsss(@PathVariable("user_ID_o") String user_ID_o, User u, HttpServletRequest req) {
				
		//세션 만들고
		//로그인 체크하고
	//	uDAO.templogin(req);
	//	uDAO.loginCheck(req);
		
		
		req.setAttribute("profilePage", "profileMini.jsp");
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/setting.jsp");
		
		return "home";
	}
	*/
	
	@RequestMapping(value = "/user.login", method = RequestMethod.POST)
	public String userLogin(Profile p, User u, HttpServletRequest req) {
		
		//System.out.println(u.getuser_ID());
		//System.out.println(u.getUser_PW());
		
		// 로그인
		uDAO.login(u, req);
		
		
		u = (User) req.getSession().getAttribute("loginMember");
//		p = (Profile) req.getSession().getAttribute("loginMember");
		
		if (u != null) {
			
			req.setAttribute("menuPage", "jy/menu.jsp");
			req.setAttribute("contentsPage", "sik/board.jsp");
			req.setAttribute("profilePage", "profileMini.jsp");
			
			
			return "home";
			
			
		}else {
			req.setAttribute("loginPage", "jy/login.jsp");
			return "index";
		}
	}
	

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String temp_home(HttpServletRequest req) {
		
		
	
		uDAO.logout(req);
		
		return "redirect:/";
		
	}
	
	
	
	@RequestMapping(value = "/user.joinus.go", method = RequestMethod.GET)
	public String joinusGo(HttpServletRequest req) {
		
		
		req.setAttribute("joinusPage", "joinus1.jsp");

		
		return "jy/joinusMain";
		
	}
	

	// id 중복 체크 컨트롤러
	@RequestMapping(value = "/user/idCheck", method = RequestMethod.GET)
	@ResponseBody
	public boolean idCheck(@RequestParam("user_ID") String user_ID) {

		

		System.out.println(user_ID);
		
		return uDAO.userIdCheck(user_ID);
	}

	@RequestMapping(value = "/user.findid.go", method = RequestMethod.GET)
	public String findid(HttpServletRequest req) {
		
		
		req.setAttribute("joinusPage", "Find/FID.jsp");

		
		return "jy/joinusMain";
		
	}

	@RequestMapping(value = "/user.findid.idr", method = RequestMethod.POST)
	public String findidR(User u, HttpServletRequest req) {
		
		System.out.println("컨트롤러");
		
		uDAO.findID(u, req);
		
		req.setAttribute("joinusPage", "Find/FIDR.jsp");

		
		return "jy/joinusMain";
		
	}
	
	@RequestMapping(value = "/user.findid.pw", method = RequestMethod.GET)
	public String findpw(HttpServletRequest req) {
		
		
		req.setAttribute("joinusPage", "Find/FPW.jsp");

		
		return "jy/joinusMain";
		
	}

	@RequestMapping(value = "/user.findid.pwr", method = RequestMethod.POST)
	public String findpwR(User u, HttpServletRequest req) {
		
		uDAO.findPW(u, req);
		req.setAttribute("joinusPage", "Find/FPWR.jsp");

		
		return "jy/joinusMain";
		
	}
	
	
	
	
	
	@RequestMapping(value = "/user.joinus.go2", method = RequestMethod.POST)
	public String joinusGo2(HttpServletRequest req) {
		
		
		req.setAttribute("joinusPage", "joinus2.jsp");
		
		
		return "jy/joinusMain";
		
	}
	@RequestMapping(value = "/user.joinus.go3", method = RequestMethod.POST)
	public String joinusGo3(HttpServletRequest req) {
		
		
		req.setAttribute("joinusPage", "joinus3.jsp");
		
		
		return "jy/joinusMain";
		
	}
	@RequestMapping(value = "/user.joinus.go4", method = RequestMethod.POST)
	public String joinusGo4(HttpServletRequest req) {
		
		
		req.setAttribute("joinusPage", "joinus4.jsp");
		
		
		return "jy/joinusMain";
		
	}
	@RequestMapping(value = "/user.joinus.go5", method = RequestMethod.POST)
	public String joinusGo5(Profile p, User u,HttpServletRequest req) {
		

		System.out.println("흠");
		
		uDAO.joinus(u, req);
		req.setAttribute("joinusPage", "joinus5.jsp");
		
		
		return "jy/joinusMain";
		
	}
	@RequestMapping(value = "/setting.go", method = RequestMethod.GET)
	public String temp_goSetting(User u, HttpServletRequest req) {
				
		//세션 만들고
		//로그인 체크하고
		uDAO.templogin(req);
		uDAO.loginCheck(req);
		
		
		req.setAttribute("profilePage", "profileMini.jsp");
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/setting.jsp");
		
		return "home";
	}
	
	
	

}
