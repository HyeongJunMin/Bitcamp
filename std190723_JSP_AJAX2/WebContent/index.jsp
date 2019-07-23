<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>190723 home</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<h1>190723 HOME!</h1>

<a href="./lct1JSP/lct1JSP1.jsp">Lecture 1 JSP</a>
<a href="./work/work1-1.jsp">JSP work1-1</a>

<%
//java 영역 == scriptlet == script + applet
	request.getParameter("");
%>

<img alt="" src="D:/min/블로그자료/css_elements_level.PNG">


<script type="text/javascript">
$("h1").click(function(){
	alert('ok jQuery ' + this);
});
</script>
</body>
</html>