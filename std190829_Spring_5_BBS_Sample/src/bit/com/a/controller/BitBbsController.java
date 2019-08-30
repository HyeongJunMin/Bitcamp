package bit.com.a.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;
import bit.com.a.service.BitBbsService;

@Controller
public class BitBbsController {

	private static final Logger logger = LoggerFactory.getLogger(BitBbsController.class);
	
	@Autowired
	BitBbsService bbsService;
	
	@RequestMapping(value = "bbslist.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String bbslist(Model model, BbsParam param) {		
		//logger.info("BitBbsController : bbslist(), param:" + param.toString());
		
		model.addAttribute("doc_title", "글목록");//제목 설정		
		
		//paging 처리, 현재 페이지가 0이면 1~10까지, 1이면 11부터 20까지
		int sn = param.getPageNumber();
		int start = sn * param.getRecordCountPerPage() + 1;
		int end = (sn + 1) * param.getRecordCountPerPage();		
		param.setStart(start);
		param.setEnd(end);
		
		List<BbsDto> bbslist = bbsService.getBbsList(param);
		model.addAttribute("bbslist", bbslist);//게시판 글 세팅
		
		//검색조건에 맞는 글의 총 개수
		int totalRecordCount = bbsService.getBbsCount(param);
		
		//paging 정보 추가
		model.addAttribute("pageNumber" , sn);
		model.addAttribute("pageCountPerScreen" , 10);
		model.addAttribute("recordCountPerPage" , param.getRecordCountPerPage());
		model.addAttribute("totalRecordCount" , totalRecordCount);
		
		return "bbslist.tiles";
	}	
	
	/**게시글 상세정보 뷰로 이동
	 * @param model
	 * @param seq
	 * @return
	 */
	@RequestMapping(value = "bbsdetail.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String bbsDetail(Model model, @RequestParam(defaultValue = "-1") int seq) {		
		//logger.info("BitBbsController : bbsdetail()");
		
		model.addAttribute("bbs", bbsService.getBbs(seq) );
		
		model.addAttribute("doc_title", "글목록 > 글 상세정보");//제목 설정	
		
		return "bbsdetail.tiles";
	}
	
	/**수정 뷰로 이동
	 * @param model
	 * @param seq
	 * @return
	 */
	@RequestMapping(value = "bbsmod.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String bbsMod(Model model, @RequestParam(defaultValue = "-1") int seq) {		
		//logger.info("BitBbsController : bbsdetail()");
		
		model.addAttribute("doc_title", "글목록 > 글 상세정보 > 글 수정");//제목 설정
		
		model.addAttribute("bbs", bbsService.getBbs(seq) );		
		
		return "bbsmod.tiles";
	}
	
	/* Ajax 통신 관련 메소드 */
	
	/**하나의 게시물을 삭제하는 기능
	 * @param model
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "bbsdeletepost.do")
	public String bbsDeletePost(Model model , HttpSession session, @RequestBody Map<String, Object> userMap) {
		
		int n = bbsService.deleteOneBbs( Integer.parseInt( userMap.get("seq") + "" ) );
		//성공 시 return 1, 실패 시 return 0
		if( n > 0 ) {			
			return "1";
		}else {
			return "0";
		}		
	}
	
	@ResponseBody
	@RequestMapping(value = "bbsmodify.do")
	public String bbsModify(Model model , HttpSession session, @RequestBody Map<String, Object> userMap) {
		
		BbsDto dto = new BbsDto( Integer.parseInt( userMap.get("seq") + "" ),
								userMap.get("id") + "" ,
								userMap.get("title") + "" ,
								userMap.get("content") + "");
		
		int n = bbsService.modifyOneBbs(dto);
		//성공 시 return 1, 실패 시 return 0
		if( n > 0 ) {			
			return "1";
		}else {
			return "0";
		}		
	}
}





