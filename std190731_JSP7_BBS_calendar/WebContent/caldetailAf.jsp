<%@page import="dto.CalendarDto"%>
<%@page import="dto.MemberDto"%>
<%@page import="dao.CalendarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String command = request.getParameter("_command");

	if( command == null ){
		response.sendRedirect("caldetail.jsp");
		
	//커맨드가 수정인 경우
	}else if( command.equals("mod") ){
		String id = ( (MemberDto)session.getAttribute("login") ).getId();
		int seq = Integer.parseInt(request.getParameter("_seq") + "" );
		String title = request.getParameter("_title");
		String content = request.getParameter("_content");
		
		CalendarDto dto = new CalendarDto(seq, id, title, content);
		
		boolean isDone = CalendarDao.getInstance().modOneSch(dto);
		
		if( isDone == true ){
			%>
				<script type="text/javascript">
				alert('수정 완료!')
				location.href='caldetail.jsp?seq=' + <%=dto.getSeq() %>;
				</script>
			<%
		}else{
			%>
				<script type="text/javascript">
				alert('수정 실패!')
				location.href='caldetail.jsp?seq=' + <%=dto.getSeq() %>;
				</script>
			<%		
		}
		
	//커맨드가 삭제인 경우
	}else if( command.equals("del") ){
		int seq = Integer.parseInt(request.getParameter("_seq") + "" );
		boolean result = CalendarDao.getInstance().deleteOneSch(seq);
		if( result == true ){
			%>
				<script type="text/javascript">
				alert('삭제 완료!')
				location.href='calendar.jsp';
				</script>
			<%
		}else{
			%>
				<script type="text/javascript">
				alert('삭제 실패!')
				location.href='calendar.jsp';
				</script>
			<%			
		}
	}
%>
</body>
</html>