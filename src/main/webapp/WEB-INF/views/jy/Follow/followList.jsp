<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


</head>
<body>

	<div>

		<div>사용자결과영역</div>
		<div>${param.searchWord }</div>

		<c:if test="${sessionScope.OtherMember == null }">
			<div>
				<div>팔로우가 없습니다. 지금 팔로우하고 새로운 친구를 사귀어 볼까요?</div>
			</div>
		</c:if>
		
		
		
		<div>
			<c:forEach var="f" items="${follow_list }">
			
			<div><a onclick="location.href='profile/go/${f.user_ID}'">${f.user_ID}</a></div>
			<div>${f.user_nickName}</div>
			<div>${f.user_contents}</div>
			<hr>
				
			</c:forEach>
		</div>


	</div>

</body>
</html>