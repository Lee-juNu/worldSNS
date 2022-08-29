const loremIpsum = document.getElementById("lorem-ipsum")
fetch("https://baconipsum.com/api/?type=all-meat&paras=200&format=html")
    .then(response => response.text())
    .then(result => loremIpsum.innerHTML = result)
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


$(function() {

	 let room = $('#roomNum').val();
	$.ajax({
				
				url:"messages.getMsg",
				data:{"msg_RoomNum": room},
				type:'GET',
				dataType: 'json',
		           success :  
		        	   function(data) {
						alert('s1s') },
						error:function(){
						}
		           });
	 });




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
		        	   
		        	   for (var i = 0; i < userdata.length; i++) {
		        		   var friendlist = userdata[i].user_ID
							console.log(friendlist)
							console.log(i)
						var user = document.createElement('div'); 
						user.innerHTML = "<div>"+ friendlist+"</div>";
						document.getElementById('userList').appendChild(user);
		        	   }
		        	   
						
						
						 },
						error:function(error){
							console.log(error)
						}
		           });
	 };

	 
	 
