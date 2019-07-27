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
<div>
ID : <input type="text" id="txt1">
<input type="button" id="btn1" value="find" class="btn btn-primary">
<input type="button" id="btn2" value="find" class="btn btn-primary">
<p id="result1"></p>
</div>
 
 <script type="text/javascript">
 $(function(){
	$("#btn1").click(function(){
		//alert('111');
		$.ajax({
			type: "get"
			, url: "work1Data.jsp"
			, datatype: "json"
			, success: function( data, status, xhr ){
				//alert( 'data:' + data + ', txt:' + $("#txt1").val() );
				var strData = (data + '').trim();
				//alert( 'strData:' + strData.trim() + ', txt:' + $("#txt1").val() );
				if( $("#txt1").val().trim() == strData ){
					$("#result1").text('정답. ' + strData);
				}else{
					$("#result1").text('오답.');
				}
			}, error: function(){
				alert('fail');
			}
		});
	});
	
	$("#btn2").click(function(){
		//alert('111');
		$.ajax({
			type: "get"
			, url: "work1Data.jsp"
			, data: "id=" + $("#txt1").val()
			, success: function( data ){
				//alert( 'data:' + data );
				$("#result1").text( data.trim() );
			}, error: function(){
				alert('fail');
			}
		});
	});
 });
 
 </script>
 
</body>
</html>