<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap, jQuery CDN -->
<jsp:include page="../MVC2ELtag/templates/header.jsp"></jsp:include>
</head>
<body style="margin: 10px;">
<jsp:include page="./lct2ajaxmenu.jsp"></jsp:include>
<h1>AJAX 1</h1>
<p>Ajax : Asynchronous Javascript And Xml</p>
<p>AJAX는 jQuery 소속</p>
<input id="btn1" type="button" class="btn btn-primary" value="ajax1"/>
<br><br>
<p id="pAjax1"></p>

<script type="text/javascript">
$(function(){
	$("#btn1").click(function(){
		//data.html 파일을 로드해라
		//$("#pAjax1").load("data.html");
		
		//data.html에서 특정 부분만 가져와라
		//$("#pAjax1").load("data.html #data2");
		
		//data.jsp에서 스크립트릿의 parameter를 지정해서 특정 부분을 가져옴
		//$("#pAjax1").load("data.jsp", "t1=abc&t2=가나다");
		//$("#pAjax1").load("data.jsp", {t1:"bcd", t2:"나다라"} );
		
		//
		$("#pAjax1").load("data.jsp", function(data, status, xhr){
			$("#pAjax1").append("<br/>" + "data = " + data);
			$("#pAjax1").append("<br/>" + "status = " + status);
			$("#pAjax1").append("<br/>" + "xhr = " + xhr);
		} );
	});
});
</script>
</body>
</html>