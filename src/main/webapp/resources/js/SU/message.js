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

---

$(function() {
	
	 $("#send").click(function() {
		
		 let msg = $("#sendmsg").val();
		 let img = $("#sendimg").val();
		 let room = $("#roomNum").val();
		 
		 
	$.ajax({
				
				url:"messages.send",
				data:{msg_Contents: msg,
					msg_img: img,
					msg_RoomNum: room,
					},
				type:"post",
			    contentType : false,
		        processData : false,
		        	
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
