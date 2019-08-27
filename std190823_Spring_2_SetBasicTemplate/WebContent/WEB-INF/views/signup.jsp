<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${alertMsg }

<h3>회원가입</h3>
<form action="dosignup">
	<table>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" id="inputId" name="id" placeholder="아이디입력">
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="text" id="inputPw" name="pw" placeholder="비밀번호입력">
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" id="inputName" name="name" placeholder="비밀번호입력">
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" id="inputEmail" name="email" placeholder="이메일입력">
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" id="doLogin" value="가입하기">			
			</td>
			<td>
				<input type="button" id="back" value="돌아가기" onclick="location.href='showlogin';">			
			</td>
		</tr>
	</table>
</form>

</body>
</html>