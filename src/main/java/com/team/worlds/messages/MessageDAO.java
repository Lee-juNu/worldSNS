package com.team.worlds.messages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team.worlds.user.User;

@Service
public class MessageDAO {

	
	
	@Autowired
	private SqlSession ss;

	

	
	public void send(HttpServletRequest req, Message m) {
		
		String path = req.getSession().getServletContext().getRealPath("resources/files");
		MultipartRequest mr = null;
		
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			
			
			if (ss.getMapper(MessageMapper.class).send(m) == 1) {
				req.setAttribute("result", "송신성공");
			} else {
				req.setAttribute("result", "송신실패");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String fileName = mr.getFilesystemName("m_photo");
			new File(path + "/" + fileName).delete();
			req.setAttribute("result", "송신실패");
		}
		
	}




	public void open(HttpServletRequest req, Message m) {

		
		User u = (User)req.getSession().getAttribute("User");
		
		String cr_num = "cr002412";
//		String cr_owner = u.getUser_id();
		String cr_owner = "yanagi";
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




	public void get(HttpServletRequest req) {
		try {
			req.setAttribute("msgs", ss.getMapper(MessageMapper.class).get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
