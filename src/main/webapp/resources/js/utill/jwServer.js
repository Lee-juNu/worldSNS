		var ws;
		
		
		const wsUserId = document.getElementById('wsUserId').value;
		const wsRoomType = document.getElementById('wsRoomType').value;
		
		console.log(wsUserId);
		console.log(wsRoomType);
		
		
        if(ws!==undefined && ws.readyState!==WebSocket.CLOSED){
            writeResponse("WebSocket is already opened.");
        }
		else
		{														
														//여기까진  //chatroom12345//dkdkd
            ws=new WebSocket("ws://210.179.100.120:8080/worlds/jwSocket/"+wsRoomType+"/"+wsUserId );
            	
            ws.onopen=function(event){
            	if(event.data===undefined) return;
				writeResponse(event.data)
            };
			/*
            ws.onmessage=function(event){
                writeResponse(event.data);
            };
			*/
            ws.onclose=function(event){
                writeResponse("Connection closed");
            }
		}
           
		function sendMsg(msgData)
		{
			var jsonData = JSON.stringify(msgData);
			console.log(msgData);
			ws.send(jsonData);
		}
        function send(){	
			var memberData = 
			{
				type : "msg",
				id : $("#sender").val(),
				contents : $("#messageinput").val() 
			}
		var jsonData = JSON.stringify(memberData);
		console.log(jsonData)
		ws.send(jsonData);
        }	
        			
	
		function sendFile(fileId, folderSendName)
		{
			//파일의 풀 경로 (ex:"C:\\teamProject\\resource\\img\\file.img")
			var filePathName = $("#"+fileId).val().split("\\");
			//파일명(ex:"file.png")
			var fileSendName = filePathName[filePathName.length-1];
			//멀티플일때 첫번째파일(업로드 데이터)
			var file = document.getElementById(fileId).files[0];
			
			
			console.log(fileSendName);	//파일명 잘 들어갔는지 확인			

			//파일이 안비어있으면
			if(fileSendName!="")
			{
				//보낼 타입은 File이고
				//보낼 사람id
				//파일명
				//끝났는가(false아니 시작)
				var fileData = 
				{
					type : "file",
					id : $("#sender").val(),
					fileName : fileSendName,
					folderName : folderSendName,
					isEnd : false
				}
				
				var jsonData = JSON.stringify(fileData);
				console.log(jsonData);				
				//onMessage의 string영역으로 들어가 Json으로 웹소켓에서 파일 받을 준비 시킴
				ws.send(jsonData);
				
				//준비가 됬으니 이제 파일을 Buffer로 바꿀 준비
				var reader = new FileReader();
				var rawData = new ArrayBuffer();
					reader.loadend = function() {
				}

				//reader가 load되면 buffer보내는 함수 실행(보내는 건 밑에 reader.readAsArrayBuffer(file);)
				reader.onload = function(e) {
				rawData = e.target.result;
				ws.send(rawData);
				
				
				//위와 같으나 isEnd가 True 파일을 전부 보냈습니다.
				var fileEndData = 
				{
					type 		: "file",
					id 			: $("#sender").val(),
					fileName 	: fileSendName,
					isEnd 		: true
				}	
				
				jsonData = JSON.stringify(fileEndData);
				
				ws.send(jsonData);
				
				}
				reader.readAsArrayBuffer(file);
			}
			else
			{
				console.log("파일없음");				
			}
		}
		
		
		
		
		
		function multiFileUpload(fileId,folderSendName,index)
		{
			if(document.getElementById('inputFile').files.length==0)
			{
				return;
			} 
			var file = document.getElementById(fileId).files[index];
			sendMultiFile(file, folderSendName);
		}
		
		
		function sendMultiFile(file, folderSendName)
		{
			
			var fileSendName = file.name;
			
			console.log(fileSendName);	//파일명 잘 들어갔는지 확인			

			//파일이 안비어있으면
			if(fileSendName!="")
			{
				//보낼 타입은 File이고
				//보낼 사람id
				//파일명
				//끝났는가(false아니 시작)
				var fileData = 
				{
					type : "file",
					id : $("#sender").val(),
					fileName : fileSendName,
					folderName : folderSendName,
					isEnd : false
				}
				
				var jsonData = JSON.stringify(fileData);
				console.log(jsonData);				
				//onMessage의 string영역으로 들어가 Json으로 웹소켓에서 파일 받을 준비 시킴
				ws.send(jsonData);
				
				//준비가 됬으니 이제 파일을 Buffer로 바꿀 준비
				var reader = new FileReader();
				var rawData = new ArrayBuffer();
					reader.loadend = function() {
				}

				//reader가 load되면 buffer보내는 함수 실행(보내는 건 밑에 reader.readAsArrayBuffer(file);)
				reader.onload = function(e) {
				rawData = e.target.result;
				ws.send(rawData);
				
				console.log("파일 전송이 완료 되었습니다.");
				
				//위와 같으나 isEnd가 True 파일을 전부 보냈습니다.
				var fileEndData = 
				{
					type 		: "file",
					id 			: $("#sender").val(),
					fileName 	: fileSendName,
					isEnd 		: true
				}	
				
				jsonData = JSON.stringify(fileEndData);
				
				ws.send(jsonData);
				
				}
				reader.readAsArrayBuffer(file);
			}
			else
			{
				console.log("파일없음");				
			}
		}
		
        function closeSocket(){
            ws.close();
        }
        function writeResponse(text){
			console.log(text);
        }
