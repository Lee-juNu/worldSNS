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

 	<input type="text" name = "user_id" id="wsUserId" value= '${sessionScope.loginMember.user_ID}'  style="display: none;">
   	<c:if test="${roomNumber == null }">
   	<input type="text" id="wsRoomType" value="chatRoom" style="display: none;">      	
   	</c:if>
   	<c:if test="${roomNumber != null }">
   	<input type="text" id="wsRoomType" value="${roomNumber}" style="display: none;">      	
   	</c:if>
   	
<div class = "chatDiv">
	<div id="chatList">
		<div class ="titleMainDiv">
		<div class ="titleDiv">メッセージ</div>
		<div style ="display: flex;">
		<button class = "chatBtn" id="btn-modal">ルームを作る</button>
		<a id="btn-modal2"> <img style='width:40px;' alt="招待する" src="resources/icon/white/invite.png"></a>
		</div>
		</div>
	
		<div class = "searchUserMainDiv">
			<div id = "backIconDiv" class = "icon" style = "margin:auto; display:none;">
					<img alt="" src="resources/icon/white/backIcon.png">				
			</div>
			<div class ="search" >
			<input id="searchbyUser" placeholder="IDで検索">
			<div class ="searchImg">
				<a id="searchbyUserBtn" onclick="searchbyUser()">
				<img style='width:30px; height:30px;' src="resources/icon/white/serach.png">
				</a>
			</div>
			</div>
		</div>
		<div id="chatContainer">
		</div>
		<div id="userContainer" style = "display:none;">
		アカウント、グループ、メッセージを検索してみましょう
		</div>
	</div>
</div>
<div style ="width:100%;">
</div>
    
</body>
    <script type = "text/javascript" src="resources/js/SU/message.js"></script>
<script type = "text/javascript" src="resources/js/utill/jQuery.js"></script>
<script type = "text/javascript" src="resources/js/utill/jwServer.js"></script>
<script type = "text/javascript" src="resources/js/SU/serverMessage.js"></script>
<script type = "text/javascript" src="resources/js/SU/messageUtil.js"></script>

</html>