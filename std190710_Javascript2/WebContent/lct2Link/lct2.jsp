<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="button" value="홈으로" onclick="moveHome()">&nbsp;&nbsp;&nbsp;
<input type="button" value="2교시 Link1" onclick="location.href = './link1.html'">&nbsp;&nbsp;&nbsp;
<input type="button" value="2교시 Link2" onclick="location.href = './link2.html'">&nbsp;&nbsp;&nbsp;
<br><br><h1>lct2 link.jsp</h1>
<%
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	
	out.println("name: " + name + ",  id: " + id);
%>
</body>
</html>