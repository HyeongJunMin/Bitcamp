package bit.com.a.util;

import java.util.List;

import bit.com.a.model.CalendarDto;

public class CustomCalendarUtil {
	
		//요일 배열을 리턴하는 메소드
		public String[] getDayNames() {
			String[] dayNames = {"일", "월", "화", "수", "목", "금", "토"};
			return dayNames;
		}
	
	
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
}
