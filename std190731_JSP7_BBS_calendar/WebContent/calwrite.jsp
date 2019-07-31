<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap, jQuery CDN -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"></link>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"></link>
</head>
<body>
<%
	int year = Integer.parseInt( request.getParameter("year") + "" );
	int month = Integer.parseInt( request.getParameter("month") + "" );
	int day = Integer.parseInt( request.getParameter("day") + "" );
	MemberDto currId = (MemberDto)session.getAttribute("login");
%>
<h3>일정 등록</h3>
<div id="calwriteDiv">
	<form action="calwriteAf.jsp" id="calwriteForm">
	<table>
		<tr>
			<td>ID</td>
			<td colspan="5" name="inputId"><%=currId.getId() %></td>
		</tr>	
		<tr>
			<td>Title</td>
			<td colspan="5"><input type="text" id="_inputTitle" name="inputTitle"></td>
		</tr>
		<tr>
			<td>Date</td>
			<td>
				<select name="inputYear">
					<%
						for( int i = 2010 ; i < 2025; i ++){
							if( i == year ){
								out.println("<option value=\"" + i + "\" selected=\"selected\">");
							}else{
								out.println("<option value=\"" + i + "\">");								
							}							
							out.println(i + "</option>");
						}
					%>
				</select>년&nbsp;&nbsp;
			</td>
			<td>
				<select name="inputMonth">
					<%
						for( int i = 1 ; i < 13; i ++){
							if( i == (month) ){
								out.println("<option value=\"" + i + "\" selected=\"selected\">");
							}else{
								out.println("<option value=\"" + i + "\">");
							}
							out.println(i + "</option>");
						}
					%>
				</select>월&nbsp;&nbsp;
			</td>
			<td>
				<select name="inputDay">
					<%
						for( int i = 1 ; i < 32; i ++){
							if( i == day ){
								out.println("<option value=\"" + i + "\" selected=\"selected\">");
							}else{
								out.println("<option value=\"" + i + "\">");	
							}
							
							out.println(i + "</option>");
						}
					%>				
				</select>일&nbsp;&nbsp;
			</td>
			<td>
				<select name="inputHour">
					<%
						for( int i = 0 ; i < 24; i ++){
							out.println("<option value=\"" + i + "\">");	
							out.println(i + "</option>");
						}
					%>				
				</select>시&nbsp;&nbsp;
			</td>
			<td>
				<select name="inputMinute">
					<%
						for( int i = 0 ; i < 60; i ++){
							out.println("<option value=\"" + i + "\">");	
							out.println(i + "</option>");
						}
					%>				
				</select>분
			</td>
		</tr>
		<tr>
			<td colspan="6">내용</td>
		</tr>
		<tr>
			<td colspan="6">
				<textarea name="inputContent" draggable="false" rows="20" cols="70"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="저장ㄱ" id="calwriteBtnSave">
			</td>
		</tr>
	</table>
	</form>
</div>
<script type="text/javascript">
//월이 바뀌면 월에 해당하는 날짜의 개수를 정해주는 스크립트
$(document).ready(function(){
	//두 셀렉트에 change 이벤트 리스너 추가
	$("select[name=inputMonth], select[name=inputYear]").change( setDay );
});


function setDay(){
	//연도와 달을 통해 해당 월의 마지막 날짜를 구해줌
	var year = $("select[name='inputYear']").val()  + "";
	var month = $("select[name=inputMonth]").val() + "";
	var lastday	= ( new Date( year, month, 0) ).getDate();
	//alert(lastday);
	
	//select option에 해당 월에 맞는 날짜 적용
	var str = "";
	for( i = 1 ; i < (lastday + 1) ; i++ ){
		str += "<option value='" + i + "'>" + i + "</option>";		
	}
	
	$("select[name=inputDay]").html(str);
}
</script>
</body>
</html>