package bit.com.a.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.member.dao.BitMemberDao;
import bit.com.a.member.model.MemberDto;
import bit.com.a.member.service.BitMemberService;

@Service
public class BitMemberServiceImpl implements BitMemberService {

	@Autowired
	private BitMemberDao bitMemberDao;

	@Override
	public boolean insertMember(MemberDto dto) throws Exception {
		// TODO Auto-generated method stub
		return bitMemberDao.insertMember(dto);
	}

	@Override
	public MemberDto getOneMember(String id) {
		// TODO Auto-generated method stub
		return bitMemberDao.getOneMember(id);
	}	
}
