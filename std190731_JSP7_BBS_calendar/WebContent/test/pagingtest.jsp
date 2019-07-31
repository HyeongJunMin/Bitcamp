<%@page import="vo.PagingVO"%>
<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.BbsDao"%>
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
	return depth==0?"":ts + rs;
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
	
	int pageNum = Integer.parseInt( request.getParameter("pageNum") + "" );


	PagingVO paging = new PagingVO();

	paging.setRows(10);
	paging.setTotalPage( BbsDao.getInstance().getBbsCount() );
	

	List<BbsDto> list = BbsDao.getInstance().getPagingList(paging, pageNum);

	
%>

<table class="type02">
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
		<th><%=bbs.getSeq() %></th>
		 	
		<%
			if(bbs.getDel() == 0){
		%>	
				<td class="seqclick" seq=<%=bbs.getSeq() %>>
					<%=arrow( bbs.getDepth() ) %>			
					<%=bbs.getTitle() %>
				</td>		 
		 <%
			}else{
		 %>
		 		<td class=""><font color="#ff0000">이 글은 작성자에 의해서 삭제되었습니다</font></td> 
		 <%
			}
		 %>
		<td align="center"><%=bbs.getId() %></td>
	</tr>
	<%
	}
}
%>
</table>
<br>
<%
	int cnt = BbsDao.getInstance().getBbsCount();
	out.println("cnt : " + cnt);
%>
</body>
</html>