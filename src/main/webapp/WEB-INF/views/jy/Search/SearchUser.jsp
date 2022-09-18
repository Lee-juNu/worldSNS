<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



</head>
<body>

	<div>

		<div>사용자결과영역</div>
		<div>${param.searchWord }</div>

		<c:if test="${sessionScope.OtherMember == null }">
			<div>
				<div>검색 결과가 없습니다.</div>
			</div>
		</c:if>






		<%-- <c:if test="${sessionScope.OtherMember != null }">
 --%>
		<c:forEach var="otherMember" items="${otherMember}">
			<div>
				<a href="${otherMember.user_ID}">

					<div><img width="50px" height="50px" alt="" src="resources/img/profile/${findUser.user_ID}/photo.png"
		onerror="this.onerror=null; this.src='resources/img/profile/s.png';"/> </div>
					<div>${otherMember.user_ID}</div>
					<div>${otherMember.user_nickName}</div>
					<div>${otherMember.user_contents}</div>
					<hr>
				</a>
			</div>
		</c:forEach>
		<%-- </c:if> --%>


	</div>


</body>
</html>