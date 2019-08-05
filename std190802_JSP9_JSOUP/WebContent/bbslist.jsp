<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.BbsDao"%>
<%@page import="dao.iBbsDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
// 댓글용 함수
public String arrow(int depth){
	String rs = "<img src='./image/arrow.png' width='20px' height='20px'/>";
	String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";	// 여백
	
	String ts = "";
	for(int i = 0;i < depth; i++){
		ts += nbsp;
	}
	return depth==0?"":ts + rs;	// 여백 + 이미지		
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Object ologin = session.getAttribute("login");
MemberDto mem = null;
if(ologin == null){
	%>
	<script type="text/javascript">
	alert("로그인해 주십시오");
	location.href = "login.jsp";
	</script>	
	<%
}
mem = (MemberDto)ologin;
%>

<%
iBbsDao dao = BbsDao.getInstance();

List<BbsDto> list = dao.getBbsList();
%>

<h4 align="right" style="background-color: #f0f0f0">
	환영합니다 <%=mem.getId() %>님 환영합니다 
</h4>

<h1>게시판</h1>

<div align="center">

<table border="1">
<col width="70"><col width="600"><col width="150">
<tr>
	<th>번호</th><th>제목</th><th>작성자</th>
</tr>
<%
if(list == null || list.size() == 0){
	%>
	<tr>
		<td colspan="3">작성된 글이 없습니다</td>
	</tr>
	<%
}else{
	for(int i = 0;i < list.size(); i++){
		BbsDto bbs = list.get(i);
	%>	
	<tr>	
		<th><%=i + 1 %></th>
		<%-- 
		<td class="seqclick" seq=<%=bbs.getSeq() %>>
			<%=arrow(bbs.getDepth()) %>
			<%=bbs.getTitle() %>			
		</td>
		 --%>
		<td>
			<%
			if(bbs.getDel() == 0){
				%>
				<%=arrow( bbs.getDepth() ) %>			
				<a href="bbsdetail.jsp?seq=<%=bbs.getSeq() %>">
					<%=bbs.getTitle() %>
				</a>	
				<%
			}else{
				%>		
				<font color="#ff0000">이 글은 작성자에 의해서 삭제되었습니다</font> 
				<%
			}
			%>
		</td> 
		<td align="center"><%=bbs.getId() %></td>		
	</tr>	
	<%	
	}	
}
%>
</table>

<a href="bbswrite.jsp">글쓰기</a>

</div>

</body>
</html>




