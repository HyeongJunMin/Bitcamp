<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<a href="../index.jsp">Go To Home</a><br/>
<a href="./work1-1.jsp">work1-1</a><br/>
<a href="./work1-2.jsp">work1-2</a><br/>
<a href="./work1-3.jsp">work1-3</a><br/>
<%
	Date d = new Date();
	int hour = d.getHours();
	out.println("<h1>Hello World!</h1>");
	out.println("<p>Hello World!</p>");
	out.println("<p>현재시간은 " + d.toString() + " 입니다.</p>");
	out.println("<p>현재시간은 <b>" + hour + "시</b>입니다.</p>");
	String str = "";
	if(hour < 10){
		str = "안녕히 주무셨어요?";
	}else if(hour > 20){
		str = "안녕히 주무세요.";
	}else{
		str = "안녕하세요?";
	}
	out.println("<p><b>" + str + "</b></p>");
%>
</body>
</html>