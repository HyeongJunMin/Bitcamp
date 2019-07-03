package coffeeOrder_3_Service;

import java.util.List;

import coffeeOrder_6_DTO.DTOOrderedMenu;

public interface LogService {
	public boolean order();
	
	public List<DTOOrderedMenu> getOrderLog();
}
