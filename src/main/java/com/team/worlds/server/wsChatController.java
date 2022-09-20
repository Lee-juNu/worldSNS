package com.team.worlds.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.apache.jasper.compiler.StringInterpreterFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.worlds.messages.Message;
import com.team.worlds.messages.MessageDAO;

import javax.annotation.PostConstruct;
import javax.websocket.RemoteEndpoint.Basic;




@Service
public class wsChatController {

	/*
	 * TODO
	 *1.제일먼저 채팅방에 들어온사람끼리만 웹소켓 채팅 (간단한메시지)주고받기
	 *2.js에서 Div등을 사용하여 채팅창 만들기
	 *3.onMessage로 받았을떄 lastIndex바꿔주는거 잊지 않기
	 *4.채팅방에는 없지만 멤버들이 전체Map에 존재하는지 확인 후 있으면 알림(이건 나중에 알림쪽이 되야되는데 언제될련지...)
	*/
	
	
	//실제로 사용하면 되는 mDAO
	private static MessageDAO mDAO;
	//끌어오기 위한  임시dao
	@Autowired
	private MessageDAO mTempDAO;
	
	  @PostConstruct     
	  private void initStaticDao () {
		  mDAO = mTempDAO;
	  }

	  private static HashMap<String, ArrayList<ChatUser>> chatRoomMap = new HashMap<String, ArrayList<ChatUser>>();
	
	  
	//1.자신이 속해있는 방이 어디인가
		public static void onMessage(JSONObject message, Session session
				, HashMap<String, ArrayList<Session>> sessionMap, String pageType, String userId) {
			
			JSONParser jsonParser = new JSONParser();
//			JSONObject result = (JSONObject)jsonParser.parse(message);
			String Dtype = (String)message.get("dataType");
			final Basic basic=session.getBasicRemote();
			String contents = (String)message.get("msg_Contents");
			String img = (String)message.get("msg_img");
			
			//타입에 맞게 바꿔주세요
			System.out.println(img);
			try
				{
/*				if (Dtype.equals("send")&&contents!=null) {
//					basic.sendText(message.toString());	
					mDAO.send(message);
					sendAllChatRoomMember(message, session, pageType, userId);
					}else if (Dtype.equals("send")&&img!=null) {
						
					}else if (contents!=null&&img!=null&&Dtype.equals("send")) {
						
					}*/
				if (Dtype.equals("send")) {
					mDAO.send(message);
					sendAllChatRoomMember(message, session, pageType, userId);
					mDAO.updateIndex2(message);

				}}catch (Exception e) 
				{
					System.out.println(e);
				}
		}
		
		
	 private static void sendAllChatRoomMember(JSONObject message, Session session,String pageType, String userId)
		{
			try
			{
				//해당하는 채팅방을 찾아서
				ArrayList<ChatUser> tempUserList = chatRoomMap.get(pageType);
				
				JSONParser jsonParser = new JSONParser();
//				JSONObject result = (JSONObject)jsonParser.parse(message);
				String type = (String)message.get("dataType");
				final Basic basic=session.getBasicRemote();

				//mDAO로 DB로 메시지를 보내자!!
//				mDAO.send(message);
				//해당하는 채팅멤버들에게 보낸다
				//Text부분에 JSon으로 보내기!
				//유저의 이름
				// JSON.put("senderID" , userId);
				
				//제일처음에 메시지 보내기전에 파일업로드-> 메시지 보내기->파일명저장 DB(메시지 같이)
				String contents = (String)message.get("msg_Contents");
				String img = (String)message.get("msg_img");
//				mDAO.send(message);
				for (ChatUser chatUser : tempUserList) {
					if(!chatUser.getSession().isOpen())
					{
						tempUserList.remove(chatUser);
					}
					chatUser.getSession().getBasicRemote().sendText(message.toString());
				}			
			}
			catch (Exception e) {
				System.out.println("\n전체 멤버 보내는 도중에 에러!!\n"+e);
			}
		}
		/*
		  private void sendAllSessionToMessage(Session self,String message) {
		        try {
		        	//들어와있는 모든 사람에게 보내라!
		        	for (Entry<String, ArrayList<Session>> entry : sessionMap.entrySet()) {
		        		for (Session session : entry.getValue()) {
		        			if(!self.getId().equals(session.getId())) {
		        				session.getBasicRemote().sendText(message);
		            		}	
						}
					}
		        }catch (Exception e) {
		            // TODO: handle exception
		            System.out.println(e.getMessage());
		        }
		    }
		*/
		
		
		
	public static void onUserOpen(Session session, String pageType, String userId)
	{ 
		//채팅방 들어가는데
		//유저한명도 없으면
		//채팅방을 만든다-DB방만들어져있는거
		//배열 			
		if(!chatRoomMap.containsKey(pageType))
		{
			createChatRoom(session, pageType,userId);
		}
		else
		{
			roomEnter(session, pageType,userId);			
		}
		
		final Basic basic=session.getBasicRemote();
		
		try {
			
			Message msg = new Message();
			msg.setMsg_RoomNum(pageType);
			msg.setMsg_sendUserID(userId);
			mDAO.updateIndex2(msg);
			basic.sendText(mDAO.getMsg3(msg).toString());

			
			mDAO.updateIndex2(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		private static void dystroyRoom(Session session, String pageType, String userId)
		{
			//방청소
			//원래대로라면 객체자체를 null로 바꿔버리고 싶긴한데 못찾겠넹 가비지콜렉터에게 맡겨보즈아
			System.out.println(userId+session.getId()+"방 부순다 방넘버"+ pageType);

			chatRoomMap.get(pageType).clear();
		}
		
		//방에 입장
		//전체 방을 관리하는 ChatRoomMap에 key로서 방번호를 입력
		private static void roomEnter(Session session, String pageType, String userId)
		{
/*			ArrayList<ChatUser> arrUsers =  chatRoomMap.get(pageType);
		
			
			ChatUser enterUser = new ChatUser(session, userId);
			arrUsers.add(enterUser);*/
			
			
			chatRoomMap.get(pageType).add(new ChatUser(session, userId));
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
		
		
}
