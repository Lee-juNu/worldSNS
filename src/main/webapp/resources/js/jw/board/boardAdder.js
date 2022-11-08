var boardContainer = $('#containerList');
function addMultiBoard(arrBoard)
{
	console.log(arrBoard);
	var html = ""
	arrBoard.forEach(function(data, index) {
		html+=addBoard(data);
	});
	boardContainer.prepend(html);
}

function addBoard(data)
{
	console.log(data.board_userID);
	var imgs = "";
		if(data.board_img4 != undefined)
		{
			imgs=addImg4(data);			
		}
		else if(data.board_img3 != undefined)
		{
			imgs=addImg3(data);
		}
		else if(data.board_img2 != undefined)
		{
			imgs=addImg2(data)
		}
		else if(data.board_img1 != undefined)
		{
			imgs=addImg1(data);
		}
		var tempHtml = `
					<div class = "board" id="board`+data.board_Num+`" style = "">
					<div class = "boardProfile">
					<div class = "profileIcon" style = "margin: auto;"> 
								<img style="width:100%; height:100%;" alt="" src="resources/img/profile/`+data.board_userID+`/photo.png"/
								onerror="this.onerror=null; this.src='resources/img/profile/s.png';">
								 </div>
					</div>
					<div class = "boardDiv" style = "">
						<div class = "accountDiv">
						
						<div>`+data.board_userID + `@` +data.board_userID+data.board_regDate+`</div><div>`+addDeleteButton(data)+`</div>
						</div>
						<div class = "contentsDiv">
							`+data.board_Contents+`
						</div>
						<div class = "imgDiv"
							<div class = "imgContainer">
							`+imgs+`
							</div>
							<div class = "reactDiv">
							<a onclick="reply(`+data+`)">
							<img style = "width:20px;height:20px;" class = "deleteIcon" alt="" src="resources/icon/white/reply.png">
							</a>
							`+addLikeButton(data)+`
							<a onclick="regShare(`+data+`)">
							<img style = "width:20px;height:20px;" class = "deleteIcon" alt="" src="resources/icon/white/share.png">
							</a>
							<div></div>
						</div>
						</div>
					</div>
				</div>`;
				
				return tempHtml;
}
function addDeleteButton(data)
{
	if(data.board_userID == userId)
	{		
				var deleteImg = '<img style = "width:20px;height:20px;" class = "deleteIcon" alt="" src="resources/icon/white/delete.png"> '
	return `<a onclick="deleteBoard(`+data.board_Num+`)">`+deleteImg+`</a>`;
	}
	return ``;
}
function addLikeButton(data)
{
	if(data.like_BoardNum == "-1")
	{
	return `<div id ="like`+data.board_Num+`">
	<input id = "likeInput`+data.board_Num+`" type="hidden"  value =`+data.likeCount+`>
	<span id = "likeSpInput`+data.board_Num+`">`+data.likeCount+`</span>
	<span id = "likeBtn`+data.board_Num+`">
	<a onclick="regLike(`+data.board_Num+`,'`+data.board_userID+`','`+userId+`')">
	<img style = "width:20px;height:20px;" class = "deleteIcon" alt="" src="resources/icon/white/like.png">
	 </a>
	</span>
	</div>
	`;		
	}
	return `<div id ="like`+data.board_Num+`">
	<input id = "likeInput`+data.board_Num+`" type="hidden"  value =`+data.likeCount+`>
	<span id = "likeSpInput`+data.board_Num+`">`+data.likeCount+`</span>
	<span id = "likeBtn`+data.board_Num+`">
	<a onclick="deleteLike(`+data.board_Num+`,'`+data.board_userID+`','`+userId+`')">
	<img style = "width:20px;height:20px;" class = "deleteIcon" alt="" src="resources/icon/white/unLike.png">
	</a>
	</span>
	</div>
	`;	
}

function addImg1(data)
{
	return `
	<div class = "imgContainerDiv">
	<img style="width:100%; height:100%;" alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img1+`"
								 /></div>`;
}
function addImg2(data)
{
	return `
				<div class = "imgContainerDiv">
			<div class = "image2Conatiner">
				<img style="width:100%; height:100%" alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img1+`"
				 />									
			</div>
			<div class = "image2Conatiner">
				<img style="width:100%; height:100%" alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img2+`"
				 />									
			</div>
			</div>
			`
}
function addImg3(data)
{
	return `
			<div class = "imgContainerDiv">
			<div class = "image3ConatinerLeft">
									<div class = "img3L">
										<img  alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img1+`"
										 />									
									</div>
									</div>
									<div class = "image3ConatinerRight">
									<div class = "img3R">
										<img  alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img2+`"
										 />									
									</div>
										<div class = "img3R">
										<img  alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img3+`"
										 />									
									</div>
									</div>
									</div>
			`;
}
function addImg4(data)
{
	console.log("나오려나"+data.board_img1);
			return `
						<div class = "imgContainerDiv">

					<div class = "image4Conatiner">
										<div class = "img4">
											<img  alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img1+`"
											 />									
										</div>
										<div class = "img4">
											<img  alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img2+`"
											 />									
										</div>
									</div>
									<div class = "image4Conatiner">
										<div class = "img4">
											<img  alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img3+`"
											 />									
										</div>
										<div class = "img4">
											<img  alt="" src="resources/img/board/`+data.board_userID+`/`+data.board_img4+`"
											 />									
										</div>
					</div>
					</div>`;
}