package com.team.worlds.user;

public interface UserMapper {
	User tempSelectUser();

	User getMemberByID(String u);
	User getMemberProfileByID(String p);
	User login(User u);
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

}
