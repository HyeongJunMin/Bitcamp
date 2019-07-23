<%@page import="model.dto.Human"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Human recvHum = (Human)request.getAttribute("human");

	recvHum = (Human)request.getSession().getAttribute("human");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Destination page of lct1JSP4</h1>
<%
	if( recvHum != null ){
		out.println(recvHum.toString());	
	}	
%>
</body>
</html>