package com.service.impl;

import com.dao.impl.MemberDAOImpl;
import com.dto.MemberDTO;
import com.service.MemberService;

public class MemberServiceImpl implements MemberService{

	MemberDAOImpl dao = new MemberDAOImpl();
	
	@Override
	public MemberDTO selectOneMember(String inputId) {
		// TODO Auto-generated method stub
		return dao.selectOneMember(inputId);
	}
	
}
