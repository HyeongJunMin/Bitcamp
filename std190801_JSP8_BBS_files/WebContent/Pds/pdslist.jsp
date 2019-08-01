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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Bootstrap, jQuery CDN -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"></link>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"></link>

<style type="text/css">
table.type02 {
    border-collapse: separate;
    border-spacing: 0;
    text-align: left;
    line-height: 1.0;
    border-top: 1px solid #ccc;
    border-left: 1px solid #ccc;
  	margin : 20px 10px;
}
table.type02 th {
    /* width: 150px; */
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    border-top: 1px solid #fff;
    border-left: 1px solid #fff;
    background: #eee;
    text-align: center;
}
table.type02 td {
    /* width: 350px; */
    padding: 10px;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
}
</style>

<!-- 메뉴  -->
<link type="text/css" rel="stylesheet" href="../css/ui.css">
</head>
<body>

<%
Object ologin = session.getAttribute("login");
MemberDto mem = null;
if(ologin == null){
	%>
	<script type="text/javascript">
	alert("로그인 해 주십시오");
	location.href = "login.jsp";
	</script>
	<%
}
mem = (MemberDto)ologin;
%>

<h4 align="right" style="background-color: #f0f0f0">환영합니다 <%=mem.getId() %>님 반갑습니다</h4>

<!-- 
<h1>게시판</h1>
 -->

<ul>
	<li><a href="../bbslist_css.jsp?pageNum=1">게시판</a></li>
	<li><a href="../calendar.jsp">일정관리</a></li>
	<li><a href="./pdslist.jsp">자료실</a></li>
</ul>
 
<hr>

<div align="center">

<table border="1" class="type02">
<col width="70"><col width="100"><col width="400"><col width="90">
<col width="80"><col width="110"><col width="150">

<tr height="35">
	<th>번호</th>
	<th>작성자</th>
	<th>제목</th>
	<th>다운로드</th>
	<th>조회수</th>
	<th>다운로드수</th>
	<th>작성일</th>	
</tr>
<%
	for( int i = 0 ; i < list.size() ; i++ ){
		PdsDto dto = list.get(i);
		%>
			<tr align="center" height="5" class="seqclick">
				<td><%=i+1 %></td>
				<td><%=dto.getId() %></td>
				<td align="left">
					<a href="pdsdetail.jsp?seq=<%=dto.getSeq() %>">
						<%=dto.getTitle() %>
					</a>
				</td>
				<td>
					<!-- 서블릿으로 filename을 넘겨서 어떤 파일에 대한 요청인지 알 수 있게하고,
					seq를 넘겨서 다운로드 회수를 늘릴 수 있게끔 함 --> 
					<input type="button" name="btnDown" value="파일" 
					onclick="location.href='../filedown?filename=<%=dto.getFilename() %>&seq=<%= dto.getSeq()%>'">
				</td>
				<td><%=dto.getReadcount() %></td>
				<td><%=dto.getDowncount() %></td>
				<td><%=dto.getRegdate().substring(0, 10) %></td>
			</tr>
		<%
	}
%>
<tr>
	<td colspan="7">
		
	</td>
</tr>
</table>
<a href="./pdswrite.jsp">자료 업로드</a>
</div>

<script type="text/javascript">
$(function () {
	$(".seqclick").mouseover(function() {		
		$(this).css("background", "#e0e0e0");
	});
	$(".seqclick").mouseout(function() {
		$(this).css("background", "#ffffff");
	});
	
});
</script>
</body>
</html>