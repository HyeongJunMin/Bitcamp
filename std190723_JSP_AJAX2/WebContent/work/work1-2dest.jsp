<%@page import="java.util.HashMap"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="./work1-2.jsp">go back</a>
<h5>--사용자의 입력을 출력한다--</h5>

<%
	HashMap<String, String> hm = new HashMap<String, String>();
	Enumeration enumParam = request.getParameterNames();
	while( enumParam.hasMoreElements() ){
		String key = enumParam.nextElement() + "";
		hm.put(key, request.getParameter(key));
	}
	String name = hm.get("inputName");
	String birth = hm.get("inputBirth");
%>

<ul>
	<li>이름 : <%=name %></li>
	<li>생년월일 : <%=birth %></li>
</ul>
</body>
</html>