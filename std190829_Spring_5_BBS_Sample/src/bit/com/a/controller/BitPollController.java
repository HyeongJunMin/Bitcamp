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
import bit.com.a.model.PollSubDto;
import bit.com.a.model.VoterDto;
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
		
		pollService.makePoll(pbean);
		
		return "redirect:/polllist.do";
	}
	
	
	@RequestMapping(value = "polldetail.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String pollDetail(Model model, PollDto poll) {
		model.addAttribute("doc_title","투표 내용");
				
		//매개변수로 받은 polldto에 해당하는 투표 정보를 db에서 가져온다
		PollDto dto = pollService.getPoll(poll);
		//polldto에 관련된 선택지 정보 리스트를 db에서 가져온다
		List<PollSubDto> list = pollService.getPollSubList(poll);
				
		model.addAttribute("poll", dto);
		model.addAttribute("pollsublist", list);
		
		return "polldetail.tiles";
	}
	
	//선택지를 선택하고 투표 버튼을 클릭했을 때 받아주는 컨트롤러
	@RequestMapping(value = "polling.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String polling(VoterDto voter) {
	
		pollService.polling(voter);
		
		return "redirect:/polllist.do";
	}	
	
	//투표 결과 뷰를 보여주는 부분
	@RequestMapping(value = "pollresult.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String pollresult(PollDto poll, Model model) {
		model.addAttribute("doc_title","투표 결과");
		
		//매개변수로 받은 polldto에 해당하는 투표 정보를 db에서 가져온다
		PollDto dto = pollService.getPoll(poll);
		//polldto에 관련된 선택지 정보 리스트를 db에서 가져온다
		List<PollSubDto> list = pollService.getPollSubList(poll);
		
		model.addAttribute("poll", dto);
		model.addAttribute("pollsublist", list);
		
		return "pollresult.tiles";
	}
}

