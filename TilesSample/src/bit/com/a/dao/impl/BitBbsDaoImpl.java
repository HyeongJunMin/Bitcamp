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
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns + "getBbsSearchList", param);
	}

	@Override
	public boolean writeBbs(BbsDto bbs) {
		int n = sqlSession.insert(ns+"writeBbs",bbs);		
		return n>0?true:false;
	}

	@Override
	public BbsDto getBbs(int seq) {		
		return sqlSession.selectOne(ns+"getBbs", seq);
	}
	
	@Override
	public boolean replyBbsUpdate(BbsDto bbs) throws Exception {		
		sqlSession.update(ns+"replyBbsUpdate", bbs);
		return true; 
	}

	@Override
	public boolean replyBbsInsert(BbsDto bbs) throws Exception {
		sqlSession.insert(ns+"replyBbsInsert", bbs);
		return true;
	}

	@Override
	public void deleteBbs(int seq) {
		sqlSession.update(ns+"deleteBbs", seq);
	}

	
}
