<%@page import="dto.CalendarDto"%>
<%@page import="dao.CalendarDao"%>
<%@page import="dao.iCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
table.type01 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    margin : 20px 10px;
}
table.type01 th {
    /* width: 150px; */
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border: 1px solid #ccc;
    text-align: center;   
    background-color: #333333;
    color: #fff; 
}
table.type01 td {
    /* width: 350px; */
    padding: 10px;
    vertical-align: top;
    border: 1px solid #ccc;
    background-color: #f0f0f0;
}
</style>
</head>
<body>

<%
String sseq = request.getParameter("seq");
int seq = Integer.parseInt(sseq);

iCalendar dao = CalendarDao.getInstance();
CalendarDto dto = dao.getDay(seq);

String year = dto.getRdate().substring(0, 4);
String month = dto.getRdate().substring(4, 6);
String day = dto.getRdate().substring(6, 8);
String hour = dto.getRdate().substring(8, 10);
String minute = dto.getRdate().substring(10, 12);

String time = String.format("%s년 %s월 %s일 %s시 %s분", year, month, day, hour, minute);
%>

<h1>일정 보기</h1>
<hr>

<div align="center">

<table class="type01">
<col width="200"><col width="500">

<tr>
	<th>아이디</th>
	<td><%=dto.getId() %></td>
</tr>

<tr>
	<th>제목</th>
	<td><%=dto.getTitle() %></td>
</tr>

<tr>
	<th>작성일</th>
	<td><%=dto.getWdate() %></td>
</tr>

<tr>
	<th>일정</th>
	<td><%=time %></td>
</tr>

<tr>
	<th>내용</th>
	<td>
		<textarea rows="20" cols="60" readonly="readonly"><%=dto.getContent() %>
		</textarea>
	</td>
</tr>

<tr>
	<td colspan="2" align="center">
		<input type="button" value="수정" onclick="location.href='calupdate.jsp?seq=<%=dto.getSeq() %>'">
		<input type="button" value="삭제" onclick="location.href='caldel.jsp?seq=<%=dto.getSeq() %>'">
	</td>
</tr>

</table>

</div>

</body>
</html>