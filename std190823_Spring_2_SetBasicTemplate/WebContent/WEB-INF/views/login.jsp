<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<form action="dologin">
	<table>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" id="inputId" placeholder="아이디입력">
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="text" id="inputPw" placeholder="비밀번호입력">
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" id="goSignup" value="회원가입" onclick="location.href='showsignup';">
			</td>
			<td>
				<input type="submit" id="doLogin" value="로그인">			
			</td>
		</tr>
	</table>
</form>
<script type="text/javascript">

</script>
</body>
</html>