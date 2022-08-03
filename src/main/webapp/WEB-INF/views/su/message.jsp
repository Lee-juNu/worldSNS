<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" type = "text/css" href = "resources/css/SU/message.css">
</head>
<body>

<div id="chatList" style="display: none">
채팅방목록
<c:forEach var="list" items="${list}" >
<div id="chatTbl">
채팅방목록
</div>
</c:forEach>
</div>




<div id="chat">
<div id="titleMessage">
채팅방 방제
</div>

<div id="chatRoom">
여기에 메세지가 올거임<br>
</div>
<div id="sendMessage">
<form action="message.send" method="post" enctype="multipart/form-data"
		name="sendMessage">
<input type="file"><input type="text"> <button>송신</button><BR>
</form>
<button id="hide" onclick="if(chatList.style.display=='none')
{chatList.style.display='';}
else {chatList.style.display='none';}">채팅방 목록 접기 펼치기</button>
</div>
</div>

</body>
</html>