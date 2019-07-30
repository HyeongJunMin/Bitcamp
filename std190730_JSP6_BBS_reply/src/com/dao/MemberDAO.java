package com.dao;

import com.dto.MemberDTO;

public interface MemberDAO {

	
	/**
	 * MEMBER DB에서 입력한 ID를 검색해서 DTO 리턴
	 * @param id
	 * @return
	 */
	public MemberDTO selectOneMember(String id);
	
}
