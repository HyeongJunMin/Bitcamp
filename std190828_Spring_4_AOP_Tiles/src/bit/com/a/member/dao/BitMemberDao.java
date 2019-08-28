package bit.com.a.member.dao;

import bit.com.a.member.model.MemberDto;

public interface BitMemberDao {
	public boolean insertMember(MemberDto dto);
	
	public MemberDto getOneMember(String id);
}
