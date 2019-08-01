<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@page import="dao.iBbsDao"%>
<%@page import="dao.MemberDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String sseq = request.getParameter("seq");
int seq = Integer.parseInt(sseq);
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bbsdetail.jsp</title>

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
}
table.type01 td {
    /* width: 350px; */
    padding: 10px;
    vertical-align: top;
    border: 1px solid #ccc;
}
</style>


</head>
<body>

<%
Object ologin = session.getAttribute("login");
MemberDto mem = (MemberDto)ologin;
%>

<%
iBbsDao dao = BbsDao.getInstance();
BbsDto bbs = dao.getBbs(seq);

// readcount 갱신
dao.readcount(seq);
%>

<h1>상세 글 보기</h1>

<div align="center">

<table border="1" class="type01">
<col width="150"><col width="600">

<tr>
	<th>작성자</th>
	<td><%=bbs.getId() %></td>
</tr>

<tr>
	<th>제목</th>
	<td><%=bbs.getTitle() %></td>
</tr>

<tr>
	<th>작성일</th>
	<td><%=bbs.getWdate() %></td>
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
<td align="center">
<textarea rows="10" cols="90" readonly="readonly"
><%=bbs.getContent() %></textarea>
</td>
</tr>

</table>


<table>
<col width="300"><col width="300">
<tr>
	<td>
	<form action="answer.jsp" method="get">
	<input type="hidden" name="seq" value="<%=bbs.getSeq() %>">
	<input type="submit" value="댓글">
	</form>
	</td>
	<td>
	<%
	if(bbs.getId().equals(mem.getId())){
		%>
		<button type="button" onclick="deleteBbs('<%=bbs.getSeq() %>')">삭제</button>
		<button type="button" onclick="updateBbs('<%=bbs.getSeq() %>')">수정</button>
		<%
	}
	%>	
	</td>
</tr>
</table>



</div>

<a href="bbslist.jsp">글목록</a>

<script type="text/javascript">
function deleteBbs( seq ) {
	location.href = "bbsdelete.jsp?seq=" + seq;
}
function updateBbs( seq ) {
	location.href = "bbsupdate.jsp?seq=" + seq;
}

</script>

</body>
</html>









