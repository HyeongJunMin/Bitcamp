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
	public List<BbsDto> getBbsList() {		
		return bbsDao.getBbsList();
	}

}
