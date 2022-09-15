<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class ="bgColor">


<div class = "contentsDiv" >
	<div class = "contentsMainDiv bgColor">
	
		<div class = "contesntsBlank">
		</div>
		
		<div class = "regContents">
			   	<input type="text" name = "user_id" id="wsUserId" value= '${sessionScope.loginMember.user_ID}'  style="display: none;">
   				<input type="text" id="wsRoomType" value="board" style="display: none;">
   
				<div class = "regContentsDiv1">
					
					<div class = "profileDiv">
						<div class = "profileIcon" style = "margin: auto;"> 
								<img style="width:100%; height:100%;" alt="" src="resources/img/profile/${sessionScope.loginMember.user_ID}/photo.png"
								onerror="this.onerror=null; this.src='resources/img/profile/s.png';"/> </div>					</div>
					
					<div class = "regContRightDiv">
					
						<div class = "uploadContainer">
							<div class = "textInputDiv ">
								<textarea id="board_contents" name= "board_contents" class = "bgColor" rows="" cols="" placeholder="your Wolrd is..."></textarea>					
							</div>
							<div class = "imgContainerDiv">
						 		<input name = "board_img[]" class = "inputFile" id = "inputFile" multiple="" data-max_length="4" type="file" style = "display: none">
							</div>					
						</div>
					
						<div class = "regContentsDiv2">
							<div class = "subContents">
								<div>
									<label for="inputFile">
						 				<img class = "menuImg" alt="" src="resources/icon/white/img.png"> 
							 		</label>
								</div>
								<div class = "birthDaySelectDiv">
           	   						<div class = "monthDiv joinBirthDiv" style= "width:150px;">
           	   							<div class = "birthTextDiv">나라</div>
										<select name="board_country" id="country" class ="joinBirthSel"></select>
									</div>
           	   				
           	   						<div class = "dayDiv joinBirthDiv"  style= "width:150px;">
										<div class = "birthTextDiv">도시</div>
										<select name="board_region" id="region" class ="joinBirthSel"></select>
									</div>
									
           	   					</div>
							</div>
						<div>
							<button type="button" id="submit">Wolrds</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class ="container" style = "width : 100%;">
			<div class = "containerList" style = "width : 100%;">
				<div class = "board" style = "display:flex;">
					<div class = "boardProfile">
					프로필
					</div>
					<div class = "boardDiv" style = "display:flex; flex-direction : column">
						<div class = "accountDiv">
						계정
						</div>
						<div class = "contentsDiv">
						콘텐츠
						</div>
						<div class = "imgDiv">
						이미지
						</div>
						<div class = "reactDiv">
						</div>
						우리들의 워 게임				
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class = "contentsSubDiv"> 
		<jsp:include page="subPage.jsp"/>
	</div>
</div>


</body>
<script type = "text/javascript" src="resources/js/utill/jwServer.js"></script>
<script type = "text/javascript" src="resources/js/jw/fakeBoard.js"></script>
<script type = "text/javascript" src="resources/js/utill/imageUploader.js"></script>
</html>