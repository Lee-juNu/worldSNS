<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type = "text/javascript" src="resources/js/JY/validCheck.js"></script>
<script type = "text/javascript" src="resources/js/JY/check.js"></script>
</head>
<body>
<form action="user.joinus.go5"   name="joinForm4"  method="post" onsubmit="return joinCheck4();">
<div  class="slide-in">
<div>마지막으로 비밀번호를 입력하면 끝입니다!</div>
<div>비밀번호는 대문자, 소문자, 숫자가 하나씩 들어가게 만들어주세요!</div>
<div><input name="user_PW"></div>
<div>한 번 더 입력해 주세요!</div>
<div><input name="user_PWC"></div>
<div><button>다음</button> </div>

<input  type="hidden"  name="user_email" value="${param.user_email }">
<input  type="hidden"  name="user_name" value="${param.user_name }">
<input  type="hidden" name="user_nickName" value="${param.user_nickName }">
<input  type="hidden"  name="user_phoneNumber" value="${param.user_phoneNumber }">
<input  type="hidden"  name="user_ID" value="${param.user_ID }">


</div>
</form>

</body>
</html>