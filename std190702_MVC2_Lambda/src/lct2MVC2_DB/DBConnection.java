package lct2MVC2_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public DBConnection() {		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Driver Loading Success!!");			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.29:1521:xe", "hr", "hr");
			
			System.out.println("DB Connection Success!!");
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		
		return conn;
	}
}
