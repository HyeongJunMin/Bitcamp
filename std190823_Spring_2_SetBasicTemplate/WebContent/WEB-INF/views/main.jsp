<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if( request.getAttribute("currId") != null ){
		%>
			${currId}님 어서오세요			
		<%		
	}else{
		%>
			guest			
		<%
	}
%>

</body>
</html>