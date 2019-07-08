<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// scriptlet = script + applet
// Java 영역
System.out.println("NewFile.jsp로 이동되었음");
// request(요청)
// response(응답)
String id = request.getParameter("id");
System.out.println("id = " + id);
String pwd = request.getParameter("pwd");
System.out.println("password = " + pwd);
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



</body>
</html>