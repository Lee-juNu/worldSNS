//메시지를 보낼때

/*
 * 	
				data:{"msg_Contents": msg,
					"msg_RoomNum": room,
					"msg_sendUserID": user,
					},

 */


function jwSendWithFile(){	
	 /*let msg = $('#sendmsg').val();
	 let room = $('#roomNum').val();
	 let user = $('#userID').val();
	 let img = $('#sendimg').val();
	 let fileId = 'sendimg'
	 var addFolderName = 'chatimg';
	*/
		//type으로  메시지 종류를 정한다
		//type ex) "chat" "board" "alarm"등등 자신이 원하는대로 커스터마이즈
		//id ex) 보내는 사람의 id
		//contents등등은 내용 이나 자기가 원하는대로 해도 됩니다
		//원하는 이름  : 원하는 변수로 채워서 보내면 됩니다.
	 var memberData = 
	 {
			 type : "chat",
			 dataType : "send",
			 msg_Contents: msg,
			 msg_RoomNum: room,
			 msg_sendUserID: user,
			 msg_img: img
	 }	
	console.log(fileId)	
	 
		sendMsg(memberData);
		sendFile(fileId, addFolderName);
}



	window.onload = function()
{
	getUser();
	inputFocus();
		ws.addEventListener("message", function(event) {
			receiveMessage(event.data);
		});
}

function receiveMessage(message)
{
	var resultJson = JSON.parse(message);
	if(resultJson.type == "serachUserList")
	{
		$("#userContainer").empty();
		addUserList(resultJson.arrUser);
		console.log(resultJson.arrUser)
	}
}

function addUserList(userList)
{
	var html = ""
	userList.forEach(function(data, index) {
		html+=addUser(data);
	});
	$('#userContainer').prepend(html);
}

function addUser(user)
{
		var tempHtml = `
		<a onclick="createChatRoom('`+user.user_ID+`')">
				<div class = "userDiv" id = "userDiv`+user.user_ID+`">
				<div class ="iconDiv">
					<div class = "profileIcon"> 
					<img style="width:100%; height:100%;" alt="" src="resources/img/profile/`+user.user_ID+`/photo.png"
					onerror="this.onerror=null; this.src='resources/img/profile/s.png';"/> </div>
				</div>
				<div class = "idNameDiv">
					<div class = "nickNameDiv">`+user.user_nickName+`</div>
					<div class = "idDiv">@`+user.user_ID+`</div>
				</div>
			</div>
			</a>`;
		return tempHtml;
}

function createChatRoom(selectUser)
{
	var chatEnterReq = 
	{
		type : "chat",
		contents : "createChatRoom",
		chatUserID : selectUser
	}
	sendMsg(chatEnterReq);
}
