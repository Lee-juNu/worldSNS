package com.team.worlds.user;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//단위테스트를 스프링과 연동
@RunWith(SpringJUnit4ClassRunner.class)
//환경설정 파일 명시
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class userTest {

	
	@Autowired
	SqlSession ss;
	
	@Autowired
	UserDAO uDao;
	
	@Test
	public void testSSCheck() {
		   assertNotNull(ss);
	}

	@Test
	public void testUserCheck() {
		   assertNotNull(uDao);
	}


}
