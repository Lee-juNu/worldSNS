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


function suceessDeleteBoard(data)
{
	$('#board'+data).remove();
}

function successLike(data)
{
	var button = `<a onclick="deleteLike(`+data.board_Num+`,'`+data.board_userID+`','`+userId+`')">
	<img style = "width:20px;height:20px;" class = "deleteIcon" alt="" src="resources/icon/white/unLike.png">
	</a>`;	
			var likePlus= ($("#likeInput"+data.board_Num).val()*1+1);
			$("#likeInput"	+data.board_Num).val(likePlus);
			$(`#likeSpInput`+data.board_Num).text(likePlus);
			$(`#likeBtn`	+data.board_Num).html(button);
}
function successDelLike(data)
{
	var button = `<a onclick="regLike(`+data.board_Num+`,'`+data.board_userID+`','`+userId+`')">
	<img style = "width:20px;height:20px;" class = "deleteIcon" alt="" src="resources/icon/white/like.png">
 	</a>`;	
			var likePlus= ($("#likeInput"+data.board_Num).val()*1-1);
			$("#likeInput"+data.board_Num).val(likePlus);
			$(`#likeSpInput`+data.board_Num).text(likePlus);
			$(`#likeBtn`+data.board_Num).html(button);
}


var 	currentFileIndex = 0;
const  maxFile = 4;
const  fileId = 'inputFile';
const  addFolderName = 'board/';
var userId = '';



function mapBack()
{
	mapSelectorInit();
	$('.back').hide();
}
function mapOpen()
{
	$('.mapOpen').hide();
	$('.mapFold').show();
	$('.mapIncludeDiv').show();
}

function mapFold()
{
	$('.mapOpen').show();
	$('.mapFold').hide();
	$('.mapIncludeDiv').hide();
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
var currCountry ="";
var currRegion ="";
function changeRegionAndCountry(countryId,regionId)
{
	if(countryId == "")	return;
	currCountry = countryId;
	currRegion = regionId;
	
	var country = 
	{
		type : "board",
		contents : "mapClick",
		countryName : countryId,
		regionName : regionId
	}
	sendMsg(country);
}

function mapClicked(data)
{
	changeRegions(data.regions);
	$('#country').val(data.countryName).prop("selected",true);
	$('#region').val(data.regionName).prop("selected",true);
	boardContainer.children().remove();
	oneTime= false;

	addMultiBoard(data.boards);
}


function deleteBoard(number)
{
	console.log(number)
	var boardDeleteMsg = 
		{
			type : "board",
			contents : "boardDelete",
			boardNumber : number
		}
	sendMsg(boardDeleteMsg);
}
function regLike(boardNum,receiverId,senderId)
{
	var boardRegMsg = 
		{
			type 		: 	"board",
			contents 	: 	"regLike",
			boardNumber : 	boardNum,
			senderID 	:  	senderId,
			receiverID	:	receiverId
		}
	sendMsg(boardRegMsg);
}

function deleteLike(boardNum,receiverId,senderId)
{
	var boardRegMsg = 
		{
			type 		: 	"board",
			contents 	: 	"deleteLike",
			boardNumber : 	boardNum,
			senderID 	:  	senderId,
			receiverID	:	receiverId
		}
	sendMsg(boardRegMsg);
}



function changeRegions(regions)
{
	$("#region").empty();
	$('#region').append('<option value="null">도시를 선택해주세요</option>');
		
		regions.forEach(function(data, index) {
			$('#region').append('<option value="' + data.region_name + '">' + data.region_name + '</option>');    		
    	});

}
function addCountries(countries)
{
	$('#country').append('<option value="null">国を選んでください</option>');
	$('#region').append('<option value="null">都市を選んでください</option>');

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

function resetBoard()
{
		$('#board_contents').val("");
		$('#inputFile').val("");
		const myNode = document.getElementById("classRemover");
  		myNode.textContent = '';
		imgArray = [];
}


