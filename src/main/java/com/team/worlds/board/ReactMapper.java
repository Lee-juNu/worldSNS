package com.team.worlds.board;

public interface ReactMapper {
	int regLike(Like like);

	Like getByID(Like like);

	int deleteLike(Like like);
	
}
