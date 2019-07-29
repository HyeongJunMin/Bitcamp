<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="./templates/header.jsp"></jsp:include>

</head>
<script type="text/javascript" src="./static/js/signinview.js"></script>
<body>
<h3>Sign in</h3>

<form action="/6_CoffeeOrderSystemMVC2/coffee" id="SigninForm">
	<input type="hidden" id="commandInSigninView" value="signinIdChk" name="command">
	<table>
		<tr>
			<td colspan="2">
				ID : <input type="text" name="inputIdInSigninView" id="_inputIdInSigninView">
			</td>
		</tr>
		<tr>
			<td colspan="2">
			PW : <input type="text" name="inputPwInSigninView" id="_inputPwInSigninView">
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" id="btnSigninInSigninView" 
					value="Sign in">
			</td>	
			<td>
				<input type="button" id="btnSignupInSigninView" value="Sign up">
			</td>
		</tr>
	</table>	
</form>
<h3 id="txtResult"></h3>

</body>
</html>