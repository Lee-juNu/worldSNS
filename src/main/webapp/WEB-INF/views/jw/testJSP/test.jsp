<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type = "text/javascript" src="resources/js/utill/jQuery.js"></script>
</head>

<body>
    <div>
        <input type="text" id="wsUserId" value=${sessionScope.user_ID } style="display: none;">
        <input type="text" id="wsRoomType" value="${roomNum} " style="display: none;">
        
        
        <input type="text" id="messageinput">
        
        <input type="file" id="inputFile" multiple="" data-max_length="4" >
    </div>
    <div>
        <button type="button" onclick="openSocket()">Open</button>
        <button type="button" onclick="jwSendWithFile()">Send</button>
        <button type="button" onclick="closeSocket()">Close</button>
        <button type="button" onclick="goFakeHome()">���ư���</button>
    </div>
    <!-- Server responses get written here -->
    <div id="messages"></div>
   
   
    <script type="text/javascript">
    function goFakeHome()
    {
    	location.href = 'fake.home';    	
    }
    
  </script>
  <script type = "text/javascript" src="resources/js/utill/jwServer.js"></script>
<script type = "text/javascript" src="resources/js/jw/tempServerUse.js"></script>
</body>
</html>