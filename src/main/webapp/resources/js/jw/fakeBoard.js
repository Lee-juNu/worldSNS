function boardInit()
{
	selectCountryInit();
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
		jwSendWithFile();
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
	else if(resultJson.type =="countryInit")
	{
		addCountries(resultJson.countries);
	}
	else if(resultJson.type=="reqNextFile")
	{
		nextFileUpload();
	}
	
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
			console.log("이미지 업로드 완료 보드 등록");
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

