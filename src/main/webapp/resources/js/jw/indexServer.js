
//메시지를 받을때
window.onload = function()
{
		var birthDay = $("#year option:selected").val() +"-" + $("#month option:selected").val() +"-"+ $("#day option:selected").val();

	mapInit();
		
		$("#loginBtn").on('click', function(event){
			login();
		});
		
		$("#joinBtn").on('click', function(event){
			joinDo();
		});
	

	function loginSucessed()
	{
		location.href = 'home.go';
	}
	
	function loginFailed()
	{
		alert("실패");	
	}
	
	function joinSucessed()
	{
		location.href = 'home.go';
	}
	
	function joinFailed()
	{
		alert("실패");	
	}
	function login()
	{
		$.ajax({
				url:"loginTest",
				data:{
					"user_ID": $("#user_ID").val(),
					"user_PW": $("#user_PW").val()
					},
				type:'GET',
				dataType: 'json',
		        	
				success:function(result){
					if(result==true){
				loginSucessed();
					}else{
				loginFailed();
					}
				}		 
		});
	}
	function joinDo()
	{
			$.ajax({
				url:"join.do",
				data:{
					"user_ID"			: $("#join_ID").val(),
					"user_PW"			: $("#join_PW").val(),
					"user_nickName"		: $("#join_nickName").val(),
					"user_phoneNumber"	: $("#join_phoneNumber").val(),
					"user_name"			: $("#join_name").val(),
					"user_email"		: $("#join_email").val(),
					"user_country"		: $("#join_country").val(),
					"user_city"			: $("#join_city").val(),
					"str_user_birthDay"		: birthDay
					},
				type:'GET',
				dataType: 'json',
		        	
				success:function(result){
					if(result==true){
				joinSucessed();
					}else{
				joinFailed();
					}
				}		 
		});
	
	}
	
}