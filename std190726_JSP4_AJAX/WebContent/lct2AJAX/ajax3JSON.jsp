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

<p id="pAjax3"></p>
<input type="button" value="go" id="btnAjax3" class="btn btn-primary">

<script type="text/javascript">
$(function(){
	$("#btnAjax3").click(function(){
		$.ajax({
			type:'get'
			,url: './member.json'
			,success: function( json ){
				alert('success' + '  ' + json[0].name);
				for(i = 0 ; i < json.length ; i++){
					$("#pAjax3").append(json[i].name + ' '
										+ json[i].age + ' '
										+ json[i].add + ' '
										+ json[i].phone + ' <br/>');
				}
				$.each(json, function( index, item ){
					$("#pAjax3").append(index + ' '
							+ item.name + ' '
							+ item.age + ' '
							+ item.add + ' '
							+ item.phone + ' <br/>');
				});
			}, error: function(xhr, status, error){
				alert('error');
			}
		});
	});
});
</script>

</body>
</html>