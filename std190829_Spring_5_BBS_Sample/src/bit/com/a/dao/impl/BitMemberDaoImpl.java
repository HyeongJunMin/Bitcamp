package bit.com.a.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BitMemberDao;
import bit.com.a.model.MemberDto;

@Repository // == 저장소
public class BitMemberDaoImpl implements BitMemberDao {

	@Autowired
	SqlSession sqlSession;
	
	String namespace = "Member.";
	
	@Override
	public boolean addmember(MemberDto mem) throws Exception {		
		int n = sqlSession.insert(namespace + "addmember", mem);		
		return n>0?true:false;
	}

	@Override
	public int getId(MemberDto mem) {		
		return sqlSession.selectOne(namespace + "getId", mem);
	}

	@Override
	public MemberDto login(MemberDto mem) {		
		return sqlSession.selectOne(namespace + "login", mem);
	}
	
	

	
}




