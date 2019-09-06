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
		return sqlSession.selectOne(ns + "isVote", voter);
	}

	//투표 만들기
	@Override
	public void makePoll(PollDto poll) {
		sqlSession.insert(ns + "makePoll", poll);
	}

	@Override
	public void makePollSub(PollSubDto pollsub) {
		sqlSession.insert(ns + "makePollSub", pollsub);
	}
	

	// 투표 수행하기
	@Override
	public PollDto getPoll(PollDto poll) {
		return sqlSession.selectOne(ns + "getPoll", poll);
	}

	@Override
	public List<PollSubDto> getPollSubList(PollDto poll) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns+"getPollSubList", poll);
	}

	
	//투표를 완료했을 때, 변경내용 DB에 저장
	@Override
	public void pollingVoter(VoterDto voter) {
		sqlSession.insert(ns + "pollingVote", voter);
	}
	@Override
	public void pollingPoll(VoterDto voter) {
		sqlSession.update(ns + "pollingPoll", voter);
	}
	@Override
	public void pollingSub(VoterDto voter) {
		sqlSession.update(ns + "pollingSub", voter);
	}	
}
