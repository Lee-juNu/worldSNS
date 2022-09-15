<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${findUser.user_ID}s Profile</title>

<!-- jy수정 : 팔로우 시작 (버튼에 아이디 추가 : followbutton)
	jy/followcontroller 에 연결되어 있음 -->
<script type = "text/javascript" src="resources/js/utill/jQuery.js"></script>
<script type = "text/javascript" src="resources/js/JY/followGo.js"></script>

<script type="text/javascript">

$(document).ready(function(){
    $("#followButton").click(follow); //id="listButton"인 태그에 click하면 function getMemberList() 실행
});
function follow(){
     var user_ID_o = $('#findUser').val();
     alert(user_ID_o);
     
     $.ajax({
    	              
    	 type: "POST",            
    	 url:  "follow.follow/" + user_ID_o,        
    	 // dataType : "json",           
    	 context: document.body,          
    	 async : false,           
    	 success : function(url) { // 결과 성공 콜백함수
    	        console.log(result);
    	    	alert("팔로우 성공!");
    	    },
        error : function(request, status, error) { // 결과 에러 콜백함수
    	        console.log(error);
    	        alert("실패라고 봐도 됩니다!!");
    	           alert("code = "+ request.status)
    	        	alert	( " message = " + request.responseText)
    	        	alert	( " error = " + error); // 실패 시 처리        	        
    	     alert(user_ID_o);
    	    }
})
};


$(document).ready(function(){
    $("#unfollowButton").click(unfollow);
});
function unfollow(){
    var user_ID_o = $('#findUser').val();
     alert(user_ID_o);
     
     $.ajax({
    	              
    	 type: "POST",            
    	 url:  "follow.unfollow/" + user_ID_o,        
    	    
    	 context: document.body,          
    	 async : false,           
    	 success : function(url) { // 결과 성공 콜백함수
    	        console.log(result);
    	    	alert("언팔로우 성공!");
    	    },
        error : function(request, status, error) { // 결과 에러 콜백함수
    	        console.log(error);
    	        alert("실패라고 봐도 됩니다!!");
    	           alert("code = "+ request.status)
    	        	alert	( " message = " + request.responseText)
    	        	alert	( " error = " + error); // 실패 시 처리        	        
    	     alert(user_ID_o);
    	    }
})
};

</script>
<!-- jy수정 :팔로우 끝 -->


</head>
<body class = "bgColor">

	<input id="findUser" type="hidden" value = '${findUser.user_ID}'>

<div class = "profileSectionDiv" >
	<div class = "profileMainDiv ">
	
		<div class = "profileBlank">
		</div>
		
		<div class = "profileDiv">
			<div class = "profileBGDiv">
				<a> <img alt="" src="resources/img/profile/${findUser.user_ID}/BG.png"
				onerror="this.onerror=null; this.src='resources/img/profile/bg.png';"/> </a>
				<div class = ""></div>
			</div>
			
			<div class =  "profileDetailDiv">
				<div class = "iconEditDiv">
					<div class = "iconDiv bgColor">
						<img alt="" src="resources/img/profile/${findUser.user_ID}/photo.png"
		onerror="this.onerror=null; this.src='resources/img/profile/s.png';"/> 
					</div>
					<div class = "editDiv">
					<c:if test ="${findUser.user_ID==sessionScope.loginMember.user_ID}">
						<button>Profile Edit</button>
					</c:if>
					
					
					<c:if test ="${findUser.user_ID!=sessionScope.loginMember.user_ID}">
						
						<button id="followButton">팔로우!!!!</button>
						<!-- jy수정 : 아이디 추가 -->
						<button id="unfollowButton">언팔로우</button>
					</c:if>
					
					
					
					</div>
				</div>
				<div class = "ProfileIdNameDiv">
					<div class = "nickNameDiv">${findUser.user_nickName}</div>
					<div class = "idDiv">@${findUser.user_ID}</div>
				</div>				
				<div class = "profileContentsDiv">
					${findUser.user_contents}
				</div>
			</div>
			
			<!-- jy수정 : 팔로우 수, 팔로워 수 추가 -->
			
			<div>
			
			<div><a href="${findUser.user_ID}/follow">팔로우 ${follow_count}</a></div>
			<div><a href="#">팔로워 ${follower_count}</a></div>
			
			</div>
			
			
			<!-- jy수정 : 팔로우 수, 팔로워 수 추가 끝 -->
			</div>
		</div>
	</div>
	
	
	<div class = "contentsSubDiv"> 
		<jsp:include page="subPage.jsp"/>
	</div>
</div>
</body>
</html>