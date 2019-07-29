<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.BbsDao"%>
<%@page import="dao.iBbsDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	//댓글용 함수, 글 앞에 화살표 표시
	public String arrow(int depth){
		//화살표 이미지와 여백문자
		String rs = "<img src='./image/arrow.png' width='20px' height='20px'/>";
		String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";
		
		String ts = "";
		for( int i = 0 ; i < depth ; i++ ){
			ts += nbsp;
		}
		
		return (depth == 0)?"":ts + rs;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"></link>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"></link>
<script type="text/javascript" src="./js/bbslist.js"></script>
</head>
<body>
<%
	Object ologin = session.getAttribute("login");
	MemberDto mem = null;
	if(ologin == null){%>
		<script type="text/javascript">
		alert('로그인해주세요');
		location.href = "login.jsp";
		</script>	
	<%}
	mem = (MemberDto)ologin;
%>

<%
	iBbsDao dao = BbsDao.getInstance();
	List<BbsDto> list = dao.getBbsList();
%>
<h4 align="right" style="background-color: #f0f0f0">환영합니다 <%=mem.getName() %>님</h4>
<h1>게시판</h1>

<div align="center">
<form action="./bbsdetail.jsp" id="frmBbs">
<table border="1">
<col width="70"><col width="600"><col width="150">
<tr>
	<th>No</th><th>title</th><th>writer</th>
</tr>
<%
	if( list == null || list.size() == 0 ){
		%><tr><td colspan="3">작성된 글 없음</td></tr><%
	}else{
		for( int i = 0 ; i < list.size() ; i++ ){
			BbsDto dto = list.get(i); %>
			<tr>
				<td><%=(i + 1) %></td>
				<td class="seqclick" seq=<%= dto.getSeq()%>>
				<a class="titles" href="bbsdetail.jsp?seq=<%=dto.getSeq() %>">
				<%=arrow( dto.getDepth() ) %><%=dto.getTitle() %>
				</a>
				</td>
				<td><%=dto.getId() %></td>
			</tr>
		<%}
	}
%>
</table>
</form>
<a href="bbswrite.jsp">글 쓰기</a>
</div>

</body>
</html>