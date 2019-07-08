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
	String str[] = request.getParameterValues("chk");
	
	for(String s : str)
		out.println(s + "<br/>");
%>
</body>
</html>