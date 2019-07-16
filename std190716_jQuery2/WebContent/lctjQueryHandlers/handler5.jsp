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
<h1>Common tags handlers</h1>
<p id="p1">asdasdasd<b>asasdasd</b>asdassda</p><br>
<input type="button" value="txt" id="btn1">
<input type="button" value="txt" id="btn2">
<input type="text" placeholder="result" id="result1">

<script type="text/javascript">
$(document).ready(function(){
	$("#btn1").click(function(){
		var txt = $("#p1").text();
		$("#result1").val(txt);
	});
	$("#btn2").click(function(){
		var html = $("#p1").html();
		$("#result1").val(html);
	});
});
</script>
<br><br><br>
<!-- attr 접근 -->
<p>
	<a href="http://www.naver.com" id="naverLink">네이버</a>
</p>
<input type="button" value="txt" id="btnAttr">
<input type="text" placeholder="result" id="result2">
<script type="text/javascript">
$(function(){
	$("#btnAttr").on("click", function(){
		//getter
		var v = $("#naverLink").attr("href");
		$("#result2").val(v);
		
		//setter
		$("#naverLink").attr("href", "http://www.daum.net");
		$("#naverLink").text("다음");
	});
});
</script>

</body>
</html>