<%@page import="java.util.Calendar"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");

MemberDto user = (MemberDto)session.getAttribute("login");

Calendar cal = Calendar.getInstance();

int tyear = cal.get(Calendar.YEAR);
int tmonth = cal.get(Calendar.MONTH) + 1;
int tday = cal.get(Calendar.DATE);
int thour = cal.get(Calendar.HOUR_OF_DAY);
int tmin = cal.get(Calendar.MINUTE);
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>calwrite.jsp</title>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

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

<h1>일정 추가</h1>

<div align="center">

<form action="calwriteAf.jsp" method="post">

<table class="type01">
<col width="200"><col width="500">
<tr>
	<td>아이디</td>
	<td>
		<%=user.getId() %>
		<input type="hidden" name="id" value="<%=user.getId() %>">
	</td>
</tr>

<tr>
	<td>제목</td>
	<td>
		<input type="text" size="60" name="title">
	</td>
</tr>

<tr>
	<td>일정</td>
	<td>
		<select name="year">
		<%
			for(int i = tyear - 5;i < tyear + 6; i++){
				%>
				<option <%=year.equals(i+"")?"selected='selected'":"" %>
					value="<%=i %>"><%=i %></option>
					
				<%
			}
		%>		
		</select>년
		
		<select name="month">
		<%
			for(int i = 1;i <= 12; i++){
				%>
				<option <%=month.equals(i+"")?"selected='selected'":"" %>
					value="<%=i %>"><%=i %></option>
					
				<%
			}
		%>		
		</select>월
		
		<select name="day">
		<%
			for(int i = 1;i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
				%>
				<option <%=day.equals(i+"")?"selected='selected'":"" %>
					value="<%=i %>"><%=i %></option>
					
				<%
			}
		%>		
		</select>일
		
		<select name="hour">
		<%
			for(int i = 0;i < 24; i++){
				%>
				<option <%=(thour + "").equals(i+"")?"selected='selected'":"" %>
					value="<%=i %>"><%=i %></option>
					
				<%
			}
		%>		
		</select>시
		
		<select name="min">
		<%
			for(int i = 0;i < 60; i++){
				%>
				<option <%=(tmin + "").equals(i+"")?"selected='selected'":"" %>
					value="<%=i %>"><%=i %></option>
					
				<%
			}
		%>		
		</select>분
	</td>
</tr>

<tr>
	<td>내용</td>
	<td>
		<textarea rows="20" cols="60" name="content"></textarea>
	</td>
</tr>

<tr>
	<td colspan="2">
		<input type="submit" value="일정쓰기">
	</td>
</tr>


</table>
</form>
</div>

<script type="text/javascript">

$(document).ready(function () {
	$("select[name='month']").change( setDay );
});

function setDay() {
	// 년도와 달을 통해서 마지막 날짜를 구한다
	var year = $("select[name='year']").val() + "";
	var month = $("select[name='month']").val() + "";
	
	var lastday = (	new Date( year, month, 0 ) ).getDate();

	// select 날짜적용
	var str = "";
	for(i = 1;i <= lastday; i++){
		str += "<option value='" + i + "'>" + i + "</option>";
	}
	
	$("select[name='day']").html( str );	
}

</script>



</body>
</html>







