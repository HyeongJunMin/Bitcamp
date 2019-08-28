package bit.com.a.member.service;

import bit.com.a.member.model.MemberDto;

public interface BitMemberService {
	
	public boolean insertMember(MemberDto dto) throws Exception;
	
	public MemberDto getOneMember(String id);
}
