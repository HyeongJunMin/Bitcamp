package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BitBbsDao;
import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;
import bit.com.a.service.BitBbsService;

@Service
public class BitBbsServiceImpl implements BitBbsService {

	@Autowired
	BitBbsDao bbsDao;

	@Override
	public List<BbsDto> getBbsList(BbsParam param) {		
		return bbsDao.getBbsList(param);
	}

	@Override
	public boolean writeBbs(BbsDto bbs) {		
		return bbsDao.writeBbs(bbs);		
	}

	@Override
	public BbsDto getBbs(int seq) {		
		return bbsDao.getBbs(seq);		
	}

	@Override
	public void reply(BbsDto bbs) throws Exception {
		bbsDao.replyBbsUpdate(bbs);
		bbsDao.replyBbsInsert(bbs);	
	}

	@Override
	public void deleteBbs(int seq) {
		bbsDao.deleteBbs(seq);		
	}
	
	
}
