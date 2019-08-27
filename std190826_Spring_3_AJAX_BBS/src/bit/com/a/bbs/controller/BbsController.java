package bit.com.a.bbs.controller;

import java.util.Date;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.bbs.model.BbsDto;
import bit.com.a.bbs.model.BbsOrderDto;
import bit.com.a.bbs.model.PagingVO;
import bit.com.a.bbs.model.SearchDto;
import bit.com.a.bbs.service.BbsService;

@Controller
public class BbsController {
	
	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	
	@Autowired
	private BbsService bbsService;
	
	/**게시글 리스트 조회 뷰로 이동
	 * @param model
	 * @return
	 */
	@RequestMapping(value="showbbs.do")
	public String showBbs(Model model) {
		logger.info("BbsController showBbs() " + new Date() );
				
		List<BbsDto> list = bbsService.getAllBbs();
		
		model.addAttribute("bbsList", list);
		
//		for(BbsDto d : list) {
//			logger.info(d.toString());
//		}		
		
		return "bbs/bbsmain";
	}
	
	/** 페이징VO에 따라 bbsmain뷰로 리스트를 리턴하는 메소드
	 * @param model
	 * @return
	 */
	@RequestMapping(value="showbbsorder.do")
	public String showBbs(Model model, @RequestParam(value="pageNum", defaultValue="1") int pageNum) {
		logger.info("BbsController showBbs() " + new Date() );
		
		//페이징 VO 생성하여 service에 전달
		int dbSize = bbsService.getDBCountSize();
		PagingVO pagingVo = PagingVO.builder().pageNum(pageNum).totalSize(dbSize).build();
		List<BbsDto> list = bbsService.getAllBbs(pagingVo);
		
		model.addAttribute("bbsList", list);
		model.addAttribute("pagingVo", pagingVo);
		
		return "bbs/bbsmain";
	}
	

	@RequestMapping(value="showbbsordersearch.do")
	public String showBbs(Model model, @RequestParam(value="pageNum", defaultValue="1") int pageNum,
											@RequestParam(value="cond", defaultValue = "4") int cond,
											@RequestParam(value="keyword", defaultValue = "") String keyword) {
		logger.info("BbsController showBbs() " + new Date() );
		//logger.info("cond=" + cond + ",  keyword : " + keyword);
		
		int dbSize = bbsService.getDBCountSize();

		BbsOrderDto dto = new BbsOrderDto(cond, keyword, pageNum, dbSize);
		List<BbsDto> list = bbsService.getAllBbs(dto);
		for(BbsDto d : list ) {
			//System.out.println(d.toString());
		}
		//System.out.println("리스트싸이즈!" + list.size());
		model.addAttribute("bbsList", list);
		dto.setNav(bbsService.getDBCountSizeByCondition(dto));
		
		model.addAttribute("bbsOrderDto", dto);
		model.addAttribute("pagingVo", PagingVO.builder().pageNum(pageNum).totalSize(bbsService.getDBCountSizeByCondition(dto)).build());
		
		
		return "bbs/bbsmain";
	}
	
	/**게시글 상세정보 조회 뷰로 이동
	 * @param model
	 * @param seq
	 * @return
	 */
	@RequestMapping(value="showbbsdetail.do")
	public String showBbsDetail(Model model, @RequestParam int seq ) {
		logger.info("BbsController showBbsDetail() " + new Date() );
		//logger.info("seq = " + seq);
		
		BbsDto dto = bbsService.getOneBySeq( seq );
		
		model.addAttribute("BbsDto",dto);
		
		//logger.info(dto.toString());
		
		return "bbs/bbsdetail";
	}
	
	/**게시글 수정 뷰로 이동
	 * @param model
	 * @return
	 */
	@RequestMapping(value="showbbsupdate.do")
	public String showBbsUpdate(Model model, @RequestParam int seq ) {
		logger.info("BbsController showBbsUpdate() " + new Date() );
		
		//seq에 맞는 게시물 1개 DB에서 가져옴
		BbsDto dto = bbsService.getOneBySeq( seq );
		//logger.info("dto : " + dto.toString());
		//조회 + 1
		bbsService.plusOneReadCntBySeq(seq);		
		
		model.addAttribute("BbsDto",dto);
		
		return "bbs/bbsupdate";
	}
	
	/**Ajax 통신을 통한 게시물 삭제 기능
	 * @param model
	 * @param seq
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deletepost.do")
	public int deletePost(Model model, @RequestBody Map<String, Object> bbsMap ) {
		logger.info("BbsController deletePost()" + new Date() );
		return bbsService.deleteOneBySeq( Integer.parseInt( bbsMap.get("seq")+ "" ) );
	}
	
	@RequestMapping(value = "showwritenew.do")
	public String showWriteNew(Model model, HttpSession session) {
		logger.info("BbsController showWriteNew()" + new Date() );
		
		if(session.getAttribute("currUser") != null ) {			
			return "bbs/bbswritenew";
		}else {
			model.addAttribute("msg", "새 게시물 작성 권한이 없습니다.");
			return "forward:/showbbsordersearch.do";
		}
	}
	
	/**새 게시물을 Ajax 통신으로 DB에 저장하는 기능
	 * @param model
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "writenew.do")
	public String writeNew(Model model , HttpSession session, @RequestBody Map<String, Object> userMap) {
		logger.info("BbsController writeNew()" + new Date() );
		//logger.info(userMap.toString());
		
		int n = bbsService.writeNewBbs( BbsDto.builder().id( userMap.get("id") + "" )
												.title( userMap.get("title") + "" )
												.content( userMap.get("content") + "" ).build() );
		
		if( n > 0 ) {			
			return "1";
		}else {
			return "0";
		}		
	}
	
	/**새 답글을 작성할 수 있는 뷰로 이동시키는 컨트롤러
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "shownewreply.do")
	public String showNewReply(Model model, @RequestParam int seq) {
		
		BbsDto dto = bbsService.getOneBySeq(seq);
		
		model.addAttribute("BbsDto", dto);
		
		return "bbs/bbsnewreply";
	}
	
	/**새 댓글을 Ajax 통신으로 DB에 저장하는 기능
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "writenewcomment.do")
	public String writeNewComment(Model model) {
		logger.info("BbsController writeNewComment()" + new Date() );
		
		return "writenewcomment";
	}
}
