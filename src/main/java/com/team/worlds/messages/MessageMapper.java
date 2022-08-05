package com.team.worlds.messages;

import java.util.List;

import com.team.worlds.user.User;


public interface MessageMapper {

	int send(Message m);

	int open(Message m);

	public List<Message> get();

	int join(Message m);

	public List<User> getUser(String User_ID);

}
