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
<a href="./lct1JSP1.jsp">lecture 1-1 JSP inner object, scriptlet</a><br/>
<a href="./lct1JSP2.jsp">lecture 1-2 JSP </a><br/>
<a href="./lct1JSP3.jsp">lecture 1-3 JSP inner object(2)</a><br/>
<a href="./lct1JSP4.jsp">lecture 1-4 JSP link to other page</a><br/>

<h1>Lecture 1 JSP 1 inner object, scriptlet</h1>
<p>scriptlet == java영역</p>
<%
	out.println("내장 객체 [out의 메소드 println]");
	out.println("<h3>out out out out </h3>");
	
	for(int i = 0 ; i < 5 ; i ++){
		%>
			<p>for loop p tag <%=(i+1) %>
				<%out.println(" !!!!!"); %>
			</p>
		<%
	}
%>
<p id="pTag1"></p>
<script type="text/javascript">
document.getElementById("pTag1").innerHTML = "also can use js";
</script>
</body>
</html>