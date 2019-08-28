package com.aopexam_xml;

import org.aspectj.lang.ProceedingJoinPoint;

//감시자 클래스
public class LogAOP {
	
	
	/**프로세싱이 된 경우(변화가 발생한 경우: 메소드가 호출 되는 등) 
	 * 조인포인트를 통해 들어오도록 접목(join)시키는 메소드
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//어떤 함수가 호출 되기 전에 시작을 출력하고 호출한 후 종료를 출력하게된다.
		String signatureStr = joinPoint.getSignature().toShortString();
		
		System.out.println(signatureStr + "시작");
		
		try {
			//특정 함수가 실행되었을 때 그 부분을 캐치하는 코드
			Object obj = joinPoint.proceed();		
			return obj;
		}finally {
			//시간이 얼마나 걸렸는지 체크
			System.out.println("실행 후: " + System.currentTimeMillis() );
			System.out.println(signatureStr + "종료");
		}
	}
}
