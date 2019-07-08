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
	String name = request.getParameter("inputName");
	String q1 = request.getParameter("q1");
	String[] q2 = request.getParameterValues("q2");
	String q3 = request.getParameter("q3");
	String q4 = request.getParameter("q4");
	
	out.println("name : " + name + "<br/>");
	out.println("q1 : " + q1 + "(1:예, 2:모름, 3:아니오)<br/>");
	out.println("q2 : <br/>");
	for(String str : q2){
		out.println(str + "&nbsp;");
	}
	out.println("<br/>");
	out.println("q3 : <pre>" + q3 + "</pre><br/>");
	out.println("q4 : " + q4 + "<br/>");
%>
</body>
</html>