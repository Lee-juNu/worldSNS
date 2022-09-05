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



window.onload = function()
{
	boardInit();
		
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
	
	var temp = JSON.parse(message);
	console.log(temp);
	if(temp.type =="countryInit")
	{
		addCountries(temp.countries);
	}
}


function addCountries(countries)
{
	$('#country').append('<option value="">나라를 선택해주세요</option>');
			countries.forEach(function(data, index) {
			$('#country').append('<option value="' + data.country_id + '">' + data.country_Name + '</option>');    		
    	});
}

