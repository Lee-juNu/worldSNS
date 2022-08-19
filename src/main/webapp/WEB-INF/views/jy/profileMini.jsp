<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div href="profile.go">
<div><img width="300px" height="300px" src="resources/pf_Img/${sessionScope.loginMemberp.pf_Img }"/></div>
<div>${sessionScope.loginMember.user_nickName }</div>
<div>아이디</div>
<div></div>
<div></div>


</div>
</body>
</html>