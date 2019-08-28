package bit.com.a.bbs.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.bbs.dao.BbsDao;
import bit.com.a.bbs.model.BbsCommentDto;
import bit.com.a.bbs.model.BbsDto;
import bit.com.a.bbs.model.BbsOrderDto;
import bit.com.a.bbs.model.PagingVO;
import bit.com.a.bbs.model.SearchDto;

@Repository
public class BbsDaoImpl implements BbsDao {

	@Autowired
	private SqlSession sqlSession;
	
	String namespace = "Bbs190729.";
	
	@Override
	public int getDBCountSize() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "getDBCountSize");
	}

	@Override
	public int getDBCountSizeByCondition(BbsOrderDto bbsOrderDto) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "getDBCountSizeByCondition", bbsOrderDto);
	}
	
	
	@Override
	public List<BbsDto> getAllBbs() {
		// TODO Auto-generated method stub
		List<BbsDto> lst = sqlSession.selectList(namespace + "getAll");		
		return lst;
	}
	
	@Override
	public List<BbsDto> getAllBbs(PagingVO pagingVO) {
		// TODO Auto-generated method stub
		List<BbsDto> lst = sqlSession.selectList(namespace + "getAllOrder", pagingVO);		
		return lst;
	}

	@Override
	public List<BbsDto> getAllBbs(SearchDto searchDto) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "getAllOrderAndSearch", searchDto);
	}	
	

	@Override
	public List<BbsDto> getAllBbs(BbsOrderDto bbsOrderDto) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "getAllBbs", bbsOrderDto);
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

	@Override
	public int writeNewReply(BbsDto dto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "writeNewReply", dto);
	}

	@Override
	public int plusOneStepBiggerThanOriginInReply(BbsDto dto) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "plusOneStepBiggerThanOriginInReply", dto);
	}
	
	
	/* 댓글(comment) 영역 */

	@Override
	public List<BbsCommentDto> getAllBbsComment(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "getAllBbsComment", seq);
	}

	@Override
	public int writeNewComment(BbsCommentDto dto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "writeNewComment", dto);
	}

	@Override
	public int deleteComment(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "deleteComment", seq);
	}

	@Override
	public int updateComment(BbsCommentDto dto) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "updateComment", dto);
	}
}
