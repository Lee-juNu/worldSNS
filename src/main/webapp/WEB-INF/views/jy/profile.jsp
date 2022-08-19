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
<div>${result }</div>
<div>모두 가운데로 배치</div>
<div>배경 사진</div>
<div><img src="resources/pf_Img/${sessionScope.loginMemberp.pf_Img }"> </div>
<div>프로필 사진 </div>
<div><img src="resources/pf_Img/${sessionScope.loginMemberp.pf_bgImg }"> </div>
<div>닉네임</div>
<div>${sessionScope.loginMember.user_nickName }</div>
<div>아이디</div>
<div>${sessionScope.loginMember.user_ID }</div>

<div>자기소개</div>
<div>${sessionScope.loginMemberp.pf_contents }</div>
<div>생일 (변경 불가)</div>
<div>${sessionScope.loginMember.user_birthDay }</div>
<hr>


<div><button onclick = "goSettingProfile()">프로필 수정</button> </div>
<div><a>팔로잉 __(명)</a><a>팔로워 __(명)</a></div>
<div>게시판</div>
<div></div>

</div>




</body>
</html>