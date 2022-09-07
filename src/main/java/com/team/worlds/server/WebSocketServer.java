package com.team.worlds.server;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import oracle.as.management.opmn.integrator.PingCallback;

/*
@Service
class alarmThread{
   @PostConstruct
   private void resendThread()
   {
	   int sleepSec = 1;
   	   
	   final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(2);
	   
	   exec.scheduleAtFixedRate(new Runnable() {
		
		@Override
		public void run() {
			try {
				WebSocketServer.Allnotice();	
			}catch (Exception e) {

			}
			
		}
	}, 0, sleepSec, TimeUnit.SECONDS);
   }
}
*/

@Controller // CR001 //adsfasd
@ServerEndpoint(value = "/jwSocket/{pageType}/{userId}")
public class WebSocketServer {
	// 여기서 말하는 세션은 우리가 배우는 그 세션이 아닌
	// 웹소켓 접속한 사람을 구별하기 위한 개별ID라고 생각하시면좋아요
	// 홈페이지가 이동할때마다 세션은 새로 주어집니다.
	// 맵을 통해서 (UserID,Session)으로 이루어집니다.

	public static final HashMap<String, ArrayList<Session>> sessionMap = new HashMap<String, ArrayList<Session>>();
	// 로그를 남겨주는 아이입니다 몰라도되요
	private static final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
	public static final HashMap<Session,BufferedOutputStream> bufferMap = new HashMap<Session,BufferedOutputStream>();
	// 저희의 Json을 파싱해주는 아이입니다.

	// 파일을 만들때 사용하는 장치입니다
	// Buffer을 쪼개서 사용자가 업로드하는걸 받아와서 처리해줍니다.

	// 생성자 모르면 쌤꼐 혼나요
	public WebSocketServer() {
		// TODO Auto-generated constructor stub
		System.out.println("웹소켓(서버) 객체생성");

	}
	/*
	 * public static synchronized void Allnotice() throws IOException { for
	 * (Map.Entry<String, ArrayList<Session>> entry :
	 * WebSocketServer.sessionMap.entrySet()) { for (Session arrSession:
	 * entry.getValue()){ arrSession.getBasicRemote().sendText("공지왔어용"); } } }
	 */

	// 웹소켓 연결될때 나오는 문구
	// 생성후 사용자와 "연결"이 될때 불려지는 함수입니다.
	@OnOpen
	public void onOpen(Session session, @PathParam(value = "pageType") String pageType,
			@PathParam(value = "userId") String userId) {

		System.out.println("시도중" + userId);
		logger.info("Open session id:" + session.getId());
		try {
			final Basic basic = session.getBasicRemote();
			System.out.println("userID=" + userId);
			//basic.sendText("server_Open");

			if (pageType.contains("CR")) {
				wsChatController.onUserOpen(session, pageType, userId);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		if (!sessionMap.containsKey(userId)) {
			ArrayList<Session> arrayList = new ArrayList<Session>();
			arrayList.add(session);
			sessionMap.put(userId, arrayList);
		} else {
			sessionMap.get(userId).add(session);
		}

		System.out.println("Welcome : " + sessionMap.get(userId).size() + " 번째" + userId);
		// sessionMap.put(userId, session);
	}

	/*
	 * 모든 사용자에게 메시지를 전달한다.
	 * 
	 * @param self 메시지 보낸 사람
	 * 
	 * @param message 보낼 메시지
	 */

	@SuppressWarnings("unused")
	private void sendAllSessionToMessage(Session self, String message) {
		try {
			// 들어와있는 모든 사람에게 보내라!
			for (Entry<String, ArrayList<Session>> entry : sessionMap.entrySet()) {
				for (Session session : entry.getValue()) {
					if (!self.getId().equals(session.getId())) {
						session.getBasicRemote().sendText(message);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@OnMessage
	public void onMessage(String message, Session session, @PathParam(value = "pageType") String pageType,
			@PathParam(value = "userId") String userId) {
		// 누구에게서 메시지가 왔는지 확인
		logger.info("Message From " + message.split(",")[1] + ": " + message.split(",")[0]);

		JSONParser jsonParser = new JSONParser();
		// JsonParser
		try {
			JSONObject result = (JSONObject) jsonParser.parse(message);
			String type = (String) result.get("type");


			if 		(type.equals("chat")) 	wsChatController.onMessage(result, session, sessionMap, pageType, userId);
			else if (type.equals("board")) 	wsBoardController.onMessage(result, session, sessionMap);
			else if (type.equals("alarm")) 	wsAlaramController.onMessage(result, session, sessionMap);
			else if (type.equals("file")) 
			{
				System.out.println("타입File로 들어왔습니다.");
				boolean isEnd = (boolean) result.get("isEnd");
				if (!isEnd) 
				{
					fileUploadRead(result,session);
				}
			} 
			else if (type.equals("others")) {

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void fileUploadRead(JSONObject result,Session session) throws FileNotFoundException {
		String fileName = (String) result.get("fileName");
		System.out.println("파일명 :" + fileName);
		String folderName = (String) result.get("folderName");
		createUploadFolder(folderName);
		
		File file = new File(wsFileManager.getFilePath() + folderName + "/" + fileName);
		System.out.println(wsFileManager.getFilePath() + folderName + "/" + fileName);
		bufferMap.put(session, new BufferedOutputStream(new FileOutputStream(file)));
		
		System.out.println("파일 업로드 준비 완료");
		System.out.println(file);
	}

	private void createUploadFolder(String folderName) throws FileNotFoundException {
		File Folder = new File(wsFileManager.getFilePath() + "/" + folderName);
		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!Folder.exists()) {
			try {
				Folder.mkdir(); // 폴더 생성합니다.
				System.out.println("폴더가 생성되었습니다.");
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {
			System.out.println("이미 폴더가 생성되어 있습니다.");
		}
	}

	// 여기는 받아오는 프로그램 메시지를 처리하는부분입니다.
	@OnMessage
	public void processUpload(ByteBuffer msg, boolean last, Session session) {
		try {
			while (msg.hasRemaining()) {
				bufferMap.get(session).write(msg.get());
			}
			if (last) {
				bufferMap.get(session).flush();
				bufferMap.get(session).close();
				bufferMap.remove(session);
				JSONObject obj = new JSONObject();
				obj.put("type", "reqNextFile");
				
				session.getBasicRemote().sendText(obj.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@OnError
	public void onError(Throwable e, Session session) {
	}

	@OnClose
	public void onClose(Session session, @PathParam(value = "pageType") String pageType,
			@PathParam(value = "userId") String userId) {
		logger.info("Session " + userId + " has ended");

		if (pageType.contains("chatRoom")) {
			wsChatController.onUserExit(session, pageType, userId);
			;
		}

		ArrayList<Session> arrUser = sessionMap.get(userId);
		if (arrUser.size() <= 1) {
			arrUser.clear();
			sessionMap.remove(userId);
		} else {
			arrUser.remove(session);
		}
	}
}
