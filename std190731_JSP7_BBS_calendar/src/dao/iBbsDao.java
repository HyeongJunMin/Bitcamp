package dao;

import java.util.List;

import dto.BbsDto;
import vo.PagingVO;

public interface iBbsDao {
	
	public List<BbsDto> getBbsList();
	public List<BbsDto> getBbsList(String choice, String searchWord);
	
	public boolean writeBbs(BbsDto bbs);
	
	public BbsDto getBbs(int seq);
	
	public void readcount(int seq);
	
	public boolean updateBbs(int seq, String title, String content);
	
	public boolean deleteBbs(int seq);
	
	public boolean answer(int seq, BbsDto bbs);
	
	
	public List<BbsDto> getPagingList(PagingVO paging, int numPage);
	public List<BbsDto> getPagingList(PagingVO paging, int numPage, String choice, String searchWord);
}




