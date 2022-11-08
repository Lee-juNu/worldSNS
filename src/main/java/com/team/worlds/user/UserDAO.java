package com.team.worlds.user;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
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

	
	
	
	public void login(User u, HttpServletRequest req, HttpServletResponse response, HttpSession httpSession) {

		
		System.out.println();
		System.out.println("되나?");
		User dbUser = ss.getMapper(UserMapper.class).getMemberByID(u.getUser_ID());

		if (dbUser != null) {
		
			if (u.getUser_PW().equals(dbUser.getUser_PW())) {
				
				req.getSession().setAttribute("loginMember", dbUser);
				req.getSession().setMaxInactiveInterval(600 * 10);
				System.out.println(dbUser.getUser_nickName());

				if (req.getParameter("useCookie") != null) {
				
					System.out.println("쿠키생성한닫앙");
					// 쿠키 생성
					Cookie loginCookie = new Cookie("loginCookie", httpSession.getId());
					loginCookie.setPath("/");
					loginCookie.setMaxAge(60 * 60 * 24 * 7);
					// 전송
					response.addCookie(loginCookie);
				}

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

		String juser_ID = req.getParameter("join_ID");
		String juser_PW = req.getParameter("join_PW");
		String juser_nickName = req.getParameter("join_nickName");
		String juser_phoneNumber = req.getParameter("join_phoneNumber");
		String juser_name = req.getParameter("join_name");
		String juser_email = req.getParameter("join_email");
		String juser_country = req.getParameter("join_country");
		String juser_city = req.getParameter("join_city");

		String mm = req.getParameter("mm");
		String dd = req.getParameter("dd");
		String yy = req.getParameter("yy");

		Date juser_birthDay = Date.valueOf(yy + "-" + mm + "-" + dd);

		System.out.println(juser_birthDay);

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
		// u.setRegDate(jregDate);

		if (ss.getMapper(UserMapper.class).joinus(u) == 1) {
			req.setAttribute("result", "성공적으로 가입이 완료되었습니다!");
			System.out.println("가입 성공");
		} else {
			req.setAttribute("result", "가입에 실패하였습니다.. 잠시 후 다시 시도해 주세요!");
			System.out.println("가입 실패");

		}

	}

	// 중복 아이디 체크
	public boolean userIdCheck(String user_ID) {


		if (ss.getMapper(UserMapper.class).checkOverId(user_ID) == null) {
			return true;
		}
		return false;

	}

	public void secession(HttpServletRequest req) {
		try {
			User u = (User) req.getSession().getAttribute("loginMember");

			if (ss.getMapper(UserMapper.class).secession(u) == 1) {
				req.setAttribute("result", "탈퇴성공");

				// sDAO.setAllMsgCount(allMsgCount - msgCount);

				// logout(req);
				// loginCheck(req);

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

		System.out.println((String) req.getSession().getAttribute("이렇게" + "user_ID"));

		String user_ID = req.getParameter("user_ID");
		String user_name = req.getParameter("user_name");
		String user_email = req.getParameter("user_email");
		String user_nickName = req.getParameter("user_nickName");
		String user_phoneNumber = req.getParameter("user_phoneNumber");

		System.out.println("왔을까 " + user_phoneNumber);
		System.out.println(user_ID);
		System.out.println();

		try {

			u.setUser_ID(user_ID);
			u.setUser_name(user_name);
			u.setUser_email(user_email);
			u.setUser_nickName(user_nickName);
			u.setUser_phoneNumber(user_phoneNumber);

			System.out.println("흠");
			if (ss.getMapper(UserMapper.class).updateInfo(u) == 1) {

				System.out.println("1" + u.getUser_nickName());
				System.out.println("수정성공");
				req.setAttribute("result", "수정성공");
				req.getSession().setAttribute("loginMember", u);

			} else {
				System.out.println("2" + u.getUser_nickName());
				System.out.println("수정실패");
				req.setAttribute("result", "수정실패");
			}
		} catch (Exception e) {
			System.out.println("3" + u.getUser_nickName());
			e.printStackTrace();
			System.out.println("수정실패");
			req.setAttribute("result", "수정실패");
		}
	}

	public void findID(User u, HttpServletRequest req) {

		System.out.println("아이디찾기" + req.getParameter("user_name"));

		User dbUser = ss.getMapper(UserMapper.class).getMemberByEmail(u);

		System.out.println("아이디찾음" + req.getParameter("user_name"));

		if (dbUser != null) {
			req.getSession().setAttribute("loginMember", dbUser);
			req.setAttribute("result", "당신의 아이디는 " + dbUser.getUser_ID() + " 입니다.");
			System.out.println(dbUser.getUser_nickName());

		} else {
			System.out.println("실패");
			req.setAttribute("result", "정보를 다시 확인해 주세요.");
		}

	}

	public void findPW(User u, HttpServletRequest req) {

		System.out.println("비밀번호 찾기" + req.getParameter("user_name"));

		User dbUser = ss.getMapper(UserMapper.class).getMemberByIDEmail(u);

		if (dbUser != null) {

			System.out.println("아마도 성공");
			if (ss.getMapper(UserMapper.class).updateFindPW(u) == 1) {
				req.setAttribute("result", "비밀번호가 0000으로 변경되었습니다. \n 개인정보 보호를 위해 로그인 후 비밀번호를 변경해 주세요!");

			} else {
				System.out.println("실패");
				req.setAttribute("result", "정보를 다시 확인해 주세요.");
			}
		}
	}

	/*
	 * public void goProfile(String user_ID_o, User_o u_o, Profile_o p_o,
	 * HttpServletRequest req) {
	 * 
	 * 
	 * System.out.println(user_ID_o); System.out.println("호오잉");
	 * 
	 * //User dbUser = ss.getMapper(UserMapper.class).getMemberByIDEmail(u);
	 * 
	 * // System.out.println("에엥" + dbUser.getUser_ID());
	 * 
	 * String user_ID = user_ID_o;
	 * 
	 * u_o.setUser_ID("9"); p_o.setPf_userID("9");
	 * 
	 * User_o dbUser_o = ss.getMapper(UserMapper.class).getOtherMemberByID(u_o);
	 * User_o dbUser_p =
	 * ss.getMapper(UserMapper.class).getOtherProfileMemberByID(p_o);
	 * 
	 * System.out.println(u_o.getUser_ID()); System.out.println(p_o.getPf_userID());
	 * 
	 * 
	 * 
	 * 
	 * System.out.println("흠" + dbUser_o.getUser_ID());
	 * 
	 * // req.getSession().setAttribute("loginMember", dbUser);
	 * req.getSession().setAttribute("OtherMember", dbUser_o);
	 * req.getSession().setAttribute("OtherMemberP", dbUser_p);
	 * 
	 * System.out.println("열ㅋ" + dbUser_o.getUser_ID());
	 * 
	 * 
	 * }
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

		// req.getSession().setAttribute("loginMember", dbUser);
		req.getSession().setAttribute("OtherMember", dbUser_o);

		System.out.println("열ㅋ" + dbUser_o.getUser_ID());

	}

	public boolean login2(User u, HttpServletRequest req) {
		System.out.println("되나?login2");
		User dbUser = ss.getMapper(UserMapper.class).getMemberByID(u.getUser_ID());
		System.out.println(u.getUser_ID() + "제발뭐하냐");

		if (dbUser != null) {
			System.out.println("아이고바빠죽겠네");
			if (u.getUser_PW().equals(dbUser.getUser_PW())) {
				req.getSession().setAttribute("loginMember", dbUser);
				req.getSession().setMaxInactiveInterval(600 * 10);
				return true;
			} else {
				System.out.println("실패1");
			}
		}

		else {
			System.out.println("실패2");
		}
		return false;
	}

	public boolean joinUs(User u, HttpServletRequest req) {

		Date date = Date.valueOf(req.getParameter("str_user_birthDay"));
		u.setUser_birthDay(date);

		System.out.println(u.getUser_ID());
		System.out.println(u.getUser_PW());
		System.out.println(u.getUser_birthDay());
		System.out.println("이거 정말안딤?");
		ss.getMapper(UserMapper.class).joinus(u);

		if (login2(u, req)) {
			try {
				FileManager.createUploadFolder("profile/" + u.getUser_ID());
			} catch (Exception e) {
				System.out.println(e);
			}
			return true;
		} else {
			return false;
		}
	}

	public void getUserByID(String userId, HttpServletRequest req) {
		User user = ss.getMapper(UserMapper.class).getMemberByID(userId);

		req.setAttribute("findUser", user);
	}
	
	public void getUserWidthProfileByID(String userId, HttpServletRequest req)
	{
		User_Profile user = ss.getMapper(UserMapper.class).getProfileMemberByID(userId);
		
		req.setAttribute("findUser", user);
	}

	public void settingProfile(User u, HttpServletRequest req) {

	}
	public void keepLogin(String user_ID, String sessionId, Date sessionLimit) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userId", user_ID);
		paramMap.put("sessionId", sessionId);
		paramMap.put("sessionLimit", sessionLimit);

		ss.update(user_ID + ".keepLogin", paramMap);
	}


	public JsonArray getFollwerByID(String userId, String search) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userId", userId);
		paramMap.put("search", search);
		System.out.println(userId);
		System.out.println(search);
		ArrayList<User> user = ss.getMapper(UserMapper.class).getFollwerByID(paramMap);
		
		
		
		System.out.println(user.size());
		return new GsonBuilder().create().toJsonTree(user).getAsJsonArray();
	}




	public boolean userEmailCheck(String user_email) {
		if (ss.getMapper(UserMapper.class).checkOverEmail(user_email) == null) {
			return true;
		}
		return false;

	}




	public boolean userPhoneNumCheck(String user_phoneNumber) {
		if (ss.getMapper(UserMapper.class).checkOverPhoneNum(user_phoneNumber) == null) {
			return true;
		}
		return false;

	}
	
	

	/*
	 * // 우리 것에 맞춰 업데이트 해야함 public void update(Profile p, User u, HttpServletRequest
	 * req) {
	 * 
	 * String path =
	 * req.getSession().getServletContext().getRealPath("resources/files");
	 * MultipartRequest mr = null; User loginMember = (User)
	 * req.getSession().getAttribute("loginMember"); Profile loginMemberprofile =
	 * (Profile) req.getSession().getAttribute("loginMember"); String oldFile =
	 * loginMemberprofile.getPf_Img(); String newFile = null; try { mr = new
	 * MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new
	 * DefaultFileRenamePolicy()); newFile = mr.getFilesystemName("jm_photo");
	 * 
	 * if (newFile == null) { newFile = oldFile; } else { newFile =
	 * URLEncoder.encode(newFile, "utf-8"); newFile = newFile.replace("+", " "); } }
	 * catch (Exception e) { e.printStackTrace(); req.setAttribute("result",
	 * "수정실패"); return; }
	 * 
	 * try { String juser_ID = mr.getParameter("jm_id"); String juser_PW =
	 * mr.getParameter("jm_pw"); String juser_name = mr.getParameter("jm_name");
	 * String jpf_Img = newFile;
	 * 
	 * u.setuser_ID(juser_ID); u.setUser_PW(juser_PW); u.setUser_name(juser_name);
	 * p.setPf_Img(jpf_Img);
	 * 
	 * if (ss.getMapper(UserMapper.class).update(p) == 1) {
	 * req.setAttribute("result", "수정성공");
	 * req.getSession().setAttribute("loginMember", u); if
	 * (!oldFile.equals(newFile)) { oldFile = URLDecoder.decode(oldFile, "utf-8");
	 * new File(path + "/" + oldFile).delete(); }
	 * 
	 * } else { req.setAttribute("result", "수정실패"); if (!oldFile.equals(newFile)) {
	 * newFile = URLDecoder.decode(newFile, "utf-8"); new File(path + "/" +
	 * newFile).delete(); } } } catch (Exception e) { e.printStackTrace();
	 * req.setAttribute("result", "수정실패"); if (!oldFile.equals(newFile)) { try {
	 * newFile = URLDecoder.decode(newFile, "utf-8"); } catch
	 * (UnsupportedEncodingException e1) { } new File(path + "/" +
	 * newFile).delete(); } }
	 * 
	 * }
	 */
	/*
	 * public void joinusp( HttpServletRequest req) {
	 * 
	 * String juser_ID = req.getParameter("user_ID");
	 * 
	 * p.setPf_userID(juser_ID);
	 * 
	 * 
	 * if (ss.getMapper(UserMapper.class).joinusp(p) == 1) {
	 * req.setAttribute("result", "성공적으로 가입이 완료되었습니다!"); } else {
	 * req.setAttribute("result", "가입에 실패하였습니다.. 잠시 후 다시 시도해 주세요!");
	 * 
	 * }
	 * 
	 * }
	 * 
	 */
}