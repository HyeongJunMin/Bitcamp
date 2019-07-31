<%@page import="dao.CalendarDao"%>
<%@page import="java.util.List"%>
<%@page import="dto.CalendarDto"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
//해당 연월의 모든 일정을 테이블로 만드는 메소드
	public String makeList(int year, int month, int day, List<CalendarDto> list){
		String str = "";
		
		String dates = year + "" + two(month + "") + day;
		
		str += "<table>";
		str += "<col width='50'>";
		str += "<col width='50'>";
		str += "<col width='300'>";
		str += "<col width='200'>";
		
		str += "<tr>";
		str += "<td>No</td>";
		str += "<td>Title</td>";
		str += "<td>Content</td>";
		str += "<td>wdate</td>";
		str += "</tr>";
		
		for(CalendarDto dto : list){
			if( dto.getRdate().substring(0, 8).equals(dates) ){
				String cont = ( dto.getContent().length() > 30 )?dto.getContent().substring(0,30)+"...":dto.getContent();
				str += "<tr>";
				str += "<td>" + dto.getSeq() + "</td>";
				str += "<td>" + dto.getTitle() + "</td>";
				str += "<td><a href='caldetail.jsp?seq=" + dto.getSeq() + "'>"
				+ cont + "</a></td>";
				str += "<td>" + dto.getWdate() + "</td>";
				str += "</tr>";
			}
		}
		str += "</table>";
		
		return str;
	}

	//날짜에 0을 더해주는 메소드 2019731 -> 20190731
	public String two(String msg){
		return (msg.trim().length() < 2)? "0" + msg.trim() : msg.trim() ;
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
	String currId = "guest";
	if( (MemberDto)session.getAttribute("login") != null ){
		currId = ( (MemberDto)session.getAttribute("login") ).getId();
	}


	int year = Integer.parseInt(request.getParameter("year")+"");
	int month = Integer.parseInt(request.getParameter("month")+"");
	int day = Integer.parseInt(request.getParameter("day")+"");
	
	List<CalendarDto> list = CalendarDao.getInstance().getCalendarList(currId, year + two(month+"") );
%>

<div align="center">
	<form action="callistAf.jsp" id="callistForm" method="get">
		<br><br><h3>Schedules of a day</h3><br><br>
		<input type="hidden" value="<%=currId %>" id="currId">
		<input type="hidden" id="command" name="_command" value="none">
		<table>
			<%=makeList(year, month, day, list) %>
		</table>
	</form>
</div>
</body>
</html>