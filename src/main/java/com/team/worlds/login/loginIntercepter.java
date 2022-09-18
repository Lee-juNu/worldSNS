package com.team.worlds.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class loginIntercepter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

		System.out.println("MyInterCeptor - preHandle");

		return true;
	}

	// controller의 handler가 끝나면 처리됨
	@Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response,
            Object obj, ModelAndView mav)
            throws Exception {
    	
    	 HttpSession httpSession = request.getSession();
    	 
    	 
    	 
    	 ModelMap modelMap = mav.getModelMap();
    	    Object userVO =  modelMap.get("User");

    	    if (userVO != null) {
    	    	System.out.println("로그인 성공");
    	        
    	        
    	        httpSession.setAttribute("loginMember", userVO);
    	        //response.sendRedirect("/");

    	        if (request.getParameter("useCookie") != null) {
    	           System.out.println("remember me");
    	        	
    	        	
    	        	// 쿠키 생성
    	            Cookie loginCookie = new Cookie("loginCookie", httpSession.getId());
    	            loginCookie.setPath("/");
    	            loginCookie.setMaxAge(60*60*24*7);
    	            // 전송
    	            response.addCookie(loginCookie);
    	        }

    	        Object destination = httpSession.getAttribute("destination");
    	        response.sendRedirect(destination != null ? (String) destination : "/");
    	    }

    	}

	// view까지 처리가 끝난 후에 처리됨
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)
			throws Exception {
	}
	
	
	
	
	
}