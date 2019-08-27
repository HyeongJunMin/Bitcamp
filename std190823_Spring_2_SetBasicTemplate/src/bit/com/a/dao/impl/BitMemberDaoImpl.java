package bit.com.a.dao.impl;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BitMemberDao;
import bit.com.a.model.MemberDto;

@Repository
public class BitMemberDaoImpl implements BitMemberDao {

	@Autowired
	private SqlSession sqlSession;
	
	String namespace = "Member.";
	
	@Override
	public boolean insertMember(MemberDto dto) {	
		int n = sqlSession.insert(namespace + "addMember", dto);				
		return n>0?true:false;
	}

}
