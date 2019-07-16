<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<a href="../index.html">Go to Home</a>
<a href="./handler1.jsp">handler1</a>
<a href="./handler2.jsp">handler2</a>
<a href="./handler3.jsp">handler3</a>
<a href="./handler4.jsp">handler4</a>
<a href="./handler5.jsp">handler5</a>
<h1>How to make link to another page 2</h1>
<br>
이름 : <input type="text" id="inputName"><br>
나이 : <input type="text" id="inputAge"><br>
주소 : <input type="text" id="inputAddress"><br>
<input type="button" id="btnGo" value="go"><br>

<form id="form1">
	이름 : <input type="text" name="inputName"><br>
	나이 : <input type="text" name="inputAge"><br>
	주소 : <input type="text" name="inputAddress"><br>
	<input type="button" id="btnGo2" value="go"><br>
</form>


<script type="text/javascript">
$(function(){
	$("#btnGo").on("click", function(){
		 location.href="destinationJSP.jsp?inputName=" + $("#inputName").val()
								+ "&inputAge=" + $("#inputAge").val() +
								+ "&inputAddress=" + $("#inputAddress").val();  
	//	alert(  $("#inputAge").val()  );
	});
	
	//폼 어트리뷰트로 값 모아서 보내기
	$("#btnGo2").click(function(){
		$("#form1").attr("action", "destinationJSP.jsp").submit();
	});
});
</script>
</body>
</html>