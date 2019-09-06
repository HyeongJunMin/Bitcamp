package bit.com.a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BitChatController {

	@RequestMapping(value = "chatting.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String chatting(Model model) {		
		
		return "chatting.tiles";
	}	
}
