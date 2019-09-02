package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BitCalendarDao;
import bit.com.a.model.CalendarDto;
import bit.com.a.service.BitCalendarService;

@Service
public class BitCalendarServiceImpl implements BitCalendarService {
	
	@Autowired
	BitCalendarDao calendarDao;

	@Override
	public List<CalendarDto> getCalendatList(CalendarDto fcal) throws Exception {	
		return calendarDao.getCalendatList(fcal);		
	}

	@Override
	public boolean writeCalendar(CalendarDto cal) throws Exception {		
		return calendarDao.writeCalendar(cal);		
	}

	@Override
	public CalendarDto getDay(CalendarDto fcal) throws Exception {		
		return calendarDao.getDay(fcal);		
	} 
	
	
	
	

}









