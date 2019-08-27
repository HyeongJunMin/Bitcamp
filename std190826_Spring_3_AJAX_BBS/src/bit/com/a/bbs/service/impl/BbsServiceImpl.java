package bit.com.a.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.bbs.dao.BbsDao;
import bit.com.a.bbs.model.BbsDto;
import bit.com.a.bbs.model.BbsOrderDto;
import bit.com.a.bbs.model.PagingVO;
import bit.com.a.bbs.model.SearchDto;
import bit.com.a.bbs.service.BbsService;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	private BbsDao bbsDao;
	
	@Override
	public int getDBCountSize() {
		// TODO Auto-generated method stub
		return bbsDao.getDBCountSize();
	}

	@Override
	public int getDBCountSizeByCondition(BbsOrderDto bbsOrderDto) {
		// TODO Auto-generated method stub
		return bbsDao.getDBCountSizeByCondition(bbsOrderDto);
	}
	
	@Override
	public List<BbsDto> getAllBbs() {
		// TODO Auto-generated method stub
		return bbsDao.getAllBbs();
	}
	
	@Override
	public List<BbsDto> getAllBbs(PagingVO pagingVO) {
		// TODO Auto-generated method stub
		return bbsDao.getAllBbs(pagingVO);
	}
	
	@Override
	public List<BbsDto> getAllBbs(SearchDto searchDto) {
		// TODO Auto-generated method stub
		return bbsDao.getAllBbs(searchDto);
	}
	@Override
	public List<BbsDto> getAllBbs(BbsOrderDto bbsOrderDto) {
		// TODO Auto-generated method stub
		return bbsDao.getAllBbs(bbsOrderDto);
	}

	@Override
	public BbsDto getOneBySeq(int seq) {
		// TODO Auto-generated method stub
		return bbsDao.getOneBySeq(seq);
	}

	@Override
	public int deleteOneBySeq(int seq) {
		// TODO Auto-generated method stub
		return bbsDao.deleteOneBySeq(seq);
	}

	@Override
	public int plusOneReadCntBySeq(int seq) {
		// TODO Auto-generated method stub
		return bbsDao.plusOneReadCntBySeq(seq);
	}

	@Override
	public int writeNewBbs(BbsDto dto) {
		// TODO Auto-generated method stub
		return bbsDao.writeNewBbs(dto);
	}
	
}
