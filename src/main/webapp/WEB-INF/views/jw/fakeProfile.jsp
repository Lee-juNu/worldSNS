<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${findUser.user_ID}s Profile</title>



</head>
<body class = "bgColor">

  	<input type="text" name = "user_id" id="wsUserId" value= '${sessionScope.loginMember.user_ID}'  style="display: none;">
   	<input type="text" id="wsRoomType" value="profile" style="display: none;">   
	<input id="findUser" type="hidden" value = '${findUser.user_ID}'>

<div class = "profileSectionDiv" id="profileSelectionID" >
	<div class = "profileMainDiv ">
	
		<div class = "profileBlank">
		</div>
		
		<div class = "profileDiv">
			<div class = "profileBGDiv">
				<a> <img alt="" src="resources/img/profile/${findUser.user_ID}/BG.png"
				onerror="this.onerror=null; this.src='resources/img/profile/bg.png';"/> </a>
				<div class = ""></div>
			</div>
			
			<div class =  "profileDetailDiv">
				<div class = "iconEditDiv">
					<div class = "iconDiv bgColor">
						<img alt="" src="resources/img/profile/${findUser.user_ID}/photo.png"
		onerror="this.onerror=null; this.src='resources/img/profile/s.png';"/> 
					</div>
					<div class = "editDiv">
					<c:if test ="${findUser.user_ID==sessionScope.loginMember.user_ID}">
						<button onclick="goSettingProfile()">Profile Edit</button>
					</c:if>
					
					
					<c:if test ="${findUser.user_ID!=sessionScope.loginMember.user_ID}">
						<button id="followButton">フォロー</button>
						<!-- jy수정 : 아이디 추가 -->
						<button id="unfollowButton" style='display:none;'>フォロー解除</button>
					</c:if>
					</div>
				</div>
				<div class = "ProfileIdNameDiv">
					<div class = "nickNameDiv">${findUser.user_nickName}</div>
					<div class = "idDiv">@${findUser.user_ID}</div>
				</div>				
				<div class = "profileContentsDiv">
					${findUser.user_contents}
				</div>
				<div class = "profileFollowCount">
					<div><a href="${findUser.user_ID}/follow">フォロー中 ${findUser.follower}</a></div>
					<div><a href="#"> フォロワー ${findUser.followed}</a></div>
				</div>
			</div>
		</div>
		<div class ="container" style = "width : 100%;">
			<div id = "containerList" class = "containerList" style = "width : 100%;">
			
			</div>
		</div>
	</div>
	
	
	<div class = "contentsSubDiv"> 
		<jsp:include page="subPage.jsp"/>
	</div>
</div>
</body>
<script type = "text/javascript" src="resources/js/utill/jQuery.js"></script>
<script type = "text/javascript" src="resources/js/JY/followGo.js"></script>
<script type = "text/javascript" src="resources/js/JY/userGo.js"></script>
<script type = "text/javascript" src="resources/js/JY/profile.js"></script>
<script type = "text/javascript" src="resources/js/JY/profile/profilePaiging.js"></script>
<script type = "text/javascript" src="resources/js/utill/jwServer.js"></script>
<script type = "text/javascript" src="resources/js/jw/board/fakeBoard.js"></script>
<script type = "text/javascript" src="resources/js/jw/board/boardAdder.js"></script>
</html>