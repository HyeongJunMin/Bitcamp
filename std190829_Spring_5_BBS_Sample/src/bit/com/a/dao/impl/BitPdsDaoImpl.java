package bit.com.a.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BitPdsDao;
import bit.com.a.model.PdsDto;

@Repository
public class BitPdsDaoImpl implements BitPdsDao {

	/**SqlSession은 iBatis, SqlSessionTemplate은 MyBatis 소속. 차이는 없다고 봐도 무방
	 * 
	 */
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String ns = "Pds.";

	@Override
	public List<PdsDto> getPdsList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns + "getPdsList");
	}

	@Override
	public PdsDto getOnePds(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns + "getOnePds", seq);
	}

	@Override
	public boolean uploadPds(PdsDto dto) {
		// TODO Auto-generated method stub
		int n = sqlSession.insert(ns + "uploadPds", dto); 
		return (n>0)?true:false;
	}

	@Override
	public int plusDownCount(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.update(ns + "plusDownCount", seq);
	}

	
}
