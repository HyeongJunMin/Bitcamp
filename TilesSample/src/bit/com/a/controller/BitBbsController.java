package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;
import bit.com.a.service.BitBbsService;

@Controller
public class BitBbsController {

	private static final Logger logger = LoggerFactory.getLogger(BitBbsController.class);
	
	@Autowired
	BitBbsService bbsService;
	
	@RequestMapping(value = "bbslist.do", method=RequestMethod.GET)
	public String bbslist(Model model, BbsParam param) {		
		logger.info("BitBbsController bbslist " + new Date());
		logger.info(param.toString());
		
		List<BbsDto> bbslist = bbsService.getBbsList(param);			
		model.addAttribute("bbslist", bbslist);
		
		return "bbslist";
	}	
	
	@RequestMapping(value = "bbswrite.do", method = {RequestMethod.GET,	RequestMethod.POST})
	public String bbswrite(Model model) {
		logger.info("BitBbsController bbswrite "+ new Date());		
		return "bbswrite";
	}
	
	@RequestMapping(value = "bbswriteAf.do", method = RequestMethod.POST)
	public String bbswriteAf(BbsDto bbs, Model model) throws Exception {
		logger.info("BitBbsController bbswriteAf! "+ new Date());
		bbsService.writeBbs(bbs);
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value = "bbsdetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsdetail(int seq, Model model) throws Exception {
		logger.info("BitBbsController bbsdetail! "+ new Date());
		BbsDto bbs=bbsService.getBbs(seq);
		model.addAttribute("bbs", bbs);
		return "bbsdetail";
	}
	
	@RequestMapping(value = "answer.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String answer(int seq, Model model) throws Exception {
		logger.info("BitBbsController answer! "+ new Date());
		BbsDto bbs = bbsService.getBbs(seq);
		model.addAttribute("bbs", bbs);
		return "answer";
	}
	
	@RequestMapping(value = "answerAf.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String answerAf(BbsDto bbs, Model model) throws Exception {
		logger.info("BitBbsController answer! "+ new Date());
		bbsService.reply(bbs);		
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value = "bbsdelete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteBbs(int seq, Model model) throws Exception {
		logger.info("Welcome BitBbsController deleteBbs! "+ new Date());
		bbsService.deleteBbs(seq);
		return "redirect:/bbslist.do";		
	}
	
	@ResponseBody
	@RequestMapping(value = "bbsTooltip.do",
					produces="application/String; charset=utf-8",
					method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsTooltip(int seq) {
		logger.info("Welcome BitBbsController bbsTooltip! "+ new Date());
		BbsDto dto = new BbsDto();
		dto.setSeq(seq);
		dto = bbsService.getBbs(dto.getSeq());
		return dto.getContent();		
	}
}












