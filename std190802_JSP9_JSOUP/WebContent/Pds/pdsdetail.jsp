<%@page import="pds.PdsDao"%>
<%@page import="pds.iPdsDao"%>
<%@page import="pds.PdsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String sseq = request.getParameter("seq");
int seq = Integer.parseInt(sseq);

iPdsDao dao = PdsDao.getInstance();
// readcount
dao.pdsReadCount(seq);
PdsDto pds = dao.getPds(seq);

request.setAttribute("_pds", pds);
%>
    
<!DOCTYPE html>
<html>
<head>
<title>pdsdetail.jsp</title>
</head>
<body>

<h2>자료 상세 내용</h2>

<div align="center">

<table border="1">
<col width="200"><col width="500">

<tr>
	<td>게시자</td>
	<td><%=pds.getId() %></td>
	<%-- <td>${_pds.id }</td> --%>
</tr>

<tr>
	<td>제목</td>
	<td>${_pds.title }</td>
</tr>

<tr>
	<td>다운로드</td>
	<td>
		<input type="button" name="btnDown" value="파일"
			onclick="location.href='../filedown?filename=<%=pds.getFilename() %>&seq=<%=pds.getSeq() %>'"/>  
	</td>
</tr>

<tr>
	<td>조회수</td>
	<td>${_pds.readcount }</td>
</tr>

<tr>
	<td>다운수</td>
	<td><%=pds.getDowncount() %></td>
</tr>

<tr>
	<td>파일명</td>
	<td><%=pds.getFilename() %></td>
</tr>

<tr>
	<td>등록일</td>
	<td><%=pds.getRegdate() %></td>
</tr>

<tr>
	<td>내용</td>
<td>
<textarea rows="20" cols="50" 
readonly="readonly"><%=pds.getContent() %>
</textarea>
</td>
</tr>

</table>
 </div>

<!-- 삭제 -->
<input type="button" value="삭제"
			 onclick="location.href='pdsdel.jsp?pdsseq=<%=pds.getSeq()%>&pdsid=<%=pds.getId()%>'"/>

<input type="button" value="수정"
			 onclick="location.href='pdsupdate.jsp?pdsseq=<%=pds.getSeq()%>'"/>



</body>
</html>





