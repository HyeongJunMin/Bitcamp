package bit.com.a.bbs.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.bbs.model.BbsCommentDto;
import bit.com.a.bbs.model.BbsDto;
import bit.com.a.bbs.model.BbsOrderDto;
import bit.com.a.bbs.model.PagingVO;
import bit.com.a.bbs.service.BbsService;

@Controller
public class BbsController {
	
	@Autowired
	private BbsService bbsService;
	
	
	/**게시글 조회 뷰로 이동
	 * @param model
	 * @param pageNum
	 * @param cond
	 * @param keyword
	 * @return
	 */
	@RequestMapping(value="showbbs.do")
	public String showBbs(Model model, @RequestParam(value="pageNum", defaultValue="1") int pageNum,
											@RequestParam(value="cond", defaultValue = "4") int cond,
											@RequestParam(value="keyword", defaultValue = "") String keyword) {
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
		
		
		//return "bbs/bbsmain";
		return "bbsmain.tiles";
	}
	
	/**게시글 상세정보 조회 뷰로 이동, 댓글리스트 commenList 가져감
	 * @param model
	 * @param seq
	 * @return
	 */
	@RequestMapping(value="showbbsdetail.do")
	public String showBbsDetail(Model model, @RequestParam int seq ) {
		
		BbsDto dto = bbsService.getOneBySeq( seq );
		List<BbsCommentDto> commentList = bbsService.getAllBbsComment(seq);
		
		bbsService.plusOneReadCntBySeq(seq);
		
		model.addAttribute("BbsDto",dto);
		model.addAttribute("commentList", commentList);
		
		return "bbsdetail.tiles";
	}
	
	/**게시글 수정 뷰로 이동
	 * @param model
	 * @return
	 */
	@RequestMapping(value="showbbsupdate.do")
	public String showBbsUpdate(Model model, @RequestParam int seq ) {
		
		//seq에 맞는 게시물 1개 DB에서 가져옴
		BbsDto dto = bbsService.getOneBySeq( seq );
		//logger.info("dto : " + dto.toString());
		//조회 + 1
		bbsService.plusOneReadCntBySeq(seq);		
		
		model.addAttribute("BbsDto",dto);
		
		return "bbsupdate.tiles";
	}
		
	/**새 게시글 작성 뷰로 이동
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "showwritenew.do")
	public String showWriteNew(Model model, HttpSession session) {
		if(session.getAttribute("currUser") != null ) {			
			return "bbswritenew.tiles";
		}else {
			model.addAttribute("msg", "새 게시물 작성 권한이 없습니다.");
			return "forward:/showbbs.do";
		}
	}
	
	/**새 답글을 작성할 수 있는 뷰로 이동
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "shownewreply.do")
	public String showNewReply(Model model, @RequestParam int seq) {
		
		BbsDto dto = bbsService.getOneBySeq(seq);
		
		model.addAttribute("BbsDto", dto);
		
		return "bbsnewreply.tiles";
	}
	
	
	/* Ajax 통신 관련 메소드 */
	
	/**새 게시물을 Ajax 통신으로 DB에 저장하는 기능
	 * @param model
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "writenew.do")
	public String writeNew(Model model , HttpSession session, @RequestBody Map<String, Object> userMap) {
		
		int n = bbsService.writeNewBbs( BbsDto.builder().id( userMap.get("id") + "" )
												.title( userMap.get("title") + "" )
												.content( userMap.get("content") + "" ).build() );
		//성공 시 return 1, 실패 시 return 0
		if( n > 0 ) {			
			return "1";
		}else {
			return "0";
		}		
	}
		
	/**Ajax 통신을 통한 게시물 삭제 기능
	 * @param model
	 * @param seq
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deletepost.do")
	public int deletePost(Model model, @RequestBody Map<String, Object> bbsMap ) {
		return bbsService.deleteOneBySeq( Integer.parseInt( bbsMap.get("seq")+ "" ) );
	}
	
	/**Ajax 통신을 통한 게시물 업데이트 기능
	 * @param model
	 * @param bbsMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updatepost.do")
	public int updatePost(Model model, @RequestBody Map<String, Object> bbsMap ) {
		BbsDto dto = BbsDto.builder().seq( Integer.parseInt( bbsMap.get("seq") + "" ) )
									.title( bbsMap.get("title") + "" )
									.content( bbsMap.get("content") + "" ).build();
		return bbsService.updateOneBbs(dto);
	}
	
	/**새 답글을 Ajax 통신으로 DB에 저장하는 기능
	 * @param model
	 * @param bbsMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "writenewreply.do", method = RequestMethod.POST)
	public String writeNewReply(Model model, @RequestBody Map<String, Object> bbsMap) {
		
//		Iterator<String> iter = bbsMap.keySet().iterator();
//		while( iter.hasNext() ) {
//			String key = iter.next() + "";
//			logger.info( "key:" + key + " , value:" + bbsMap.get(key) );
//		}
		
		//원본글(seq)이 갖고있는 ref와 동일한 ref를 갖는 글 중 seq보다 step이 큰 글의 step을 1씩 증가.
		BbsDto originDto = bbsService.getOneBySeq( Integer.parseInt(bbsMap.get("seq") + "") );
		bbsService.plusOneStepBiggerThanOriginInReply( originDto );
		
		//새로 추가되는 글의 step과 depth는 원본글  + 1, parent는 원본글의 seq
		BbsDto replyDto = BbsDto.builder().step( originDto.getStep() + 1 )
											.depth( originDto.getDepth() + 1 )
											.parent( originDto.getSeq() )
											.ref( originDto.getRef() )
											.id( bbsMap.get("id") + "" )
											.title( bbsMap.get("title") + "" )
											.content( bbsMap.get("content") + "" )											
											.build();
		
		int m = bbsService.writeNewReply(replyDto);
		
		//성공 시 return 1, 실패 시 return 0
		if( m > 0 ) {
			return "1";
		}else{
			return "0";
		}
		
	}

	
	
	
	/* 댓글(comment) 관련 기능 */
	/** Ajax 통신을 통한 새 댓글 작성 기능
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="writenewcomment.do")
	public String writeNewComment(Model model,  @RequestBody Map<String, Object> bbsMap) {
		
		BbsCommentDto dto = BbsCommentDto.builder().parent( Integer.parseInt( bbsMap.get("parent") + "" ) )
													.id( bbsMap.get("id") + "" )
													.content( bbsMap.get("content") + "" ).build();
			
		int n = bbsService.writeNewComment(dto);
		
		//성공 시 return 1, 실패 시 return 0
		if( n > 0 ) {
			return "1";
		}else{
			return "0";
		}
	}

	
}
