<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type = "text/javascript" src="resources/js/menuGo.js"></script>

</head>

<body>
<div>
	<div><h1>메뉴 홈페이지 </h1></div>
	
	
	<!-- 메뉴 링크 홈컨트롤러로 연결해놨는데 다른 곳에 있으면 옮기기 ! -->
	<div><button onclick = "goHome()"><img  width="50px" src="resources/icon/homeIcon.png" alt="HOME"></button></div>
	<div><button onclick = "goMessages()"><img  width="50px" src="resources/icon/chatIcon.png" alt="CHAT"></button></div>
	<div><button onclick = "goAram()"><img  width="50px" src="resources/icon/noticeIcon.png" alt="NOTICE"></button></div>
	<div><button onclick = "goSetting()"><img  width="50px" src="resources/icon/settingIcon.png" alt="SETTING"></button></div>
	<div><button onclick = "goProfile()"><img width="50px" src="resources/icon/profileIcon1.png"></button></div>
	
	<form action="Search.user">
	
	<div>
	<input name="searchWord" placeholder="검색어를 입력해 주세요"> <button>검색</button>
	
	</div>
	</form>
	
	<div><jsp:include page="${profilePage }"/></div>
	<!-- 이미지 주소 생성 후에 이미지 주소 넣기 -->
	
	</div>
	
</body>

</html>