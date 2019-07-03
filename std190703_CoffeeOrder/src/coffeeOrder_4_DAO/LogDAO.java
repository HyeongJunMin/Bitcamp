package coffeeOrder_4_DAO;

import java.util.List;

import coffeeOrder_6_DTO.DTOOrderedMenu;

public interface LogDAO {
	public boolean order();
	
	public List<DTOOrderedMenu> getOrderLog();
}
