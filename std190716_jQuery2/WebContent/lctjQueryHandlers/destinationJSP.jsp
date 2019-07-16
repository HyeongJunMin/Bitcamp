<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//데이터를 받아주는 Java 영역 : Scriptlet
	String name = null;
	if( (name =  request.getParameter("inputId_name")) != null ){
		out.println(name);
	}
	
	Integer age = null;
	String address = null;
	
	if( (name =  request.getParameter("inputName")) != null &&
		(age = new Integer(Integer.parseInt( request.getParameter("inputAge")+"" ))) != null &&
		(address =  request.getParameter("inputAddress")) != null ){
		out.println("name : " + name + ", age : " + age + ", add : " + address);
	}
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