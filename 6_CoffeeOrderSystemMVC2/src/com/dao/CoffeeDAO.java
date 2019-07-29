package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dto.CoffeeMemberDTO;
import com.dto.CoffeeMenuDTO;

public class CoffeeDAO {
	private static CoffeeDAO single = null;
	
	private CoffeeDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static CoffeeDAO getInstance() {
		if( single == null ) {
			single = new CoffeeDAO();
		}		
		return single;
	}	
	
	public Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@192.168.0.29:1521:xe";
		String user = "hr";
		String pass = "hr";
		
		return DriverManager.getConnection(url, user, pass);
	}
	
	public void close(Connection conn, PreparedStatement psmt, ResultSet rs) throws SQLException {
		if(conn != null) 
			conn.close();
		if(psmt != null) 
			psmt.close();
		if(rs != null) 
			rs.close();
	}
	
	//DB에서 메뉴 리스트를 가져오는 메소드
	public List<CoffeeMenuDTO> getMenuList() throws SQLException{
		
		String sql = " SELECT * FROM COFFEE_MENU ORDER BY SEQ ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<CoffeeMenuDTO> lst = new ArrayList<CoffeeMenuDTO>();
		
		conn = this.getConnection();
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
		
		while( rs.next() ) {
			int seq = rs.getInt("SEQ");
			String name = rs.getString("NAME");
			int priceShort = rs.getInt("PRICE_SHORT");
			int priceTall = rs.getInt("PRICE_TALL");
			int priceGrande = rs.getInt("PRICE_GRANDE");
			
			lst.add(new CoffeeMenuDTO(seq, name, priceShort, priceTall, priceGrande));
		}
		System.out.println("user list done. list size:" + lst.size());
		
		this.close(conn, psmt, rs);
		
		return lst;
	}

	//DB에서 한 계정의 정보를 가져오는 메소드
	public String[] getOneMamberInfo(String inputId) throws SQLException{
		String[] idAndPw = null;
		
		String sql = " SELECT ID, PW FROM COFFEE_MEM WHERE ID='" + inputId + "' ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		conn = this.getConnection();
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
		
		while( rs.next() ) {
			String dbId = rs.getString("ID");
			String dbPw = rs.getString("PW");

			idAndPw = new String[2];
			idAndPw[0] = dbId;
			idAndPw[1] = dbPw;
		}		
		
		this.close(conn, psmt, rs);
		
		return idAndPw;
	}

	//새 계정 insert
	public void insertOneMember(CoffeeMemberDTO dto) {
		
		String id = dto.getId();
		String pw = dto.getPw();
		String name = dto.getName();
		int age = dto.getAge();
				
		String sql = " INSERT INTO COFFEE_MEM VALUES( '" + id + "'"
				+ ", '" + pw +"', '" + name + "', " + age + ", SYSDATE, 3) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.executeUpdate(sql);			
			
			this.close(conn, psmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
