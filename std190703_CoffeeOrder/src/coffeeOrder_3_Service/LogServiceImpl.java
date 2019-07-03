package coffeeOrder_3_Service;

import coffeeOrder_4_DAO.LogDAO;
import coffeeOrder_4_DAO.LogDAOImpl;

public class LogServiceImpl implements LogService {

	LogDAO dao = new LogDAOImpl();
	
	public LogServiceImpl() {
		
	}
	
	@Override
	public boolean order() {
		// TODO Auto-generated method stub
		return dao.order();
	}
	
}
