package coffeeOrder_8_Singleton;

import java.util.ArrayList;
import java.util.List;

import coffeeOrder_2_Controller.CoffeeOrderController;
import coffeeOrder_6_DTO.DTOOrderedMenu;

public class Singleton {
	
	private static Singleton s = null;
	
	public CoffeeOrderController ctrl = null;
	public String sessionId = "";
	public List<DTOOrderedMenu> orderBucket = null;
	
	private Singleton() {
		ctrl = new CoffeeOrderController();
		orderBucket = new ArrayList<DTOOrderedMenu>();
	}
	
	public static Singleton getInstance() {
		if( s == null ) {
			s = new Singleton();
		}
		
		return s;
	}
}
