<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<form action="setting.go.Password3">
		<div>

			<div>새로운 비밀번호 입력</div>

			<div>
				<input name="settingPassword2">
			</div>
			<div>
				<button>다음으로</button>
			</div>
	<input name="settingPassword1"  type="hidden"  value="${param.settingPassword1 }">
				
		</div>
	</form>


</body>
</html>