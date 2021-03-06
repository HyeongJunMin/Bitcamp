package pds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;

public class PdsDao implements iPdsDao {

	private static PdsDao dao = new PdsDao();
	
	private PdsDao() {
	}
	
	public static PdsDao getInstance() {
		return dao;
	}

	@Override
	public List<PdsDto> getPdsList() {
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, FILENAME, "
				+ " READCOUNT, DOWNCOUNT, REGDATE "
				+ " FROM PDS "
				+ " ORDER BY SEQ DESC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<PdsDto> list = new ArrayList<PdsDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getPdsList suc");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getPdsList suc");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getPdsList suc");
			
			while(rs.next()) {
				int i = 1;
				PdsDto dto = new PdsDto(rs.getInt(i++), 
										rs.getString(i++), 
										rs.getString(i++), 
										rs.getString(i++), 
										rs.getString(i++), 
										rs.getInt(i++), 
										rs.getInt(i++), 
										rs.getString(i++));
				list.add(dto);
			}	
			System.out.println("4/6 getPdsList suc");
			
		} catch (Exception e) {
			System.out.println("getPdsList fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);			
		}
		
		return list;
	}
	
	@Override
	public boolean writePds(PdsDto pds) {
		
		String sql = " INSERT INTO PDS(SEQ, ID, TITLE, CONTENT, FILENAME, "
					+ "				READCOUNT, DOWNCOUNT, REGDATE) "
					+ " VALUES(SEQ_PDS.NEXTVAL, ?, ?, ?, ?, "
					+ "				0, 0, SYSDATE) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 writePds suc");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pds.getId());
			psmt.setString(2, pds.getTitle());
			psmt.setString(3, pds.getContent());
			psmt.setString(4, pds.getFilename());
			System.out.println("2/6 writePds suc");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 writePds suc");
								
		} catch (Exception e) {
			System.out.println("writePds fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);			
		}
		
		return count>0?true:false;
	}
	
	@Override
	public boolean downLoadCount(int seq) {
		String sql = " UPDATE PDS "
				+ " SET DOWNCOUNT=DOWNCOUNT+1 "
				+ " WHERE SEQ=? "; 
		
		int count = 0;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 S downloadcount");
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/6 S downloadcount");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 S downloadcount");						
		} catch (Exception e) {
			System.out.println("fail downloadcount");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);			
		}		
		
		return count>0?true:false;
	}

	@Override
	public PdsDto getPds(int seq) {
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, "
				+ " FILENAME, READCOUNT, DOWNCOUNT, REGDATE "
				+ " FROM PDS "
				+ " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		PdsDto pds = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getPds Success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/6 getPds Success");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getPds Success");
			
			if(rs.next()) {
				int i = 1;				
				pds = new PdsDto(rs.getInt(i++), 
								rs.getString(i++), 
								rs.getString(i++), 
								rs.getString(i++), 
								rs.getString(i++), 
								rs.getInt(i++), 
								rs.getInt(i++), 
								rs.getString(i++));				
			}
			System.out.println("4/6 getPds Success");
			
		} catch (Exception e) {		
			System.out.println("getPds Fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);		
		}
				
		return pds;
	}
	
	@Override
	public boolean pdsReadCount(int seq) {
		int count=0;
		String sql=" UPDATE PDS SET " +
				" READCOUNT=READCOUNT+1 " +
				" WHERE  SEQ=? ";
		
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("2/6 S  pdsReadCount");
			
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, seq );
			System.out.println("3/6 S  pdsReadCount");
			
			count=psmt.executeUpdate();
			System.out.println("4/6 S  pdsReadCount");
			
		} catch (Exception e) {
			System.out.println("F pdsReadCount");
		}finally{
			DBClose.close(conn, psmt, null);			
		}
		return count>0?true:false;
	}
	
	@Override
	public boolean delPDS(int seq) {
		int count=0;
		String sql=" DELETE FROM PDS  " +
				" WHERE  SEQ = ? " ;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn=DBConnection.getConnection();
			System.out.println("2/6 S deletePDS");
			psmt=conn.prepareStatement(sql);
						
			psmt.setInt(1, seq);
			System.out.println("3/6 S deletePDS");
			
			count=psmt.executeUpdate();
			System.out.println("4/6 S deletePDS");
			
		} catch (Exception e) {
			System.out.println("F deletePDS");
		}finally{
			DBClose.close(conn, psmt, null);			
		}
		return count>0?true:false;
	}

	@Override
	public boolean updatePds(int seq, PdsDto pds) {
		
		System.out.println(pds.toString());
		
		String sql = " UPDATE PDS "
				+ "	SET TITLE=?, CONTENT=?, FILENAME=?, REGDATE=SYSDATE "
				+ " WHERE SEQ=? ";
		
		Connection conn=null;
		PreparedStatement psmt=null;
		
		int count=0;
		
		try {
			conn=DBConnection.getConnection();
			System.out.println("1/6 S updatePds");
			
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, pds.getTitle());
			psmt.setString(2, pds.getContent());
			psmt.setString(3, pds.getFilename());
			psmt.setInt(4, seq);
			System.out.println("2/6 S updatePds");
			
			count=psmt.executeUpdate();
			System.out.println("3/6 S updatePds");
			
		} catch (Exception e) {
			System.out.println("F updatePds");
		}finally{
			DBClose.close(conn, psmt, null);			
		}
		
		return count>0?true:false;
	}
	
	
	
}


