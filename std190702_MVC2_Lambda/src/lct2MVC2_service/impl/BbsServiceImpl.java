package lct2MVC2_service.impl;

import java.util.List;

import lct2MVC2_DAO.BbsDAO;
import lct2MVC2_DAO.impl.BbsDAOImpl;
import lct2MVC2_model.DTOBbs;
import lct2MVC2_service.BbsService;

public class BbsServiceImpl implements BbsService {

	public BbsDAO dao = new BbsDAOImpl();
	
	@Override
	public List<DTOBbs> getBbsList() {
		// TODO Auto-generated method stub
		return dao.getBbsList();
	}
	
	@Override
	public List<DTOBbs> getBbsList(String txt, int choice) {
		// TODO Auto-generated method stub
		return dao.getBbsList(txt, choice);
	}

	@Override
	public boolean deleteContent(DTOBbs dto) {
		// TODO Auto-generated method stub
		return dao.deleteContent(dto);
	}

	@Override
	public boolean updateContent(DTOBbs dto) {
		// TODO Auto-generated method stub
		return dao.updateContent(dto);
	}

	@Override
	public boolean updateReadCount(int seq) {
		// TODO Auto-generated method stub
		return dao.updateReadCount(seq);
	}

	@Override
	public DTOBbs selectContent(int seq) {
		// TODO Auto-generated method stub
		return dao.selectContent(seq);
	}

	@Override
	public boolean insertNewWrite(DTOBbs dto) {
		// TODO Auto-generated method stub
		return dao.insertNewWrite(dto);
	}

}
