<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type = "text/javascript" src="resources/js/JY/userGo.js"></script>


</head>
<body>
<form action="setting.go.ProfileR" 	method="post" enctype="multipart/form-data"
		name="settingProfile">
<div>

<div>배경</div>
<div><input type="file" name="pf_Img"></div>
<div>프로필</div>
<div><input type="file" name="pf_bgImg"></div>
<div>닉네임</div>
<div><input name="user_nickName" value="${sessionScope.loginMember.user_nickName }"></div>
<div>자기소개!!</div>
<div><input name="pf_contents" value="${sessionScope.loginMemberp.pf_contents }"></div>
<div>생일 (후에 설정 가능)</div>
<div><input name="user_birthDay" type="date"></div>



<input name="pf_userID" value="${sessionScope.loginMember.user_ID }">


<div><button>수정하기</button></div>
</div>

</form>


</body>
</html>