package dao;

import java.util.List;

import dto.BbsDto;

public interface iBbsDao {
	
	public List<BbsDto> getBbsList();
	
	public boolean writeBbs(BbsDto bbs);
	
	public BbsDto getBbs(int seq);
	public void readcount(int seq);
	
	public boolean updateBbs(int seq, String title, String content);
	
	public boolean deleteBbs(int seq);
}
