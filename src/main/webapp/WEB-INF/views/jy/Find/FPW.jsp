<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type = "text/javascript" src="resources/js/JY/userGo.js"></script>

</head>
<body>

<div>
<div> 비밀번호찾기 </div>
<form action="user.findid.pwr"  name="findpw"  method="post">
<div>아이디 <input name="user_ID"></div>
<div>이름 <input name="user_name"></div>
<div>이메일<input name="user_email"></div>
<div><button> 찾아보기</button></div>
</form>
<div><button onclick="findid()">아이디 찾으러 가기</button></div>



</div>


</body>
</html>