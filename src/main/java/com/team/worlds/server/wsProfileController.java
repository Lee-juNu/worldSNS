package com.team.worlds.server;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.websocket.Session;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.worlds.board.FakeBoardDAO;


@Service
public class wsProfileController {
	
	//실제로 사용하면 되는 mDAO
	private static FakeBoardDAO bDAO;
	//끌어오기 위한  임시dao
	@Autowired
	private FakeBoardDAO bTempDAO;
	 @PostConstruct     
	  private void initStaticDao () {
		 bDAO = bTempDAO;
	  }
	
	
	public static void onMessage(JSONObject result, Session session, HashMap<String, ArrayList<Session>> sessionmap) {
		
		if(result.get("contents").toString().equals("nextPageReq"))
		{
			int pageSize = Integer.parseInt(result.get("size").toString()) ;
			int currPage = Integer.parseInt(result.get("currPage").toString());
			String userID = result.get("profileUser").toString();

			reqNextPage(session,userID,pageSize,currPage);
		}
		else if(result.get("contents").toString().equals("pfBoardInit"))
		{
			String userID = result.get("profileUser").toString();
			System.out.println(userID);
			getBoardID(session,userID,5,1);
		}
	}
	
	private static void reqNextPage(Session session, String userID, int pageSize, int currPage) {
		try {

			JSONObject obj = new JSONObject();
			
			obj.put("resultType", "nextBoard");
			obj.put("arrBoard",bDAO.getBoardByOnlyID(userID,pageSize,currPage));
			System.out.println(obj.toJSONString());
			if(session.isOpen())
			session.getBasicRemote().sendText(obj.toJSONString());
			}catch (Exception e) {
				System.out.println(e);
			}
		
	}


	private static void getBoardID(Session session, String userID,int pageSize, int currPage)
	{
		try {
		System.out.println(bDAO);
		JSONObject obj = new JSONObject();
		obj.put("resultType", "getPfBoard");
		obj.put("arrBoard",bDAO.getBoardByOnlyID(userID,pageSize,currPage));
		System.out.println(obj.toJSONString());
		if(session.isOpen())
		session.getBasicRemote().sendText(obj.toJSONString());
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
