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
<h1>How to make link to another page</h1>
<div id="formDiv1">
	<form action="./destinationJSP.jsp">
		ID : <input type="text" name="inputId_name" id="inputId_id">
		<input type="submit" value="Submit">
	</form>
</div>
<div id="formDiv1">
	<form action="./destinationJSP.jsp">
		ID : <input type="text" name="inputId_name" id="inputId_id2">
		<input type="button" value="jsSubmit" id="jsSubmit_id" onclick="f1()">
	</form>
</div>
<div id="formDiv2">
	<form action="./destinationJSP.jsp">
		ID : <input type="text" name="inputId_name" id="inputId_id3">
		<input type="button" value="jqSubmit" id="jqSubmit_id">
	</form>
</div>

<script type="text/javascript">
function f1(){
	var id = document.getElementById("inputId_id2").value;
	location.href = "destinationJSP.jsp?inputId_name=" + id;
}
$(function() {
	$("#jqSubmit_id").click(function(){
		var inputId = $("#inputId_id3").val();
		location.href = "destinationJSP.jsp?inputId_name=" + inputId;
	});	
});



</script>
</body>
</html>