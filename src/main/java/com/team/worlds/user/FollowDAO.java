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

	/*
	 * //UUID UUIDgeneration uuid = new UUIDgeneration(); String id =
	 * uuid.getUUID();
	 */

	public void follow(HttpServletRequest req, User u, String user_ID_o, Follow f) {
		// TODO Auto-generated method stub

		u = (User) req.getSession().getAttribute("loginMember");

		System.out.println("ㅇ왜안되지");

		// User dbUser = ss.getMapper(UserMapper.class).getMemberByID(u.getUser_ID());

		System.out.println("ㅇ왜안되지");

		String user_ID = u.getUser_ID();

		f.setFlw_FromId(user_ID);
		f.setFlw_ToId(user_ID_o);

		System.out.println("내아이디" + f.getFlw_FromId());
		System.out.println("상대아이디" + f.getFlw_ToId());
		System.out.println("이건뜨는건가");
		if (ss.getMapper(FollowMapper.class).already_follow(f) == 0) {

			System.out.println("여기까지 왔음");
			
			if (ss.getMapper(FollowMapper.class).follow(f) == 1) {
				System.out.println("팔로우 성공!");

			} else {
				System.out.println("팔로우 실패");
			}
		} else

		{
			System.out.println("이미 팔로우 중입니다");
			System.out.println();

		}

	}

	public void unfollow(HttpServletRequest req, User u, String user_ID_o, Follow f) {

		u = (User) req.getSession().getAttribute("loginMember");
		
		String user_ID = u.getUser_ID();

		f.setFlw_FromId(user_ID);
		f.setFlw_ToId(user_ID_o);

		System.out.println("내아이디" + f.getFlw_FromId());
		System.out.println("상대아이디" + f.getFlw_ToId());
		System.out.println("이건뜨는건가");
	//	if (ss.getMapper(FollowMapper.class).already_unfollow(f) == 0) {

		//	System.out.println("여기까지 왔음");
			
			if (ss.getMapper(FollowMapper.class).unfollow(f) == 1) {
				System.out.println("언팔로우 성공!");

			} else {
				System.out.println("언팔로우 실패");
			}
		} /*else

		{
			System.out.println("이미 팔로우 중입니다");
			System.out.println();

		}
*/
	

	public void follow_count(HttpServletRequest req, User u, String user_ID_o, Follow f) {
		// TODO Auto-generated method stub

		/*u = (User) req.getSession().getAttribute("loginMember");

		String user_ID = u.getUser_ID();*/

		f.setFlw_FromId(user_ID_o);

		int follow_count = Integer.parseInt(ss.getMapper(FollowMapper.class).follow_count(f));
		System.out.println(follow_count);

		if (follow_count != 0) {

			req.setAttribute("follow_count", follow_count);
		} else {

			req.setAttribute("follow_count", "0");
		}

	}

	public void follower_count(HttpServletRequest req, User u, String user_ID_o, Follow f) {
		// TODO Auto-generated method stub
		u = (User) req.getSession().getAttribute("loginMember");

		// String user_ID = u.getUser_ID();

		f.setFlw_ToId(user_ID_o);
		int follower_count = Integer.parseInt(ss.getMapper(FollowMapper.class).follower_count(f));
		System.out.println(follower_count);

		if (follower_count != 0) {

			req.setAttribute("follower_count", follower_count);
		} else {

			req.setAttribute("follower_count", "0");
		}

	}

	public void follow_list(String user_ID_o, HttpServletRequest req, Follow f) {

		try {

			f.setFlw_FromId(user_ID_o);
			System.out.println("왜안돼" + f.getFlw_FromId());

			req.setAttribute("Follow", ss.getMapper(FollowMapper.class).follow_list(f));
			System.out.println("아좀돼라"+req.getAttribute("Follow"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void follower_list(String user_ID_o, HttpServletRequest req, Follow f) {
		
		try {
			
			f.setFlw_FromId(user_ID_o);
			System.out.println("왜안돼" + f.getFlw_FromId());
			
			req.setAttribute("Follow", ss.getMapper(FollowMapper.class).follower_list(f));
			System.out.println("아좀돼라"+req.getAttribute("Follow"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/*public void getfollow_list(String user_ID_o, User u, HttpServletRequest req, Follow f) {

		f = (Follow) req.getSession().getAttribute("follows");

		try {

			req.setAttribute("follow_list", ss.getMapper(FollowMapper.class).getfollow_list(f));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
*/

}
