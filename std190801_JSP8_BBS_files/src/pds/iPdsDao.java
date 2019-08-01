package pds;

import java.util.List;

public interface iPdsDao {

	public List<PdsDto> getPdsList();
	
	public PdsDto getOnePds(int seq);
	
	public boolean updateOnePds(PdsDto dto);
	
	public boolean addCount(int seq, boolean addRead, boolean addDown);
	
	public boolean delOnePds(int seq);
}
