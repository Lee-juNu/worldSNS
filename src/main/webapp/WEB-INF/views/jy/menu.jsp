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
	<div class = "homeLogoImg"><img alt="" src="resources/img/util/logo/wlogo.png"></div>
	
	
	
	
	<!-- 메뉴 링크 홈컨트롤러로 연결해놨는데 다른 곳에 있으면 옮기기 ! -->
	<div class = "menuButton">
		<a href=""><div class = "menuFlex">
			<div>
			<img class = "menuImg" alt="" src="resources/icon/white/homeIcon.png"> 
			</div>
			<div class = "menuTitle">
			<span>Home</span> 
			</div>
		</div></a>
	</div>
	
	
	<div class = "menuButton">
		<a href=""><div class = "menuFlex">
			<div>
			<img class = "menuImg" alt="" src="resources/icon/white/noticeIcon.png"> 
			</div>
			<div class = "menuTitle">
			<span>Notice</span> 
			</div>
		</div></a>
	</div>
	
	<div class = "menuButton">
		<a href=""><div class = "menuFlex">
			<div>
			<img class = "menuImg" alt="" src="resources/icon/white/chatIcon.png"> 
			</div>
			<div class = "menuTitle">
			<span>Chat</span> 
			</div>
		</div></a>
	</div>
	
	<div class = "menuButton">
		<a href=""><div class = "menuFlex">
			<div>
			<img class = "menuImg" alt="" src="resources/icon/white/settingIcon.png"> 
			</div>
			<div class = "menuTitle">
			<span>Setting</span> 
			</div>
		</div></a>
	</div>
	
	<div class = "menuButton">
		<a href=""><div class = "menuFlex">
			<div>
			<img class = "menuImg" alt="" src="resources/icon/white/profileIcon1.png"> 
			</div>
			<div class = "menuTitle">
			<span>Profile</span> 
			</div>
		</div></a>
	</div>
	<div><jsp:include page="${profilePage }"/></div>
	<!-- 이미지 주소 생성 후에 이미지 주소 넣기 -->
	
	</div>
	
</body>

</html>