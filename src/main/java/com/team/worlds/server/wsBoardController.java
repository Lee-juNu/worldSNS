package com.team.worlds.server;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.websocket.Session;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.worlds.board.BoardOutput;
import com.team.worlds.board.FakeBoardDAO;
import com.team.worlds.messages.MessageDAO;


	
@Service
public class wsBoardController {

	//실제로 사용하면 되는 mDAO
		private static FakeBoardDAO bDAO;
		//끌어오기 위한  임시dao
		@Autowired
		private FakeBoardDAO bTempDAO;
		 @PostConstruct     
		  private void initStaticDao () {
			 bDAO = bTempDAO;
		  }
	
	public static void onMessage(JSONObject result, Session session,
			HashMap<String, ArrayList<Session>> sessionmap, String userID) {
		// TODO Auto-generated method stub
		
		if(result.get("contents").toString().equals("nextPageReq"))
		{
			int pageSize = Integer.parseInt(result.get("size").toString()) ;
			int currPage = Integer.parseInt(result.get("currPage").toString());
			System.out.println("페이지 사이즈"+pageSize);
			System.out.println("지금 사이즈"+currPage);
			reqNextPage(session,userID,pageSize,currPage);
		}
		else if(result.get("contents").toString().equals("mapNextPageReq"))
		{
			int pageSize = Integer.parseInt(result.get("size").toString()) ;
			int currPage = Integer.parseInt(result.get("currPage").toString());
			System.out.println("페이지 사이즈"+pageSize);
			System.out.println("지금 사이즈"+currPage);
			reqNextPageByRegion(session,userID,pageSize,currPage,result.get("regionName").toString());
		}
		else if(result.get("contents").toString().equals("upload"))
		{
			if(true)
			{
				try
				{
					System.out.println("");
					JSONObject obj = new JSONObject();
					obj.put("type", "result");
					obj.put("resultType", "boardSuceess");
					obj.put("board",  bDAO.insertBoard(result));
					System.out.println("실험중");
					System.out.println(obj.toJSONString());
					if(session.isOpen())
						session.getBasicRemote().sendText(obj.toJSONString());
				}catch (Exception e) {
					System.out.println(e);
				}

			}
		}
		else if(result.get("contents").toString().equals("mapClick"))
		{
			mapClickInit(session,userID,result.get("countryName").toString(),result.get("regionName").toString() );
		}
		else if(result.get("contents").toString().equals("regLike"))
		{
			regLike(session, result);
		}
		else if(result.get("contents").toString().equals("deleteLike"))
		{
			deleteLike(session,result);
		}
		else if(result.get("contents").toString().equals("boardDelete"))
		{
			bDAO.deleteBoard(result.get("boardNumber").toString());
			try
			{
			System.out.println("");
			JSONObject obj = new JSONObject();
			obj.put("type", "result");
			obj.put("resultType", "deleteSuceess");
			obj.put("boardNum", result.get("boardNumber").toString());
			System.out.println(obj.toJSONString());
			if(session.isOpen())
				session.getBasicRemote().sendText(obj.toJSONString());
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(result.get("contents").toString().equals("boardInit"))
		{
			getBoardID(session,userID,5,1);
		}
		else if(result.get("contents").toString().equals("regionInit"))
		{
			regionInit(session,result.get("countryName").toString());
		}
		else if(result.get("contents").toString().equals("countryInit"))
		{
			countryInit(session);
		}
	}
	



	private static void regLike(Session session, JSONObject result) {
		if(bDAO.regLike(result))
		{
			try
			{
				System.out.println("");
				JSONObject obj = new JSONObject();
				obj.put("type", "result");
				obj.put("resultType", "likeSuceess");
				obj.put("board_Num", result.get("boardNumber").toString() );
				obj.put("board_userID", result.get("receiverID").toString() );
				System.out.println(obj.toJSONString());
				if(session.isOpen())
					session.getBasicRemote().sendText(obj.toJSONString());
			}catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	private static void deleteLike(Session session, JSONObject result) {
		if(bDAO.deleteLike(result))
		{
			try
			{
				System.out.println("삭제성공");
				JSONObject obj = new JSONObject();
				obj.put("type", "result");
				obj.put("resultType", "likeDelSuceess");
				obj.put("board_Num", result.get("boardNumber").toString() );
				obj.put("board_userID", result.get("receiverID").toString() );
				System.out.println(obj.toJSONString());
				if(session.isOpen())
					session.getBasicRemote().sendText(obj.toJSONString());
			}catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	private static void regionInit(Session session, String countryName) {
		try {
			System.out.println("regionInit"+countryName);
			
			JSONObject obj = new JSONObject();
			obj.put("type", "changeRegion");
			obj.put("regions",bDAO.getRegionByCountry(countryName));
			System.out.println(obj.toJSONString());
			if(session.isOpen())
			session.getBasicRemote().sendText(obj.toJSONString());

		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static void mapClickInit(Session session,String userID, String countryName, String region) {
		try {
			System.out.println("regionInit"+countryName);
			
			JSONObject obj = new JSONObject();
			obj.put("type", "clickMapReturn");
			obj.put("regions",bDAO.getRegionByCountry(countryName));
			obj.put("boards",bDAO.getBoardByRegion(userID,region,5,1));
			obj.put("countryName",countryName);
			obj.put("regionName",region);
			System.out.println(obj.toJSONString());
			if(session.isOpen())
			session.getBasicRemote().sendText(obj.toJSONString());
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	private static void reqNextPageByRegion(Session session, String userID, int pageSize, int currPage,
			String region) {
	
		try
		{			
			JSONObject obj = new JSONObject();
			obj.put("type", "nextBoard");
			obj.put("boards",bDAO.getBoardByRegion(userID,region, pageSize,currPage));
			if(session.isOpen())
				session.getBasicRemote().sendText(obj.toJSONString());
				
		}catch (Exception e) {
			
		}

	}
	
	private static void deleteBoard(String id)
	{
		
		System.out.println("aa");
	}
	
	private static void getBoardID(Session session, String userID,int pageSize, int currPage)
	{
		try {

		JSONObject obj = new JSONObject();
		obj.put("type", "getBoard");
		obj.put("arrBoard",bDAO.getBoardByUserID(userID,pageSize,currPage));
		System.out.println(obj.toJSONString());
		if(session.isOpen())
		session.getBasicRemote().sendText(obj.toJSONString());
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static void reqNextPage(Session session, String userID, int pageSize, int currPage) {
		try {

			JSONObject obj = new JSONObject();
			
			obj.put("type", "nextBoard");
			obj.put("arrBoard",bDAO.getBoardByUserID(userID,pageSize,currPage));
			System.out.println(obj.toJSONString());
			if(session.isOpen())
			session.getBasicRemote().sendText(obj.toJSONString());
			}catch (Exception e) {
				System.out.println(e);
			}
	}
	private static void countryInit(Session session)
	{
		try {
			JSONObject obj = new JSONObject();
			obj.put("type", "countryInit");
			obj.put("countries",bDAO.getAllCountry());
			if(session.isOpen())
			session.getBasicRemote().sendText(obj.toJSONString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
