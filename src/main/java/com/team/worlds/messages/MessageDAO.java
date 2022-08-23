package com.team.worlds.messages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		int rm_lastIndex = 0;
		
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
		int rm_lastIndex = 0;
		
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
		
		m.setRm_roomNum(msg_RoomNum);
		m.setRm_userID(rm_userID);
		
		try {
			req.setAttribute("room", ss.getMapper(MessageMapper.class).getRoom(m));
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
		
		req.removeAttribute("roomNum");
		String roomno = req.getParameter("join");
		req.getSession().setAttribute("roomNum", roomno);
		req.getSession().setMaxInactiveInterval(-1);
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
		System.out.println(ss.getMapper(MessageMapper.class).getMsg(m));
		
		return new Message(ss.getMapper(MessageMapper.class).getMsg(m));
	}

	
	
	public void send(JSONObject message) {
		System.out.println("ddddd");
	}




	
	
	
}
