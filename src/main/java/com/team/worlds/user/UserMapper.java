package com.team.worlds.user;

import java.sql.Date;


public interface UserMapper{
	User tempSelectUser();

	User getMemberByID(String u);
	User getMemberProfileByID(String p);
	
	
	static com.team.worlds.user.User login(User u) {
		// TODO Auto-generated method stub
		return null;
	}
	
	int joinus(User u);

	int secession(User u);

	int update(Profile p);


	int updateInfo(User u);

	int updatePW(User u);

	User getMemberByEmail(User u);

	User getMemberByIDEmail(User u);

	int updateFindPW(User u);


	int updateUserProfile(User u);
	
	int joinusp(Profile p);

	User checkOverId(String user_ID);

	User_o getOtherMemberByID(User_o u_o);


	User_o getOtherProfileMemberByID(Profile_o p_o);

	int updateProfile(User u);

	void keepLogin(String user_ID, String sessionId, Date next) throws Exception;


		
	
}
