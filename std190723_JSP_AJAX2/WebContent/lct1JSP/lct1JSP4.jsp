<%@page import="model.dto.Human"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	void printPTag(){
		System.out.println("<p>jQuery call</p>");
	}
	String test = "123";
%>
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
<h1>lecture 1-4 JSP link to other page</h1>
<%
	//request attr, forward 활용 페이지 이동
	
	//전달 객체 설정
	Human hum = new Human(0,"human1");
	//request.setAttribute("human", hum);
	
	//페이지 이동
	//pageContext.forward("lct1JSP4dest.jsp");
	
	//다른 이동 방법 request.getRequestDispatcher("lct1JSP4dest.jsp").forward(request, response);
%>
<%
	//session 활용 페이지 이동
	//session 설정
	//request.getSession().setAttribute("human", hum);
	//response.sendRedirect("lct1JSP4dest.jsp");
%>
<input type="button" value="home" id="btnMove1"/>
<input type="text" value="<%=test %>" id="txtTest1"/>
<script type="text/javascript">
$("#btnMove1").click(function(){
	alert('<%=hum %>');
});

</script>
</body>
</html>