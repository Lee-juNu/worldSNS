const loremIpsum = document.getElementById("lorem-ipsum")

const modal = document.getElementById("modal")
function modalOn() {
    modal.style.display = "flex"
}
function isModalOn() {
    return modal.style.display === "flex"
}
function modalOff() {
    modal.style.display = "none"
}
const btnModal = document.getElementById("btn-modal")
btnModal.addEventListener("click", e => {
    modalOn()
})
const closeBtn = modal.querySelector(".close-area")
closeBtn.addEventListener("click", e => {
    modalOff()
})
modal.addEventListener("click", e => {
    const evTarget = e.target
    if(evTarget.classList.contains("modal-overlay")) {
        modalOff()
    }
})
window.addEventListener("keyup", e => {
    if(isModalOn() && e.key === "Escape") {
        modalOff()
    }
})


const modal2 = document.getElementById("modal2")
function modalOn2() {
	modal2.style.display = "flex"
}
function isModalOn2() {
	return modal2.style.display === "flex"
}
function modalOff2() {
	modal2.style.display = "none"
}
const btnModal2 = document.getElementById("btn-modal2")
btnModal2.addEventListener("click", e => {
	modalOn2()
})
const closeBtn2 = modal2.querySelector(".close-area")
closeBtn2.addEventListener("click", e => {
	modalOff2()
})
modal2.addEventListener("click", e => {
	const evTarget = e.target
	if(evTarget.classList.contains("modal-overlay")) {
		modalOff2()
	}
})
window.addEventListener("keyup", e => {
	if(isModalOn() && e.key === "Escape") {
		modalOff2()
	}
})


$(function() {
	
	 $('#send').click(function() {
		
		 let msg = $('#sendmsg').val();
		 let room = $('#roomNum').val();
		 let user = $('#userID').val();
		 
	$.ajax({
				
				url:"messages.send",
				data:{"msg_Contents": msg,
					"msg_RoomNum": room,
					"msg_sendUserID": user,
					},
				type:'GET',
				dataType: 'json',
		        	
				success:function(result){
					if(result==1){
						alert('전송 성공')
					}else{
						alert('전송 실패')
					}
				}		 
		});
		 $('#sendmsg').val('');
		 $('#sendimg').val('');
	 });
	 });


function getroomuser() {
	
	var room = $('.crNum').children('input');
		console.log(room)
		
	$.ajax({
		
		url:"messages.getroomuser",
		data:{"rm_RoomNum": room},
		type:'GET',
		dataType: 'json',
		success :  
			function() {
			 const getroom = getroomuser;
			 console.log(getroom)
			 console.log(getroomuser)
			 console.log(typeof(getroom))
			 console.log(typeof(getroomuser))
			 },
			error:function(){
			console.log('error')
			}
	});
};




function search() {

	
	
	 let search = $('#searchUser').val();
	 console.log(search);
	 
	$.ajax({
				url:"messages.searchUser",
				data:{"user_ID": search},
				type:'GET',
				dataType: 'json',
		           success :  
		        	   function(search) {
		        	   
		        	   console.log(search)
		        	   const userdata = search;
		        	   console.log(typeof(search))
		        	   
		        	   var tbody = document.getElementById("userList");
		        		while(tbody.hasChildNodes()){
		        			tbody.removeChild(tbody.firstChild);
		        		}
		        	   
		        	   for (var i = 0; i < userdata.length; i++) {
		        		var friendlist = userdata[i].user_ID
						var user = document.createElement('div');
						$('#userList').val(""); 
						user.innerHTML =
						"<form onsubmit=\"invite()\" id=\"invite\"><div>"+friendlist+"<button>초대</button></div>" +
						"<input type=\"hidden\" id=\"inviteUser\" value="+ friendlist +"></form>";
						document.getElementById('userList').appendChild(user);
		        	   }
		        	   
//		        	   user.innerHTML ="<div>"+friendlist+"<button onclick=+"+ "invite()"+ ">초대</button>"+"</div>";
						
						
						 },
						error:function(error){
							console.log(error)
						}
		           });
	 };

	 function searchbyUser() {
		 
		 
		 
		 let searchBU = $('#searchbyUser').val();
		 console.log(searchBU);
		 
		 $.ajax({
			 url:"messages.searchbyUser",
			 data:{"rm_userID": searchBU},
			 type:'GET',
			 dataType: 'json',
			 success :  
				 function(searchbyUser) {
				 const SBUdata = searchbyUser;
				 console.log(SBUdata)
				 console.log(typeof(searchbyUser))
				 
				 
				   var tbody = document.getElementById("sbuDiv");
	        		while(tbody.hasChildNodes()){
	        			tbody.removeChild(tbody.firstChild);
	        		}
				 
				 for (var i = 0; i < SBUdata.length; i++) {
					 var SBUlist = SBUdata[i].cr_Num
					 var user = document.createElement('div'); 
					 user.innerHTML =
						 "<div>"+SBUlist+"</div>";
					 document.getElementById('sbuDiv').appendChild(user);
				 }
				 
				 
				 
			 },
			 error:function(error){
				 console.log(error)
			 }
		 });
	 };
	 
	 
	 function invite() {
		 
		 
		 
		 let inviteU = $('#inviteUser').val();
		 let roomType = $('#wsRoomType').val();
		 console.log(inviteU);
		
		 $.ajax({
			 url:"messages.inviteUser",
			 data:{"rm_userID": inviteU,
				 "rm_roomNum":roomType},
			 type:'GET',
			 dataType: 'json',
			 success :  
				 function(invite) {
				 console.log("invite")
				 },
			 error:function(error){
				 console.log(error)
			 }
		 });
	 };

	 
	 
