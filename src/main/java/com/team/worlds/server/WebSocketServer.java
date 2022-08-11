

package com.team.worlds.server;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.websocket.RemoteEndpoint.Basic;
 
@Controller
@ServerEndpoint(value="/echo.do/{userId}")
public class WebSocketServer{
    
	
	private static final HashMap<String, Session> sessionMap = new HashMap<String, Session>();
    private static final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
    BufferedOutputStream bos;
    String path = "E:\\TeamProject\\img\\";
    
    
    public WebSocketServer() {
    	// TODO Auto-generated constructor stub
        System.out.println("웹소켓(서버) 객체생성");
    }
    
    @RequestMapping(value="/chat.do/")
    public ModelAndView getChatViewPage(ModelAndView mav) {
        mav.setViewName("chat");
        return mav;
    }
    
    
    
    //웹소켓 연결될때 나오는 문구
    @OnOpen
    public void onOpen(Session session , @PathParam(value="userId") String userId) {
        logger.info("Open session id:"+session.getId());
        try {
            final Basic basic=session.getBasicRemote();
            System.out.println("userID=" + userId);
            basic.sendText("server_Open");
            
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        System.out.println("Welcome : " + userId);
        sessionMap.put(userId, session);
    }
    
    
    /*
     * 모든 사용자에게 메시지를 전달한다.
     * @param self 메시지 보낸 사람 
     * @param message 나머지 사람들
     */
    private void sendAllSessionToMessage(Session self,String message) {
        try {
        	
        	for (Map.Entry<String, Session> entry : sessionMap.entrySet()) {
        		if(!self.getId().equals(entry.getValue().getId())) {
        			entry.getValue().getBasicRemote().sendText(message.split(",")[1]+" : "+message);
        		}				
			}
        	
        	

        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
    
    @OnMessage
    public void onMessage(String message,Session session) {
        logger.info("Message From "+message.split(",")[1] + ": "+message.split(",")[0]);
        
        	JSONParser jsonP = new JSONParser();
        try {
        	JSONObject result = (JSONObject)jsonP.parse(message);
        	
        	String type = (String) result.get("type");
        
        	if(type.equals("msg"))
        	{
        		String id = (String) result.get("id");
        		String contents = (String) result.get("contents");
        		System.out.println("id : " + id);
        		System.out.println("내용 : " + contents);
        		
        		final Basic basic=session.getBasicRemote();
        		basic.sendText(id+" : "+contents);
        	}
        	if(type.equals("file"))
        	{
        		System.out.println("타입File로 들어왔습니다.");
        		System.out.println(message);
        		boolean msg = (boolean)result.get("isEnd");
        		   if(!msg){
        	        	String fileName = (String) result.get("fileName");
        		         System.out.println("파일명 :" + fileName);
        		         File file = new File(path + fileName);
        		         bos = new BufferedOutputStream(new FileOutputStream(file));
        		         System.out.println("파일 업로드 준비 완료");
        		   }
        		   else
        		   {
        			   bos.flush();
                       bos.close();
                       System.out.println("파일 업로드 끝");
        		   }
        	}
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        sendAllSessionToMessage(session, message);
    }
    
    @OnMessage
    public void processUpload(ByteBuffer msg, boolean last, Session session) {
        
        while(msg.hasRemaining()){
            try {
                bos.write(msg.get());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    @OnError
    public void onError(Throwable e,Session session) {
    }
    
    
    @OnClose
    public void onClose(Session session) {
        logger.info("Session "+session.getId()+" has ended");
        sessionMap.remove(session.getId());
    }
}
 
