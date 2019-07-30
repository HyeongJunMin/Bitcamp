package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.BbsDAO;
import com.db.DBClose;
import com.db.DBConnection;
import com.dto.BbsDTO;

public class BbsDAOImpl implements BbsDAO{
	
	private static BbsDAOImpl single = null;
	
	public static BbsDAOImpl getInstance() {		
		if(single == null) {
			single = new BbsDAOImpl();
		}		
		return single;
	}
	
	
	/**
	 * BBS190729 DB에서 모든 게시물을 불러오는 메소드
	 */
	@Override
	public List<BbsDTO> getBbsList() {
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE, PARENT, "
				+ " DEL, READCOUNT "
				+ " FROM BBS190729 "
				+ " ORDER BY REF DESC, STEP ASC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDTO> list = new ArrayList<BbsDTO>();
		
		try {
			conn = DBConnection.getConnection();
			//System.out.println("1/6 getBbsList suc");
			
			psmt = conn.prepareStatement(sql);
			//System.out.println("2/6 getBbsList suc");
			
			rs = psmt.executeQuery();
			//System.out.println("3/6 getBbsList suc");
			
			while(rs.next()) {
				BbsDTO dto = new BbsDTO(rs.getInt(1), 
										rs.getString(2), 
										rs.getInt(3), 
										rs.getInt(4), 
										rs.getInt(5), 
										rs.getString(6), 
										rs.getString(7), 
										rs.getString(8), 
										rs.getInt(9), 
										rs.getInt(10), 
										rs.getInt(11));
				list.add(dto);				
			}			
			//System.out.println("4/6 getBbsList suc");
			
		} catch (Exception e) {
			//System.out.println("getBbsList fail " + e.getMessage());
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);			
		}	
		
		return list;
	}


	public boolean writeNewPost(BbsDTO dto) {
		boolean isDone = false;
		
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE, PARENT, "
				+ " DEL, READCOUNT "
				+ " FROM BBS190729 "
				+ " ORDER BY REF DESC, STEP ASC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
						
			isDone = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);			
		}	
		
		return isDone;
		
		
	}
}
