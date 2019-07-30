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

}
