<%@page import="dto.MemberDto"%>
<%@page import="pds.PdsDto"%>
<%@page import="java.util.List"%>
<%@page import="pds.PdsDao"%>
<%@page import="pds.iPdsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
iPdsDao dao = PdsDao.getInstance();
List<PdsDto> list = dao.getPdsList();
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdslist.jsp</title>

<style type="text/css">
table.blueTable {
  border: 1px solid #1C6EA4;
  background-color: #EEEEEE;
  width: 80%;
  text-align: left;
  border-collapse: collapse;
}
table.blueTable td, table.blueTable th {
  border: 1px solid #AAAAAA;
  padding: 3px 2px;
  text-align: center;  
}
table.blueTable th {
	background-color: #0f0f0f;
	height: 40px;  
	color: white;
}
table.blueTable tbody td {
  font-size: 13px;
}
table.blueTable tr:nth-child(even) {
  background: #D0E4F5;
}
table.blueTable thead {
  background: #1C6EA4;
  background: -moz-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
  background: -webkit-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
  background: linear-gradient(to bottom, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
  border-bottom: 2px solid #444444;
}
table.blueTable thead th {
  font-size: 15px;
  font-weight: bold;
  color: #FFFFFF;
  border-left: 2px solid #D0E4F5;
}
table.blueTable thead th:first-child {
  border-left: none;  
}

table.blueTable tfoot {
  font-size: 14px;
  font-weight: bold;
  color: #FFFFFF;
  background: #D0E4F5;
  background: -moz-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);
  background: -webkit-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);
  background: linear-gradient(to bottom, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);
  border-top: 2px solid #444444;
}
table.blueTable tfoot td {
  font-size: 14px;
}
table.blueTable tfoot .links {
  text-align: right;
}
table.blueTable tfoot .links a{
  display: inline-block;
  background: #1C6EA4;
  color: #FFFFFF;
  padding: 2px 8px;
  border-radius: 5px;
}

</style>

<!-- 메뉴  -->
<link type="text/css" rel="stylesheet" href="../css/ui.css">

</head>
<body>

<%
MemberDto mem = (MemberDto)session.getAttribute("login");
%>

<h4 align="right" style="background-color: #f0f0f0">환영합니다 <%=mem.getId() %>님 반갑습니다</h4>

<ul>
	<li><a href="../bbslist_css.jsp">게시판</a></li>
	<li><a href="../calendar.jsp">일정관리</a></li>
	<li><a href="./pdslist.jsp">자료실</a></li>
</ul>
 
<hr>

<div align="center">

<table border="1" class="blueTable">
<col width="50"><col width="100"><col width="400"><col width="60">
<col width="50"><col width="80"><col width="100">

<tr>
	<th>번호</th><th>작성자</th><th>제목</th><th>다운로드</th>
	<th>조회수</th><th>다운로드수</th><th>작성일</th>
</tr>

<%
for(int i = 0;i < list.size(); i++){
	PdsDto pds = list.get(i);
	%>
	<tr align="center" height="5">
		<td><%=i+1 %></td>
		<td><%=pds.getId() %></td>
		<td align="left">
			<a href="pdsdetail.jsp?seq=<%=pds.getSeq() %>">
				<%=pds.getTitle() %>
			</a>
		</td>
		<td>
			<input type="button" name="btnDown" value="파일"
				onclick="location.href='../filedown?filename=<%=pds.getFilename() %>&seq=<%=pds.getSeq()%>'">
		</td>
		<td><%=pds.getReadcount() %></td>
		<td><%=pds.getDowncount() %></td>
		<td><%=pds.getRegdate() %></td>
	</tr>
	<%
}
%>
</table>
<br>
<a href="pdswrite.jsp">자료 올리기</a>

</div>

</body>
</html>



