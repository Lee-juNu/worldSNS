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

<div id="chatList">
	<div class ="titleMainDiv">
	<div class ="titleDiv">メッセージ</div>
	<div style ="display: flex;">
	<button class = "chatBtn" id="btn-modal">ルームを作る</button>
	<a id="btn-modal2"> <img style='width:40px;' alt="招待する" src="resources/icon/white/invite.png"></a>
	</div>
	</div>
	
	<div class ="search">
		<input id="searchbyUser" placeholder="IDで検索">
		<div class ="searchImg">
		<a id="searchbyUserBtn" onclick="searchbyUser()">
		<img style='width:30px; height:30px;' src="resources/icon/white/serach.png">
		</a>
		</div>
	</div>


<c:forEach var="chat" items="${msgs}" >
<div id="chatTbl" >
<form action="messages.select" name="selectroom">
<div class ="arrChat">
 ルーム：${chat.cr_Num }
<button name="join" id="join" value="${chat.cr_Num }"> 入る </button>
</div>
</form>
</div>
</c:forEach>
	<div id="sbuDiv">
	</div>
</div>


<div id="chat">
<div id="titleMessage">
${roomNum } 
</div>
<div id="chatRoom">
<div id="chatMsg">



</div>
</div>
<div id="sendMessage">

<form action="messages.send" method="post" enctype="multipart/form-data"
		name="sendMessage">
</form>

<input type="file" name="sendimg" id="sendimg"><input type="text" name="sendmsg" id="sendmsg">
<button onclick="jwSendWithFile()">송신</button><BR>
<input type="hidden" name="roomNum" id="roomNum" value="${roomNum }">
<input type="hidden" name="userID" id="userID" value="${loginMember.user_ID }">
<!-- <button id="hide" onclick="if(chatList.style.display=='none')
{chatList.style.display='';}
else {chatList.style.display='none';}">채팅방 목록 접기 펼치기</button> -->
<form action="messages.out" method="get">
<input type="hidden" id="outRoom" name="outRoom" value="${roomNum }">
<input type="hidden" id="outId" name="outID" value="${loginMember.user_ID }">
<button>방 나가기</button>
</form>
<!-- <button id="getroomuserBtn" onclick="getroomuser()">딸깍</button>
 -->
 </div>
</div>


<input type="hidden" id="wsRoomType" value="${roomNum }">
<input type="hidden" id="wsUserId" value="${sessionScope.loginMember.user_ID}">

    <div id="modal" class="modal-overlay">
        <div class="modal-window">
            <div class="title">
                <h2>채팅방을 만들래?</h2>
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

    <div id="modal2" class="modal-overlay">
        <div class="modal-window">
            <div class="title">
                <h2>초대할 친구는?</h2>
            </div>
            <div class="close-area">X</div>
            <div class="content">
            <div>
		<input name="searchUser" id="searchUser"> 
		<button id="searchButton" onclick="search()">검색</button>   <br>
            </div>
            <div id="userList">
            </div>
            </div>
        </div>
    </div>
    
</body>
    <script type = "text/javascript" src="resources/js/SU/message.js"></script>
<script type = "text/javascript" src="resources/js/utill/jQuery.js"></script>
<script type = "text/javascript" src="resources/js/utill/jwServer.js"></script>
<script type = "text/javascript" src="resources/js/SU/serverMessage.js"></script>

</html>