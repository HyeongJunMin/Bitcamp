package bit.com.a.dao;

import java.util.List;

import bit.com.a.model.PollDto;
import bit.com.a.model.PollSubDto;
import bit.com.a.model.VoterDto;

public interface BitPollDao {
	
	public List<PollDto> getAllPollList();
	
	public int isVote(VoterDto voter);
	
	public void makePoll(PollDto poll);
	
	public void makePollSub(PollSubDto pollsub);
}
