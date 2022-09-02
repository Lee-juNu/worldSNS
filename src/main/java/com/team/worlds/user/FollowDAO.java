package com.team.worlds.user;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowDAO {

	@Autowired
	SqlSession ss;


	
	public void follow(HttpServletRequest req, User u, String user_ID_o, Follow f) {
		// TODO Auto-generated method stub	
		
		u = (User) req.getSession().getAttribute("loginMember");
		
		System.out.println("ㅇ왜안되지");
		
	//	User dbUser = ss.getMapper(UserMapper.class).getMemberByID(u.getUser_ID());
		
		System.out.println("ㅇ왜안되지");
		

		String user_ID = u.getUser_ID();
		
		f.setFlw_FromId(user_ID);
		f.setFlw_ToId(user_ID_o);
		
		
		
		System.out.println("내아이디" + user_ID);
		System.out.println("상대아이디" + user_ID_o);
		
		
		if (ss.getMapper(FollowMapper.class).follow(f) == 1) {
			System.out.println("팔로우 성공!");
			
			
		} else {
			System.out.println("팔로우 실패");
		}
		}



	public void follow_count(HttpServletRequest req, User u, String user_ID_o, Follow f) {
		// TODO Auto-generated method stub
		
		u = (User) req.getSession().getAttribute("loginMember");
		
		String user_ID = u.getUser_ID();
		
		f.setFlw_FromId(user_ID);
		
		req.setAttribute("follow_count", ss.getMapper(FollowMapper.class).follow_count(f));
		

		
	}



	public void follower_count(HttpServletRequest req, User u, String user_ID_o, Follow f) {
		// TODO Auto-generated method stub
		u = (User) req.getSession().getAttribute("loginMember");
		
	//	String user_ID = u.getUser_ID();
		
		f.setFlw_ToId(user_ID_o);
		
		req.setAttribute("follower_count", ss.getMapper(FollowMapper.class).follower_count(f));
		
	}
		
	
	
	/*
	 * 
	 * 	public void follow_count(HttpServletRequest req, User u, String user_ID_o, Follow f) {
		// TODO Auto-generated method stub

		u = (User) req.getSession().getAttribute("loginMember");

		String user_ID = u.getUser_ID();

		f.setFlw_FromId(user_ID);

		if (ss.getMapper(FollowMapper.class).follow_count(f) != null) {

			req.setAttribute("follow_count", ss.getMapper(FollowMapper.class).follow_count(f));
		} else {

			req.setAttribute("follow_count", "0");

		}

	}

	public void follower_count(HttpServletRequest req, User u, String user_ID_o, Follow f) {
		// TODO Auto-generated method stub
		u = (User) req.getSession().getAttribute("loginMember");

		// String user_ID = u.getUser_ID();

		f.setFlw_ToId(user_ID_o);

		if (ss.getMapper(FollowMapper.class).follower_count(f) != null) {

			req.setAttribute("follower_count", ss.getMapper(FollowMapper.class).follower_count(f));
		} else {

			System.out.println(ss.getMapper(FollowMapper.class).follower_count(f));
			req.setAttribute("follower_count", "0");

		}
	 * 
	 * 
	 * 
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	}



