package bit.com.a.bbs.service;

import java.util.List;

import bit.com.a.bbs.model.BbsCommentDto;
import bit.com.a.bbs.model.BbsDto;
import bit.com.a.bbs.model.BbsOrderDto;
import bit.com.a.bbs.model.PagingVO;
import bit.com.a.bbs.model.SearchDto;

public interface BbsService {
	
	public int getDBCountSize();
	
	public int getDBCountSizeByCondition(BbsOrderDto bbsOrderDto);

	public List<BbsDto> getAllBbs();
	
	public List<BbsDto> getAllBbs(PagingVO pagingVO);
	
	public List<BbsDto> getAllBbs(SearchDto searchDto);
	
	public List<BbsDto> getAllBbs(BbsOrderDto bbsOrderDto);
	
	public BbsDto getOneBySeq(int seq);
	
	public int deleteOneBySeq(int seq);
	
	public int plusOneReadCntBySeq(int seq);
	
	public int writeNewBbs(BbsDto dto);
	
	public int writeNewReply(BbsDto dto);
	
	/**새 답글을 Ajax 통신으로 DB에 저장하는 기능
	 * @param dto
	 * @return
	 */
	public int plusOneStepBiggerThanOriginInReply(BbsDto dto);
	
	
	/* 댓글(comment)영역 */
	
	/**게시글의 seq를 매개변수로 받아 해당되는 Comment를 보여주는 메소드
	 * @param seq
	 * @return
	 */
	public List<BbsCommentDto> getAllBbsComment(int seq);
		
	/**댓글을 DB에 저장하는 메소드. BbsCommentDto에 포함된 parent가 게시물의 seq번호가 된다
	 * @param dto
	 * @return
	 */
	public int writeNewComment(BbsCommentDto dto);
	
	/**댓글을 삭제하는 메소드. DEL을 0으로 변경한다.
	 * @param seq
	 * @return
	 */
	public int deleteComment(int seq);
	
	/**댓글을 수정하는 메소드.
	 * @param dto
	 * @return
	 */
	public int updateComment(BbsCommentDto dto);
}
