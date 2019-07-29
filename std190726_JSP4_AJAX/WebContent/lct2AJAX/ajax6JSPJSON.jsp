<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap, jQuery CDN -->
<jsp:include page="../MVC2ELtag/templates/header.jsp"/>
</head>
<body>
<h3>JSP에서 AJAX로 JSON 데이터를 보내고</h3>
<h3>JSON 데이터를 받아오는 예제</h3>

보낼값1(valA) : <input type="text" id="valA">
<br>
보낼값2(valB) : <input type="text" id="valB">
<br><input type="button" value="보내기" id="btnSend">
<br>
받은값1(valC) : <input type="text" id="valC">
<br>
받은값2(valD) : <input type="text" id="valD">

<script type="text/javascript">
$(function(){
	$("#btnSend").click(function(){
		
		var valA = $("#valA").val();
		var valB = $("#valB").val();
		
		$.ajax({
			type: "GET"
			, url: "jspjsondata.jsp"
			, datatype: "json"
			, data: {"valA":valA, "valB":valB}
			, success: function( data ){
				alert('succeed : ' + data );
				
				//json data parsing
				var recv = JSON.parse( data.trim() );
				
				$("#valC").val('valA : ' + recv.valA);
				$("#valD").val('valB : ' + recv.valB);
				
			}, error: function( error ){
				alert('error : ' + error);
			}
		});
	});
});
</script>

</body>
</html>