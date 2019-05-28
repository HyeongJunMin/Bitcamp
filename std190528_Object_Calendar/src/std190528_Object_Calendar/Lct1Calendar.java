package std190528_Object_Calendar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Lct1Calendar {
	/*
	  	날짜를 활용할 수 있는 클래스는 Calendar, Data 등이 있다
	  	주로 Calendar를 활용한다. Data는 별로 안좋음
	  	
	  	주 사용처 : 예약 시스템
	*/
	
	public static void aboutTimeClass() {
		//Time 클래스 활용
		int year = 0;
		int mon = 0;
		int day = 0;
		
		//현재 년-월-일 확인
		LocalDate currentDate = LocalDate.now();
		year = currentDate.getYear();
		mon = currentDate.getMonthValue();
		day = currentDate.getDayOfMonth();
		System.out.println(year + " " + mon + " " + day);
		System.out.println(year + " " + currentDate.getMonth() + " " + day);
		
		//지정한 날짜의 년-월-일 확인
		LocalDate targetDate = LocalDate.of(1991, 2, 18);
		System.out.println(targetDate.getYear() + " " + targetDate.getMonth() + " " + targetDate.getDayOfMonth());
		
		//현재 시간객체 생성
		LocalTime crtTime = LocalTime.now();
		LocalTime trgTime = LocalTime.of(12, 30, 34, 33); //시, 분, 초, 나노초
		
	}
	
	
	public static void main(String[] args) {
		//캘린더 선언 방법 1
		Calendar cal2 = new GregorianCalendar(); cal2.clear();
		//캘린더 선언 방법 2
		Calendar cal = Calendar.getInstance();
		
		//날짜 취득 - 날짜는 소수점이 없지요? > 정수 ㄱ
		int year = cal.get(Calendar.YEAR);
		int mon = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DATE);
		System.out.println( "오늘 : " + year + "-0" + mon + "-" + day);
		
		//날짜 설정 == setter
		cal.set(Calendar.YEAR, 1991);
		cal.set(Calendar.MONTH, 2 - 1);
		cal.set(Calendar.DATE, 18);
		System.out.println( "생일 : " + cal.get(Calendar.YEAR) + "-0" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE));
		
		cal = Calendar.getInstance();
		//오전은 0, 오후는 1
		String ampm = cal.get(Calendar.AM_PM)==0?"오전":"오후";
		System.out.println(ampm);
		
		//요일 : 일요일 시작으로 1부터 나감(시작 0아님)
		int weekDay = cal.get(Calendar.DAY_OF_WEEK);
		String wdn = "";
		switch( weekDay ) {
			case 1 : wdn="일"; break;
			case 2 : wdn="월"; break;
			case 3 : wdn="화"; break;
			case 4 : wdn="수"; break;
			case 5 : wdn="목"; break;
			case 6 : wdn="금"; break;
			case 7 : wdn="토"; break;
			default : wdn="?"; break;
		}
		System.out.println("요일 : " + wdn + " " +weekDay);
		
		//지정한 달의 마지막 날짜를 취득하는 방법
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("현재 마지막 날짜 : " + lastDay);
		cal.set(Calendar.MONTH, 2 - 1);
		System.out.println("2월 마지막 날짜 : " + cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal = Calendar.getInstance();
		
		//연-월-일을 설정하면, 달력의 빈 칸이 몇 개 있는지 취득
		year = 2020;
		mon = 2;
		day = 1;
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, mon - 1);
		cal.set(Calendar.DATE, day);
		weekDay = cal.get(Calendar.DAY_OF_WEEK);//무슨요일인지 확인
		
		int emptySpace = (weekDay - 1) % 7;//요일-1 = 빈 칸 개수
		
		System.out.println("윗쪽의 빈칸 : " + emptySpace + "칸");
		lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DATE, lastDay);
		weekDay = cal.get(Calendar.DAY_OF_WEEK);
		
		int emptySpace2 = 7 - weekDay;
		System.out.println("아래쪽의 빈칸 : " + emptySpace2 + "칸");
		
		aboutTimeClass();
	}
}
