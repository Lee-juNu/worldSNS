package com.team.worlds.board;

import java.util.ArrayList;
import java.util.HashMap;

public interface BoardMapper {
	int boardInsert(Board board);
	ArrayList<BoardOutput> getBoardByFollower(String userId);
	ArrayList<BoardOutput> getBoardByNum(HashMap<String, String> map);
	ArrayList<BoardOutput> getBoardByFollowerAndRegion(HashMap<String, String> map);
	ArrayList<BoardOutput> getBoardByFollowerAndCountry(HashMap<String, String> map);
	void boardDelete(String number);
}