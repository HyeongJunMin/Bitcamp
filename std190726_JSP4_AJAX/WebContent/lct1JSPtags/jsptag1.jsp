<%@page import="com.model.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>JSP tags</h3>
<a href="../index.jsp">go to home</a><br>

<h3>1. JSP include 태그</h3>
<jsp:include page="/MVC2ELtag/userlist.jsp" flush="false"/>

<h3>2. JSP forward 태그</h3>
<pre>
jsp:forward page="NewFile.jsp"/
</pre>

<%
	MemberDto memmem = new MemberDto();
	memmem.setMessage("hi");
	String msg = memmem.getMessage();
	request.setAttribute("memberAttr", memmem);
%>

3. jsp태그를 통한 객체 생성<br>
<jsp:useBean id="dto" class="com.model.dto.MemberDto"/>
<jsp:setProperty property="message" name="dto" value="hi jspBean" />
 property : 변수명(필드), name : 인스턴스, value : 값 <br>
 setAttr의 메시지 : ${memberAttr.message } <br>
  useBean의 메시지 : ${dto.message }
  <br><br>
  

</body>
</html>