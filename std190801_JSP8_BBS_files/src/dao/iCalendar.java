package dao;

import java.util.List;

import dto.CalendarDto;

public interface iCalendar {
	public List<CalendarDto> getCalendarList(String id, String yyyyMM);
	
	public boolean writeNewSch(CalendarDto dto);
	
	public CalendarDto getOneSch(int seq);
	
	public boolean deleteOneSch(int seq);
	
	public boolean modOneSch(CalendarDto dto);
}
