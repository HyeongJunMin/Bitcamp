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

<p id="pAjax4"></p>
<input type="button" value="go" id="btnAjax4" class="btn btn-primary">

<script type="text/javascript">
$(function(){
	var arrXmlTarget = [];
	var arrXmlLink = [];
	var arrXmlName = [];
	
	$("#btnAjax4").click(function(){
		$.ajax({
			url: 'data_ajax4.xml'
			,datatype: 'xml'
			,success: function( dataVar ){
				var xmlRoot =$(dataVar).find("xmldata");//얘가 xml 루트태그
				var len = xmlRoot.find("news").length;//new태그 갯수

				for( i = 0 ; i < len ; i++ ){
					/* arrXmlTarget[i] = xmlRoot.find("news").eq(i).find("target").text();
					arrXmlLink[i] = xmlRoot.find("news").eq(i).find("link").text();
					arrXmlName[i] = xmlRoot.find("news").eq(i).find("name").text(); */
					arrXmlTarget[i] = xmlRoot.find("news").find("target").eq(i).text();
					arrXmlLink[i] = xmlRoot.find("news").find("link").eq(i).text();
					arrXmlName[i] = xmlRoot.find("news").find("name").eq(i).text();
					
					$("#pAjax4").append(arrXmlTarget[i] 
										+ ' ' + arrXmlLink[i]
										+ ' ' + arrXmlName[i] + '<br/>');
				}
			}, error: function(xhr, status, error){
				alert('error');
			}
		});
	});
});
</script>

</body>
</html>