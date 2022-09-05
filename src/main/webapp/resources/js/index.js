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

var maxStep = 4;
var currentStep=1;
const joinDivStep = "joinDiv";

$(".nextModalBtn").on('click', function(event){
	currentStep++;
	$('#joinStep').text(maxStep+"단계 중 "+currentStep+"단계");
	$('#joinDiv'+(currentStep-1)).css('display','none');
	$('#joinDiv'+currentStep).css('display','block');
});

$(".prevModalBtn").on('click', function(event){
	currentStep--;
	$('#joinStep').text(maxStep+"단계 중 "+currentStep+"단계");
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
