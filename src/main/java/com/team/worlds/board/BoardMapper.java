package com.team.worlds.board;

import java.util.ArrayList;
import java.util.HashMap;

public interface BoardMapper {
	int boardInsert(Board board);
	ArrayList<BoardOutput> getBoardByFollower(HashMap<String, Object> boardMap);
	ArrayList<BoardOutput> getBoardByNum(HashMap<String, String> map);
	ArrayList<BoardOutput> getBoardByFollowerAndRegion(HashMap<String, Object> map);
	ArrayList<BoardOutput> getBoardByFollowerAndCountry(HashMap<String, String> map);
	void boardDelete(String number);
	ArrayList<BoardOutput> getBoardByID(HashMap<String, Object> boardMap);
}