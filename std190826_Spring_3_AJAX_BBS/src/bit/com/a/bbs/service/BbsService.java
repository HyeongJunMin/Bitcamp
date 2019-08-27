package bit.com.a.bbs.service;

import java.util.List;

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
}
