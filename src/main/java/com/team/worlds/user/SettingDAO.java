package com.team.worlds.user;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class SettingDAO {

	@Autowired
	SqlSession ss;


	public void SettingPW1(User u,Profile p, HttpServletRequest req) {


		
		String settingPassword1 = req.getParameter("settingPassword1");
		
		
		u = (User) req.getSession().getAttribute("loginMember");
		
		
		
		if (settingPassword1.equals(u.getUser_PW())) {
			
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword2.jsp");

		} else {
			req.setAttribute("result", "비밀번호가 틀렸습니다!");
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword4.jsp");

		}
		
		
		
	}

	

	public void SettingPW2(User u,Profile p, HttpServletRequest req) {


		
		String settingPassword1 = req.getParameter("settingPassword1");
		String settingPassword2 = req.getParameter("settingPassword2");
		u = (User) req.getSession().getAttribute("loginMember");
		
		
		if (settingPassword2 == settingPassword1) {
			req.setAttribute("result", "ㅇㅇㅇ를 포함한 새로운 비밀번호를 만들어 주세요!");
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword4.jsp");
			System.out.println("뭐가달라");
			
		} else if (settingPassword2 != settingPassword1) {
			System.out.println("1달라");
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword3.jsp");

		} else {
			req.setAttribute("result", "비밀번호가 틀렸습니다!");
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword4.jsp");

		}
		
		
		
	}

	
	
	public void SettingPW3(User u,Profile p, HttpServletRequest req) {
		

		
		String settingPassword2 = req.getParameter("settingPassword2");
		String settingPassword3 = req.getParameter("settingPassword3");
		u = (User) req.getSession().getAttribute("loginMember");
		//System.out.println("마지막"+settingPassword2);
		System.out.println("마지막"+settingPassword3);
		
		u.setUser_PW(settingPassword3);
		
		System.out.println("1"+u.getUser_PW());
		
		if (ss.getMapper(UserMapper.class).updatePW(u) == 1) {
			
			
			req.setAttribute("result", "비밀번호 변경 성공!");
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword4.jsp");
			System.out.println("2"+u.getUser_PW());
			
		} else {
			req.setAttribute("result", "새로운 비밀번호와 같은 비밀번호를 다시 입력해 주세요!");
			req.setAttribute("contentsPage", "jy/Setting/SettingPassword4.jsp");
			
		}
		
		
		
	}
	
	

	public void updateProfile(User u, Profile p, HttpServletRequest req) {

		
		User loginMember = (User) req.getSession().getAttribute("loginMember");
		Profile loginMemberp = (Profile) req.getSession().getAttribute("loginMember");
		
		
		String path1 = req.getSession().getServletContext().getRealPath("WEB-INF/views/jy/Setting/pf_Img");
			String path2 = req.getSession().getServletContext().getRealPath("WEB-INF/views/jy/Setting/pf_bgImg");
			try {
				
				MultipartRequest mr = null;
				MultipartRequest mr2 = null;
				mr = new MultipartRequest(req, path1, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
				mr2 = new MultipartRequest(req, path2, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
				String newFile1 = null;
				String newFile2 = null;
				
				
				newFile1 = mr.getFilesystemName("pf_Img");
				newFile2 = mr2.getFilesystemName("pf_bgImg");
				
				
				String Spf_contents = mr.getParameter("pf_contents");
		//	jm_photo = URLEncoder.encode(jm_photo, "utf-8");
		//	jm_photo = jm_photo.replace("+", " ");

			
			
			
		/*	p.setPf_Img(Spf_Img);
			p.setPf_bgImg(Spf_bgImg);
			p.setPf_contents(Spf_contents); */

			String oldFile1 = loginMemberp.getPf_Img();
			String oldFile2 = loginMemberp.getPf_bgImg();
			
			if (newFile1 == null) {
				newFile1 = oldFile1;
			} else {
				newFile1 = URLEncoder.encode(newFile1, "utf-8");
				newFile1 = newFile1.replace("+", " ");
			}
			
			if (newFile2 == null) {
				newFile2 = oldFile1;
			} else {
				newFile2 = URLEncoder.encode(newFile2, "utf-8");
				newFile2 = newFile1.replace("+", " ");
			}
			
			if (ss.getMapper(UserMapper.class).updateProfile(p, u) == 1) {
				req.setAttribute("result", "수정 성공");
			} else {
				req.setAttribute("result", "수정 실패");
			}
			
		}catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("result", "수정실패");
				return;
			
		}

}
		
	

	
	
	


}
