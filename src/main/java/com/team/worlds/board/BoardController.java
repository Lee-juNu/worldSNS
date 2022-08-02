package com.team.worlds.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.worlds.user.UserDAO;

@Controller
public class BoardController {

	//게시물창을 보기위해선 home.go를 이용해주세요
	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String (HttpServletRequest req) {
		
		
		
		return "home";
	}
	*/
}
