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
<div> 아이디 찾기 </div>
<form action="user.findid.idr"  name="findid"  method="post">
<div>이름 <input name="user_name"></div>
<div>이메일<input type="email" name="user_email"></div>
<div><button> 찾아보기</button></div>
</form>
<div><button onclick="findpw()">비밀번호 찾으러 가기</button></div>



</div>


</body>
</html>