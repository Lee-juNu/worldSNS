package com.team.worlds.user;

public interface ProfileMapper {

	Profile getProfileByID(String p);

	int createProfile(String id);

	
}
