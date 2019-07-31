package com.service.impl;

import java.util.List;

import com.dao.impl.BbsDAOImpl;
import com.dto.BbsDTO;
import com.service.BbsService;

public class BbsServiceImpl implements BbsService {

	BbsDAOImpl dao = BbsDAOImpl.getInstance();
	
	@Override
	public List<BbsDTO> getBbsList() {
		// TODO Auto-generated method stub
		return dao.getBbsList();
	}

	@Override
	public boolean writeNewPost(BbsDTO dto) {
		// TODO Auto-generated method stub
		return dao.writeNewPost(dto);
	}

	@Override
	public BbsDTO selectOnePost(int seq) {
		// TODO Auto-generated method stub
		return dao.selectOnePost(seq);
	}

	@Override
	public List<BbsDTO> searchPosts(String option, String condition) {
		// TODO Auto-generated method stub
		return dao.searchPosts(option, condition);
	}
	
	
}
