<%@page import="dto.MemberDto"%>
<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@page import="dao.iBbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>answer.jsp</title>
<link rel="stylesheet" type="text/css" href="./css/style3.css">

<style type="text/css">
h1{	
	background-color: #f0f0f0;
}
</style>

</head>
<body>

<a href="logout.jsp">로그 아웃</a>

<%
String sseq = request.getParameter("seq");
int seq = Integer.parseInt(sseq.trim());

iBbsDao dao = BbsDao.getInstance();
BbsDto bbs = dao.getBbs(seq);

request.setAttribute("_bbs", bbs);
%>

<h1>부모글</h1>
<div align="center">

<table border="2">
<col width="200"><col width="500">

<tr>
	<th>작성자</th>
	<%-- <td><%=bbs.getId() %></td> --%>
	<td>${_bbs.id }</td>
</tr>

<tr>
	<th>제목</th>
	<td>${_bbs.title }</td>
</tr>

<tr>
	<th>작성일</th>
	<td>${_bbs.wdate }</td>
</tr>

<tr>
	<th>조회수</th>
	<td><%=bbs.getReadcount() %></td>	
</tr>

<tr>
	<th>정보</th>
	<td><%=bbs.getRef() %>-<%=bbs.getStep() %>-<%=bbs.getDepth() %></td>
</tr>

<tr>
	<th>내용</th>
	<td>
		<textarea rows="10" cols="70"><%=bbs.getContent() %></textarea>
	</td>
</tr>
</table>

<hr>

<%
Object ologin = session.getAttribute("login");
MemberDto mem = (MemberDto)ologin;
%>

<h1 align="left">답글</h1>

<form action="answerAf.jsp" method="post">
<input type="hidden" name="seq" value="<%=bbs.getSeq() %>">

<table border="1">
<col width="200"><col width="500">

<tr>
	<th>아이디</th>
	<td>
		<input type="text" name="id" readonly="readonly" size="50"
			value="<%=mem.getId() %>">
	</td>
</tr>

<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" size="50">
	</td>
</tr>

<tr>
	<th>내용</th>
	<td>
		<textarea rows="10" cols="70" name="content"></textarea>
	</td>
</tr>

<tr>
	<td colspan="2" align="center">
		<input type="submit" value="답글추가">
	</td>
</tr>

</table>
</form>

<a href="bbslist.jsp">글목록</a>
</div>

</body>
</html>







