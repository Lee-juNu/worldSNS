package com.team.worlds.server;

import javax.websocket.Session;

public class ChatUser {
	private Session session;
	private String userId;
	
	
	public ChatUser(Session session, String userId) {
		this.session = session;
		this.userId = userId;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
