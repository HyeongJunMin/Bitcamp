package lct1MVCModel1;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public boolean updateMember(MemDTO dto) {
		boolean complete = false;
		
		String sql = " UPDATE MEMBER SET ID = ?, PW = ?, NAME = ?, EMAIL = ?, AUTH = ? WHERE ID = ? ";
		
		PreparedStatement psmt = null;
		
		try {
			psmt = memCon.prepareStatement(sql);
			
			System.out.println(dto.toString());
			psmt.setString(1, dto.getId() );
			psmt.setString(2, dto.getPw() );
			psmt.setString(3, dto.getName() );
			psmt.setString(4, dto.getEmail() );
			psmt.setInt(5, dto.getAuth());
			psmt.setString(6, dto.getId() );
			
			psmt.executeUpdate();
			System.out.println("okok" + "  " + dto.toString());
			complete = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return complete;
	}
	
	public boolean alterAuth(int auth, String id) {
		boolean complete = false;
		
		int authTo = 1;
		if(auth == 1)
			authTo = 3;
		
		String sql = " UPDATE MEMBER SET AUTH = " + authTo + "  WHERE ID = '" + id + "'  ";
		PreparedStatement psmt = null;
		int rs = 0;
		
		try {
			psmt = memCon.prepareStatement(sql);
			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return complete;
	}
	
	public boolean syncDBToMap() {
		boolean complete = false;
		
		hm = new HashMap<String, MemDTO>();
		
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
