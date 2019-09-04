package bit.com.a.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BitPollDao;
import bit.com.a.model.PollBean;
import bit.com.a.model.PollDto;
import bit.com.a.model.PollSubDto;
import bit.com.a.model.VoterDto;
import bit.com.a.service.BitPollService;

@Service
public class BitPollServiceImpl implements BitPollService{

	@Autowired
	private BitPollDao pollDao;

	@Override
	public List<PollDto> getAllPollList(String id) {
		// 모든 투표 목록
		List<PollDto> list = pollDao.getAllPollList();
		
		// 투표를 할 수 있는지 정리해서 넘겨줄 리스트
		List<PollDto> plist = new ArrayList<>();
		
		for(PollDto poll : list ) {
			int pollid = poll.getPollid();
			int count = pollDao.isVote(new VoterDto(pollid, -1, id));
			//id를 가진 멤버가 투표를 했는지 여부를 poll에 set
			if( count == 1) {
				poll.setVote(true);
			}else {
				poll.setVote(false);
			}
			
			plist.add(poll);
		}
		
		
		return plist;
	}

	@Override
	public int isVote(VoterDto voter) {
		// TODO Auto-generated method stub
		return pollDao.isVote(voter);
	}

	@Override
	public void makePoll(PollBean pbean) {
		// 투표항목 PollDto DB에 저장
		System.out.println("start make poll, param pbean:" + pbean.toString());
		
		PollDto poll = new PollDto(pbean.getId(), pbean.getQuestion(), pbean.getSdate(), pbean.getEdate(), pbean.getItemcount(), 0);
//		PollDto poll = PollDto.builder().id( pbean.getId() )
//										.question( pbean.getQuestion() )
//										.sdate( pbean.getSdate() )
//										.edate( pbean.getEdate() )
//										.itemcount( pbean.getItemcount() )
//										.polltotal( 0 ).build();
		
		System.out.println("polldto build done, " + poll.toString() );
		
		pollDao.makePoll(poll);
		
		System.out.println("make poll done");
		
		// 선택지 DB에 저장
		String answer[] = pbean.getPollnum();
		for( int i = 0 ; i < pbean.getItemcount() ; i++ ) {
			PollSubDto pollsub = new PollSubDto();
			//pollsub.setPollid( poll.getPollid() );
			pollsub.setAnswer( answer[i] );
			
			pollDao.makePollSub(pollsub);
		}
		
		System.out.println("make poll sub done");
		
	}

	@Override
	public void makePollSub(PollSubDto pollsub) {
		// TODO Auto-generated method stub
		
	}	
	
}
