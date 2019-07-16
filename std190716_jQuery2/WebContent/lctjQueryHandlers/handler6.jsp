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
<h1>Create Element</h1>

<p>sdofijsodfijsodifj</p>
<p>sdo123123123123123fijsodfijsodifj</p>
<br>
<ol>
	<li>사과</li><li>배</li><li>바나나</li>
</ol>
<br>
<select id="food">
	<option value="burger">버거</option>
	<option value="chicken">치킨</option>
	<option value="pizza">피자</option>
</select>
<br><br>
<input type="button" id="btn1" value="add text(right)">
<input type="button" id="btn2" value="add text(left)">
<input type="button" id="btn3" value="add tag">

<script type="text/javascript">
$(function () {
	$("#btn1").click(function(){
		//$("p").append("<br>add text(append)");
		//$("ol").append("<li>orange</li>");
		$("select").append("<option value='pasta'>파스타</option>");
	});
	$("#btn2").click(function(){
		//$("p").prepend("add text(prepend)<br>");
		//$("ol").prepend("<li>grape</li>");
		$("select").prepend("<option value='dbk'>떡볶이</option>");
	});
	
	$("#btn3").click(function(){
		//html
		var txt1 = "<p>add text by html</p>";
		$("body").append(txt1);
		
		//javascript
		var txt2 = document.createElement("p");
		txt2.innerHTML = "add text by javascript";
		$("body").append(txt2);
		
		//jQuery
		var txt3 = $("<p></p>").text("add text by jQuery");
		$("body").append(txt3);
	});
});
</script>

</body>
</html>