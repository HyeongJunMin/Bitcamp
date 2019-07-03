package coffeeOrder_3_Service;

import java.util.List;

import coffeeOrder_4_DAO.LogDAO;
import coffeeOrder_4_DAO.LogDAOImpl;
import coffeeOrder_6_DTO.DTOOrderedMenu;

public class LogServiceImpl implements LogService {

	LogDAO dao = new LogDAOImpl();
	
	public LogServiceImpl() {
		
	}
	
	@Override
	public boolean order() {
		// TODO Auto-generated method stub
		return dao.order();
	}

	@Override
	public List<DTOOrderedMenu> getOrderLog() {
		// TODO Auto-generated method stub
		return dao.getOrderLog();
	}
	
}
