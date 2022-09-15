function boardInit()
{
	selectCountryInit();
	getBoardInit();
}
function selectCountryInit()
{
	var country = 
		{
			type : "board",
			contents : "countryInit"
		}	
	sendMsg(country);
}

function getBoardInit()
{
	var boardInitMsg = 
		{
			type : "board",
			contents : "boardInit"
		}
	sendMsg(boardInitMsg);	
}

var 	currentFileIndex = 0;
const  maxFile = 4;
const  fileId = 'inputFile';
const  addFolderName = 'board/';
var userId = '';

window.onload = function()
{
	boardInit();
	userId = $('#wsUserId').val();
	$('#submit').click(function(){
		if(0!=document.getElementById(fileId).files.length)
		{
			jwSendWithFile();
		}
		else
		{
			uploadBoard();
		}
	});		


	$('#country').change(function(){
		changeRegionByCountry(this.value)
	})	
	
	ws.addEventListener("message", function(event) {
		receiveMessage(event.data);
	});
}





function changeRegionByCountry(countryId)
{
	if(countryId == "")	return;
	
	var country = 
		{
			type : "board",
			contents : "regionInit",
			countryName : countryId
		}
		
	sendMsg(country);
	
}
function receiveMessage(message)
{
	
	var resultJson = JSON.parse(message);
	console.log(resultJson);
	if(resultJson.type == "changeRegion")
	{
		changeRegions(resultJson.regions);
	}
	else if(resultJson.type =="getBoard")
	{
		addBoard(resultJson.arrBoard);
	}
	else if(resultJson.type =="countryInit")
	{
		addCountries(resultJson.countries);
	}
	else if(resultJson.type=="reqNextFile")
	{
		nextFileUpload();
	}
}

function addBoard(arrBoard)
{
	console.log(arrBoard);
	
	var html = `
	<div class = "board" style = "">
					<div class = "boardProfile">
					<div class = "profileIcon" style = "margin: auto;"> 
								<img style="width:100%; height:100%;" alt="" src="resources/img/profile/{sessionScope.loginMember.user_ID}/photo.png"
								onerror="this.onerror=null; this.src='resources/img/profile/s.png';"/>
								 </div>
					</div>
					<div class = "boardDiv" style = "">
						<div class = "accountDiv">
						{sessionScope.loginMember.user_nickName}
						@{sessionScope.loginMember.user_ID} reg Date
						</div>
						
						<div class = "contentsDiv">
							콘텐츠다아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아콘텐츠다아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아
						</div>
						<div class = "imgDiv">
							<div class = "imgContainer">
								<img style="width:100%; height:100%;" alt="" src="resources/img/profile/{sessionScope.loginMember.user_ID}/photo.png"
								onerror="this.onerror=null; this.src='resources/img/profile/s.png';"/>
							</div>
						</div>
						<div class = "reactDiv">
						</div>
					</div>
				</div>`;	

				
				
	
}

function changeRegions(regions)
{
	$("#region").empty();
	$('#region').append('<option value="">도시를 선택해주세요</option>');
		
		regions.forEach(function(data, index) {
			$('#region').append('<option value="' + data.region_name + '">' + data.region_name + '</option>');    		
    	});

}
function addCountries(countries)
{
	$('#country').append('<option value="">나라를 선택해주세요</option>');
	$('#region').append('<option value="">도시를 선택해주세요</option>');

			countries.forEach(function(data, index) {
			$('#country').append('<option value="' + data.country_id + '">' + data.country_Name + '</option>');    		
    	});
}




function jwSendWithFile(){	
		multiFileUpload(fileId, addFolderName+userId,currentFileIndex);
}

function nextFileUpload()
{
		currentFileIndex++;
		console.log(document.getElementById(fileId).files.length);
		if(currentFileIndex<document.getElementById(fileId).files.length && currentFileIndex < maxFile)
		{
			multiFileUpload(fileId, addFolderName+userId,currentFileIndex);
		}
		else
		{
			currentFileIndex = 0;
			uploadBoard();
		}
}

function uploadBoard()
{
	var fileDoc = document.getElementById(fileId);
	var filesName = '';
	for (var i = 0; i < fileDoc.files.length; ++i) {
  		filesName += fileDoc.files[i].name;
		if(i+1<fileDoc.files.length)
		{
			filesName +="/";
		}
	}
	console.log(filesName);
	var boardMsg = 
		{
			type : "board",
			contents : "upload",
			board_contents :$('#board_contents').val(),
			board_imgs : filesName,
			board_country: $('#country').val(),
			board_region : $('#region').val(),
			board_userId: userId,
			board_parent: ''
		}
		
	sendMsg(boardMsg);

}

