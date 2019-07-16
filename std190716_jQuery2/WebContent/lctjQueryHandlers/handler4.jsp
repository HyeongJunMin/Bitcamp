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
<h1>Handlers for radio and checkbox</h1>
<ul>
	<li><input type="radio" name="radio1" value="apple">사과</li>
	<li><input type="radio" name="radio1" value="pear">배</li>
	<li><input type="radio" name="radio1" value="banana" checked="checked">바나나</li>
</ul>
<input type="button" id="btn1" value="클릭">
<br>
<input type="checkbox" id="chk1">그림 그리기
<input type="checkbox" id="chk2">나도 그리기
<input type="button" id="btn2" value="go">

<script type="text/javascript">
$(document).ready(function(){
	//radio button
	$("#btn1").click(function(){
		//getter
		var rValue= $("input[name='radio1']:checked").val();
		alert("rValue : " + rValue);
	
		//setter
		$("input[name='radio1']").val(["pear"]);
	});
	//checkbox
	$("#btn2").click(function(){
		//getter
		var cValue = $("#chk1").is(":checked");
		var cValue2 = $("input:checkbox[id='chk1']").is(":checked");
		alert(cValue2);
		
		//setter
		if(cValue2 == true){
			$("#chk2").prop("checked", true);	
		}else{
			$("#chk2").prop("checked", false);
		}		
	});
});
</script>

</body>
</html>