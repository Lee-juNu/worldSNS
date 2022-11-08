package com.team.worlds.user;

import java.util.List;

public interface FollowMapper {

	int follow(Follow f);
	
	int unfollow(Follow f);
	
	String follow_count(Follow f);

	String follower_count(Follow f);
	
	public List<Follow> follow_list(Follow f);
	public List<Follow> follower_list(Follow f);

	int already_follow(Follow f);
}
