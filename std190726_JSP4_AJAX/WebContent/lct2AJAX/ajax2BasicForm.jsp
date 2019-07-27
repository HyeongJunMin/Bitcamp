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

<h3>AJAX 2</h3>

<input type="button" class="btn btn-primary" id="btn1" value="connect">

<p id="pAjax2"></p>


<script type="text/javascript">

$(function(){
	$("#btn1").click(function(){
		$.ajax({
			///////////////보내 줄 정보 세팅 부분/////////////
			//데이터를 가져 올 대상(목적지)
			url: "data.jsp"
			//메소드 지정(GET/POST)
			,type: "get"
			//보내 줄 값(목적지에서 getParameter로 받을 값)
			,data: {t1: "bcd" , t2: "나다라" } 
			///////////////////////////////////////////
			
			///////////////받아 올 정보 세팅 부분/////////////
			,success: function(data, status, xhr){
				alert('통신 성공');
				$("#pAjax2").html(data);
				 
			}
			,error: function(xhr, status, error){
				alert('통신 에러');
			}
			//종종 생략되는 부분
			,complete:function(xhr, status){
				alert('통신 종료');
			}
		});
	});
});

</script>

</body>
</html>