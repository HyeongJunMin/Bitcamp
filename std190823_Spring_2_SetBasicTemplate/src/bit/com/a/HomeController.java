package bit.com.a;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/home")
	public ModelAndView home() {
		
		logger.info("HomeController home " + new Date() );
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/home");
		
		//System.out.println("[HomeController] home()");
		
		return mav;
	}
	
	@RequestMapping(value="/hello.do", method = RequestMethod.GET)
	public String hello(Model model) {
		
		logger.info("HomeController hello " + new Date() );
		
		//req.setAttribute와 동일
		model.addAttribute("yes", "yes!");
		
		return "/hello";
	}
	
}
