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
<form  action="setting.go.InfoUpR"  name="UpdateForm"  method="post">

<div>아이디</div>
<div><input value="${sessionScope.loginMember.user_ID }" name="user_ID"> </div>
<hr>



<div>이름 </div>
<div><input value="${sessionScope.loginMember.user_name }" name="user_name"> </div>
<hr>

<div>닉네임</div>
<div><input value="${sessionScope.loginMember.user_nickName }" name="user_nickName"> </div>
<hr>



<div>휴대폰번호</div>
<div><input value="${sessionScope.loginMember.user_phoneNumber }" name="user_phoneNumber"> </div>
<hr>


<div>이메일</div>
<div><input value="${sessionScope.loginMember.user_email }" name="user_email"> </div>
<hr>



<div>생일 (변경 불가)</div>
<div>${sessionScope.loginMember.user_birthDay }</div>
<hr>


<div>레벨 확인</div>
<div>${sessionScope.loginMember.level }</div>
<hr>


<div>가입일</div>
<div>${sessionScope.loginMember.regDate }</div>
<hr>


<div>

<button>수정하기</button>
</form>



<button onclick="goSettingPassword()">비밀번호 변경하러 가기</button>

 </div>
</div>
<!-- 나중에 할 수 있음 트위터같이 하나에 하나 수정하는 걸로 수정하기 
일단은 한번에 수정하는 걸로 만들기 
 -->
</body>
</html>