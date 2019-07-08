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
	String str = request.getParameter("i1");
	out.println(str + "<br/>");

	str = request.getParameter("i2");
	out.println(str + "<br/>");
	
	str = request.getParameter("i3");
	out.println(str + "<br/>");
	
	str = request.getParameter("i4");
	out.println(str + "<br/>");
	
	str = request.getParameter("i5");
	out.println(str + "<br/>");
	
	str = request.getParameter("i6");
	out.println(str + "<br/>");
%>
</body>
</html>