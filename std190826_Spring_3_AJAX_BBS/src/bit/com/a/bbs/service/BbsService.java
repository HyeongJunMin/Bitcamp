package bit.com.a.bbs.service;

import java.util.List;

import bit.com.a.bbs.model.BbsDto;
import bit.com.a.bbs.model.PagingVO;

public interface BbsService {

	public List<BbsDto> getAllBbs();
	
	public List<BbsDto> getAllBbsOrder(PagingVO pagingVO);
	
	public BbsDto getOneBySeq(int seq);
	
	public int deleteOneBySeq(int seq);
	
	public int plusOneReadCntBySeq(int seq);
	
	public int writeNewBbs(BbsDto dto);
}
