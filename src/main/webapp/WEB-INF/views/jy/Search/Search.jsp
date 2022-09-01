<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">


</script>

<script type = "text/javascript" src="resources/js/JY/searchGo.js"></script>


</head>
<body>
<div>

<div><button onclick="goSearchUser()">사용자</button><button onclick="goSearchPost()">게시글</button></div>

<div id="search">
		<jsp:include page="${searchPage }"></jsp:include>



</div>
</body>
</html>