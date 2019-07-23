<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int visitTimes = 0;	
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
<a href="./work2-1.jsp">work2-1</a><br/>
<a href="./work2-2.jsp">work2-2</a><br/>
<a href="./work2-3.jsp">work2-3</a><br/>
<h3>Check visit times with session in JSP</h3>
<h6>Count : <%=visitTimes %></h6>

<%
	HttpSession ses = request.getSession();
	
	if( ses.getAttribute("visitTimes") == null ){
		out.println("첫 방문");
		ses.setAttribute("visitTimes", 1);
	}else{
		visitTimes = Integer.parseInt(ses.getAttribute("visitTimes")+"");
		out.println("첫 방문 아님" + visitTimes);
		visitTimes++;
		ses.setAttribute("visitTimes", visitTimes);
	}
	
	//ses.invalidate();
	//visitTimes = 0;
%>
</body>
</html>