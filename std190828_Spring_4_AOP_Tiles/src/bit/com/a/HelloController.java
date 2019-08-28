package bit.com.a;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.model.MyClass;

@Controller
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(value = "hello.do", method = RequestMethod.GET)
	public String hello(Model model) {		
		logger.info("HelloController hello() " + new Date() );
		
		MyClass cls = new MyClass();
		cls.setNumber(1001);
		cls.setName("홍길동");
		
		model.addAttribute("mycls", cls);
		
		return "hello";
	}
	
	//GET, POST 둘 다 받기 {GET, POST}
	@RequestMapping(value = "inputData.do", method = { RequestMethod.GET, RequestMethod.POST} )
	public String inputData(Model model, MyClass mycls) {
		logger.info("HelloController inputData() " + new Date() );
		logger.info(mycls.toString());
		
		model.addAttribute("mycls", mycls);
		
		return "hello";
	}
	
	@RequestMapping(value = "move.do" , method = { RequestMethod.GET, RequestMethod.POST} )
	public String move() {
		logger.info("HelloController move() " + new Date() );
		
		return "redirect:/hello.do";
		/* return "forward:/hello.do"; */
	}
}
