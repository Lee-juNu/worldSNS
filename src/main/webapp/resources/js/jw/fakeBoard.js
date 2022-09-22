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


function receiveMessage(message)
{
	var resultJson = JSON.parse(message);
	console.log(resultJson);
	if(resultJson.type == "nextBoard")
	{
		if(resultJson.arrBoard!= null)
		{
			receiveBoard(resultJson.arrBoard);			
		}
	}
	else if(resultJson.type == "changeRegion")
	{
		changeRegions(resultJson.regions);
	}
	else if(resultJson.type == "clickMapReturn")
	{
		mapClicked(resultJson);
	}
	else if(resultJson.type =="getBoard")
	{
		addMultiBoard(resultJson.arrBoard);
	}
	else if(resultJson.type =="result")
	{
		if(resultJson.resultType =="boardSuceess")
		{
			addMultiBoard(resultJson.board);
			resetBoard();
		}
		else if(resultJson.resultType == "likeSuceess")
		{
			successLike(resultJson);
		}	
		else if(resultJson.resultType == "likeDelSuceess")
		{
			successDelLike(resultJson);
		}	
		else if(resultJson.resultType =="deleteSuceess")
		{
			suceessDeleteBoard(resultJson.boardNum);
		}
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
			$("#likeInput"+data.board_Num).val(likePlus);
			$(`#likeSpInput`+data.board_Num).text(likePlus);
			$(`#likeBtn`+data.board_Num).html(button);
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


window.onload = function()
{
	boardInit();
	mapInit();
	mapPlusTransition();
	YesScroll();
	userId = $('#wsUserId').val();
	$('#submit').click(function(){
		if(0!=document.getElementById(fileId).files.length)
		{
			jwSendWithFile();
		}
		else
		{
			uploadBoard();
			resetBoard();
		}
	});		
	$('.back').click(function(){
		mapBack();
		mapMatrixInit();
	})

	$('#country').change(function(){
		changeRegionByCountry(this.value)
	})	
	
	ws.addEventListener("message", function(event) {
		receiveMessage(event.data);
	});
	
	function mapMatrixInit()
	{
		prevScale = 1;
		currentScale = 1;
		offsetPtX=0;
		offsetPtY=0;
		transformMatrix = [1, 0, 0, 1, 0, 0];
		var newMatrix = "matrix(" +  transformMatrix.join(' ') + ")";
  		matrixGroup.setAttributeNS(null, "transform", newMatrix);
	}
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



	var boardContainer = $('#containerList');
function addMultiBoard(arrBoard)
{
	console.log(arrBoard);
	//data.board_City
	
	//data.board_Country
	//data.board_Num

	
	
	var html = ""
	arrBoard.forEach(function(data, index) {
		html+=addBoard(data);
	});
	boardContainer.prepend(html);
}

function addBoard(data)
{
	console.log(data.board_userID);
	var imgs = "";
		if(data.board_img4 != undefined)
		{
			imgs=addImg4(data);			
		}
		else if(data.board_img3 != undefined)
		{
			imgs=addImg3(data);
		}
		else if(data.board_img2 != undefined)
		{
			imgs=addImg2(data)
		}
		else if(data.board_img1 != undefined)
		{
			imgs=addImg1(data);
		}
		var tempHtml = `
					<div class = "board" id="board`+data.board_Num+`" style = "">
					<div class = "boardProfile">
					<div class = "profileIcon" style = "margin: auto;"> 
								<img style="width:100%; height:100%;" alt="" src="resources/img/profile/`+data.board_userID+`/photo.png"/
								onerror="this.onerror=null; this.src='resources/img/profile/s.png';">
								 </div>
					</div>
					<div class = "boardDiv" style = "">
						<div class = "accountDiv">
						
						<div>`+data.board_userID + `@` +data.board_userID+data.board_regDate+`</div><div>`+addDeleteButton(data)+`</div>
						</div>
						<div class = "contentsDiv">
							`+data.board_Contents+`
						</div>
						<div class = "imgDiv"
							<div class = "imgContainer">
							`+imgs+`
							</div>
							<div class = "reactDiv">
							<a onclick="reply(`+data+`)">
							<img style = "width:20px;height:20px;" class = "deleteIcon" alt="" src="resources/icon/white/reply.png">
							</a>
							`+addLikeButton(data)+`
							<a onclick="regShare(`+data+`)">
							<img style = "width:20px;height:20px;" class = "deleteIcon" alt="" src="resources/icon/white/share.png">
							</a>
							<div></div>
						</div>
						</div>
					</div>
				</div>`;
				
				return tempHtml;
}
function addDeleteButton(data)
{
	if(data.board_userID == userId)
	{		
				var deleteImg = '<img style = "width:20px;height:20px;" class = "deleteIcon" alt="" src="resources/icon/white/delete.png"> '
	return `<a onclick="deleteBoard(`+data.board_Num+`)">`+deleteImg+`</a>`;
	}
	return ``;
}
function addLikeButton(data)
{
	if(data.like_BoardNum == "-1")
	{
	return `<div id ="like`+data.board_Num+`">
	<input id = "likeInput`+data.board_Num+`" type="hidden"  value =`+data.likeCount+`>
	<span id = "likeSpInput`+data.board_Num+`">`+data.likeCount+`</span>
	<span id = "likeBtn`+data.board_Num+`">
	<a onclick="regLike(`+data.board_Num+`,'`+data.board_userID+`','`+userId+`')">
	<img style = "width:20px;height:20px;" class = "deleteIcon" alt="" src="resources/icon/white/like.png">
	 </a>
	</span>
	</div>
	`;		
	}
	return `<div id ="like`+data.board_Num+`">
	<input id = "likeInput`+data.board_Num+`" type="hidden"  value =`+data.likeCount+`>
	<span id = "likeSpInput`+data.board_Num+`">`+data.likeCount+`</span>
	<span id = "likeBtn`+data.board_Num+`">
	<a onclick="deleteLike(`+data.board_Num+`,'`+data.board_userID+`','`+userId+`')">
	<img style = "width:20px;height:20px;" class = "deleteIcon" alt="" src="resources/icon/white/unLike.png">
	</a>
	</span>
	</div>
	`;	
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



function addImg1(data)
{
	return `
	<div class = "imgContainerDiv">
	<img style="width:100%; height:100%;" alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img1+`"
								 /></div>`;
}
function addImg2(data)
{
	return `
				<div class = "imgContainerDiv">
			<div class = "image2Conatiner">
				<img style="width:100%; height:100%" alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img1+`"
				 />									
			</div>
			<div class = "image2Conatiner">
				<img style="width:100%; height:100%" alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img2+`"
				 />									
			</div>
			</div>
			`
}
function addImg3(data)
{
	return `
			<div class = "imgContainerDiv">
			<div class = "image3ConatinerLeft">
									<div class = "img3L">
										<img  alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img1+`"
										 />									
									</div>
									</div>
									<div class = "image3ConatinerRight">
									<div class = "img3R">
										<img  alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img2+`"
										 />									
									</div>
										<div class = "img3R">
										<img  alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img3+`"
										 />									
									</div>
									</div>
									</div>
			`;
}
function addImg4(data)
{
	console.log("나오려나"+data.board_img1);
			return `
						<div class = "imgContainerDiv">

					<div class = "image4Conatiner">
										<div class = "img4">
											<img  alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img1+`"
											 />									
										</div>
										<div class = "img4">
											<img  alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img2+`"
											 />									
										</div>
									</div>
									<div class = "image4Conatiner">
										<div class = "img4">
											<img  alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img3+`"
											 />									
										</div>
										<div class = "img4">
											<img  alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img4+`"
											 />									
										</div>
					</div>
					</div>`;
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
	$('#country').append('<option value="null">나라를 선택해주세요</option>');
	$('#region').append('<option value="null">도시를 선택해주세요</option>');

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


