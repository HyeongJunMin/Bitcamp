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
	session.invalidate();
	response.sendRedirect("http://localhost:8090/std190730_JSP6_BBS_reply/bbs?command=showbbslist");
%>
</body>
</html>