package com.team.worlds.user;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class UserDAO {

	@Autowired
	SqlSession ss;

	public void templogin(HttpServletRequest req) {

		User dbUser = ss.getMapper(UserMapper.class).tempSelectUser();

		if (dbUser != null) {
			System.out.println(dbUser.getUser_nickName());
		} else {
		}
	}

	public void login(User u, HttpServletRequest req) {

		User dbUser = ss.getMapper(UserMapper.class).getMemberByID(u.getUser_ID());

		if (dbUser != null) {
			if (u.getUser_PW().equals(dbUser.getUser_PW())) {
				req.getSession().setAttribute("loginMember", dbUser);
				req.getSession().setMaxInactiveInterval(600 * 10);
				System.out.println(dbUser.getUser_nickName());

			} else {
				System.out.println("실패");
				req.setAttribute("result", "로그인을 다시 시도해 주세요.");
			}
		} else {
			System.out.println("실패");
			req.setAttribute("result", "로그인을 다시 시도해 주세요.");
		}

	}

	public void logout(HttpServletRequest req) {

		req.getSession().setAttribute("loginMember", null);

	}

	public boolean loginCheck(HttpServletRequest req) {

		User u = (User) req.getSession().getAttribute("loginMember");
		if (u != null) {
			req.setAttribute("profileMini", "jy/profileMini.jsp");
			return true;
		} else {

			return false;
		}

	}

	public void joinus(User u, HttpServletRequest req) {
		// TODO Auto-generated method stub

		String juser_ID = req.getParameter("user_ID");
		String juser_PW = req.getParameter("user_PW");
		String juser_nickName = req.getParameter("user_nickName");
		String juser_phoneNumber = req.getParameter("user_phoneNumber");
		String juser_name = req.getParameter("user_name");
		String juser_email = req.getParameter("user_email");
		String juser_city = req.getParameter("user_city");
		String juser_birthDay = req.getParameter("user_birthDay");
		int jlevel = Integer.parseInt(req.getParameter("level"));
		// String jregDate = req.getParameter("regDate");
		// jm_photo = URLEncoder.encode(jm_photo, "utf-8");
		// jm_photo = jm_photo.replace("+", " ");

		u.setUser_ID(juser_ID);
		u.setUser_PW(juser_PW);
		u.setUser_nickName(juser_nickName);
		u.setUser_phoneNumber(juser_phoneNumber);
		u.setUser_name(juser_name);
		u.setUser_email(juser_email);
		u.setUser_city(juser_city);
		u.setUser_birthDay(juser_birthDay);
		u.setLevel(jlevel);
		// u.setRegDate(jregDate);

		if (ss.getMapper(UserMapper.class).joinus(u) == 1) {
			req.setAttribute("result", "성공적으로 가입이 완료되었습니다!");
		} else {
			req.setAttribute("result", "가입에 실패하였습니다.. 잠시 후 다시 시도해 주세요!");

		}

	}

	public void secession(HttpServletRequest req) {
		try {
			User u = (User) req.getSession().getAttribute("loginMember");

			if (ss.getMapper(UserMapper.class).secession(u) == 1) {
				req.setAttribute("result", "탈퇴성공");

				// sDAO.setAllMsgCount(allMsgCount - msgCount);

				logout(req);
				loginCheck(req);
			} else {
				req.setAttribute("result", "탈퇴실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "탈퇴실패");
		}

	}

	
	// 우리 것에 맞춰 업데이트 해야함
	public void update(Profile p, User u, HttpServletRequest req) {

		String path = req.getSession().getServletContext().getRealPath("resources/files");
		MultipartRequest mr = null;
		User loginMember = (User) req.getSession().getAttribute("loginMember");
		Profile loginMemberprofile = (Profile) req.getSession().getAttribute("loginMember");
		String oldFile = loginMemberprofile.getPf_Img();
		String newFile = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			newFile = mr.getFilesystemName("jm_photo");

			if (newFile == null) {
				newFile = oldFile;
			} else {
				newFile = URLEncoder.encode(newFile, "utf-8");
				newFile = newFile.replace("+", " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정실패");
			return;
		}

		try {
			String juser_ID = mr.getParameter("jm_id");
			String juser_PW = mr.getParameter("jm_pw");
			String juser_name = mr.getParameter("jm_name");
			String jpf_Img = newFile;

			u.setUser_ID(juser_ID);
			u.setUser_PW(juser_PW);
			u.setUser_name(juser_name);
			p.setPf_Img(jpf_Img);

			if (ss.getMapper(UserMapper.class).update(p) == 1) {
				req.setAttribute("result", "수정성공");
				req.getSession().setAttribute("loginMember", u);
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "utf-8");
					new File(path + "/" + oldFile).delete();
				}

			} else {
				req.setAttribute("result", "수정실패");
				if (!oldFile.equals(newFile)) {
					newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정실패");
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "utf-8");
				} catch (UnsupportedEncodingException e1) {
				}
				new File(path + "/" + newFile).delete();
			}
		}

	}

	

	public void SettingPW1(User u, HttpServletRequest req) {


		
		String settingPassword1 = req.getParameter("settingPassword1");
		
		System.out.println("어\n\\n\\n\\n\\n어" + settingPassword1);
		
		u = (User) req.getSession().getAttribute("loginMember");
		
		
		System.out.println("ㄴㅇㅃㅃㄹ" + u.getUser_PW());

		if (settingPassword1.equals(u.getUser_PW())) {
			
			System.out.println("여기까진 옴");
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword2.jsp");

		} else {
			req.setAttribute("r", "비밀번호가 틀렸습니다!");
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword4.jsp");

		}
		
		
		
	}

	
	
	
	
	
	
}
