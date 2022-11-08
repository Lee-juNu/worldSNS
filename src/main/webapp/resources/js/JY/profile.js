window.onload = function()
{
	profileBoardInit();
		
		ws.addEventListener("message", function(event) {
		receiveMessage(event.data);
	});
	$("#unfollowButton").click(unfollow);
    $("#followButton").click(follow); 
	profilePaiging();
}


function receiveMessage(message)
{
	var resultJson = JSON.parse(message);
	if(resultJson.resultType =="getPfBoard")
	{
		console.log(resultJson);		
		addMultiBoard(resultJson.arrBoard);		
	}
	else if(resultJson.resultType == "nextBoard" )
	{
		receiveBoard(resultJson.arrBoard);
	}
}

function profileBoardInit()
{
	var profileBoard = 
	{
		type : "profile",
		contents : "pfBoardInit",
		profileUser : $('#findUser').val()
	}
	sendMsg(profileBoard);
}


function follow(){
     var user_ID_o = $('#findUser').val();
     
     $.ajax({
    	              
    	 type: "POST",            
    	 url:  "follow.follow/" + user_ID_o,        
    	 // dataType : "json",           
    	 context: document.body,          
    	 async : false,           
    	 success : function(url) { // 결과 성공 콜백함수
    	        console.log(result);
				 $("#followButton").hide();
				 $("#unfollowButton").show();
    	    },
        error : function(request, status, error) { // 결과 에러 콜백함수
    	        console.log(error);
    	    }
})
};


function unfollow(){
    var user_ID_o = $('#findUser').val();
     
     $.ajax({
    	              
    	 type: "POST",            
    	 url:  "follow.unfollow/" + user_ID_o,        
    	 context: document.body,          
    	 async : false,           
    	 success : function(url) { // 결과 성공 콜백함수
    	        console.log(result);
$("#followButton").show();
				 $("#unfollowButton").hide();
    	    },
        error : function(request, status, error) { // 결과 에러 콜백함수
    	        console.log(error);
    	    }
})
};