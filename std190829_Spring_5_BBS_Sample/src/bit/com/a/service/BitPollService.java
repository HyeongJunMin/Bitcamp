package bit.com.a.service;

import java.util.List;

import bit.com.a.model.PollBean;
import bit.com.a.model.PollDto;
import bit.com.a.model.PollSubDto;
import bit.com.a.model.VoterDto;

public interface BitPollService {
	
	public List<PollDto> getAllPollList(String id);
	
	public int isVote(VoterDto voter);
		
	public void makePoll(PollBean pbean);
	
	public void makePollSub(PollSubDto pollsub);
}
