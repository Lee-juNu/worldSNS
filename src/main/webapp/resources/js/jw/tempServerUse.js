//메시지를 보낼때
function jwSendWithFile(){	
		
		//type으로  메시지 종류를 정한다
		//type ex) "chat" "board" "alarm"등등 자신이 원하는대로 커스터마이즈
		//id ex) 보내는 사람의 id
		//contents등등은 내용 이나 자기가 원하는대로 해도 됩니다
		//원하는 이름  : 원하는 변수로 채워서 보내면 됩니다.
		var memberData = 
		{
			type : "chat",
			id : $("#sender").val(),
			contents : $("#messageinput").val() 
		}	
		sendMsg(memberData);



			//파일 보내기 영역
			//파일의 id를 입력합니다.
			var fileId = 'inputFile';
			//기본 img폴더에 저장됩니다
			//img SNS
			var addFolderName = '폴더이름';
			sendFile(fileId, addFolderName);
        }


//메시지를 받을때
window.onload = function()
{
		// some other listener for incoming messages
				ws.addEventListener("message", function(event) {
					//원하는 코드를 적으면 됩니다 저는 밖에 함수로 뺴서 사
					receiveMessage(event.data);
					//event.data를 하면 보낸 데이터가 들어가있음
					//json으로 보내면 json형식을 유지하고
					//string으로 보내면 string으로 돌아옵니다.
					
					//각자 원하는 형태의 함수로 만들어주면 됩니다
					//채팅은 Div를 추가해서 채팅창을 밀어줘도 OK
					//게시판은 게시판을 받와와서 추가
					//알람은 알람추가하는 형식으로 커스터마이징 합시다					
		});
}
function receiveMessage(message)
{
	//간단한 메모입니다 innerHTML은 HTML에 어떠한 내용을 추가한다는걸로 <br> <div>등등 아무거나 다 추가 가능
	//웹소켓쪽에서 메시지를 보내면 messages라는 div를 참조해서 그 안에 한줄 띄우고 메시지를 입력
		var messages = document.getElementById("messages")
			messages.innerHTML += '<br>'+ message;
}

