package bit.com.a.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.model.CalendarDto;
import bit.com.a.util.CustomCalendarUtil;

@Controller
public class CalendarController {
	
	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);
	
	/**calmain뷰로 보내주는 메소드
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "calmain.do")
	public String calMain(Model model) {
		
		logger.info("CalendarController calMain()");
		
		model.addAttribute("doc_title", "일정관리");//제목 설정
		model.addAttribute("cal", new CustomCalendarUtil());
		
		return "calmain.tiles";
	}
	
	/**Ajax 통신을 통해 DB에 저장된 스케줄을 리턴하는 메소드
	 * @param model
	 * @param jsMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "calgetschedules.do")
	public Map<String, CalendarDto> calGetSchedules(Model model, @RequestBody Map<String, Object> jsMap){
		logger.info("ajax input : " + jsMap.get("year") + "  ..  " + jsMap.get("month"));
		Map<String, CalendarDto> javaMap = new HashMap<String, CalendarDto>();
		javaMap.put("f", CalendarDto.builder().id("1").content("내용").build());
		javaMap.put("s", CalendarDto.builder().id("2").content("내용").title("제목").build());
		
		return javaMap;
	}
}
