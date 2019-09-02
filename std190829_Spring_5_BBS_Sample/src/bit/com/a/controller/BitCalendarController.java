package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.model.CalendarDto;
import bit.com.a.model.CalendarParam;
import bit.com.a.model.MemberDto;
import bit.com.a.model.myCal;
import bit.com.a.service.BitCalendarService;
import bit.com.a.util.CalendarUtil;


@Controller
public class BitCalendarController {
	
	private static final Logger logger 
		= LoggerFactory.getLogger(BitCalendarController.class);
	
	@Autowired
	BitCalendarService calendarService;
	
	@RequestMapping(value="calendar.do", method={RequestMethod.GET, RequestMethod.POST})
	public String calendar(Model model, myCal jcal, HttpServletRequest req) throws Exception{
		logger.info("BitCalendarController calendar " + new Date());
		
		model.addAttribute("doc_title", "일정");
		
		jcal.calculate();
		
		// id 취득
		String id = ((MemberDto)req.getSession().getAttribute("login")).getId();
		
		String yyyymm = CalendarUtil.yyyymm(jcal.getYear(), jcal.getMonth());
		
		CalendarDto fcal = new CalendarDto();
		fcal.setId(id);
		fcal.setRdate(yyyymm);
		
		List<CalendarDto> flist = calendarService.getCalendatList(fcal);
		
		model.addAttribute("flist", flist);
		model.addAttribute("jcal", jcal);
		
		return "calendar.tiles";
	}
	
	@RequestMapping(value="calwrite.do", method={RequestMethod.GET, RequestMethod.POST})
	public String calwrite(Model model, myCal jcal) {
		logger.info("BitCalendarController calwrite " + new Date());
		
		model.addAttribute("doc_title", "일정쓰기");
		
		jcal.calculate();
		model.addAttribute("jcal", jcal);
		
		return "calwrite.tiles";		
	}
	
	@RequestMapping(value="calwriteAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String calwriteAf(Model model, CalendarParam calparam)throws Exception {
		logger.info("BitCalendarController calwriteAf " + new Date());
		
		String yyyymmdd = "" + calparam.getYear() + CalendarUtil.two(calparam.getMonth()) +
				CalendarUtil.two(calparam.getDay());
		
		CalendarDto dto = new CalendarDto(calparam.getId(), 
										calparam.getTitle(), 
										calparam.getContent(), 
										yyyymmdd);
		
		calendarService.writeCalendar(dto);
		
		model.addAttribute("year", calparam.getYear());
		model.addAttribute("month", calparam.getMonth());
		
		return "forward:/calendar.do";		
	}
	
	@RequestMapping(value="caldetail.do", method={RequestMethod.GET, RequestMethod.POST})
	public String caldetail(CalendarDto fcal, Model model) throws Exception{
		logger.info("BitCalendarController caldetail " + new Date());
		model.addAttribute("doc_title", "일정");
		
		CalendarDto dto = calendarService.getDay(fcal);
		String wdate = dto.getWdate();
		
		logger.info("dto:" + dto.toString());
		
		String year = wdate.substring(0, 4);	// year
		String month = CalendarUtil.toOne(wdate.substring(4, 6)) + "";	// month
		String urls = String.format("%s?year=%s&month=%s", 
								"calendar.do", year, month);		
				
		model.addAttribute("cal", dto);
		model.addAttribute("urls", urls);
		
		return "caldetail.tiles";		
	}
	
	@RequestMapping(value="calendarMonth.do", method={RequestMethod.GET, RequestMethod.POST})
	public String calendarMonth(myCal jcal, Model model, HttpServletRequest req)throws Exception{
		logger.info("BitCalendarController calendarMonth " + new Date());		
		model.addAttribute("doc_title", "월별일정");
		
		jcal.calculate();
		// id
		String id = ((MemberDto)req.getSession().getAttribute("login")).getId();
		String yyyymm = CalendarUtil.yyyymm(jcal.getYear(), jcal.getMonth());
		
		CalendarDto fcal = new CalendarDto();
		fcal.setId(id);
		fcal.setRdate(yyyymm);
		
		List<CalendarDto> clist = calendarService.getCalendatList(fcal);
		
		model.addAttribute("callist", clist);
		model.addAttribute("year", jcal.getYear());
		model.addAttribute("month", jcal.getMonth());
		
		return "calendarMonth.tiles";		
	}
		
	
}














