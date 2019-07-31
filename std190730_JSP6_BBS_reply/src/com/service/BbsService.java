package com.service;

import java.util.List;

import com.dto.BbsDTO;

public interface BbsService {
	public List<BbsDTO> getBbsList();
	
	public boolean writeNewPost(BbsDTO dto);
	
	public BbsDTO selectOnePost(int seq);
	
	public List<BbsDTO> searchPosts(String option, String condition);
}
