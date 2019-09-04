package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BitPollDao;
import bit.com.a.model.PollDto;
import bit.com.a.model.PollSubDto;
import bit.com.a.model.VoterDto;

@Repository
public class BitPollDaoImpl implements BitPollDao {

	@Autowired
	private SqlSession sqlSession;
	
	private String ns = "Poll.";

	@Override
	public List<PollDto> getAllPollList() {
		return sqlSession.selectList(ns + "getAllPollList");
	}

	@Override
	public int isVote(VoterDto voter) {
		return sqlSession.selectOne(ns + "idVote", voter);
	}

	@Override
	public void makePoll(PollDto poll) {
		sqlSession.insert(ns + "makePoll", poll);
	}

	@Override
	public void makePollSub(PollSubDto pollsub) {
		sqlSession.insert(ns + "makePollSub", pollsub);
	}	
	
}
