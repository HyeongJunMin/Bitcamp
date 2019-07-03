package coffeeOrder_3_Service;

import java.util.Map;

import coffeeOrder_4_DAO.MemDAO;
import coffeeOrder_4_DAO.MemDAOImpl;
import coffeeOrder_6_DTO.DTOCfMem;

public class MemServiceImpl implements MemService {
	
	public MemDAO dao = new MemDAOImpl();

	@Override
	public Map<String, DTOCfMem> getMembersFromDB() {
		// TODO Auto-generated method stub
		return dao.getMembersFromDB();
	}

	@Override
	public boolean regNewMember(DTOCfMem dto) {
		// TODO Auto-generated method stub
		return dao.regNewMember(dto);
	}

	@Override
	public boolean idChk(String id) {
		// TODO Auto-generated method stub
		return dao.idChk(id);
	}

	@Override
	public String[] chcAccount(String id) {
		// TODO Auto-generated method stub
		return dao.chcAccount(id);
	}	
}
