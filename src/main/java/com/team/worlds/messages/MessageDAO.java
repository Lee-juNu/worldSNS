package com.team.worlds.messages;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageDAO {

	
	
	@Autowired
	private SqlSession ss;

	public void send(HttpServletRequest req, Message m) {
		
	}
	
	
	
}
