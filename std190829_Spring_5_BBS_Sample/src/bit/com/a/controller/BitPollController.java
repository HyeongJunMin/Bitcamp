package bit.com.a.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.model.MemberDto;
import bit.com.a.model.PollBean;
import bit.com.a.model.PollDto;
import bit.com.a.service.BitPollService;

@Controller
public class BitPollController {

	@Autowired
	private BitPollService pollService;
	
	@RequestMapping(value = "polllist.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String polllist(Model model, HttpServletRequest req) {
		
		model.addAttribute("doc_title", "투표 목록");
		
		String id = ( (MemberDto)req.getSession().getAttribute("login") ).getId();
		
		List<PollDto> list = pollService.getAllPollList(id);
		model.addAttribute("plists", list);
		
		return "polllist.tiles";
	}
	
	@RequestMapping(value = "pollmake.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String pollmake(Model model) {
		model.addAttribute("doc_title", "투표 만들기");
		
		return "pollmake.tiles";
	}
	
	@RequestMapping(value = "pollmakeAf.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String pollmakeAf(PollBean pbean) {
		System.out.println(pbean.toString());
		
		pollService.makePoll(pbean);
		
		return "redirect:/polllist.do";
	}
}
