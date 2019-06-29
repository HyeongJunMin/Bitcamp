package lct1MVCModel1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class MemDAO {
	/*
	 * singleton
	 * */
	
	private static MemDAO single = null;
	public static Map<String, MemDTO> hm = null;
	public static Connection memCon = null;
	public static DBConnection d = null;
	public static String currId = null;
	
	private MemDAO() {
		hm = new HashMap<String, MemDTO>();
		d = new DBConnection();
		memCon = d.getConnection();
		this.syncDBToMap();
	}
	
	public boolean syncDBToMap() {
		boolean complete = false;
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM MEMBER ";
		
		String id;
		String pw;
		String name;
		String email;
		int auth;
		
		
		try {
			stmt = memCon.createStatement();
			rs = stmt.executeQuery(sql);
			
			while( rs.next() ) {
				id = rs.getString(1);
				pw = rs.getString(2);
				name = rs.getString(3);
				email = rs.getString(4);
				auth = rs.getInt(5);
				hm.put(id, new MemDTO(id, pw, name, email, auth));				
			}
			
			System.out.println("DAO Map bring data from DB.");
		} catch (SQLException e) {
			System.out.println("DB Connection Fail(Sync DB To Map)");
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		}
		
		return complete;
	}
	
	public boolean addMem(String memId, String memPw, String memName, String email) {
		boolean complete = false;
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			stmt = memCon.createStatement();
			sql = " INSERT INTO MEMBER VALUES('" + memId + "', '" +
											memPw + "', '" +
											memName + "', '" +
											email + "', 3) ";
			rs = stmt.executeQuery(sql);
			complete = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return complete;
	}
	
	public static MemDAO getInstance() {
		if(single == null) {
			single = new MemDAO();
		}		
		return single;
	}
}
