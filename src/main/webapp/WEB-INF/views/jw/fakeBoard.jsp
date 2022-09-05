<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class ="bgColor">
   <input type="text" id="wsUserId" value= "admin" style="display: none;">
   <input type="text" id="wsRoomType" value="board" style="display: none;">

<div class = "contentsDiv" >
	<div class = "contentsMainDiv bgColor">
	
		<div class = "contesntsBlank">
		</div>
		
		<div class = "regContents">
				<div class = "regContentsDiv1">
					
					<div class = "profileDiv">
						<div class = "profileIcon" style = "margin: auto;"> 
								<img style="width:100%; height:100%;" alt="" src="resources/img/profile/${sessionScope.loginMember.user_ID}/photo.png"
								onerror="this.onerror=null; this.src='resources/img/profile/s.png';"/> </div>					</div>
					
					<div class = "regContRightDiv">
					
						<div class = "uploadContainer">
							<div class = "textInputDiv ">
								<textarea class = "bgColor" rows="" cols="" placeholder="your Wolrd is..."></textarea>					
							</div>
							<div class = "imgContainerDiv">
						 		<input class = "inputFile" id = "input-file" multiple="" data-max_length="4" type="file" style = "display: none">
							</div>					
						</div>
					
						<div class = "regContentsDiv2">
							<div class = "subContents">
								<div>
									<label for="input-file">
						 				<img class = "menuImg" alt="" src="resources/icon/white/img.png"> 
							 		</label>
								</div>
								<div class = "birthDaySelectDiv">
           	   				
           	   						<div class = "monthDiv joinBirthDiv" style= "width:150px;">
           	   							<div class = "birthTextDiv">나라</div>
										<select name="mm" id="country" class ="joinBirthSel"></select>
									</div>
           	   				
           	   						<div class = "dayDiv joinBirthDiv"  style= "width:150px;">
										<div class = "birthTextDiv">도시</div>
										<select name="dd" id="region" class ="joinBirthSel"></select>
									</div>
									
           	   					</div>
							</div>
						<div>
							<button>Wolrds</button>
						</div>
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