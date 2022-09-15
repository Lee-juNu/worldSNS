package com.team.worlds.board;

import java.util.ArrayList;

public interface BoardMapper {
	int boardInsert(Board board);
	ArrayList<BoardOutput> getBoardByFollower(String userId);
}
