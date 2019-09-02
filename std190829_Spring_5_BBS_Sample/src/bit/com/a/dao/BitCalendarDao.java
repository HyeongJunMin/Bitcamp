package bit.com.a.dao;

import java.util.List;

import bit.com.a.model.CalendarDto;

public interface BitCalendarDao {
	
	List<CalendarDto> getCalendatList(CalendarDto fcal) throws Exception;

	boolean writeCalendar(CalendarDto cal) throws Exception;
	
	CalendarDto getDay(CalendarDto fcal) throws Exception;	
	
}
