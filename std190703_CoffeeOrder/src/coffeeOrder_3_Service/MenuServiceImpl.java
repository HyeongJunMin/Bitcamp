package coffeeOrder_3_Service;

import java.util.Map;

import coffeeOrder_4_DAO.MenuDAO;
import coffeeOrder_4_DAO.MenuDAOImpl;
import coffeeOrder_6_DTO.DTOCfMenu;

public class MenuServiceImpl implements MenuService {

	MenuDAO dao = new MenuDAOImpl();
	
	@Override
	public Map<Integer, DTOCfMenu> getMemu() {
		// TODO Auto-generated method stub
		return dao.getMemu();
	}

	@Override
	public int menuPrice(String menuName, String size) {
		// TODO Auto-generated method stub
		return dao.menuPrice(menuName, size);
	}

}
