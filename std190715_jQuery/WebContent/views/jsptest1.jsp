<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="../index.html">go to home</a>
<h1>jsp test 1</h1>
<%
	String str = null;
	if( (str = request.getParameter("name1")) != null ){
		out.println(str);
%>
<%
	}else{
		out.println("없어요");
	}
%>
</body>
</html>