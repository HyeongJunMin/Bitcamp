<%@page import="bit.com.a.model.MyClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello!</h1>
<p>attr 받아오기</p>
<p>1번 방법 스크립트릿</p>
<%
	MyClass cls = (MyClass)request.getAttribute("mycls");
%>
number:<%=cls.getNumber() %>
<br/>
name:<%=cls.getName() %>
<br/>
<p>2번 방법 EL tag</p>
number: ${mycls.number }
<br/>
name: ${mycls.name }
<br/><br/>

<p>뷰에서 컨트롤러로 보내기</p>
<form action="inputData.do">
번호:<input type="text" name="number"/>
이름:<input type="text" name="name"/>
<input type="submit" value="전송">
</form>

<br>
<p>컨트롤러에서 컨트롤러로 이동하기</p>
<form action="move.do">
<input type="submit" value="move">
</form>
</body>
</html>