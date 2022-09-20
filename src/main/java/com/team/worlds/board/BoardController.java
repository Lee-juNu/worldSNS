package com.team.worlds.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class BoardController {
	
	@Autowired
	FakeBoardDAO bDAO;
	
	@RequestMapping(value = "/boardUpload", method = RequestMethod.POST)
	public @ResponseBody String boardUpload(HttpServletRequest req) {
		
		
		return "결과";
	}
	
}
