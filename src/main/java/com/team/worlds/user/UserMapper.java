package com.team.worlds.user;

public interface UserMapper {
	User tempSelectUser();

	User getMemberByID(String u);

	int joinus(User u);

	int secession(User u);

	int update(Profile p);
}
