package bit.com.a.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.model.MemberDto;
import bit.com.a.service.BitMemberService;

@Controller
public class BitMemberController {

	private static final Logger logger = LoggerFactory.getLogger(BitMemberController.class);
	
	@Autowired
	private BitMemberService bitMemberService;
	
	@RequestMapping(value = "/showlogin", method = RequestMethod.GET)
	public String toLoginView(Model model) {
		
		logger.info("BitMemberController showlogin " + new Date() );
		
		//req.setAttribute와 동일
		//model.addAttribute("yes", "yes!");		
		
		return "/login";
	}
	
	@RequestMapping(value = "/dologin", method = RequestMethod.GET)
	public String doLogin(Model model) {
		
		logger.info("BitMemberController showlogin " + new Date() );
		
		//req.setAttribute와 동일
		//model.addAttribute("yes", "yes!");
		
		return "/main";
	}
	
	@RequestMapping(value = "/showsignup", method = RequestMethod.GET)
	public String toSignupView(Model model) {
		
		logger.info("BitMemberController showlogin " + new Date() );
		
		//req.setAttribute와 동일
		//model.addAttribute("yes", "yes!");
		
		return "/signup";
	}
	
	@RequestMapping(value = "/dosignup", method = RequestMethod.GET)
	public String doSignup(MemberDto dto, Model model, HttpServletRequest req){
		String jsMsg = "<script>alert('다시 시도 해 주세요.');</script>";
		
		logger.info("BitMemberController showlogin " + new Date() );
		logger.info("BitMemberController dto : " + dto.toString());
		
		//MemberDto dto = new MemberDto(inputId, inputPw, inputName, inputEmail, 3);
		dto.setAuth(3);
		boolean isDone = false;
		try {
			isDone = bitMemberService.insertMember(dto);	
		}catch ( SQLIntegrityConstraintViolationException ex ) {
			logger.info("BitMemberController exception : SQLIntegrityConstraintViolationException");
			model.addAttribute("alertMsg", jsMsg);
			return "/signup";	
		}catch ( Exception e ) {
			logger.info("BitMemberController exception : Exception");
			model.addAttribute("alertMsg", jsMsg);
			return "/signup";	
		}		
		
		//req.setAttribute와 동일
		//model.addAttribute("yes", "yes!");
		
		if( isDone ) {
			return "/main";
		}else {			
			return "/signup";	
		}				
	}
}
