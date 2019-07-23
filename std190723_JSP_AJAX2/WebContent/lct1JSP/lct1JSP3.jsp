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

<h4>내장 객체 : 동적 할당을 하지 않고 사용할 수 있는 클래스(class)</h4>
<%
	String name = request.getParameter("name");
	out.println("name = " + name + "<br/>");
	
	//checkbox, select
	String[] hob = request.getParameterValues("hobby");
	if( hob != null){
		for(int i = 0 ; i < hob.length ; i++){
			out.println("<br/>" + "hobby " + (i+1) + ": " + hob[i] );			
		}		
	}
%>
<br>
name : <input type="text" id="txtInput" size="8"><input type="button" id="btnInput" value="go">

<p id="pHob">select, checkbox</p>
<script type="text/javascript">
$("#btnInput").click(function(){
	var inputTxt = document.getElementById("txtInput").value;
	location.href="./lct1JSP3.jsp?name="+inputTxt;
});

$("#pHob").click(function(){
	location.href="./lct1JSP3.jsp?name=gg&hobby=painting&hobby=singing";
});
</script>

</body>
</html>