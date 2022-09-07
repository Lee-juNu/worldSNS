//메시지를 보낼때




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

var currentFileIndex = 0;
const  maxFile = 4;
const  fileId = 'inputFile';
const  addFolderName = '폴더이름';

function jwSendWithFile(){	
		multiFileUpload(fileId, addFolderName,currentFileIndex);
}
function receiveMessage(message)
{
	var resultJson = JSON.parse(message);

	console.log(resultJson.type);
	
	if(resultJson.type=="reqNextFile")
	{
		currentFileIndex++;
		console.log(document.getElementById('inputFile').files.length);
		if(currentFileIndex<document.getElementById('inputFile').files.length && currentFileIndex < maxFile)
		{
			multiFileUpload(fileId, addFolderName,currentFileIndex);
		}
		else
		{
			console.log("다중 업로드 완료");
			currentFileIndex = 0;
		}
	}
}

