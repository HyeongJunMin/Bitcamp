package bit.com.a.dao;

import java.util.List;

import bit.com.a.model.PdsDto;

public interface BitPdsDao {
	
	public List<PdsDto> getPdsList();
	
	public PdsDto getOnePds(int seq);
	
	public boolean uploadPds(PdsDto dto);
	
	public int plusDownCount(int seq);
}
