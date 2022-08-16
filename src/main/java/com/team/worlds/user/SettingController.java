package com.team.worlds.user;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SettingController {

	@Autowired
	private UserDAO uDAO;
	@Autowired
	private SettingDAO sDAO;
	

	@RequestMapping(value = "/setting.go.Info", method = RequestMethod.GET)
	public String goSettingInfo(User u, HttpServletRequest req) {
		
		uDAO.loginCheck(req);
		req.setAttribute("profilePage", "profileMini.jsp");
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/Setting/SettingInfo.jsp");
		
		return "home";
	}
	

	@RequestMapping(value = "/setting.go.InfoUp", method = RequestMethod.GET)
	public String goSettingInfoUp(User u, HttpServletRequest req) {
		
		System.out.println("빨리ㅜ시고싶다");
		
		
		uDAO.loginCheck(req);
		req.setAttribute("profilePage", "profileMini.jsp");
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/Setting/SettingInfoUp.jsp");
		
		return "home";
	}
	
	@RequestMapping(value = "/setting.go.InfoUpR", method = RequestMethod.GET)
	public String goSettingInfoUpR(User u, HttpServletRequest req) {
		
		System.out.println("빨리ㅜ시고싶다");
		
		
		uDAO.loginCheck(req);
		uDAO.updateInfo(u, req);
		
		req.setAttribute("profilePage", "profileMini.jsp");
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/Setting/SettingInfo.jsp");
		
		return "home";
	}
	
	
	@RequestMapping(value = "/setting.go.Password", method = RequestMethod.GET)
	public String goSettingPassword(User u, HttpServletRequest req) {
	
		uDAO.loginCheck(req);
		u = (User) req.getSession().getAttribute("loginMember");
		System.out.println("연결됨");

		//System.out.println(Session.getAttribute("user_name"));
		// req.setParameter("settingPassword1","settingPassword1")
		req.setAttribute("profilePage", "profileMini.jsp");
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/Setting/SettingPassword.jsp");
		
		return "home";
	}
	@RequestMapping(value = "/setting.go.Password2", method = RequestMethod.POST)
	public String goSettingPassword2(User u, HttpServletRequest req) {

		
		
		//System.out.println("ㅇㅇ" + req.getParameter("settingPassword1"));
		
		uDAO.loginCheck(req);
		sDAO.SettingPW1(u, req);
		//u = (User) req.getSession().getAttribute("loginMember");
		//System.out.println(Session.getAttribute("user_name"));

	
		req.setAttribute("profilePage", "profileMini.jsp");
		req.setAttribute("menuPage", "jy/menu.jsp");
		//req.setAttribute("contentsPage", "jy/Setting/SettingPassword2.jsp");
		
		return "home";
	}
	@RequestMapping(value = "/setting.go.Password3", method = RequestMethod.GET)
	public String goSettingPassword3(User u, HttpServletRequest req) {
	
		uDAO.loginCheck(req);
		sDAO.SettingPW2(u, req);
		
		u = (User) req.getSession().getAttribute("loginMember");
		System.out.println("연결됨");
		//System.out.println(Session.getAttribute("user_name"));
	
		req.setAttribute("profilePage", "profileMini.jsp");
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		
		return "home";
	}
	@RequestMapping(value = "/setting.go.Password4", method = RequestMethod.GET)
	public String goSettingPassword4(User u, HttpServletRequest req) {
	
		uDAO.loginCheck(req);
		sDAO.SettingPW3(u, req);
		
		u = (User) req.getSession().getAttribute("loginMember");
		System.out.println("연결됨");
		//System.out.println(Session.getAttribute("user_name"));
	
		req.setAttribute("profilePage", "profileMini.jsp");
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		
		return "home";
	}
	
	
	@RequestMapping(value = "/setting.go.Notice", method = RequestMethod.GET)
	public String goSettingNotice(User u, HttpServletRequest req) {
		
		uDAO.loginCheck(req);
		
		req.setAttribute("profilePage", "profileMini.jsp");
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/Setting/SettingNotice.jsp");
		
		return "home";
	}
	
	
	
	@RequestMapping(value = "/setting.go.Profile", method = RequestMethod.GET)
	public String goSettingProfile(User u, HttpServletRequest req) {
		
		uDAO.loginCheck(req);
		req.setAttribute("profilePage", "profileMini.jsp");
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/Setting/SettingProfile.jsp");
		
		return "home";
	}
	

	@RequestMapping(value = "/setting.go.Secession", method = RequestMethod.GET)
	public String goSettingSecession(User u, HttpServletRequest req) {
		
		uDAO.loginCheck(req);
		
		req.setAttribute("profilePage", "profileMini.jsp");
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/Setting/SettingSecession.jsp");
		
		return "home";
	}
	
	@RequestMapping(value = "/setting.go.SecessionR", method = RequestMethod.GET)
	public String goSettingSecessionR(User u, HttpServletRequest req) {
		
		uDAO.loginCheck(req);
		uDAO.secession(req);
		
		req.setAttribute("profilePage", "profileMini.jsp");
		
		
		req.setAttribute("menuPage", "jy/menu.jsp");
		req.setAttribute("contentsPage", "jy/Setting/SettingSecessionR.jsp");
		
		return "home";
	}
	
	
	
}
