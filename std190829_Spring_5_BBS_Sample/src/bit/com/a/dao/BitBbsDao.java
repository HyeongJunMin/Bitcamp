package bit.com.a.dao;

import java.util.List;

import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;

public interface BitBbsDao {

	/**검색조건(param)에 맞는 게시글 리스트 리턴
	 * @param param
	 * @return
	 */
	public List<BbsDto> getBbsList(BbsParam param);
	
	/**검색조건에 맞는 게시글 사이즈 리턴
	 * @param param
	 * @return
	 */
	public int getBbsCount(BbsParam param);
	
	/**seq에 맞는 게시글 1개 리턴
	 * @param seq
	 * @return
	 */
	public BbsDto getBbs(int seq);
	
	/**seq에 맞는 게시글 삭제 
	 * @param seq
	 * @return
	 */
	public int deleteOneBbs(int seq);
	
	
	/**하나의 게시글을 새로운 내용으로 업데이트
	 * @param dto
	 * @return
	 */
	public int modifyOneBbs(BbsDto dto);
}
