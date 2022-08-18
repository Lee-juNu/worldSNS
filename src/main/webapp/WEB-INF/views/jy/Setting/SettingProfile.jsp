<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>

<div>

<div>배경</div>
<div><input type="file" name="pf_Img"></div>
<div>프로필</div>
<div><input type="file" name="pf_bgImg"></div>
<div>닉네임</div>
<div><input name="user_nickName"></div>
<div>자기소개</div>
<div><input name="pf_contents"></div>
<c:if test = "${empty sessionScope.loginMember.user_birthDay }">
<div>생일 (후에 설정 가능, 설정한 이후 바꿀 수 없음)</div>
<div><input type="date"></div>


      </c:if>

</div>




</body>
</html>