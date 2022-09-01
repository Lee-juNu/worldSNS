<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
 
<script type = "text/javascript" src="resources/js/JY/userGo.js"></script>
 
 
 
<!-- 
<script type="text/javascript">

function goJoinUs()
{
	location.href = 'user.joinus.go';
	
}

function findID()
{
	location.href = 'user.findid.go';
	
}

</script> -->
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
	
	<button type="button" onclick="goJoinUs()">회원가입!!!!!</button><br>
	<button type="button" onclick="findid()">아이디 / 비밀번호 찾기</button>
<a href="user.joinus.go" data-toggle="modal" data-target="#myModal">이미지 모달띄우기</a>
	</div>
	</div>
	</form>

</body>
</html>