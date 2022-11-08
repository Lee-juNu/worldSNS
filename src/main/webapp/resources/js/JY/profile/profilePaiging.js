var currentPage = 1;
const pageSize = 5;

/**
만들기전에 기억해야될꺼
1.누르는 것에 따라 달라야된다
2. 지역
 */
var currentSelect = 0;
var oneTime = false; // 일회용 글로벌 변수
function profilePaiging () {

const screenHeight = screen.height; // 화면 크기
document.addEventListener('scroll',OnScroll,{passive:true}) // 스크롤 이벤트함수정의
 function OnScroll () { //스크롤 이벤트 함수
   const fullHeight = $('#profileSelectionID').height(); // infinite 클래스의 높이   
console.log(fullHeight);
   const scrollPosition = pageYOffset; // 스크롤 위치
   if (fullHeight-screenHeight*2 <= scrollPosition && !oneTime) { // 만약 전체높이-화면높이/2가 스크롤포지션보다 작아진다면, 그리고 oneTime 변수가 거짓이라면
     oneTime = true; // oneTime 변수를 true로 변경해주고,
		if(currentSelect==0)
		{
			idlePaiging();
		}
   }
 }
	function idlePaiging()
	{
		var boardAddPage = 
		{
			type : "profile",
			contents : "nextPageReq",
			currPage : currentPage+1,
			size : pageSize,
			profileUser : $('#findUser').val()
		}
		sendMsg(boardAddPage);	
	}
 }

function receiveBoard(arrBoard)
	{
		var html = ""
		arrBoard.forEach(function(data, index) {
			html+=addBoard(data);
		});
		boardContainer.append(html);
		currentPage++;
		oneTime = false;
	}
