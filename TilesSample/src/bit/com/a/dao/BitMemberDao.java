package bit.com.a.dao;

import bit.com.a.model.MemberDto;

public interface BitMemberDao {

	public boolean addmember(MemberDto mem)throws Exception;
	
	public int getId(MemberDto mem);
	
	public MemberDto login(MemberDto mem);
}
