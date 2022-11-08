function goJoin()
{
	location.href = 'home.go';
}


$(document).ready(function(){

const modal = document.getElementById("modal");
const modalJoin = document.getElementById("modalJoin");
const btnModal = document.getElementById("loginModal");
const joinBtnModal = document.getElementById("joinUsTag");


joinBtnModal.addEventListener("click", e => {
	 modal.style.display = "none";
	modalJoin.style.display = "flex";
	})
btnModal.addEventListener("click", e => {
    modal.style.display = "flex";
	modalJoin.style.display = "none";
})


window.addEventListener("keyup", e => {
    if(modal.style.display === "flex" && e.key === "Escape") {
        modal.style.display = "none"
    }
	if(modalJoin.style.display === "flex" && e.key === "Escape")
	{
		modalJoin.style.display = "none";
	}
})

modal.addEventListener("mousedown", e => {
    const evTarget = e.target
    if(evTarget.classList.contains("modal-overlay")) {
        modal.style.display = "none"
    }
})
modalJoin.addEventListener("mousedown", e => {
    const evTarget = e.target
    if(evTarget.classList.contains("modal-overlay")) {
		modalJoin.style.display = "none";
    }
})

var maxStep = 2;
var currentStep=1;


$("#join_ID").blur(function()
{
	if(!idCheck($("#join_ID").val())){ return false;}
})

$("#join_PW").blur(function()
{
	if(!pwCheck($("#join_PW").val())){ return false;}
})

$("#join_phoneNumber").blur(function()
{
	if(!phoneNumberCheck($('#join_phoneNumber').val())){ return false;}
})

$("#join_email").blur(function()
{
	if(!emailCheck($('#join_email').val())){ return false;}
})

$("#join_name").blur(function()
{
	if(!nameRuleCheck($('#join_name').val())){ return false;}
})

$("#join_nickName").blur(function()
{
	if(!nickName($('#join_nickName').val())){ return false;}
})

$(".nextModalBtn").on('click', function(event){
	if(currentStep==1)
	{
		if(!loginCheck1())
		{
			return;			
		}
	}
	else if(currentStep==2)
	{
		if(!loginCheck2())
		{
			return;			
		}
	}
	else if(currentStep == 3)
	{
		loginCheck3();
		return;
	}
	currentStep++;
	$('#joinStep').text(maxStep+"段階 中 "+currentStep+"段階");
	$('#joinDiv'+(currentStep-1)).css('display','none');
	$('#joinDiv'+currentStep).css('display','block');
});


function loginCheck1()
{
	if(!idCheck($("#join_ID").val())){ return false;}
	if(!pwCheck($("#join_PW").val())){ return false;}
	if(!phoneNumberCheck($('#join_phoneNumber').val())){ return false;}
	if(!emailCheck($('#join_email').val())){ return false;}
	return true;
}
function isIDExist()
{
	var exResult = false;
	$.ajax({
				url:"idCheck.do",
				async:false,
				data:{
					"user_ID": $("#join_ID").val(),
					},
				type:'GET',
				dataType: 'json',
		        	
				success:function(result){
					if(result == true)
					{
						exResult =true;						
					}else
					{				
						exResult =false;						
					}
				}		 
		});
		return exResult;
}

function isEmailExist()
{
	var exResult = false;
	$.ajax({
				url:"emailCheck.do",
				async:false,
				data:{
					"user_email": $("#join_email").val(),
					},
				type:'GET',
				dataType: 'json',
		        	
				success:function(result){
					if(result == true)
					{
						exResult =true;						
					}else
					{				
						exResult =false;						
					}
				}		 
		});
		return exResult;
}
function isPhoneExist()
{
	var exResult = false;
	$.ajax({
				url:"phoneCheck.do",
				async:false,
				data:{
					"user_phoneNumber": $("#join_phoneNumber").val(),
					},
				type:'GET',
				dataType: 'json',
		        	
				success:function(result){
					if(result == true)
					{
						exResult =true;						
					}else
					{				
						exResult =false;						
					}
				}		 
		});
		return exResult;
}
function idCheck(str)
{
	var pattern1 = /[0-9]/; // 숫자
	var pattern2 = /[a-zA-Z]/; // 문자
	var pattern3 = /[~!@#$%^&*()+|<>?:{}]/; // 특수문자
	
	console.log(str);
	var numtextyn = (pattern1.test(str) || pattern2.test(str));
	if(!numtextyn || pattern3.test(str) || str.length<5 || str.length > 14) {
		$("#join_IDRule").show();
		return false;
	} else {
		$("#join_IDRule").hide();
		if(!isIDExist())
		{
			return false;
		}
		return true;
	}
}
function pwCheck(str)
{
	const pattern1 = /[0-9]/; // 숫자
	const pattern2 = /[a-zA-Z]/; // 문자
	const pattern3 = /[~!@#$%^&*()+|_<>?:{}]/; // 특수문자

	console.log(str);
	
	if(!pattern1.test(str) || !pattern2.test(str)|| !pattern3.test(str) || str.length<5 || str.length > 14) {
		$("#join_PWRule").show();
		return false;
	} else {
		$("#join_PWRule").hide();
		return true;
	}	
}
function phoneNumberCheck(str)
{
	const pattern1 = /[0-9]/; // 숫자

	if(!pattern1.test(str) || str.length!=11) {
		$("#join_phoneRule").show();
		return false;
	} else {
		$("#join_phoneRule").hide();
		if(!isPhoneExist())
		{
			return false;
		}
			
		return true;
	}	
}
function emailCheck(str)
{
	const email = /[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]$/i;
	if(!email.test(str)) {
		$("#join_emailRule").show();
		return false;
	} else {
		$("#join_emailRule").hide();
	if(!isEmailExist())
		{
			return false;
		}
		return true;
	}	
}

function loginCheck2()
{
	if(!nameRuleCheck($('#join_name').val())){ return false;}
	if(!nickName($('#join_nickName').val())){ return false;}
	return true;

}

function nameRuleCheck(str)
{
	if(str.length>40 ||str.length<2)
	{
		$("#join_nameRule").show();
		return false;
	} else {
		$("#join_nameRule").hide();
		return true;
	}
}
function nickName(str)
{
	if(str.length>8 ||str.length<2)
	{
		$("#join_nickInputDiv").show();
		return false;
	} else {
		$("#join_nickInputDiv").hide();
		return true;
	}
}


function loginCheck3()
{
	
}

$(".prevModalBtn").on('click', function(event){
	currentStep--;
	$('#joinStep').text(maxStep+"段階 中 "+currentStep+"段階");
	$('#joinDiv'+(currentStep+1)).css('display','none');
	$('#joinDiv'+currentStep).css('display','block');
});


 selectDateInit();

});


function modalNextPage()
{
	
}


/**회원가입 생년월일 셀렉트를 채워주는 함수입니다 */
function selectDateInit()
{
	var now = new Date();
    var year = now.getFullYear();
    var mon = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1) : '0'+(now.getMonth() + 1); 
    var day = (now.getDate()) > 9 ? ''+(now.getDate()) : '0'+(now.getDate());           
    //년도 selectbox만들기               
    for(var i = 1900 ; i <= year ; i++) {
        $('#year').append('<option value="' + i + '">' + i + '</option>');    
    }

    // 월별 selectbox 만들기            
    for(var i=1; i <= 12; i++) {
        var mm = i > 9 ? i : "0"+i ;            
        $('#month').append('<option value="' + mm + '">' + mm + '</option>');    
    }
    
    // 일별 selectbox 만들기
    for(var i=1; i <= 31; i++) {
        var dd = i > 9 ? i : "0"+i ;            
        $('#day').append('<option value="' + dd + '">' + dd+ '</option>');    
    }
    $("#year  > option[value="+year+"]").attr("selected", "true");        
    $("#month  > option[value="+mon+"]").attr("selected", "true");    
    $("#day  > option[value="+day+"]").attr("selected", "true"); 

}
