<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- CSS모음-->
<link rel = "stylesheet" type = "text/css" href = "resources/css/jw/fakeIndex.css">
<link rel = "stylesheet" type = "text/css" href = "resources/css/jw/loginModal.css">
<link rel = "stylesheet" type = "text/css" href = "resources/css/jw/colorTemplet.css">
<link rel = "stylesheet" type = "text/css" href = "resources/css/jw/profile.css">
<link rel = "stylesheet" type = "text/css" href = "resources/css/jw/map.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Fredoka+One&display=swap" rel="stylesheet">


<!-- 병합전의 CSS를 입력해주세요 -->
<link rel = "stylesheet" type = "text/css" href = "resources/css/JY/bootstrap/bootstrap.min.css">


<!-- JS모음-->
<script type = "text/javascript" src="resources/js/utill/jQuery.js"></script>
<script type = "text/javascript" src="resources/js/index.js"></script>


<!-- 병합전의 JS를  입력해주세요-->
<script type = "text/javascript" src="resources/js/JY/bootstrap/bootstrap.min.js"></script>
<script type = "text/javascript" src="resources/js/JY/validCheck.js"></script>
<script type = "text/javascript" src="resources/js/JY/check.js"></script>



</head>
<body class = "homeBody subColor bgColor">
	<div class = "headerDiv subBgColor">
		<div class = "logoDiv subColor">
			<img class = "logoImg" alt="LOGO" src="resources/img/util/logo/wlogo.png">		
		</div>
		<div class = "countryInputDiv">
		<input placeholder="나라를 입력해주세요">
		</div>
		<div class = "menuDiv">
			<button id = "loginModal" class = "loginBtn">Login</button>
			<button id = "testBtn" class = "loginBtn">test</button>
		</div>
	</div>
	<div class = "mapDiv">	
			<jsp:include page="jw/mapPage.jsp"/>
	</div>
	
	
	
	<input type="text" id="wsUserId" value="guest" style="display: none;">
        <input type="text" id="wsRoomType" value="lobby" style="display: none;">
        
	 <div id="modal" class="modal-overlay">
        <div class="modal-window">
        <div class = "mLogoDiv">
			<img class = "mLogoImg" alt="LOGO" src="resources/img/util/logo/wlogo.png">		
        </div>
            <div class="content">   
                <input id="user_ID" class = "input-modal" name="user_ID" placeholder="아이디를 입력해주세요"><br>
                <input id="user_PW" type='password' class = "input-modal" name="user_PW" placeholder="비밀번호를 입력해주세요"><br>
               
                <button id="loginBtn" class = "mloginBtn">로그인</button><br>
               <!--  <input type="checkbox" name="useCookie"> 로그인유지 -->
                <div class = "forgotPwDiv"><a>비밀번호를 잊어버리셨나요?</a></div>
                <div class = "joinUsDiv">계정이 없으신가요? <a id = "joinUsTag">회원가입</a></div>
                <div class = "tempLogin"></div>                               
            </div>
        </div>
    </div>
    
   
    <div id="modalJoin" class="modal-overlay">
        <div class="modal-window">
        <div class = "joinTitle">
			<span id = "joinStep">5단계 중 1단계</span>
        </div>

        <div id = "joinDiv1" class="content">   
           	<div><h1>계정을 생성하세요</h1></div>    
            	   
           	<div class ="inputContents">
            	   
            	   
            	<div class = "idInputDiv">
           	   		<input id="join_ID" placeholder="아이디">
           	   	</div>
           	   	<div class = "pwInputDiv">
           	   		<input id="join_PW" placeholder="비밀번호">
           	   	</div>   
            	   
           	   
           	   <div class = "phoneInputDiv">
           	   		<input id="join_phoneNumber" placeholder="핸드폰번호">
           	   	</div>
           	   
           	   	<div class = "mailInputDiv">
           	   		<input id="join_email" placeholder="이메일">
           	   	</div>
           	   	
           	   	<div class = "stepBtnDiv"> 	        
           	   		<div class = "stepLeftDiv"> <button type="button" class = "returnModalBtn stepBtn">돌아가기</button></div>
           	   		<div class = "stepRightDiv"> <button type="button" class = "nextModalBtn stepBtn">다음</button></div>
           	   	</div>	
        	</div>            
        </div>
        <div id = "joinDiv2" class="content" >
        
        
        		<div class = "nameInputDiv">
           	   		<input id="join_name" placeholder="이름">
           	   	</div>
           	   
           	   	<div class = "nickInputDiv">
           	   		<input id="join_nickName" placeholder="닉네임">
           	   	</div>

				<div class = "birthDayDiv">           	   	
         		<span>생년월일 <br></span>
         		<span>
         			이 곳은 반드시 당신의 생일이 아니여도 상관없습니다.<br>
         			당신의 회사, 애완동물, 좋아하는 날짜 무엇이든 괜찮습니다.
         		</span>
           	   		<div class = "birthDaySelectDiv">
           	   			<div class = "monthDiv joinBirthDiv">
           	   				<div class = "birthTextDiv">월</div>
							<select name="mm" id="month" class ="joinBirthSel"></select>
						</div>
           	   			<div class = "dayDiv joinBirthDiv">
							<div class = "birthTextDiv">일</div>
							<select name="dd" id="day" class ="joinBirthSel"></select>
						</div>
						<div class = "yearDiv joinBirthDiv">
							<div class = "birthTextDiv">년</div>
           	   				<select name="yy" id="year" class ="joinBirthSel"></select>
						</div>
           	   		</div>
           	  </div>
        <div class = "stepBtnDiv"> 	        
        <div class = "stepLeftDiv"> <button type="button" class = "prevModalBtn stepBtn">이전으로</button></div>
        <div class = "stepRightDiv"> <button type="button" class = "nextModalBtn stepBtn">다음</button></div>
		</div>
        
        </div>

        <div id = "joinDiv3" class="content">
        <h1>당신이 흥미있는 도시를 선택해주세요</h1>
        <input placeholder="나라 또는 도시를 입력해주세요">
        <input type="hidden" id = "join_country" value = "korea">
        <input type="hidden" id = "join_city" value = "seoul">
         
         
<<<<<<< HEAD
         <div class = "stepBtnDiv">
        <div class = "stepLeftDiv"> <button type="button" class = "prevModalBtn stepBtn">이전으로</button></div>
        <div class = "stepRightDiv"> <button type="button" class = "nextModalBtn stepBtn">다음</button></div>
=======
        <div class = "stepBtnDiv">
        	<div class = "stepLeftDiv"> <button class = "prevModalBtn stepBtn">이전으로</button></div>
        	<div class = "stepRightDiv"> <button class = "nextModalBtn stepBtn">다음</button></div>
>>>>>>> JW2
        </div>
        
        </div>


        <div id = "joinDiv4" class="content"> 
        <div class = "stepBtnDiv">
        <div class = "stepLeftDiv"> <button type="button" class = "prevModalBtn stepBtn">이전으로</button></div>
        <div class = "stepRightDiv"> <button type="submit" id = "joinBtn" class = "stepBtn">가입하기</button></div>
        </div>
        </div>
        
        

        </div>
    </div>
  
<script type = "text/javascript" src="resources/js/jw/indexServer.js"></script>
    <script type = "text/javascript" src="resources/js/jw/map.js"></script>
</body>
</html>


