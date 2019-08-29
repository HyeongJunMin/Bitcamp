package bit.com.a.service;

import bit.com.a.model.MemberDto;

public interface BitMemberService {

	public boolean addmember(MemberDto mem) throws Exception;
	
	public int getId(MemberDto mem);
	
	public MemberDto login(MemberDto mem);
}
