package coffeeOrder_1_Main;

import coffeeOrder_8_Singleton.Singleton;

public class CoffeeOrderMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton s = Singleton.getInstance();
		s.ctrl.login();
		
//		new View3MenuSelect();
//		new View4ShowMenu();
//		new View5ShowOrderList();
		System.out.println("그만...");
	}

}
