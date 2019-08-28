package bit.com.a.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.model.MemberDto;
import bit.com.a.service.BitMemberService;

@Controller
public class BitMemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(BitMemberController.class);

	@Autowired
	private BitMemberService bitMemberService;
	
	@RequestMapping(value = "login.do", method=RequestMethod.GET)
	public String login() {		
		logger.info("BitMemberController login " + new Date());	
		return "login.tiles";
	}	
	
	@RequestMapping(value = "regi.do", method = RequestMethod.GET)
	public String regi() {
		logger.info("BitMemberController account " + new Date());		
		return "regi.tiles";
	}
	
	@RequestMapping(value = "regiAf.do", method = RequestMethod.POST)
	public String regiAf() {
		logger.info("BitMemberController account " + new Date());		
		return "regi.tiles";
	}
	
	@RequestMapping(value = "account.do", method = RequestMethod.GET)
	public String account() {
		logger.info("BitMemberController account " + new Date());		
		return "regi";
	}
	
	@RequestMapping(value = "accountAf.do", method = RequestMethod.POST)
	public String accountAf(MemberDto dto, Model model, HttpServletRequest req)throws Exception {		
		logger.info("BitMemberController accountAf " + new Date());
		logger.info(dto.toString());
		
		boolean b = bitMemberService.addmember(dto);
		if(b) {
			logger.info("회원가입되었습니다 " + new Date());
			return "ok";
		}
		
		return "regi";
	}
	
	@ResponseBody
	@RequestMapping(value="getId.do", method=RequestMethod.POST)
	public String getId(MemberDto mem) {
		logger.info("KhMemberController getId " + new Date());
		
		int count = bitMemberService.getId(mem);
		
		logger.info("count = " + count);
		String msg = "";
		if(count > 0) {
			msg = "NO";
		}else {
			msg = "OK";
		}
		return msg;
	}
	
	
	@RequestMapping(value = "loginAf.do", method = RequestMethod.POST)
	public String loginAf(MemberDto dto, HttpServletRequest req) {	
		logger.info("KhMemberController loginAf " + new Date());
		
		MemberDto login = bitMemberService.login(dto);
		
		if(login != null && !login.getId().equals("")) {
			logger.info("KhMemberController loginAf SUC " + new Date());
			// session 저장
			req.getSession().setAttribute("login", login);			

			return "redirect:/bbslist.do";			
		}else {	
			logger.info("KhMemberController loginAf Fail " + new Date());			
			return "login.do";
		}		
	}
	
}







