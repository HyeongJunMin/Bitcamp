<%@page import="dao.BbsDao"%>
<%@page import="dto.BbsDto"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="./js/bbsdetail.js"></script>
</head>
<body>
<%
	BbsDto dto = null;
	String currId = ( (MemberDto)session.getAttribute("login") ).getId();
	String currName = ( (MemberDto)session.getAttribute("login") ).getName();
	int seq = 0;
	try {
		if (request.getParameter("seq") != null) {
			//int seq = Integer.parseInt(request.getParameter("seq") + "" );
			//out.println("seq = " + seq);

			seq = Integer.parseInt(request.getParameter("seq") + "");
			
			dto = BbsDao.getInstance().getOnePost(seq);
			
		}
	} catch (Exception e) {
		response.sendRedirect("./bbslist.jsp");
	}
%>
<h4 align="right" style="background-color: #f0f0f0">환영합니다 <%=currName %>님</h4>
<div>
		<div>
		<h1>글 상세보기</h1>
		</div>
		
		<div>
		<form action="./bbswriteAf.jsp" method="GET" id="frmWrite">
			<input type="hidden" value="<%=seq %>" id="originSeq">
			<input type="hidden" value="<%=dto.getTitle() %>" id="originTitle">
			<input type="hidden" value="<%=dto.getContent() %>" id="originContent">	
			<input type="hidden" value="<%=dto.getId() %>" id="originId">
			<input type="hidden" value="<%=currId %>" id="currId">
			<table>
				<tr>
					<td>작성자 ID : </td>
					<td><a id="writer"><%=dto.getId() %></a></td>
				</tr>
				<tr>
					<td>제목 : </td>
					<td>
						<input type="text" size="25" id="_inputTitle" name="inputTitle" value="<%=dto.getTitle() %>">
					</td>
				</tr>
				<tr>
					<td colspan="2">내용</td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea rows="15" cols="40" id="_inputContent" name="inputContent"><%=dto.getContent() %></textarea>
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="변경내용 저장" id="_btnSave" name="btnSave" disabled="disabled">
					</td>
					<td></td>
				</tr>
			</table>
		
		</form>		
		</div>
		
	</div>
<p id="chkTitle"></p>
<p id="chkContent"></p>
<p id="modifyDone"></p>
<input type="button" value="버튼숨기기" id="btnHide">
<input type="button" value="돌아가기" id="btnBack">
<script type="text/javascript">
$(function(){
	$("#btnBack").click(function(){
		location.href = './bbslist.jsp';
	});
});
</script>
</body>
</html>