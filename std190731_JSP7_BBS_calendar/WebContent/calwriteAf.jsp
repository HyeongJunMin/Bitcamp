<%@page import="java.util.Date"%>
<%@page import="dao.CalendarDao"%>
<%@page import="dto.MemberDto"%>
<%@page import="dto.CalendarDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>ggggg</h3>
<%
	String id =  ( (MemberDto)session.getAttribute("login") ).getId();
	String title = request.getParameter("inputTitle");
	String year = request.getParameter("inputYear");
	String month = request.getParameter("inputMonth");
	String day = request.getParameter("inputDay");
	String hour = request.getParameter("inputHour");
	String minute = request.getParameter("inputMinute");
	String content = request.getParameter("inputContent");
	
	String rdate = year;
	rdate += (month.trim().length()<2) ? 0 + month : month;
	rdate += day;
	rdate += hour + minute;
	
	CalendarDto dto = new CalendarDto(0, id, title, content, rdate, rdate);
	out.println(dto.toString());
	
	boolean saveDone = CalendarDao.getInstance().writeNewSch(dto);
	
	if( saveDone == true ){
		out.println("<script>alert('저장 완료'); location.href='calendar.jsp';</script>");
	}else{
		out.println("<script>alert('저장 실패!'); location.href='calendar.jsp';</script>");
	}
%>
</body>
</html>