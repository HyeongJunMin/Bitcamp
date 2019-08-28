package bit.com.a.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

@Aspect
public class LogAop {
	
	private static final Logger logger = LoggerFactory.getLogger(LogAop.class);
	
	@Around("within(bit.com.a.bbs.controller.*) or within(bit.com.a.member.controller.*)")
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//어떤 함수가 호출 되기 전에 시작을 출력하고 호출한 후 종료를 출력하게된다.
		String signatureStr = joinPoint.getSignature().toShortString();
		
		//System.out.println(signatureStr + "AOP logger 시작");
		/*
		try {
			//세션 ID 체크 부분 
			HttpServletRequest req = ( (ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			if( req != null ) {
				//System.out.println("세션을 가져왔다!!!!");
				HttpSession session = req.getSession();				
				if( session.getAttribute("currUser") == null ) {
					System.out.println("세션이 만료되었습니다.");
					return "redirect:/showlogin.do";
				}
			}			
			//세션 ID 체크 부분
			
			
			
			System.out.println("loggerAOP : " + signatureStr + " 메소드가 실행되었습니다.");
			//특정 함수가 실행되었을 때 그 부분을 캐치하는 코드. 실행 전 처리
			//proceed()메소드는 수행된 시점을 캐치
			Object obj = joinPoint.proceed();		
			return obj;
		}finally {
			//시간이 얼마나 걸렸는지 체크
			//System.out.println("실행 후: " + System.currentTimeMillis() );
			//System.out.println(signatureStr + "AOP logger 종료");
		}
		*/
		
		//강사코드 - 세션 ID 체크 -> 리퀘스트만 얻어오면 끝난거다
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		/*
		HttpServletRequest req = ( (ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		if( req != null ) {
			HttpSession session = req.getSession();
			
			MemberDto  dto = (MemberDto)session.getAttribute("currUser");
			if( dto == null ) {				
				HttpServletResponse resp = ( (ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter pw = resp.getWriter();
				pw.print("<script>alert('세션이 만료되었습니다.'); location.href='/std190826_Spring_3_AJAX_BBS/showlogin.do';</script>");
				pw.flush();
				pw.close();
				//return "redirect:/showlogin.do";
			}else {
				
				logger.info("[AOP logger] current ID : " + dto.getId() + " ... " + stopWatch.getTotalTimeMillis() );
			}
		}
		*/
		
		try {
			Object obj = joinPoint.proceed();
			stopWatch.stop();
			logger.info("[AOP logger] " + signatureStr + " ... " + stopWatch.getTotalTimeMillis() + " ... " + new Date());			
			return obj;
		}finally {
			
		}
		
	}
	
}
