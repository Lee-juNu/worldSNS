<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="user.joinus.go3"  name="joinForm2"  method="post">
<div id="joinus2" class="slide-in">
<div>당신의 정보를 알려 주세요!</div>
<div>이름<input name="user_name"></div>
<div>닉네임<input name="user_nickName"></div>
<div>전화번호<input name="user_phoneNumber"></div>
<div><button>다음</button> </div>

<input type="hidden"  name="user_email" value="${param.user_email }">


</form>
</div>
</body>
</html>