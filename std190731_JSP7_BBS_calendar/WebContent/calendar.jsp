<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@page import="dao.iBbsDao"%>
<%@page import="dao.CalendarDao"%>
<%@page import="dao.iCalendar"%>
<%@page import="dto.MemberDto"%>
<%@page import="java.util.Calendar"%>
<%@page import="dto.CalendarDto"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 함수 선언부 -->
<%!
	//nvl 함수 준비, 오류를 검사하기 위한 함수
	public boolean nvl(String msg){
		return ( msg == null || msg.trim().equals("") ) ? true : false;
	}

	//날짜를 클릭하면 그 날의 일정을 모두 보여주는 callist.jsp로 이동하는 함수
	//어떤 날인지 년/월/일을 알려줘야함
	public String callist(int year, int month, int day){
		String str = "";
		
		//href = callist.jsp?year=2019&month=7&day=4
		//text = 04
		str += String.format("<a href='%s?year=%d&month=%d&day=%d'>", 
				"callist.jsp", year, month, day);
		str += String.format("%2d", day);
		str += "</a>";
		
		return str;
	}
	
	//일정을 기입하기 위해 pen이미지를 클릭하면, calwrite.jsp로 이동시키는 함수
	public String showPen(int year, int month, int day){
		String str = "";
		
		//<a href='calwrite.jsp?year=2019&month=07&day=31'>
		//	<img src='image/pen.gif'/></a>
		String img = "<img src='image/pen.gif'/>";
		str += String.format("<a href='%s?year=%d&month=%d&day=%d'>%s</a>", 
				"calwrite.jsp", year, month, day, img);				
		
		return str;
	}
	
	//날짜에 0을 더해주는 메소드 2019731 -> 20190731
	public String two(String msg){
		return (msg.trim().length() < 2)? "0" + msg.trim() : msg.trim() ;
	}
	
	//제목 잘라주는 메소드 제목제목...
	public String dot3(String msg){
		String str = "";
		if( msg.length() > 4 ){
			str += msg.substring(0, 4) + "...";
		}else{
			str = msg;
		}		
		return str;
	}
	
	//날짜 칸 마다 각각의 html 테이블을 생성해주는 함수
	//해당 날짜의 일정이 몇 개 인지 파악하기 위해 List 가져옴
	public String makeTable(int year, int month, int day, List<CalendarDto> list){
		String str = "";
		
		String dates = year + "" + two(month + "") + day;
		
		str += "<table>";
		str += "<col width='98'>";
		for(CalendarDto dto : list){
			if( dto.getRdate().substring(0, 8).equals(dates) ){
				str += "<tr bgcolor='green'>";
				str += "<td class='calendarSchContent' title='" + dto.getContent() + "'>";
				str += "<a href='caldetail.jsp?seq=" + dto.getSeq() + "'>";
				str += "<font style='font-size:8; color:red;'>";
				str += dot3(dto.getTitle());
				str += "</font>";
				str += "</a>";
				str += "</td>";
				str += "</tr>";
			}
		}
		str += "</table>";
		
		return str;
	}
	
	//해당 연월의 모든 일정을 테이블로 만드는 메소드
	public String makeList(int year, int month, List<CalendarDto> list){
		String str = "";
		
		String dates = year + "" + two(month + "");
		
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
			if( dto.getRdate().substring(0, 6).equals(dates) ){
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
%>
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
<link type="text/css" rel="stylesheet" href="./css/ui.css">
<style type="text/css">
table.type02 {
    border-collapse: separate;
    border-spacing: 0;
    text-align: left;
    line-height: 1.0;
    border-top: 1px solid #ccc;
    border-left: 1px solid #ccc;
  	margin : 20px 10px;
}
table.type02 th {
    /* width: 150px; */
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    border-top: 1px solid #fff;
    border-left: 1px solid #fff;
    background: #eee;
    text-align: center;
}
table.type02 td {
    /* width: 350px; */
    padding: 10px;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
}
</style>
</head>
<body>

<h4 align="right" style="background-color: #f0f0f0">환영합니다 <%=((MemberDto)session.getAttribute("login")).getId() %>님 반갑습니다</h4>

<ul>
	<li><a href="./bbslist_css.jsp">게시판</a></li>
	<li><a href="./calendar.jsp">일정관리</a></li>
	<li><a href="./pdslist.jsp">자료실</a></li>
</ul>
<%
	Calendar cal = Calendar.getInstance();
	cal.set(Calendar.DATE, 1);//오늘 기준 월의 1일로 calendar 객체를 세팅(7월 1일)
	
	String syear = request.getParameter("year");
	String smonth = request.getParameter("month");
	String sday = request.getParameter("day");
	
	int year = cal.get(Calendar.YEAR);
	//syear가 비어있지 않은 경우 == 파라미터가 넘어온 경우
	if( nvl(syear) == false ){
		year = Integer.parseInt(syear);
	}
	
	int month = cal.get(Calendar.MONTH) + 1;
	//smonth가 비어있지 않은 경우 == 파라미터가 넘어온 경우
	if( nvl(smonth) == false ){
		month = Integer.parseInt(smonth);
	}
	
	//month가 1보다 작으면 1년빼줌
	if(month < 1){
		month = 12;
		year--;
	//month가 12보다 크면 1년 더해줌
	}else if(month > 12){
		month = 1;
		year++;
	}
	//연월일 세팅(객체 데이터이기 때문에 month-1)
	cal.set(year, month - 1, 1);
	
	//요일
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	
	// img << : year--
	String pp = String.format("<a href='%s?year=%d&month=%d'>"
				+ "<img src='image/left.gif'/></a>",
				"calendar.jsp", year-1, month);
	// img < : month++(prev)
	String p = String.format("<a href='%s?year=%d&month=%d'>"
				+ "<img src='image/prec.gif'/></a>",
				"calendar.jsp", year, month-1);
	// img >> : year++
	String nn = String.format("<a href='%s?year=%d&month=%d'>"
			+ "<img src='image/last.gif'/></a>",
			"calendar.jsp", year+1, month);
	// img > : month++(next)
	String n = String.format("<a href='%s?year=%d&month=%d'>"
				+ "<img src='image/next.gif'/></a>",
				"calendar.jsp", year, month+1);
	
	//유저 정보 세션에서 받아옴
	MemberDto user = (MemberDto)session.getAttribute("login");
	
	//유저 정보에 맞는 월 별 일정 정보 받아옴
	iCalendar dao = CalendarDao.getInstance();
	List<CalendarDto> list = dao.getCalendarList(user.getId(), year + two(month+"") );
			
%>

<div align="center">
	<table border="1" id="calendarTbl">
	<col width="100"><col width="100"><col width="100"><col width="100">
	<col width="100"><col width="100"><col width="100">
	
	<!-- 일정관리 테이블 상단에 년, 월 선택 부분 -->
	<tr height="100">
		<td colspan="7" align="center">
			<%=pp %>&nbsp;<%=p %>
			<font color="black" style="font-size: 50px;">
				<%=String.format("%d년  %d월", year, month) %>
			</font>
			<%=n %>&nbsp;<%=nn %>
		</td>
	</tr>	
	<tr>
		<td align="center">월</td>
		<td align="center">화</td>
		<td align="center">수</td>
		<td align="center">목</td>
		<td align="center">금</td>
		<td align="center">토</td>
		<td align="center">일</td>
	</tr>
	<tr height="100" align="left" valign="top">
		<%
			//1행에서 날짜가 없는 달력의 빈칸
			for( int i = 1 ; i < dayOfWeek ; i++ ){
			%>
				<td class="calenderCell">&nbsp;</td>
			<%	
			}
		%>
		<%
			//달력 내용 설정
			int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			for( int i = 1 ; i < lastDay + 1 ; i++ ){
				%>
					<td class="calenderCell">
						<!-- 상세일정 조회를 위한 a태그, 새 일정 작성을 위한 pen이미지, 일정테이블 생성 -->
						<%=callist(year, month, i) %>&nbsp;<%=showPen(year, month, i) %>
						<%=makeTable(year, month, i, list) %>
					</td>
				<%
					if( (i + dayOfWeek - 1) % 7 == 0 && i != lastDay ){
						out.println("</tr><tr height='100' align='left' valign='top'>");
					}
			}
		%>
		<%
			//달력 마지막 행의 빈칸을 채우기 위한 마지막날짜 계산
			for( int i = 0 ; i < ( ( 7 - ( ( dayOfWeek + lastDay - 1) % 7 ) ) % 7 ) ; i++ ){
				out.println("<td  class=\"calenderCell\">&nbsp;</td>");
			}
		%>
	</tr>
	</table>
</div>

<div id="" align="center">
<br><br><h3>모든 일정</h3><br><br>
<%=makeList(year, month, list)%>
</div>

<script type="text/javascript">
$(function(){
	$(".calendarSchContent").tooltip();
	$(".calenderCell").hover(function(){
		$(this).css("background-color","#f2f2f2")
	});
	$(".calenderCell").mouseout(function(){
		$(this).css("background-color","#ffffff")
	});
});
</script>
</body>
</html>