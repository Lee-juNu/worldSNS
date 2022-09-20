<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>W's</title>

<!-- CSS모음-->
<link rel = "stylesheet" type = "text/css" href = "resources/css/home.css">
<link rel = "stylesheet" type = "text/css" href = "resources/css/jw/fakeBoard.css">
<link rel = "stylesheet" type = "text/css" href = "resources/css/jw/subPage.css">
<link rel = "stylesheet" type = "text/css" href = "resources/css/jw/profile.css">
<link rel = "stylesheet" type = "text/css" href = "resources/css/jw/colorTemplet.css">
<link rel = "stylesheet" type = "text/css" href = "resources/css/jw/map.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Fredoka+One&display=swap" rel="stylesheet">




<!-- JS모음-->
<!-- 병합전의 JS를 입력해주세요 -->
<script type = "text/javascript" src="resources/js/utill/jQuery.js"></script>

</head>
<body class ="homeBody bgColor">

<div class = "homeDiv">
	<!-- Header는 그냥 DIV라고 생각해주세요 -->
	<div class = "homeHeader">
		<!-- 확장성(뭔가 더 넣을수도 있을수도 있을려면?) 떄문에 넣어놓았습니다 이해 했으면 주석 지워주세요!!-->
		<div class = "homeHeaderDiv">
	
			<!-- 여기에 게시글,메시지 알람등등 아이콘과 배치해주세요!! 지도는 따로 배치할게요 -->
			<div class = "homeHeaderMainDiv">
				<jsp:include page="${menuPage }"></jsp:include>
			</div>
		
			<div class = "homeMapDiv">
		
			</div>	
		</div>
	</div>

	<div class = "homeMain">
		<div class = "homeMainDiv">
		<jsp:include page="${contentsPage }"></jsp:include>
		</div>
	</div>
</div>

</body>
</html>