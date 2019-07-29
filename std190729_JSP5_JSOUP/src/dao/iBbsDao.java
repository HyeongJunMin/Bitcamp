package dao;

import java.util.List;

import dto.BbsDto;

public interface iBbsDao {
	public List<BbsDto> getBbsList();
	
	public int insertBbs(BbsDto dto);
	
	public BbsDto getOnePost(int seq);
}
