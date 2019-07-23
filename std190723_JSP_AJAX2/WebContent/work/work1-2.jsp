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
<a href="../index.jsp">Go To Home</a><br/>
<a href="./work1-1.jsp">work1-1</a><br/>
<a href="./work1-2.jsp">work1-2</a><br/>
<a href="./work1-3.jsp">work1-3</a><br/>
<h5>입력 페이지</h5>
<form action="">
	이름 : <input type="text" name="inputName" id="inputN"><br/>
	생년월일 : <input type="text" name="inputBirth" id="inputB"><br/>
	<input type="button" value="OK" id="btnGo">
</form>

<script type="text/javascript">
$("#btnGo").click(function(){
	location.href="./work1-2dest.jsp?inputName=" + $("#inputN").val()
					+ "&inputBirth=" + $("#inputB").val();
});
</script>

</body>
</html>