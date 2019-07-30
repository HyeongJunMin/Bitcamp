package com.dao;

import java.util.List;

import com.dto.BbsDTO;

public interface BbsDAO {
	public List<BbsDTO> getBbsList();
	
	public boolean writeNewPost(BbsDTO dto);
	
	public BbsDTO selectOnePost(int seq);
}
