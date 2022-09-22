var currentPage = 1;
const pageSize = 5;
var oneTime = false; // 일회용 글로벌 변수
function YesScroll () {
	
const screenHeight = screen.height; // 화면 크기
document.addEventListener('scroll',OnScroll,{passive:true}) // 스크롤 이벤트함수정의
 function OnScroll () { //스크롤 이벤트 함수
   const fullHeight = $('#contentsDivID').height(); // infinite 클래스의 높이   
console.log(fullHeight);
   const scrollPosition = pageYOffset; // 스크롤 위치
   if (fullHeight-screenHeight*2 <= scrollPosition && !oneTime) { // 만약 전체높이-화면높이/2가 스크롤포지션보다 작아진다면, 그리고 oneTime 변수가 거짓이라면
     oneTime = true; // oneTime 변수를 true로 변경해주고,
     

		if('null'==$("#region option:selected").val())
		{
			madeBox(currentPage); // 컨텐츠를 추가하는 함수를 불러온다.			
		}
		else
		{
			madeBoxRegion(currentPage);
		}
		
   }
 }
	function madeBox(nextPage)
	{
		var boardAddPage = 
		{
			type : "board",
			contents : "nextPageReq",
			currPage : currentPage+1,
			size : pageSize
		}
		sendMsg(boardAddPage);	
	}
	function madeBoxRegion(nextPage)
	{
		if(currCountry == "")	return;
		var country = 
		{
			type : "board",
			contents : "mapNextPageReq",
			countryName : currCountry,
			regionName : currRegion,
			currPage : currentPage+1,
			size : pageSize
		}
		sendMsg(country);	
	}
 }

function receiveBoard(arrBoard)
	{
		console.log(arrBoard);
	
		var html = ""
		arrBoard.forEach(function(data, index) {
			html+=addBoard(data);
		});
		boardContainer.append(html);
		currentPage++;
		oneTime = false;
	}
