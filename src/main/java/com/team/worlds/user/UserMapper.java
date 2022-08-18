package com.team.worlds.user;

public interface UserMapper {
	User tempSelectUser();

	User getMemberByID(String u);

	int joinus(User u);

	int secession(User u);

	int update(Profile p);


	int updateInfo(User u);

	int updatePW(User u);

	User getMemberByEmail(User u);

	User getMemberByIDEmail(User u);

	int updateFindPW(User u);

	int updateProfile(Profile p, User u);
}
