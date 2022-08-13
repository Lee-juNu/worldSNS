//메시지를 보낼때
function jwSend(){	
			var memberData = 
			{
				type : "chat",
				id : $("#sender").val(),
				contents : $("#messageinput").val() 
			}
			
		sendMsg(memberData);
        }
function jwFileSend()
{
	sendFile();
}

//메시지를 받을때
window.onload = function()
{
		// some other listener for incoming messages
				ws.addEventListener("message", function(event) {
			});
}