package bit.com.a.member.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.member.model.MemberDto;
import bit.com.a.member.service.BitMemberService;

@Controller
public class BitMemberController {

	private static final Logger logger = LoggerFactory.getLogger(BitMemberController.class);
	
	@Autowired
	private BitMemberService bitMemberService;
	
	@RequestMapping(value = "/showlogin.do", method = RequestMethod.GET)
	public String toLoginView(Model model) {
		
		logger.info("BitMemberController showlogin " + new Date() );
		
		//req.setAttribute와 동일
		//model.addAttribute("yes", "yes!");		
		
		return "member/login";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(Model model, HttpSession session) {
		
		logger.info("BitMemberController logout " + new Date() );
		
		if( session.getAttribute("currUser") != null ) {
			session.removeAttribute("currUser");
		}
		
		return "member/login";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/dologin.do", method = RequestMethod.GET)
	public String doLogin(Model model, MemberDto dto, HttpServletRequest req) {
		String jsMsg = "다시 시도 해 주세요.";
		
		logger.info("BitMemberController showlogin " + new Date() );
		
		//logger.info("폼에서 받은 멤버 : " + dto.toString());
		
		MemberDto dbDto = null;
		
		try {
			dbDto = bitMemberService.getOneMember(dto.getId());		
			
			//logger.info("DB에서 찾은 멤버 : " + dbDto.toString());			
		}catch(Exception e) {
			e.printStackTrace();
			//DB에 ID 없으면
			jsMsg = "올바르지 않은 계정 정보입니다.";
			model.addAttribute("msg", jsMsg);
			return "forward:/showlogin.do";
		}
				
		if( dbDto != null ) {
			//ID가 있으면
			if(dto.getPw().equals(dbDto.getPw())) {
				//PW일치하면?
				jsMsg = dbDto.getId() + "님 환영합니다";
				req.getSession().setAttribute("currUser", dbDto);
				model.addAttribute("msg", jsMsg);
				return "forward:/showbbsordersearch.do";
			}else {
				jsMsg = "올바르지 않은 계정 정보입니다.";
				model.addAttribute("msg", jsMsg);
				return "forward:/showlogin.do";
			}
		}else {
			//DB에 ID 없으면
			jsMsg = "올바르지 않은 계정 정보입니다.";
			model.addAttribute("msg", jsMsg);
			return "forward:/showlogin.do";
		}

	}
	
	@RequestMapping(value = "/showsignup.do", method = RequestMethod.GET)
	public String toSignupView(Model model) {
		
		logger.info("BitMemberController showlogin " + new Date() );
		
		//req.setAttribute와 동일
		//model.addAttribute("yes", "yes!");
		
		return "member/signup";
	}
	
	@ResponseBody
	@RequestMapping(value = "/bbsidchk.do", method = { RequestMethod.GET, RequestMethod.POST})
	public int bbsIdChk(Model model, @RequestParam String id) throws Exception {
		
		logger.info("BitMemberController bbsIdChk " + new Date() );
		//ajax 0리턴하면 회원가입 불가, 1 리턴하면 회원가입 가능
		MemberDto dto = bitMemberService.getOneMember(id);
		if(dto == null ) {			
			return 1;
		}else {
			//logger.info(dto.toString());
			return 0;
		}
	}
	
	@RequestMapping(value = "/insertmember.do", method = RequestMethod.GET)
	public String doSignup(MemberDto dto, Model model, HttpServletRequest req){
		String jsMsg = "다시 시도 해 주세요.";
		
		logger.info("BitMemberController insertmember.do() " + new Date() );
		//logger.info("BitMemberController dto : " + dto.toString());
		
		//MemberDto dto = new MemberDto(inputId, inputPw, inputName, inputEmail, 3);
		dto.setAuth(3);
		boolean isDone = false;
		try {
			isDone = bitMemberService.insertMember(dto);	
		}catch ( SQLIntegrityConstraintViolationException ex ) {
			logger.info("BitMemberController exception : SQLIntegrityConstraintViolationException");
			model.addAttribute("msg", jsMsg);
			return "member/signup";	
		}catch ( Exception e ) {
			logger.info("BitMemberController exception : Exception");
			model.addAttribute("msg", jsMsg);
			return "member/signup";	
		}		
		
		//req.setAttribute와 동일
		//model.addAttribute("yes", "yes!");
		
		if( isDone ) {
			jsMsg = dto.getId() + "님 환영합니다.";
			req.getSession().setAttribute("currUser", dto);
			model.addAttribute("msg", jsMsg);
			return "forward:/showbbsordersearch.do";
		}else {		
			model.addAttribute("msg", jsMsg);
			return "member/signup";	
		}				
	}
}
