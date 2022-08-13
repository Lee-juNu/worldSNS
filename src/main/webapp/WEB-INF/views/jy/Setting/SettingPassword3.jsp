<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<form action="setting.go.Password4">
		<div>

			<div>새로운 비밀번호 확인</div>

			<div>
				<input name="settingPassword3">
			</div>
			<div>
				<button>다음으로</button>
				
				<input name="settingPassword2" type="hidden" value="${param.settingPassword2 }">
				
				
			</div>

		</div>
	</form>


</body>
</html>