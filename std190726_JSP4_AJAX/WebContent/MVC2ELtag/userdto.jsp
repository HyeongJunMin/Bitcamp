<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	List<String> lst = new ArrayList<>();
	lst.add("11");
	lst.add("22");
	request.setAttribute("list", lst);
%>
<jsp:forward page="./userlist.jsp"></jsp:forward>
</body>
</html>