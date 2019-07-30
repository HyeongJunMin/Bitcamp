package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.MemberDAO;
import com.db.DBClose;
import com.db.DBConnection;
import com.dto.MemberDTO;


public class MemberDAOImpl implements MemberDAO{

	/**
	 * MEMBER DB에서 입력한 ID를 검색해서 DTO 리턴
	 */
	public MemberDTO selectOneMember(String inputId) {
		MemberDTO dto = null;
		
		String sql = " SELECT ID, PW, NAME, EMAIL, AUTH "
				+ " FROM MEMBER "
				+ " WHERE ID=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			//System.out.println("1/6 login suc");
			
			psmt.setString(1, inputId);
			
			//System.out.println("2/6 login suc");
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				int auth = rs.getInt(5);
				
				dto = new MemberDTO(id, pw, name, email, auth);				
			}
			//System.out.println("3/6 login suc");
			
		} catch (Exception e) {
			//System.out.println("login fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);			
		}
		
		return dto;
	}
}
