package com.team.worlds.user;

public interface FollowMapper {

	int follow(Follow f);
	
	int unfollow(Follow f);
	
	String follow_count(Follow f);

	String follower_count(Follow f);
}
