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
<body style="margin: 10px;">
<jsp:include page="./lct2ajaxmenu.jsp"/>

<p id="pAjax5"></p>
<input type="button" id="btnAjax5" value="from jsp" class="btn btn-primary">

<script type="text/javascript">

$(function(){
	$("#btnAjax5").click(function(){
		$.ajax({
			type: "get"
			, url: "dataFac.jsp"
			, datatype: "json"
			, success: function( obj ){
				alert('success');
				
				//String을 JSON으로 변환
				var jsonData = JSON.parse( obj );
				alert(jsonData.num);
				
				var jsonStr = JSON.stringify( jsonData );
			}, error: function(){
				alert('fail');
			}
		});
	});
});
</script>

</body>
</html>