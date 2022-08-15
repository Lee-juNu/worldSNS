<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" type = "text/css" href = "resources/css/SU/message.css">
<script type = "text/javascript" src="resources/js/utill/jQuery.js"></script>
</head>
<body>

<div id="chatList" style="display: none">
채팅방목록
<button id="btn-modal">채팅방 만들기</button>
<c:forEach var="chat" items="${msgs}" >
<div id="chatTbl">
<form action="messages.select" name="selectroom">
${chat.cr_Num } <button name="join" value="${chat.cr_Num }"> 참여 </button>
</form>


</div>
</c:forEach>
</div>


<div id="chat">
<div id="titleMessage">
${roomNum } 
</div>

<div id="chatRoom">
<div id="chatMsg">
<c:forEach var="msg" items="${msglist}" >
${msg.msg_sendUserID } : ${msg.msg_Contents } <img src="resources/files/${msg.msg_img }"> 
<c:forEach var="index" items="${room}" >
<c:if test="${index.rm_lastIndex < msg.msg_index }">
${0+1}
</c:if>
</c:forEach>
 <br>
</c:forEach>
</div>
</div>
<div id="sendMessage">

<form action="messages.send" method="post" enctype="multipart/form-data"
		name="sendMessage">
</form>
<input type="file" name="sendimg" id="sendimg"><input type="text" name="sendmsg" id="sendmsg">
<button name="send" id="send">송신</button><BR>
<input type="hidden" name="roomNum" id="roomNum" value="${roomNum }">
<input type="hidden" name="userID" id="userID" value="${loginMember.user_ID }">
<button id="hide" onclick="if(chatList.style.display=='none')
{chatList.style.display='';}
else {chatList.style.display='none';}">채팅방 목록 접기 펼치기</button>
</div>
</div>




    <div id="modal" class="modal-overlay">
        <div class="modal-window">
            <div class="title">
                <h2>초대할 친구는?</h2>
            </div>
            <div class="close-area">X</div>
            <div class="content">
		<c:forEach var="user" items="${userlist}" >
<form action="messages.open" name="openMessage">
		${user.user_ID } <button name="invite" value="${user.user_ID }">초대</button>   <br>
</form>
		</c:forEach>   
            </div>
        </div>
    </div>
    <script type = "text/javascript" src="resources/js/SU/message.js"></script>
</body>
</html>