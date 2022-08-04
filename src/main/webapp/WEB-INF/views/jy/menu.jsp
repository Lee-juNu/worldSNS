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
	<h1>메뉴 홈페이지 </h1>
	<br>
	
	
	<button onclick = "goHome()"><img  width="50px" src="resources/icon/homeIcon.png" alt="HOME"></button><br>
	<button onclick = "goMessages()"><img  width="50px" src="resources/icon/chatIcon.png" alt="CHAT"></button><br>
	<button onclick = "goAram()"><img  width="50px" src="resources/icon/noticeIcon.png" alt="NOTICE"></button><br>
	<jsp:include page="${profileMini }"/><br>
</body>

</html>