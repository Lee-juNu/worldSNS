package com.team.worlds.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.team.worlds.server.wsFileManager;

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
		
		if(wsFileManager.getFilePath()=="")
		{
			wsFileManager.setFilePath(request.getSession().getServletContext().getRealPath("resources/img/"));
			//파일 이미지 경로가 셋팅되었습니다.
			System.out.println(wsFileManager.getFilePath());	
		}

    	}

	// view까지 처리가 끝난 후에 처리됨
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)
			throws Exception {
	}
}
