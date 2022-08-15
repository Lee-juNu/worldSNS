package com.team.worlds.messages;

import java.util.List;

import com.team.worlds.user.User;


public interface MessageMapper {

	int send(Message m);

	int open(Message m);

	public List<Message> get();

	int join(Message m);
	int join2(Message m);

	public List<User> getUser(String User_ID);

//	public List<Message> getMsg(String msg_RoomNum);
	public List<Message> getMsg(Message m);

	public List<Message> updateIndex(Message m);

	public List<Message> getRoom(Message m);

	Object send();

	Object getMsg();


}
