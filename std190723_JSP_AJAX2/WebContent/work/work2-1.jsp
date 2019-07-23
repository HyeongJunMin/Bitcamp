<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! int glnum = 0 ; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="../index.jsp">Go To Home</a><br/>
<a href="./work2-1.jsp">work2-1</a><br/>
<a href="./work2-2.jsp">work2-2</a><br/>
<a href="./work2-3.jsp">work2-3</a><br/>
<%
	out.println("<h3>glnum : " + glnum + "</h3>");
	glnum++;
%>
<h3>구구단</h3>
<table border="1">
<%
	for(int i = 1 ; i < 10 ; i ++){
		out.println("<tr>");
		for(int j = 1 ; j < 10 ; j ++){
			out.println("<td>" + i + "*" + j + "=" + (i*j) + "</td>");
		}
		out.println("</tr>");
	}
%>
</table>

</body>
</html>