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
}

/**
웹소켓 받았을때
 */
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

