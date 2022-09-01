package com.team.worlds.user;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team.worlds.fileUtil.FileManager;

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
//		u.setUser_birthDay(juser_birthDay);
		// u.setRegDate(jregDate);

		if (ss.getMapper(UserMapper.class).joinus(u) == 1) {
			req.setAttribute("result", "성공적으로 가입이 완료되었습니다!");
		} else {
			req.setAttribute("result", "가입에 실패하였습니다.. 잠시 후 다시 시도해 주세요!");

		}

	}
	
	

	// 중복 아이디 체크
	public boolean userIdCheck(String user_ID) {

		System.out.println(user_ID);
		
		if (ss.getMapper(UserMapper.class).checkOverId(user_ID) == null) {
			
			return false;
			
		}
		
		return true;
	
}

	
	
	public void secession(HttpServletRequest req) {
		try {
			User u = (User) req.getSession().getAttribute("loginMember");

			if (ss.getMapper(UserMapper.class).secession(u) == 1) {
				req.setAttribute("result", "탈퇴성공");

				// sDAO.setAllMsgCount(allMsgCount - msgCount);

				//logout(req);
				//loginCheck(req);
				
			} else {
				req.setAttribute("result", "탈퇴실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "탈퇴실패");
		}

	}
	
	public void updateInfo(User u, HttpServletRequest req) {

		User loginMember = (User) req.getSession().getAttribute("loginMember");
		String Nuser_ID = req.getParameter("Nuser_ID");
		String Nuser_PW = req.getParameter("Nuser_PW");
		String Nuser_name = req.getParameter("Nuser_name");
		String Nuser_email = req.getParameter("Nuser_email");
		String Nuser_nickName = req.getParameter("Nuser_nickName");
		
		
		
		try {
			
			u.setUser_ID(Nuser_ID);
			u.setUser_PW(Nuser_PW);
			u.setUser_name(Nuser_name);
			u.setUser_email(Nuser_email);
			u.setUser_nickName(Nuser_nickName);

			if (ss.getMapper(UserMapper.class).updateInfo(u) == 1) {
			
				
				System.out.println("수정성공");
				req.setAttribute("result", "수정성공");
				req.getSession().setAttribute("loginMember", u);

			} else {
				System.out.println("수정실패");
				req.setAttribute("result", "수정실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정실패");
			req.setAttribute("result", "수정실패");
			}
		}

	


	

	public void findID(User u, HttpServletRequest req) {


		System.out.println("아이디찾기"+ req.getParameter("user_name"));
		
		User dbUser = ss.getMapper(UserMapper.class).getMemberByEmail(u);
		
		System.out.println("아이디찾음"+ req.getParameter("user_name"));
		
		
		if (dbUser != null) {
			req.getSession().setAttribute("loginMember", dbUser);
				req.setAttribute("result", "당신의 아이디는 " + dbUser.getUser_ID() + " 입니다." );
				System.out.println(dbUser.getUser_nickName());

		} else {
			System.out.println("실패");
			req.setAttribute("result", "정보를 다시 확인해 주세요.");
		}

	}
		
		
	public void findPW(User u, HttpServletRequest req) {
		
		
		System.out.println("비밀번호 찾기"+ req.getParameter("user_name"));
		
		User dbUser = ss.getMapper(UserMapper.class).getMemberByIDEmail(u);
		
		
		if (dbUser != null) {
			
			
			System.out.println("아마도 성공");
			if(ss.getMapper(UserMapper.class).updateFindPW(u) == 1) {
			req.setAttribute("result", "비밀번호가 0000으로 변경되었습니다. \n 개인정보 보호를 위해 로그인 후 비밀번호를 변경해 주세요!");
			
		} else {
			System.out.println("실패");
			req.setAttribute("result", "정보를 다시 확인해 주세요.");
		}
		}
	}


/*
	public void goProfile(String user_ID_o, User_o u_o, Profile_o p_o, HttpServletRequest req) {

		
		System.out.println(user_ID_o);
		System.out.println("호오잉");
		
		//User dbUser = ss.getMapper(UserMapper.class).getMemberByIDEmail(u);
		
//		System.out.println("에엥" + dbUser.getUser_ID());
		
		String user_ID = user_ID_o;
		
		u_o.setUser_ID("9");
		p_o.setPf_userID("9");
		
		User_o dbUser_o = ss.getMapper(UserMapper.class).getOtherMemberByID(u_o);
		User_o dbUser_p = ss.getMapper(UserMapper.class).getOtherProfileMemberByID(p_o);
		
		System.out.println(u_o.getUser_ID());
		System.out.println(p_o.getPf_userID());
		
		
		
		
		System.out.println("흠" + dbUser_o.getUser_ID());
		
	//	req.getSession().setAttribute("loginMember", dbUser);
		req.getSession().setAttribute("OtherMember", dbUser_o);
		req.getSession().setAttribute("OtherMemberP", dbUser_p);
		
		System.out.println("열ㅋ" + dbUser_o.getUser_ID());
		
		
	}
*/


	public void goProfile(String user_ID_o, User_o u_o, HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		System.out.println(user_ID_o);
		System.out.println("호오잉");
		
//		User dbUser = ss.getMapper(UserMapper.class).getMemberByIDEmail(u);
		
//		System.out.println("에엥" + dbUser.getUser_ID());
		
		String user_ID = user_ID_o;
		
		u_o.setUser_ID(user_ID);
		
		System.out.println(u_o.getUser_ID());
		
		
		
		User_o dbUser_o = ss.getMapper(UserMapper.class).getOtherMemberByID(u_o);
		
		
		System.out.println("흠" + dbUser_o.getUser_ID());
		
	//	req.getSession().setAttribute("loginMember", dbUser);
		req.getSession().setAttribute("OtherMember", dbUser_o);
		
		System.out.println("열ㅋ" + dbUser_o.getUser_ID());
		
	}
	
	
	public boolean login2(User u, HttpServletRequest req) {

		
		User dbUser = ss.getMapper(UserMapper.class).getMemberByID(u.getUser_ID());
			
			
			if (dbUser != null) {
				if (u.getUser_PW().equals(dbUser.getUser_PW())) {
					req.getSession().setAttribute("loginMember", dbUser);
					req.getSession().setMaxInactiveInterval(600 * 10);
					return true;
				} else {
					System.out.println("실패");
				}
			} else {
				System.out.println("실패");
			}
			return false;
	}
	
	public boolean joinUs(User u, HttpServletRequest req)
	{
		
		Date date = Date.valueOf(req.getParameter("str_user_birthDay")); 
		u.setUser_birthDay(date);
		
		System.out.println(u.getUser_ID());
		System.out.println(u.getUser_PW());
		System.out.println(u.getUser_birthDay());
		
		ss.getMapper(UserMapper.class).joinus(u);
		
		if(login2(u,req))
		{
			try
			{
				FileManager.createUploadFolder("profile/"+u.getUser_ID());				
			}
			catch (Exception e) {
				System.out.println(e);
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void getUserByID(String userId, HttpServletRequest req)
	{
		User user = ss.getMapper(UserMapper.class).getMemberByID(userId);
		
		
		req.setAttribute("findUser", user);
	}
		
	



/*
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
		
		u.setuser_ID(juser_ID);
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
	
}*/
	/*
	public void joinusp( HttpServletRequest req) {

		String juser_ID = req.getParameter("user_ID");

		p.setPf_userID(juser_ID);
		

		if (ss.getMapper(UserMapper.class).joinusp(p) == 1) {
			req.setAttribute("result", "성공적으로 가입이 완료되었습니다!");
		} else {
			req.setAttribute("result", "가입에 실패하였습니다.. 잠시 후 다시 시도해 주세요!");

		}

	}

	*/
}