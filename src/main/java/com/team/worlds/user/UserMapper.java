package com.team.worlds.user;

import java.sql.Date;

import org.apache.tomcat.jni.User;

public interface UserMapper{
	LoginDTO tempSelectUser();

	LoginDTO getMemberByID(String u);
	LoginDTO getMemberProfileByID(String p);
	
	
	static User login(LoginDTO u) {
		// TODO Auto-generated method stub
		return null;
	}
	
	int joinus(LoginDTO u);

	int secession(LoginDTO u);

	int update(Profile p);


	int updateInfo(LoginDTO u);

	int updatePW(LoginDTO u);

	LoginDTO getMemberByEmail(LoginDTO u);

	LoginDTO getMemberByIDEmail(LoginDTO u);

	int updateFindPW(LoginDTO u);


	int updateUserProfile(LoginDTO u);
	
	int joinusp(Profile p);

	LoginDTO checkOverId(String user_ID);

	User_o getOtherMemberByID(User_o u_o);


	User_o getOtherProfileMemberByID(Profile_o p_o);

	int updateProfile(LoginDTO u);

	void keepLogin(String user_ID, String sessionId, Date next) throws Exception;

	static com.team.worlds.user.User checkLoginBefore(String value) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
