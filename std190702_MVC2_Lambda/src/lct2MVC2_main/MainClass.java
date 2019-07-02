package lct2MVC2_main;

import lct2MVC2_DB.DBConnection;
import lct2MVC2_single.Singleton;

public class MainClass {
	
	static DBConnection db;
	
	public static void main(String[] args) {
		db = new DBConnection();
		
		Singleton s = Singleton.getInstance();
		s.memCtrl.login();
	}
}
