<%@page import="java.util.Date"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberDto user = (MemberDto)session.getAttribute("login");

// 시간을 취득
// String fname = (new Date().getTime() + "");
// System.out.println("fname:" + fname);

// mydata.txt -> 1564623619593.txt
// 1564623619593.txt -> 다운로드끝 -> mydata.txt

%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdswrite.jsp</title>
</head>
<body>

<%-- 
	주의사항 : 같은 파일명이 업로드 될수 있다. 
			주로 사용되는 방법은 Date().getTile()			
			한글명은 사용하지 말것.
--%>

<h1>자료 올리기</h1>

<div align="center">

<%--
	id,	title, content -> String	-> form field
	file -> byte
 --%>

<form action="pdsupload.jsp" method="post" enctype="multipart/form-data">

<table border="1">
<col width="200"><col width="500">

<tr>
	<th>아이디</th>
	<td><%=user.getId() %>
		<input type="hidden" name="id" value="<%=user.getId() %>">
	</td>
</tr>
<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" size="50">
	</td>
</tr>

<tr>
	<th>파일업로드</th>
	<td>
		<input type="file" name="fileload" style="width:400px">
	</td>
</tr>

<tr>
	<th>내용</th>
	<td>
		<textarea rows="20" cols="50" name="content"></textarea>
	</td>
</tr>

<tr align="center">
	<td colspan="2">
		<input type="submit" value="자료 올리기">
	</td>
</tr>

</table>

</form>

</div>


</body>
</html>



