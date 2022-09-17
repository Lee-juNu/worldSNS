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


	var boardContainer = $('#containerList');
function addBoard(arrBoard)
{
	console.log(arrBoard);
	//data.board_City
	
	//data.board_Country
	//data.board_Num

	var imgs = "";
	
	
	var html = ""
	arrBoard.forEach(function(data, index) {
		
		if(data.board_img4 != undefined)
		{
		}
		else if(data.board_img3 != undefined)
		{
			
		}
		else if(data.board_img2 != undefined)
		{
			imgs = `<img style="width:100%; height:100%;" alt="" src="resources/img/board/`+data.board_img1+`/photo.png"
								onerror="this.onerror=null; this.src='resources/img/profile/s.png';"/>`;
		}
		else if(data.board_img1 != undefined)
		{
			imgs = `<img style="width:100%; height:100%;" alt="" src="resources/img/board/`+data.board_img1+`/photo.png"
								onerror="this.onerror=null; this.src='resources/img/profile/s.png';"/>`;
		}
		html += `
	<div class = "board" style = "">
					<div class = "boardProfile">
					<div class = "profileIcon" style = "margin: auto;"> 
								<img style="width:100%; height:100%;" alt="" src="resources/img/profile/`+data.board_userID+`/photo.png"
								onerror="this.onerror=null; this.src='resources/img/profile/s.png';"/>
								 </div>
					</div>
					<div class = "boardDiv" style = "">
						<div class = "accountDiv">
						`+data.board_userID + `@` +data.board_userID+data.board_regDate+`
						</div>
						
						<div class = "contentsDiv">
							`+data.board_Contents+`
						</div>
						<div class = "imgDiv"
							<div class = "imgContainer">
							`+imgs+`
							</div>
						</div>
						<div class = "reactDiv">
						</div>
					</div>
				</div>`;
	});
	boardContainer.append(html);
}



function addImg1(data)
{
	
}
function addImg2(data)
{
	
}
function addImg3(data)
{
	
}
function addImg4(data)
{
	
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

