package dao;

import java.util.List;

import dto.CalendarDto;

public class CalendarDao implements iCalendar{
	private static CalendarDao dao = new CalendarDao();

	private CalendarDao() {
	}
	
	public static CalendarDao getInstance() {
		return dao;
	}
	
	public List<CalendarDto> getCalendarList(){
		return null;
	}
}
