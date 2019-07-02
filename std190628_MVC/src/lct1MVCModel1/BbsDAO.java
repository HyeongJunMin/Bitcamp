package lct1MVCModel1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BbsDAO {
	private static BbsDAO single = null;
	
	private BbsDAO() { }
	
	public static BbsDAO getInstance() {
		if( single == null ) {
			single = new BbsDAO();
		}
		return single;
	}
	
	public boolean deleteContent(BbsDTO dto) {
		boolean complete = false;
		
		String sql = " UPDATE BBS SET "
				+ " DEL = 0 "
				+ " WHERE SEQ =" + dto.getSeq() + " ";

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			con = DBConnection.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				psmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return complete;
	}
	
	public boolean updateContent(BbsDTO dto) {
		boolean complete = false;
		
		String sql = " UPDATE BBS SET "
				+ " TITLE = '" + dto.getTitle() + "', "
				+ " CONTENT = '" + dto.getContent() + "' "
				+ "WHERE SEQ =" + dto.getSeq() + " ";

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			con = DBConnection.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				psmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return complete;
	}
	
	public boolean updateReadCount(int seq) {
		boolean complete = false;
		
		String sql = " UPDATE BBS SET READCOUNT = READCOUNT + 1 WHERE SEQ = ? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
						
		try {
			conn = DBConnection.getConnection();		
			psmt = conn.prepareStatement(sql);			
			psmt.setInt(1, seq);
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				psmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		return complete;
	}
	
	public BbsDTO selectContent() {
		BbsDTO dto = null;
		
		String sql = " SELECT * FROM BBS WHERE SEQ = 1 ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
				
		try {
			conn = DBConnection.getConnection();		
			psmt = conn.prepareStatement(sql);			
			rs = psmt.executeQuery();
			
			rs.next();
			
			dto = new BbsDTO(rs.getInt(1), 
									rs.getString(2), 
									rs.getString(3), 
									rs.getString(4), 
									rs.getString(5), 
									rs.getInt(6), 
									rs.getInt(7));
			System.out.println("di!!!!!!durldi!!!!!!!" + rs.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		return dto;
	}
	
	public BbsDTO selectContent(int seq) {
		BbsDTO dto = null;
		
		String sql = " SELECT SEQ, ID, TITLE, "
//							+ " CONTENT, "
//							+ " REPLACE(CONTENT, CHR(10), ''), "
//							+ " REPLACE(REPLACE(CONTENT,CHR(10), ''), CHR(13), ''), "
							+ " REPLACE ( CONTENT, CHR(13)||CHR(10), '\n') , "
							+ " WDATE, DEL, READCOUNT "
							+ " FROM BBS WHERE SEQ = " + seq + " ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
				
		try {
			conn = DBConnection.getConnection();		
			psmt = conn.prepareStatement(sql);			
			rs = psmt.executeQuery();
			
			rs.next();
			
			dto = new BbsDTO(rs.getInt(1), 
									rs.getString(2), 
									rs.getString(3), 
									rs.getString(4), 
									rs.getString(5), 
									rs.getInt(6), 
									rs.getInt(7));
			System.out.println("di!!!!!!durldi!!!!!!!" + rs.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		return dto;
	}
	
	public boolean insertNewWrite() {
		String id = "dddd";
		String title = "제목이다.";
		String contentIn = "ㅎㅎㅎㅎ\nggg\nㅎㅎㅎㅎ";
		String sql = " INSERT INTO BBS VALUES(SEQ_BBS.NEXTVAL, 'system', '제목2', 'ㅇㅇㅇ\nㅇㅇ', SYSDATE, 1, 1) ";
		
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			psmt = con.prepareStatement(sql);
//			psmt.setString(1, id);
//			psmt.setString(2, title);
//			psmt.setString(3, contentIn);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	public boolean insertNewWrite(BbsDTO dto) {
		boolean complete = false;
		
		
		String sql = " INSERT INTO BBS VALUES("
						+ "SEQ_BBS.NEXTVAL, '"
						+ dto.getId() + "', '"
						+ dto.getTitle() + "', '"
						+ dto.getContent() + "', SYSDATE, 1, 0) ";
		
		Connection con = null;
		PreparedStatement psmt = null;
		
		
		try {
			con = DBConnection.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				psmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return complete;
	}
	
	public List<BbsDTO> getBbsList(){
		List<BbsDTO> lst = null;
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, "
				+ " WDATE, DEL, READCOUNT "
				+ " FROM BBS "
				+ " ORDER BY WDATE DESC ";
		
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		lst = new ArrayList<BbsDTO>();
		
		try {
			con = DBConnection.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while( rs.next() ) {
				BbsDTO dto = new BbsDTO(rs.getInt(1), 
										rs.getString(2), 
										rs.getString(3), 
										rs.getString(4), 
										rs.getString(5), 
										rs.getInt(6), 
										rs.getInt(7) );
				lst.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return lst;
	}
	
	public List<BbsDTO> getBbsList(String title, int sel){
		List<BbsDTO> lst = null;
		
		String sql = null;
		//sel > 제목=0, 내용=1, 작성자=2
		switch(sel){
			case 0: sql = " SELECT SEQ, ID, TITLE, CONTENT, "
					+ " WDATE, DEL, READCOUNT "
					+ " FROM BBS WHERE TITLE = '" + title + "' "
					+ " ORDER BY WDATE DESC ";
					break;
			case 1:sql = " SELECT SEQ, ID, TITLE, CONTENT, "
					+ " WDATE, DEL, READCOUNT "
					+ " FROM BBS WHERE CONTENT LIKE '%" + title + "%' "
					+ " ORDER BY WDATE DESC ";
					break;
			case 2:sql = " SELECT SEQ, ID, TITLE, CONTENT, "
					+ " WDATE, DEL, READCOUNT "
					+ " FROM BBS WHERE ID = '" + title + "' "
					+ " ORDER BY WDATE DESC ";
					break;
			default: break;
		}
		
		
		
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		lst = new ArrayList<BbsDTO>();
		
		try {
			con = DBConnection.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while( rs.next() ) {
				BbsDTO dto = new BbsDTO(rs.getInt(1), 
										rs.getString(2), 
										rs.getString(3), 
										rs.getString(4), 
										rs.getString(5), 
										rs.getInt(6), 
										rs.getInt(7) );
				lst.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ee){
			System.out.println("없음");
		} finally {
			try {
				con.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return lst;
	}
}
