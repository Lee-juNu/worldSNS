

package com.team.worlds.server;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
import javax.websocket.server.ServerEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
import javax.websocket.RemoteEndpoint.Basic;
 
@Controller
@ServerEndpoint(value="/echo.do")
public class WebSocketServer{
    
	
	private static final HashMap<String, Session> sessionMap = new HashMap<String, Session>();
    private static final List<Session> sessionList=new ArrayList<Session>();
    private static final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
    
    
    public WebSocketServer() {
    	// TODO Auto-generated constructor stub
        System.out.println("웹소켓(서버) 객체생성");
    }
    
    @RequestMapping(value="/chat.do")
    public ModelAndView getChatViewPage(ModelAndView mav) {
        mav.setViewName("chat");
        return mav;
    }
    
    
    
    //웹소켓 연결될때 나오는 문구
    @OnOpen
    public void onOpen(Session session) {
        logger.info("Open session id:"+session.getId());
        try {
            final Basic basic=session.getBasicRemote();
            basic.sendText("server_Open");
            
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        sessionList.add(session);
    }
    
    
    /*
     * 모든 사용자에게 메시지를 전달한다.
     * @param self 메시지 보낸 사람 
     * @param message 나머지 사람들
     */
    private void sendAllSessionToMessage(Session self,String message) {
        try {
            for(Session session : WebSocketServer.sessionList) {
                if(!self.getId().equals(session.getId())) {
                    session.getBasicRemote().sendText(message.split(",")[1]+" : "+message);
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
        
        
        try {
            final Basic basic=session.getBasicRemote();
            basic.sendText("to : "+message);
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        sendAllSessionToMessage(session, message);
    }
    
    
    @OnError
    public void onError(Throwable e,Session session) {
        
    }
    
    
    @OnClose
    public void onClose(Session session) {
        logger.info("Session "+session.getId()+" has ended");
        sessionList.remove(session);
    }
}
 
