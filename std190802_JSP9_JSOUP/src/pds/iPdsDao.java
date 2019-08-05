package pds;

import java.util.List;

public interface iPdsDao {

	public List<PdsDto> getPdsList();
	
	public boolean writePds(PdsDto pds);
	
	public boolean downLoadCount(int seq);
	
	public PdsDto getPds(int seq);
	public boolean pdsReadCount(int seq);
	
	public boolean delPDS(int seq);
	public boolean updatePds(int seq, PdsDto pds);
}
