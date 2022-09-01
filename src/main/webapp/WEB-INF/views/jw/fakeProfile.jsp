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

<div class = "profileSectionDiv" >
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
						<button>Profile Edit</button>
					</c:if>
					<c:if test ="${findUser.user_ID!=sessionScope.loginMember.user_ID}">
						<button>팔로우</button>
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
			</div>
			
			</div>
		</div>
	</div>
	
	
	<div class = "contentsSubDiv"> 
		<jsp:include page="subPage.jsp"/>
	</div>
</div>
</body>
</html>