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
<a href="./handler4.jsp">handler4</a><br>
mousein, mouseout, dblclick, hover, hide, show, toggle
<p id="efef">가나다</p>


<div align="center">
	<input type="button" value="hide" id="hideBtn">
	<input type="button" value="show" id="showBtn">
	<input type="button" value="switch" id="toggleBtn"><br><br>
	<div class="innerDiv1" style="background: green; width: 50%; height: 100px; text-align: center">
		
	</div>
</div>

<script type="text/javascript">
$(function() {
	$("#hideBtn").click(function() {
		$(".innerDiv1").hide(1000);
	});
	$("#showBtn").click(function() {
		$(".innerDiv1").show(1000);
	});
	$("#toggleBtn").click(function() {
		$(".innerDiv1").toggle(100);
	});
	
/* 	
 	$(".innerDiv1").mouseenter(function() {
		$(this).css("background","#000000");
	});
	$(".innerDiv1").mouseleave(function() {
		$(this).css("background","#ffffff");
	}); 
*/
	$(".innerDiv1").hover(function() {
		$(this).css("background","#ffffff");
	},	function() {
		$(this).css("background","green");
	}	);
});
</script>
</body>
</html>