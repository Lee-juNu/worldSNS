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
${msg.msg_sendUserID } : ${msg.msg_Contents } <img src="${msg.msg_img }">   <br>
</c:forEach>
</div>
여기에 메세지가 올12거임<br>
로그인 중인 아이디 세션 : ${sessionScope.loginMember.user_ID }
${userlist}

</div>
<div id="sendMessage">
<form action="messages.send" method="post" enctype="multipart/form-data"
		name="sendMessage">
<input type="file" name="sendimg"><input type="text" name="sendmsg"> <button>송신</button><BR>
<input type="hidden" name="roomNum" value="${roomNum }">
</form>
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