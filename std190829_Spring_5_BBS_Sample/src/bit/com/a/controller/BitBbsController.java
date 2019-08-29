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
		model.addAttribute("doc_title", "글목록");//제목 설정		
		
		List<BbsDto> bbslist = bbsService.getBbsList();			
		model.addAttribute("bbslist", bbslist);//게시판 글 세팅
		
		
		return "bbslist.tiles";
	}	
}












