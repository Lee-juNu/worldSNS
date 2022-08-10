<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- CSS모음-->
<link rel = "stylesheet" type = "text/css" href = "resources/css/index.css">

<!-- 병합전의 CSS를 입력해주세요 -->
<link rel = "stylesheet" type = "text/css" href = "resources/css/JY/bootstrap/bootstrap.min.css">


<!-- JS모음-->
<script type = "text/javascript" src="resources/js/utill/jQuery.js"></script>
<script type = "text/javascript" src="resources/js/index.js"></script>

<!-- 병합전의 JS를  입력해주세요-->
<script type = "text/javascript" src="resources/js/JY/bootstrap/jquery.min.js"></script>
<script type = "text/javascript" src="resources/js/JY/bootstrap/bootstrap.min.js"></script>

</head>
<body>


	<div class = "mainDiv">
		<div class = "leftMain">
			<div class = "mainMapDiv">
				지도 영역-이준우
			</div>
		</div>
		
		
		
		
		<div class = "rightMain">
			<div class = "mainLoginDiv">	
			<!-- 최종에서 빼기! -->
				<button onclick = "goJoin()" >임시 관리자 로그인</button><br><br>
			<div><jsp:include page="${loginPage }"/></div>
			</div>
		</div>
		
		
	</div>
	
	<!-- 회원가입 모달 -->
<div class="modal fade" id="myModal" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog modal-xl modal-dialog-centered">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">회원가입</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
    	<div><jsp:include page="${loginPage }"/></div>
      </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">다음</button>
        </div>
        
      </div>
    </div>
</div>
		
	
	
</body>
</html>


