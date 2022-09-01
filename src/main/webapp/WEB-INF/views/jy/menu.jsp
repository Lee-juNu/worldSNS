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
<div class = "menuMainDiv">
	
	
	
	<div class = "menuTopDiv">
	<div class = "homeLogoImg"><img alt="" src="resources/img/util/logo/wlogo.png"></div>
	<!-- 메뉴 링크 홈컨트롤러로 연결해놨는데 다른 곳에 있으면 옮기기 ! -->
	<div class = "menuButton">
		<a href="home.go"><div class = "menuFlex">
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
		<a href="messages.go"><div class = "menuFlex">
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
		<a href="${sessionScope.loginMember.user_ID}"><div class = "menuFlex">
			<div>
			<img class = "menuImg" alt="" src="resources/icon/white/profileIcon1.png"> 
			</div>
			<div class = "menuTitle">
			<span>Profile</span> 
			</div>
		</div></a>
	</div>
		<div>
			<button class = "submitBtn">World is...</button>		
		</div>	
	</div>
	
	<div class = "menuProfile" >
		<div class = "profileIcon"> 
		<img style="width:100%; height:100%;" alt="" src="resources/img/profile/${sessionScope.loginMember.user_ID}/photo.png"
		onerror="this.onerror=null; this.src='resources/img/profile/s.png';"/> </div>
		
		<div class = "profileAccount">
			<div class = "profileNickName">
				<span>${sessionScope.loginMember.user_nickName}</span>
			</div>
			<div class = "profileID">
				<span>@${sessionScope.loginMember.user_ID}</span>
			</div>
		</div>
	</div>
	</div>
	<!-- 이미지 주소 생성 후에 이미지 주소 넣기 -->
</body>

</html>