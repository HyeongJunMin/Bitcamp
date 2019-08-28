package bit.com.a.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.model.MyData;

@Controller
public class AjaxController {
	
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	@RequestMapping(value="ajax1.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String ajax1() {
		logger.info("AjaxController ajax1() " + new Date() );
		return "ajax1";
	}
	
	@ResponseBody
	@RequestMapping(value="idcheck.do",
					produces="application/String; charset=utf-8",
					method= {RequestMethod.GET, RequestMethod.POST})
	public String idCheck(String id) {
		logger.info("AjaxController idcheck() " + new Date() );
		logger.info("id:" + id);
		
		String str = "OK";
		
		//ResponseBody 어노테이션 때문에 jsp파일을 찾는게 아니고 ajax로 데이터를 넘겨줌
		return str;
	}
	
	@ResponseBody
	@RequestMapping(value="account.do", method= RequestMethod.POST)
	public Map<String, Object> account(MyData myData) {
		logger.info("AjaxController idcheck() " + new Date() );
		logger.info("MyData:" + myData);
		
		//넘길 데이터의 key는 String이여야만 한다.
		Map<String, Object> hm = new HashMap<String, Object>();
		hm.put("msg", "메시지 입니다.");
		hm.put("data", "홍길동");
		
		return hm;
	}	
	
	@ResponseBody
	@RequestMapping(value="updateUser.do", method= RequestMethod.POST)
	public Map<String, Object> updateUser(@RequestBody Map<String, Object> userMap) {
		logger.info("AjaxController updateUser() " + new Date() );
		logger.info(userMap.get("name") + " ," + userMap.get("phone") + " ," + userMap.get("email") + " ," + userMap.get("birth"));
		
		//넘길 데이터의 key는 String이여야만 한다.
		Map<String, Object> hm = new HashMap<String, Object>();
		hm.put("msg", " @RequestBody적용끝");
		hm.put("data", " cont:updateUser");
		
		return hm;
	}
}
