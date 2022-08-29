<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script type = "text/javascript" src="resources/js/utill/jQuery.js"></script>
<script type = "text/javascript" src="resources/js/JY/validCheck.js"></script>
<script type = "text/javascript" src="resources/js/JY/check.js"></script>
<script type = "text/javascript" src="resources/js/JY/IdCheck.js"></script>
<script>

</script>







</head>
<body>

<form action="user.joinus.go4"  name="joinForm3" method="post" onsubmit="return joinCheck3();">
<div  class="slide-in">
<div>세상에서 가장 멋진 아이디를 정해 주세요!!</div>
<div>중복 아이디는 허용되지 않습니다~</div>
<!-- 아이디 -->
<div class="form-group">
	<label for="user_ID">아이디</label>
		<input type="text" class="form-control" id="user_ID" name="user_ID" placeholder="ID" required>
<div id="id_check"></div>
<!-- <div> <button onclick="javascript:btn()"> 버튼 </button></div> -->
<div><button>다음</button> </div>

<input type="hidden"  name="user_email" value="${param.user_email }">
<input type="hidden"  name="user_name" value="${param.user_name }">
<input type="hidden"  name="user_nickName" value="${param.user_nickName }">
<input type="hidden"  name="user_phoneNumber" value="${param.user_phoneNumber }">


</div>
</form>
</body>
</html>