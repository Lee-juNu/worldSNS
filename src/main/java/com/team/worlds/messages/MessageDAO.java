package com.team.worlds.messages;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team.worlds.user.User;

@Service
public class MessageDAO {

	
	
	public static final Message send = null;
	public static final Message getMsg = null;
	@Autowired
	private SqlSession ss;


	
	/*public void send(HttpServletRequest req, Message m) {
		
		String path = req.getSession().getServletContext().getRealPath("resources/files");
		MultipartRequest mr = null;
		User u = (User)req.getSession().getAttribute("loginMember");
		
		
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			
//			String msg_Num = mr.getParameter("dd"); 시퀀스
			String msg_RoomNum = mr.getParameter("roomNum");
			int msg_index = 0;
			String msg_sendUserID = u.getUser_ID();
			Date msg_sendTime = new Date();
			String msg_img = mr.getFilesystemName("sendimg");
			String msg_Contents = mr.getParameter("sendmsg");
			
//			m.setMsg_Num(msg_Num); 시퀀스
			m.setMsg_RoomNum(msg_RoomNum);
			m.setMsg_index(msg_index);
			m.setMsg_sendUserID(msg_sendUserID);
			m.setSendTime(msg_sendTime);
			m.setMsg_img(msg_img);
			m.setMsg_Contents(msg_Contents);

			System.out.println(path);
			
//			if (!msg_img.equals(null)||!msg_Contents.equals(null)) {
				if (ss.getMapper(MessageMapper.class).send(m) == 1) {
					req.setAttribute("result", "송신성공");
				} else {
					req.setAttribute("result", "송신실패");
				}
//			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String fileName = mr.getFilesystemName("m_photo");
			new File(path + "/" + fileName).delete();
			req.setAttribute("result", "송신실패");
		}
		
	}
*/



	public void open(HttpServletRequest req, Message m) {

		
		User u = (User)req.getSession().getAttribute("loginMember");
		
		
		System.out.println(u.getUser_ID());
		
		String cr_num = "CR";
		String cr_owner = u.getUser_ID();
		Date today = new Date();
				
		m.setCr_Num(cr_num);
		m.setCr_ownerID(cr_owner);
		m.setCr_date(today);
		
		if (ss.getMapper(MessageMapper.class).open(m) == 1) {
			req.setAttribute("result", "개설성공");
		} else {
			req.setAttribute("result", "개설실패");
		}
	}

	public void join(HttpServletRequest req, Message m) {
		
		
		User u = (User)req.getSession().getAttribute("loginMember");
		
		//	String rm_roomNum = req.getParameter("join");
		String rm_roomNum = u.getUser_ID();
		String rm_userID = req.getParameter("invite");
		int rm_lastIndex = 1;
		
		System.out.println(rm_userID);
		
		m.setRm_roomNum(rm_roomNum);
		m.setRm_userID(rm_userID);
		m.setRm_lastIndex(rm_lastIndex);
		
		if (ss.getMapper(MessageMapper.class).join(m) == 1) {
			req.setAttribute("result", "참여성공");
		} else {
			req.setAttribute("result", "참여실패");
		}
	}

	public void join2(HttpServletRequest req, Message m) {
		
		
		User u = (User)req.getSession().getAttribute("loginMember");
		
		//	String rm_roomNum = req.getParameter("join");
		String rm_roomNum = u.getUser_ID();
		String rm_userID = u.getUser_ID();
		int rm_lastIndex = 1;
		
		System.out.println(rm_userID);
		
		m.setRm_roomNum(rm_roomNum);
		m.setRm_userID(rm_userID);
		m.setRm_lastIndex(rm_lastIndex);
		
		if (ss.getMapper(MessageMapper.class).join(m) == 1) {
			req.setAttribute("result", "참여성공");
		} else {
			req.setAttribute("result", "참여실패");
			
		}
		
	}



	public void get(HttpServletRequest req) {
		try {
			req.setAttribute("msgs", ss.getMapper(MessageMapper.class).get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

/*	public void getMsg(HttpServletRequest req) {
		
		String msg_RoomNum = (String) req.getSession().getAttribute("roomNum");
		
		try {
			req.setAttribute("msglist", ss.getMapper(MessageMapper.class).getMsg(msg_RoomNum));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/

	public void getUser(HttpServletRequest req, User u) {
		User lu = (User)req.getSession().getAttribute("loginMember");
	
		String User_ID = lu.getUser_ID();
		u.setUser_ID(User_ID);
		try {
			req.setAttribute("userlist", ss.getMapper(MessageMapper.class).getUser(User_ID));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void getRoom(HttpServletRequest req, Message m) {
		String msg_RoomNum = (String) req.getSession().getAttribute("roomNum");
		User u = (User)req.getSession().getAttribute("loginMember");
		
		String rm_userID = u.getUser_ID();
		
		m.setRm_userID(rm_userID);
		m.setRm_roomNum(msg_RoomNum);
		
		try {
			req.setAttribute("room", ss.getMapper(MessageMapper.class).getRoom(m));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getnowuser(Message m, HttpServletRequest req) {
		String msg_RoomNum = (String) req.getSession().getAttribute("roomNum");
		
		
		m.setRm_roomNum(msg_RoomNum);
		
		try {
			req.setAttribute("gru", ss.getMapper(MessageMapper.class).getnowuser(m));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateIndex(HttpServletRequest req, Message m) {
		
		String msg_RoomNum = (String) req.getSession().getAttribute("roomNum");
		User u = (User)req.getSession().getAttribute("loginMember");
		
		String rm_userID = u.getUser_ID();
		
		m.setRm_roomNum(msg_RoomNum);
		m.setRm_userID(rm_userID);
		
		try {
			ss.getMapper(MessageMapper.class).updateIndex(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	public void select(HttpServletRequest req, Message m) {
		req.setAttribute("roomNum", req.getParameter("join"));
	}

	public Message send(Message m) {
		
/*		int msg_index = 0;
		Date msg_sendTime = new Date();
		String msg_img = "dd";
		
		m.setMsg_index(msg_index);
		m.setSendTime(msg_sendTime);
		m.setMsg_img(msg_img);*/
		
				
		return new Message(ss.getMapper(MessageMapper.class).send(m));
		// TODO Auto-generated method stub
	}

	public Message getMsg(Message m) {
		
		return new Message(ss.getMapper(MessageMapper.class).getMsg(m));
	}

	
	
	public void send(JSONObject message) {
		try {
			System.out.println("message" + ":" + message);
			ss.getMapper(MessageMapper.class).sendMsg2(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateIndex2(JSONObject message) {

		System.out.println(message);
		JSONObject jsonObj = (JSONObject)message;
//		System.out.println((String)jsonObj.get("msg_Contents"));
		ss.getMapper(MessageMapper.class).updateIndex2(jsonObj);
	}

	
	public JsonArray getMsg2(JSONObject message) {
		JSONObject jsonObj = (JSONObject)message;
		
		ArrayList<Message> ar = ss.getMapper(MessageMapper.class).getMsg2(jsonObj);
		Gson gson = new GsonBuilder().create();
		JsonArray jsar = gson.toJsonTree(ar).getAsJsonArray();
		
		return jsar;
	}

	public void updateIndex2(Message msg) {
		ss.getMapper(MessageMapper.class).updateIndex2(msg);
	}
	

	
	public Object getMsg3(Message msg) {
		ArrayList<Message> ar = ss.getMapper(MessageMapper.class).getMsg2(msg);
		Gson gson = new GsonBuilder().create();
		JsonArray jsar = gson.toJsonTree(ar).getAsJsonArray();
		
		if (jsar.size()<1||jsar.isEmpty()) {
			return msg;
		} else {
			return jsar;
			
		}
		
	}


	public void inviteUser(Message msg) {
		ss.getMapper(MessageMapper.class).inviteUser(msg);
	}

	public void out(HttpServletRequest req, Message m) {
				
		String outRoom = req.getParameter("outRoom");
		String outID = req.getParameter("outID");
		System.out.println(outID);
		m.setRm_roomNum(outRoom);
		m.setRm_userID(outID);
		ss.getMapper(MessageMapper.class).outRoom(m);
	}

	public Message checkRoom(HttpServletRequest req, Message msg) {
		
		String room = req.getParameter("outRoom");
		msg.setRm_roomNum(room);
			return ss.getMapper(MessageMapper.class).checkRoom(msg);
	}

	public void destroy(HttpServletRequest req, Message m) {
		String room = req.getParameter("outRoom");
		m.setRm_roomNum(room);
		ss.getMapper(MessageMapper.class).destroyRoom(m);		
	}

	public List<User> search(String name) {
		ss.getMapper(MessageMapper.class).search(name);
		return ss.getMapper(MessageMapper.class).search(name);				
	}
	
	public List<Message> searchbyUser(String name) {
		ss.getMapper(MessageMapper.class).searchbyUser(name);
		return ss.getMapper(MessageMapper.class).searchbyUser(name);
	}

	public int indexcheck(Message m, HttpServletRequest req) {
		User u = (User)req.getSession().getAttribute("loginMember");
		String rm_userID = u.getUser_ID();
		m.setRm_userID(rm_userID);
		
		ArrayList<Message> roomindex = ss.getMapper(MessageMapper.class).checkroomindex(m);
		ArrayList<Message> userindex = ss.getMapper(MessageMapper.class).checkuserindex(m);
		System.out.println("y1esy2esy3es");
		int ri = 0;
		int ui = 0;
		
		for (Message message : roomindex) {
			int sttp = message.getRm_lastIndex();
			ri = ri+sttp;
			System.out.println("qq:"+ri);
			System.out.println("ww:"+sttp);
		}
		for (Message message : userindex) {
			int sttp = message.getMsg_index();
			ui = ui+sttp;
			System.out.println("ee:"+ui);
			System.out.println("rr:"+sttp);
		}
		int indexresult = ui - ri;
		System.out.println(ri);
		System.out.println(ui);
		System.out.println(indexresult);
		
		
		return indexresult;
	}

	public List<Message> getroomuser(String roomno) {
		System.out.println(roomno);
		ss.getMapper(MessageMapper.class).getroomuser(roomno);
		return ss.getMapper(MessageMapper.class).getroomuser(roomno);
	}

	
	
/*	public void updateIndex2(String userId, String pageType, Message m) {
		
		m.setRm_roomNum(pageType);
		m.setRm_userID(userId);
	
		try {
		ss.getMapper(MessageMapper.class).updateIndex2(userId, pageType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/



	
	
	
}
