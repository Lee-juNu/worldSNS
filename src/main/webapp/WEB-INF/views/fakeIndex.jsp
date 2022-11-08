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
		<input autocapitalize="none" placeholder="どこか探したい国はありますか？">
		</div>
		<div class = "menuDiv">
			<button id = "loginModal" class = "loginBtn">ログイン</button>
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
                <input id="user_ID" class = "input-modal" name="user_ID" placeholder="ID"><br>
                <input id="user_PW" type='password' class = "input-modal" name="user_PW" placeholder="PW"><br>
               
                <button id="loginBtn" class = "mloginBtn">ログイン</button><br>
               <!--  <input type="checkbox" name="useCookie"> 로그인유지 -->
                <div class = "joinUsDiv" >アカウントを作りますか? <a id = "joinUsTag">会員登録</a></div>
                <div class = "tempLogin"></div>                               
            </div>
        </div>
    </div>
    
   
    <div id="modalJoin" class="modal-overlay">
        <div class="modal-window">
        <div class = "joinTitle">
			<span id = "joinStep">2段階 中 1段階</span>
        </div>

        <div id = "joinDiv1" class="content">   
           	<div><h1><span style = 'font-size:35px'>アカウントを作ります</span></h1></div>    
            	   
           	<div class ="inputContents">
            	   
            	   
            	<div class = "idInputDiv">
           	   		<input id="join_ID" placeholder="ID" autocomplete="off">
           	   		<div class="ruleDiv" id = "join_IDRule" style ='display:none;'>
           	   		IDは8~16文字の英語、数字、ー、＿だけを<br>入力してください
           	   		</div>
           	   	</div>
           	   	<div class = "pwInputDiv">
           	   		<input id="join_PW" placeholder="PW" type = "password" autocomplete="off">
           	   		<div class="ruleDiv" id = "join_PWRule" style ='display:none;'>PWは8~16文字の英語、数字、ー、＿だけを使ってください</div>
           	   	</div>   
            	   
           	   
           	   <div class = "phoneInputDiv">
           	   		<input id="join_phoneNumber" placeholder="000-0000-0000">
           	   		<div class="ruleDiv" id = "join_phoneRule" style ='display:none;'>携帯番号を入力してください</div>
           	   	</div>
           	   
           	   	<div class = "mailInputDiv">
           	   		<input id="join_email" placeholder="e-Mail">
           	   		<div class="ruleDiv" id = "join_emailRule" style ='display:none;'>メールを入力してください</div>
           	   	</div>
           	   	
           	   	<div class = "stepBtnDiv"> 	        
           	   		<div class = "stepLeftDiv"> <button type="button" class = "returnModalBtn stepBtn">戻る</button></div>
           	   		<div class = "stepRightDiv"> <button type="button" class = "nextModalBtn stepBtn">次へ</button></div>
           	   	</div>	
        	</div>            
        </div>
        <div id = "joinDiv2" class="content" >
        
        
        		<div class = "nameInputDiv">
           	   		<input id="join_name" placeholder="名前">
           	   		<div class="ruleDiv" id = "join_nameRule" style ='display:none;'>名前は40文字までです</div>
           	   	</div>
           	   
           	   	<div class = "nickInputDiv">
           	   		<input id="join_nickName" placeholder="ニックネーム">
           	   		<div class="ruleDiv" id = "join_nickInputDiv" style ='display:none;'>ニックネームは8文字までです</div>
           	   	</div>

				<div class = "birthDayDiv">           	   	
         		<span>誕生日<br></span>
         		<span>
         			本当の誕生日じゃ無くってもかまいません<br>
         			会社、ペット、好きな日どっちでも大丈夫です
         		</span>
           	   		<div class = "birthDaySelectDiv">
           	   			<div class = "monthDiv joinBirthDiv">
           	   				<div class = "birthTextDiv">月</div>
							<select name="mm" id="month" class ="joinBirthSel"></select>
						</div>
           	   			<div class = "dayDiv joinBirthDiv">
							<div class = "birthTextDiv">日</div>
							<select name="dd" id="day" class ="joinBirthSel"></select>
						</div>
						<div class = "yearDiv joinBirthDiv">
							<div class = "birthTextDiv">年</div>
           	   				<select name="yy" id="year" class ="joinBirthSel"></select>
						</div>
           	   		</div>
           	  </div>
        <div class = "stepBtnDiv"> 	        
        <div class = "stepLeftDiv"> <button type="button" class = "prevModalBtn stepBtn">戻る</button></div>
       	<div class = "stepRightDiv"> <button id = "joinBtn" class = "stepBtn">登録する</button></div>
		</div>
        
        </div>

        <div id = "joinDiv3" class="content">
        <h1>あなたが興味を持っている地域を選んでください</h1>
        <input placeholder="나라 또는 도시를 입력해주세요">
        <input type="hidden" id = "join_country" value = "korea">
        <input type="hidden" id = "join_city" value = "seoul">
         
         
         <div class = "stepBtnDiv">
        <div class = "stepLeftDiv"> <button type="button" class = "prevModalBtn stepBtn">戻る</button></div>
        	</div>
        </div>
    </div>
	<script type = "text/javascript" src="resources/js/jw/indexServer.js"></script>
    <script type = "text/javascript" src="resources/js/jw/map.js"></script>
</body>
</html>


