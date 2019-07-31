package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.BbsDto;

public class BbsDao implements iBbsDao {

	private static BbsDao bbsdao = new BbsDao();
	
	private BbsDao() {
	}
	
	public static BbsDao getInstance() {
		return bbsdao;
	}

	
	@Override
	public List<BbsDto> getBbsList() {
		
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE, PARENT, "
				+ " DEL, READCOUNT "
				+ " FROM BBS190729 "
				+ " ORDER BY REF DESC, STEP ASC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<BbsDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getBbsList suc");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getBbsList suc");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getBbsList suc");
			
			while(rs.next()) {
				BbsDto dto = new BbsDto(rs.getInt(1), 
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
			System.out.println("4/6 getBbsList suc");
			
		} catch (Exception e) {
			System.out.println("getBbsList fail " + e.getMessage());
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);			
		}	
		
		return list;
	}
	
	
	@Override
	public boolean writeBbs(BbsDto bbs) {
		String sql = " INSERT INTO BBS190729 "
				+ " (SEQ, ID, "
				+ " REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE, PARENT, "
				+ " DEL, READCOUNT) "
				+ " VALUES(SEQ_BBS.NEXTVAL, ?, "
				+ " (SELECT NVL(MAX(REF), 0)+1 FROM BBS), "	// 1 2 3		// ref
				+ " 0, 0, "							// step, depth
				+ " ?, ?, SYSDATE, 0, "
				+ " 0, 0) ";
		
		int count = 0;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 writeBbs Success");	
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 writeBbs Success");
			
			psmt.setString(1, bbs.getId());
			psmt.setString(2, bbs.getTitle());
			psmt.setString(3, bbs.getContent());
			
			count = psmt.executeUpdate();
			System.out.println("3/6 writeBbs Success");
						
		} catch (Exception e) {
			System.out.println("writeBbs Fail");
		} finally {
			DBClose.close(conn, psmt, null);			
		}
				
		return count>0?true:false;
	}

	@Override
	public BbsDto getBbs(int seq) {
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE, PARENT, "
				+ " DEL, READCOUNT "
				+ " FROM BBS190729 "
				+ " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		BbsDto dto = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getBbs Success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/6 getBbs Success");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getBbs Success");
			
			if(rs.next()) {				
				dto = new BbsDto(rs.getInt(1), 	// seq
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
			}
			
		} catch (Exception e) {
			System.out.println("getBbs fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);			
		}
		
		return dto;
	}

	@Override
	public void readcount(int seq) {
		String sql = " UPDATE BBS190729 SET "
				+ " READCOUNT=READCOUNT+1 "
				+ " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 readcount Success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/6 readcount Success");
			
			psmt.executeUpdate();
			System.out.println("3/6 readcount Success");			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);			
		}
	}
	
	@Override
	public boolean updateBbs(int seq, String title, String content) {
		String sql = " UPDATE BBS190729 SET "
				+ " TITLE=?, CONTENT=? "
				+ " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("2/6 S updateBbs");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setInt(3, seq);
			
			System.out.println("3/6 S updateBbs");
			
			count = psmt.executeUpdate();
			System.out.println("4/6 S updateBbs");
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally{
			DBClose.close(conn, psmt, null);
			System.out.println("5/6 S updateBbs");
		}		
		
		return count>0?true:false;
	}

	@Override
	public boolean deleteBbs(int seq) {
		
		String sql = " UPDATE BBS190729 "
					+ " SET DEL=1 "
					+ " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 S deleteBbs");
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/6 S deleteBbs");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 S deleteBbs");
			
		} catch (Exception e) {		
			System.out.println("fail deleteBbs");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);			
		}
		
		return count>0?true:false;
	}

	@Override
	public boolean answer(int seq, BbsDto bbs) {
		// update
		String sql1 = " UPDATE BBS190729 "
					+ "	SET STEP=STEP+1 "
					+ " WHERE REF=(SELECT REF FROM BBS190729 WHERE SEQ=?) "
					+ "		AND STEP>(SELECT STEP FROM BBS190729 WHERE SEQ=?) ";
		/*
		  	2-0-0
			3-0-0	
				3-1-1	-> SEQ
					(3-2-2)	--> 기준점
		step	3-3-1	-> depth
					3-4-2
					3-5-2
			4-0-0
		*/
		
		// insert
		String sql2 = " INSERT INTO BBS190729 "
				+ " (SEQ, ID, REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE, PARENT, DEL, READCOUNT) "
				+ " VALUES(SEQ_BBS.NEXTVAL, ?, "
				+ "		(SELECT REF FROM BBS190729 WHERE SEQ=?), "	// REF
				+ "	    (SELECT STEP FROM BBS190729 WHERE SEQ=?) + 1, " //STEP
				+ "		(SELECT DEPTH FROM BBS190729 WHERE SEQ=?) + 1, " // DEPTH
				+ " ?, ?, SYSDATE, ?, 0, 0) "; 	
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			System.out.println("1/6 answer success");
			
			// update
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, seq);
			psmt.setInt(2, seq);
			System.out.println("2/6 answer success");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 answer success");
			
			// psmt 초기화
			psmt.clearParameters();
			
			// insert
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, bbs.getId());
			psmt.setInt(2, seq);	// ref
			psmt.setInt(3, seq);	// step
			psmt.setInt(4, seq);	// depth
			psmt.setString(5, bbs.getTitle());
			psmt.setString(6, bbs.getContent());
			psmt.setInt(7, seq);	// parent
			System.out.println("4/6 answer success");
			
			count = psmt.executeUpdate();
			conn.commit();
			System.out.println("5/6 answer success");
			
		} catch (Exception e) {
			System.out.println("answer fail");			
			try {
				conn.rollback();
			} catch (SQLException e1) {}				
			e.printStackTrace();
		} finally {			
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			DBClose.close(conn, psmt, null);
			System.out.println("6/6 answer success");
		}	
		
		return count>0?true:false;
	}	
	
	
	@Override
	public List<BbsDto> getBbsList(String choice, String searchWord) {
		
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE, PARENT, "
				+ " DEL, READCOUNT "
				+ " FROM BBS190729 ";		
		
		// 검색항목과 검색어
		String sqlWord = "";
		if(choice.equals("title")) {
			sqlWord = " WHERE TITLE LIKE '%" + searchWord.trim() + "%' ";
		}
		else if(choice.equals("writer")) {
			sqlWord = " WHERE ID='" + searchWord.trim() + "' ";
		}	
		else if(choice.equals("content")) {
			sqlWord = " WHERE CONTENT LIKE '%" + searchWord.trim() + "%' ";
		}
		sql += sqlWord;		
				
		sql += " ORDER BY REF DESC, STEP ASC";
				
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getBbsList suc");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getBbsList suc");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getBbsList suc");
			
			while(rs.next()) {
				
				BbsDto dto = new BbsDto(rs.getInt(1), 	// seq
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
			System.out.println("4/6 getBbsList suc");
			
		} catch (Exception e) {
			System.out.println("getBbsList fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);			
		}
		
		return list;
	}
}




