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
	public List<BbsDto> getBbsList() {		
		return sqlSession.selectList(ns + "getBbsList");
	}

	
}
