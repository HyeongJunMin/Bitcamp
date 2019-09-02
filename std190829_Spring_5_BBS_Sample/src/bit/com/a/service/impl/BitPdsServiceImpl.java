package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BitPdsDao;
import bit.com.a.model.PdsDto;
import bit.com.a.service.BitPdsService;

@Service
public class BitPdsServiceImpl implements BitPdsService {

	@Autowired
	private BitPdsDao pdsDao;

	@Override
	public List<PdsDto> getPdsList() {
		// TODO Auto-generated method stub
		return pdsDao.getPdsList();
	}

	@Override
	public PdsDto getOnePds(int seq) {
		// TODO Auto-generated method stub
		return pdsDao.getOnePds(seq);
	}

	@Override
	public boolean uploadPds(PdsDto dto) {
		// TODO Auto-generated method stub
		return pdsDao.uploadPds(dto);
	}

	@Override
	public int plusDownCount(int seq) {
		// TODO Auto-generated method stub
		return pdsDao.plusDownCount(seq);
	}
}
