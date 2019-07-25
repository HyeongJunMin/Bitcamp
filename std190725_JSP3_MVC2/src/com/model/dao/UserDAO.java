package com.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.dto.UserDTO;



public class UserDAO {
	
	private static UserDAO single = null;
	
	private UserDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static UserDAO getInstance() {
		if( single == null ) {
			single = new UserDAO();
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
	
	public List<UserDTO> getUserList() throws SQLException{
		
		String sql = " SELECT * FROM CUSTOMERS_USER ORDER BY ID ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<UserDTO> lst = new ArrayList<UserDTO>();
		
		conn = this.getConnection();
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
		
		while( rs.next() ) {
			String id = rs.getString("ID");
			String name = rs.getString("NAME");
			String address = rs.getString("ADDRESS");
			
			lst.add(new UserDTO(id, name, address));
		}
		System.out.println("user list done. list size:" + lst.size());
		
		this.close(conn, psmt, rs);
		
		return lst;
	}
	
	public UserDTO getUser(String inputId) throws SQLException{
		
		String sql = " SELECT * FROM CUSTOMERS_USER WHERE ID='" + inputId + "' ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		conn = this.getConnection();
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
		
		rs.next();
		
		String id = rs.getString("ID");
		String name = rs.getString("NAME");
		String address = rs.getString("ADDRESS");
			
		UserDTO dto = new UserDTO(id, name, address);
		
		this.close(conn, psmt, rs);
		
		return dto;
	}
	
	public List<UserDTO> search(String option, String txt) throws SQLException{
		
		String optionVal = "";
		
		switch(option) {
			case "1": optionVal = "ID"; break;
			case "2": optionVal = "NAME"; break;
			case "3": optionVal = "ADDRESS"; break;
			default : break;
		}
		System.out.println("들어온 옵션 : " + optionVal);
		System.out.println("들어온 텍스트 : " + txt);
		
		String sql = " SELECT * FROM CUSTOMERS_USER WHERE "
		+ optionVal + " LIKE '%" + txt + "%' ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<UserDTO> lst = new ArrayList<UserDTO>();
		
		conn = this.getConnection();
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
		
		while( rs.next() ) {
			String id = rs.getString("ID");
			String name = rs.getString("NAME");
			String address = rs.getString("ADDRESS");
			
			lst.add(new UserDTO(id, name, address));
		}
		System.out.println("user list done. list size:" + lst.size());
		
		this.close(conn, psmt, rs);
		
		return lst;
	}
	
	public void addUser(UserDTO dto) throws SQLException {
		String sql = " INSERT INTO CUSTOMERS_USER VALUES( "
				+ "'" + dto.getId() + "', '" + dto.getName() + "', '" 
				+ dto.getAddress() + "') ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		conn = this.getConnection();
		psmt = conn.prepareStatement(sql);
		
		psmt.executeUpdate();
		
		this.close(conn, psmt, rs);
	}
	
	public void delUser(String[] users) throws SQLException{
		String sql = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		conn = this.getConnection();
		
		for(String s : users) {
			sql = " DELETE FROM CUSTOMERS_USER WHERE ID='" + s + "' ";			
			psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();
		}
		
		this.close(conn, psmt, rs);
	}

	public void modUser(UserDTO dto) throws SQLException{
		String sql = " UPDATE CUSTOMERS_USER SET " 
				+ " NAME='" + dto.getName() + "', ADDRESS='" + dto.getAddress() + "' "
				+ "WHERE ID='" + dto.getId() + "' ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		conn = this.getConnection();
		psmt = conn.prepareStatement(sql);
		psmt.executeUpdate();
		
		
		this.close(conn, psmt, rs);
	}


}
