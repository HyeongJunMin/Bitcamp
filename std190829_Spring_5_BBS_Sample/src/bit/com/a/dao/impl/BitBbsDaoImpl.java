package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BitBbsDao;
import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;

@Repository
public class BitBbsDaoImpl implements BitBbsDao {

	@Autowired
	SqlSession sqlSession;
	
	String ns = "Bbs.";
	
	@Override
	public List<BbsDto> getBbsList(BbsParam param) {		
		return sqlSession.selectList(ns + "getBbsList", param);
	}

	@Override
	public int getBbsCount(BbsParam param) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns + "getBbsCount", param);
	}

	@Override
	public BbsDto getBbs(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns + "getBbs", seq);
	}

	@Override
	public int deleteOneBbs(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.update(ns + "deleteOneBbs", seq);
	}

	@Override
	public int modifyOneBbs(BbsDto dto) {
		// TODO Auto-generated method stub
		return sqlSession.update(ns + "modifyOneBbs", dto);
	}
	
}
