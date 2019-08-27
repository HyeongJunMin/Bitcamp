package bit.com.a.bbs.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.bbs.dao.BbsDao;
import bit.com.a.bbs.model.BbsDto;
import bit.com.a.bbs.model.PagingVO;

@Repository
public class BbsDaoImpl implements BbsDao {

	@Autowired
	private SqlSession sqlSession;
	
	String namespace = "Bbs190729.";
	
	@Override
	public List<BbsDto> getAllBbs() {
		// TODO Auto-generated method stub
		List<BbsDto> lst = sqlSession.selectList(namespace + "getAll");		
		return lst;
	}
	
	@Override
	public List<BbsDto> getAllBbsOrder(PagingVO pagingVO) {
		// TODO Auto-generated method stub
		List<BbsDto> lst = sqlSession.selectList(namespace + "getAllOrder", pagingVO);		
		return lst;
	}

	@Override
	public BbsDto getOneBySeq(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "getOneBySeq", seq);
	}

	@Override
	public int deleteOneBySeq(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "deleteOneBySeq", seq);
	}

	@Override
	public int plusOneReadCntBySeq(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "plusOneReadCntBySeq", seq);
	}

	@Override
	public int writeNewBbs(BbsDto dto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "writeNew", dto);
	}
	
	
}
