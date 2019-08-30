package bit.com.a.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bit.com.a.util.CustomCalendarUtil;

@Controller
public class CalendarController {
	
	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);
	
	@RequestMapping(value = "calmain.do")
	public String calMain(Model model) {
		
		logger.info("CalendarController calMain()");
		
		model.addAttribute("doc_title", "일정관리");//제목 설정
		model.addAttribute("cal", new CustomCalendarUtil());
		
		return "calmain.tiles";
	}
}
