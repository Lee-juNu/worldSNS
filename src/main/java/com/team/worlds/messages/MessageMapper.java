package com.team.worlds.messages;

import java.util.List;


public interface MessageMapper {

	int send(Message m);

	int open(Message m);

	public List<Message> get();

}
