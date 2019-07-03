package coffeeOrder_3_Service;

import java.util.Map;

import coffeeOrder_6_DTO.DTOCfMenu;

public interface MenuService {
	public Map<Integer, DTOCfMenu> getMemu();
	
	public int menuPrice(String menuName, String size);
	
}
