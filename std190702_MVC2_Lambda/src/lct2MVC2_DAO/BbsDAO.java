package lct2MVC2_DAO;

import java.util.List;

import lct2MVC2_model.DTOBbs;

public interface BbsDAO {
	List<DTOBbs> getBbsList();
	
	List<DTOBbs> getBbsList(String txt, int choice);
	
	boolean deleteContent(DTOBbs dto);

	boolean updateContent(DTOBbs dto);
	
	public boolean updateReadCount(int seq) ;
	
	public DTOBbs selectContent(int seq);
	
	public boolean insertNewWrite(DTOBbs dto);



}
