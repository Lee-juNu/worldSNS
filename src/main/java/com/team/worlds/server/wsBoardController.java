package com.team.worlds.server;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.websocket.Session;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public static void onMessage(JSONObject result, Session session, HashMap<String, ArrayList<Session>> sessionmap) {
		// TODO Auto-generated method stub
		
		if(result.get("contents").toString().equals("regionInit"))
		{
			regionInit(session,result.get("countryName").toString());
		}
		else if(result.get("contents").toString().equals("countryInit"))
		{
			countryInit(session);
		}
	}
	
	private static void regionInit(Session session, String countryName) {
		try {
			System.out.println("regionInit"+countryName);
			
			JSONObject obj = new JSONObject();
			obj.put("type", "changeRegion");
			obj.put("regions",bDAO.getRegionByCountry(countryName));
			System.out.println(obj.toJSONString());
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
			System.out.println(obj.toJSONString());
			session.getBasicRemote().sendText(obj.toJSONString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
