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
<link rel = "stylesheet" type = "text/css" href = "resources/css/JY/joinus.css">
<style type="text/css">

body {
background-color:black;}

#joinus{

background-color: white;
color: black;
	position: absolute;
	color:black;
	top: 50%;

    left: 50%;
    transform: translate(-50%, -50%);

}


</style>


</head>
<body>

<div id="joinus">
		<jsp:include page="${joinusPage }"></jsp:include>


</div>


</body>
</html>