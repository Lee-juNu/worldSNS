<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body class ="bgColor">


<div class = "contentsDiv" id ="contentsDivID" >
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
							<div id = "classRemover" class = "imgContainerDiv">
							</div>
						 	<input name = "board_img[]" class = "inputFile" id = "inputFile" multiple="" data-max_length="4" type="file" style = "display: none">
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
           	   							<div class = "birthTextDiv">Country</div>
										<select name="board_country" id="country" class ="joinBirthSel"></select>
									</div>
           	   				
           	   						<div class = "dayDiv joinBirthDiv"  style= "width:150px;">
										<div class = "birthTextDiv">City</div>
										<select name="board_region" id="region" class ="joinBirthSel"></select>
									</div>
           	   					</div>
							</div>
						<div>
							<button type="button" id="submit" class = "boardSubmit">Wolrds</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class = "mapDiv">
			<div class = "hideDiv">
				<a onclick ="mapOpen()">
				<div class = "mapOpen" >
				<div>
				</div>
				<div>
				地図を開く
				</div>
					<div class = "icon">
							<img alt="" src="resources/icon/white/extend.png">
					</div>
				</div>
				</a>
				<div class = "mapFold" style = "display:none;">
				<div>
				<div class ="back" style = "display:none;">
					<img alt="" src="resources/icon/white/backIcon.png">				
				</div>
				</div>
				<a style="width:80%;height:100%" onclick ="mapFold()">
				<div style="width:100%;height:100%">
					地図を閉じる
				</div>
				</a>
				<div class = "icon">
					<img alt="" src="resources/icon/white/fold.png">				
				</div>
				</div>
			</div>
			
			<div class = "mapIncludeDiv" style = "display:none;">
				<div id = "worldsMap">
					<jsp:include page="mapPage.jsp"/>
				</div>
				<div id = "map-KR" style = "display:none">
					<jsp:include page="mapCountry/koreaMap.jsp"/>
				</div>
				<div id = "map-JP" style = "display:none">
					<jsp:include page="mapCountry/japanMap.jsp"/>
				</div>
			</div>

		</div>
		
		<div class ="container" style = "width : 100%;">
			<div id = "containerList" class = "containerList" style = "width : 100%;">
			
			</div>
		</div>
	</div>
	<div class = "contentsSubDiv"> 
		<jsp:include page="subPage.jsp"/>
	</div>
</div>


</body>
<script type = "text/javascript" src="resources/js/utill/jwServer.js"></script>
<script type = "text/javascript" src="resources/js/jw/map.js"></script>
<script type = "text/javascript" src="resources/js/jw/board/fakeBoard.js"></script>
<script type = "text/javascript" src="resources/js/jw/board/boardAdder.js"></script>
<script type = "text/javascript" src="resources/js/jw/board/boardMain.js"></script>
<script type = "text/javascript" src="resources/js/jw/paiging.js"></script>
<script type = "text/javascript" src="resources/js/utill/imageUploader.js"></script>

</html>