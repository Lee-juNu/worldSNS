<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function goJoinUs()
{
	location.href = 'user.joinus.go';
	
}

</script>
</head>
<body>

	${result }
	<form action="user.login" method="post" name="loginForm">
		<div>
			<div>
				ID <input id="user_ID" name="user_ID">
			</div>
			<div>
			PW <input id="user_PW" name="user_PW">
		</div>
		<div>
			<button>로그인</button>
	
	<button type="button" onclick="goJoinUs()">회원가입!!!!!</button>
	</div>
	</div>
	</form>

</body>
</html>