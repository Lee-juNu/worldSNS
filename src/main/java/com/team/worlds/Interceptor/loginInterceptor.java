package com.team.worlds.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.team.worlds.user.User;
import com.team.worlds.user.UserDAO;

public class loginInterceptor implements HandlerInterceptor {
	
	@Autowired
	UserDAO udao;
	
	@Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

return true;
		//하단의 Url 체크를 통해, login 페이지는 예외처리를 해줘야 무한 리디렉션에서 벗어날 수 있다
	 }
	 @Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
