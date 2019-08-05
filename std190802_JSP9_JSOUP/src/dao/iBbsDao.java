package dao;

import java.util.List;

import dto.BbsDto;

public interface iBbsDao {
	
	public List<BbsDto> getBbsList();
	public List<BbsDto> getBbsList(String choice, String searchWord);
	public List<BbsDto> getBbsPagingList(String choice, String searchWord, int page);
	
	public boolean writeBbs(BbsDto bbs);
	
	public BbsDto getBbs(int seq);
	public void readcount(int seq);
	
	public boolean updateBbs(int seq, String title, String content);
	public boolean deleteBbs(int seq);
	
	public boolean answer(int seq, BbsDto bbs);
	
	public int getAllBbs();
	
}




