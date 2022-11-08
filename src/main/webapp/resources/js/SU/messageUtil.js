
var currentInput ='';

function getUser()
{
	$('#searchbyUser').on('change keyup paste',function(e)
	{
		if(currentInput==$('#searchbyUser').val()){	return;}
		console.log($('#searchbyUser').val());
		reqUserList($('#searchbyUser').val());			
		currentInput=$('#searchbyUser').val();
	});
	
	function reqUserList(inputVal)
	{
		var boardAddPage = 
		{
			type : "chat",
			contents : "reqUsers",
			searchVal : inputVal
		}
		sendMsg(boardAddPage);
	}
}

function inputFocus()
{
	$('#searchbyUser').focus(function() {
		$('#backIconDiv').show();
		$('#userContainer').show();
		$('#chatContainer').hide();
	});
	
	$( "#backIconDiv" ).click(function() {
  		$('#backIconDiv').hide();
		$('#userContainer').hide();
		$('#chatContainer').show();
	});
}

