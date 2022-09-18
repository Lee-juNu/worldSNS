<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${findUser.user_ID}sProfile</title>

<script type="text/javascript" src="resources/js/utill/jQuery.js"></script>



</head>
<body class="bgColor">

	<div class="profileSectionDiv">
		<div class="profileMainDiv ">

			<div class="profileBlank"></div>

			<div class="profileDiv">
				<div class="profileBGDiv">
					<a> <img alt=""
						src="resources/img/profile/${findUser.user_ID}/BG.png"
						onerror="this.onerror=null; this.src='resources/img/profile/bg.png';" />
					</a>
					<div class=""></div>
				</div>

				<div class="profileDetailDiv">
					<div class="iconEditDiv">
						<div class="iconDiv bgColor">
							<img alt=""
								src="resources/img/profile/${findUser.user_ID}/photo.png"
								onerror="this.onerror=null; this.src='resources/img/profile/s.png';" />
								<input type="image" name="${findUser.user_ID}">
						</div>
					
					</div>
					<div class="ProfileIdNameDiv">
						<div class="nickNameDiv">
						닉네임<input value="${findUser.user_nickName}" name="user_nickName">
						
					</div>
					<div class="profileContentsDiv">
					
					자기소개<input value="${findUser.user_contents}" name="user_contents">
					</div>
					<div class="profileContentsDiv">
					
					위치<input value="${findUser.user_contents}" name="user_contents">
					</div>
					
					
					
					
					
					
					
					
					
					
				</div>

				<!-- jy수정 : 팔로우 수, 팔로워 수 추가 -->

				<div></div>





			</div>
		</div>
	</div>



</body>
</html>