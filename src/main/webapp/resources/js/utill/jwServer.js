		var ws;
		
            if(ws!==undefined && ws.readyState!==WebSocket.CLOSED){
                writeResponse("WebSocket is already opened.");
            }
		else
		{

            ws=new WebSocket("ws://localhost:80/worlds/echo.do/yorunohosi");
            
            ws.onopen=function(event){
                if(event.data===undefined) return;
				writeResponse(event.data);
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
			console.log(jsonData)
			ws.send(jsonData);
			sendFile();
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
		sendFile();
        }	
        				
		function sendFile()
		{
			var filePathName = $("#inputFile").val().split("\\");
			var fileSendName = filePathName[filePathName.length-1];
			var file = document.getElementById('inputFile').files[0];

			console.log(fileSendName);				

			if(fileSendName!="")
			{
				var fileData = 
				{
					type : "file",
					id : $("#sender").val(),
					fileName : fileSendName,
					isEnd : false
				}	
				var jsonData = JSON.stringify(fileData);
				console.log(jsonData);				

				ws.send(jsonData);
				
				var reader = new FileReader();
				var rawData = new ArrayBuffer();
					reader.loadend = function() {
				}

				reader.onload = function(e) {
				rawData = e.target.result;
				ws.send(rawData);
				alert("파일 전송이 완료 되었습니다.")
				
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
			var messages = document.getElementById("messages")
			messages.innerHTML += '<br>'+ text;
        }
