package com.team.worlds.board;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team.worlds.fileUtil.FileManager;
import com.team.worlds.user.User;
import com.team.worlds.util.Country;
import com.team.worlds.util.CountryMapper;
import com.team.worlds.util.Region;

@Service
public class FakeBoardDAO {

	@Autowired
	private SqlSession ss;

	
	public JsonArray getBoardByUserID(String userId)
	{
		ArrayList<BoardOutput> arrBoard =  ss.getMapper(BoardMapper.class).getBoardByFollower(userId);
		if(arrBoard.size()!=0)
		{
			System.out.println(arrBoard.get(0).getBoard_Contents());			
			System.out.println(arrBoard.get(0).getBoard_regDate());			
			
			return new GsonBuilder().create().toJsonTree(arrBoard).getAsJsonArray();
		}
		else 
		{
			System.out.println("실패인듯");
		}
		return null;
	}
	
	
	public void insertBoard(JSONObject result)
	{
		Board board = new Board();
		board.setBoard_userID(result.get("board_userId").toString());
		board.setBoard_Contents(result.get("board_contents").toString());
		board.setBoard_Country(result.get("board_country").toString());
		board.setBoard_City(result.get("board_region").toString());
		board.setBoard_ParentNum(result.get("board_parent").toString());
				
		
		String[] imgs =  result.get("board_imgs").toString().split("/");
		for(int i = 0 ; i<imgs.length;i++)
		{
			if(i==0)
			{
				board.setBoard_img1(imgs[i]);				
			}
			if(i==1)
			{
				board.setBoard_img2(imgs[i]);				
			}
			if(i==2)
			{
				board.setBoard_img3(imgs[i]);				
			}
			if(i==3)
			{
				board.setBoard_img4(imgs[i]);				
			}
		}
		
		if(1== ss.getMapper(BoardMapper.class).boardInsert(board))
		{
			System.out.println("성공이닷");
		}
		else
		{
			System.out.println("실패쓰");
		}
		
	}
	
	public JsonArray getAllCountry()
	{
		ArrayList<Country> arrCountry =  ss.getMapper(CountryMapper.class).getAllCountry();
		
			for (Country country : arrCountry) {
				System.out.println(country.getCountry_id());
			}

		return new GsonBuilder().create().toJsonTree(arrCountry).getAsJsonArray();
	}




	public JsonArray getRegionByCountry(String countryName) {
		
		ArrayList<Region> arrRegion = ss.getMapper(CountryMapper.class).getRegionByCountry(countryName);
		return new GsonBuilder().create().toJsonTree(arrRegion).getAsJsonArray();

	}

	public void getBoardByID(HttpServletRequest req) {
		
	}
	
}
