package bit.com.a.service;

import java.util.List;

import bit.com.a.model.PollBean;
import bit.com.a.model.PollDto;
import bit.com.a.model.PollSubDto;
import bit.com.a.model.VoterDto;

public interface BitPollService {
	
	public List<PollDto> getAllPollList(String id);
	
	public int isVote(VoterDto voter);
		
	//투표 만들기
	public void makePoll(PollBean pbean);	
	public void makePollSub(PollSubDto pollsub);
	
	//투표하기
	public PollDto getPoll(PollDto poll);
	public List<PollSubDto> getPollSubList(PollDto poll);
	
	//투표를 완료했을 때, 변경내용 DB에 저장
	public void polling(VoterDto voter);
}
