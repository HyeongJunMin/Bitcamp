package coffeeOrder_4_DAO;

import java.util.Map;

import coffeeOrder_6_DTO.DTOCfMenu;

public interface MenuDAO {
	public Map<Integer, DTOCfMenu> getMemu();
	
	public boolean syncDBToMap();
	
	public int menuPrice(String menuName, String size);
}
