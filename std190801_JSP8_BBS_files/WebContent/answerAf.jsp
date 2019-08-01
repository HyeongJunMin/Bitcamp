<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@page import="dao.iBbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>        
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String sseq = request.getParameter("seq");
int seq = Integer.parseInt(sseq.trim());

String id = request.getParameter("id");
String title = request.getParameter("title");
String content = request.getParameter("content");

iBbsDao dao = BbsDao.getInstance();
boolean isS = dao.answer(seq, new BbsDto(id, title, content));

if(isS){
	%>
	<script type="text/javascript">
	alert("답글 입력성공!!");
	location.href = "bbslist_css.jsp";
	</script>
	<%
}else{
	%>
	<script type="text/javascript">
	alert("답글 입력하지 못했습니다 다시 입력해 주십시오");
	location.href = "bbslist_css.jsp";
	</script>
	<%
}
%>



</body>
</html>









