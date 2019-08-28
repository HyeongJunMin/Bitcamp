<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

<h3>회원가입</h3>
<form action="insertmember.do">
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
				<input type="password" id="inputPw" name="pw" placeholder="비밀번호입력">
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" id="inputName" name="name" placeholder="이름 입력">
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
				<input type="button" id="back" value="돌아가기" onclick="location.href='showlogin.do';">			
			</td>
		</tr>
	</table>
</form>
<p id="signupWarn"></p>
<script type="text/javascript">
$(function(){
	$("#doLogin").attr("disabled", true);
	
	$("#inputId").keyup(function(){
		var inputId = $("#inputId").val().trim();
		
		
		$.ajax({
			url:"bbsidchk.do",
			type:"POST",
			data:"id=" + inputId,
			success:function(data){
				
				if(data > 0){
					$("#signupWarn").html('회원가입이 가능한 아이디입니다.');
					$("#doLogin").removeAttr("disabled");
				}else{
					$("#signupWarn").html('중복된 아이디입니다. 다른 아이디를 사용해 주세요.');
					$("#doLogin").attr("disabled", true);
				}
				
			}, error:function(r, s, err){
				alert('error');
			}
		});	
		
	});
});
</script>
</body>
</html>