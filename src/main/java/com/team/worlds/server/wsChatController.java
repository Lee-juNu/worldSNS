package com.team.worlds.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.websocket.Session;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.team.worlds.messages.MessageDAO;

import javax.websocket.RemoteEndpoint.Basic;





public class wsChatController {

	@Autowired
	private MessageDAO mDAO;
	
	private static HashMap<String, ArrayList<ChatUser>> chatRoomMap = new HashMap<String, ArrayList<ChatUser>>();
	
	
	public static void onUserOpen(Session session, String pageType, String userId)
	{ 
		if(!chatRoomMap.containsKey(pageType))
		{
			createChatRoom(session, pageType,userId);
		}
		else
		{
			roomEnter(session, pageType,userId);			
		}
	}
	
	public static void onUserExit(Session session, String pageType, String userId)
	{
		
		if(chatRoomMap.get(pageType).size()<=1)
		{
			//마지막한명이 나갈꺼면 그냥 방을 폭발시켜버렷
			dystroyRoom(session, pageType, userId);			
		}
		else
		{
			//한명씩 밖으로 나가자
			roomExit(session, pageType, userId);			
		}
	}
	
	
	
	//1.자신이 속해있는 방이 어디인가
	public static void onMessage(JSONObject result, Session session
			, HashMap<String, ArrayList<Session>> sessionmap, String pageType, String userId) {
		try
		{
			//타입에 맞게 바꿔주세요
			String contents = (String)result.get("contents");
			
			final Basic basic=session.getBasicRemote();
			basic.sendText(userId+":"+ contents+ pageType);	
			
		}catch (Exception e) 
		{
			System.out.println(e);
		}
	}	
	
		//방에 입장
		//전체 방을 관리하는 ChatRoomMap에 key로서 방번호를 입력
		private static void roomEnter(Session session, String pageType, String userId)
		{
			System.out.println(userId+session.getId()+"님이 방에 입장하셨습니다 방넘버:"+ pageType);

			chatRoomMap.get(pageType).add(new ChatUser(session, userId));
		}
		
		
		private static void dystroyRoom(Session session, String pageType, String userId)
		{
			//방청소
			//원래대로라면 객체자체를 null로 바꿔버리고 싶긴한데 못찾겠넹 가비지콜렉터에게 맡겨보즈아
			System.out.println(userId+session.getId()+"방 부순다 방넘버"+ pageType);

			chatRoomMap.get(pageType).clear();
		}
		private static void roomExit(Session session, String pageType, String userId)
		{
			//룸에서 사람이 나갈때  두명 이상이면 호출된다.
			//방에 있는 룸멤버들 전체 호출
			ArrayList<ChatUser> arrRoomMember = chatRoomMap.get(pageType);
			
			//거기서 룸멤버중 지금 나간 한명 찾아서 없애버리기
			//id는 중복으로 들어올 수도 있으니 조심(한유저가 2개이상의 창으로 띄우고 있을경우)
			for(int i= 0; i<arrRoomMember.size() ; i++)
			{
				if(arrRoomMember.get(i).getSession() == session)
				{
					System.out.println(userId+session.getId()+"방나간다  방넘버"+ pageType);
					arrRoomMember.remove(i);		
				}
			}
		}
		
		//방을 만든다
		//처음 들어가는 사람이 방을 만드는 방식
		private static void createChatRoom(Session session, String pageType, String userId)
		{
			//먼저 유저들을 담을 배열하나 만들고 제일 처음 들어가는 사람 유저정보(유저,세션)를 입력 
			ArrayList<ChatUser> arrUser =  new ArrayList<ChatUser>();
			arrUser.add(new ChatUser(session, userId));
			//(방번호와 만든 유저배열) 로 Map을 하나 생성
			chatRoomMap.put(pageType, arrUser);
			
			System.out.println(userId+session.getId()+"방 만든다  방넘버"+ pageType);
		}
}
