package lct2MVC2_DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lct2MVC2_DAO.BbsDAO;
import lct2MVC2_DB.DBConnection;
import lct2MVC2_model.DTOBbs;

public class BbsDAOImpl implements BbsDAO {
	
	public DBConnection d = null;
			
	public BbsDAOImpl() {
		d = new DBConnection();
	}
	
	//BBS DB에 저장된 게시글 모두 리턴
	@Override
	public List<DTOBbs> getBbsList() {
		List<DTOBbs> lst = null;
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, "
				+ " WDATE, DEL, READCOUNT "
				+ " FROM BBS "
				+ " ORDER BY WDATE DESC ";
		
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		lst = new ArrayList<DTOBbs>();
		
		try {
			con = DBConnection.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while( rs.next() ) {
				DTOBbs dto = new DTOBbs(rs.getInt(1), 
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
			lst = null;
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
	
	//검색조건에 맞는 게시글을 리턴
	@Override
	public List<DTOBbs> getBbsList(String txt, int choice) {
		List<DTOBbs> lst = null;
		

		String sqlWhere = null;
		
		//sel > 제목=0, 내용=1, 작성자=2
		switch(choice){
			case 0: sqlWhere = " WHERE TITLE LIKE'%" + txt + "%' ";
					break;
			case 1: sqlWhere = " WHERE CONTENT LIKE '%" + txt + "%' ";
					break;
			case 2: sqlWhere = " WHERE ID LIKE '%" + txt + "%' ";
					break;
			default: break;
		}
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, "
				+ " WDATE, DEL, READCOUNT "
				+ " FROM BBS " + sqlWhere
				+ " ORDER BY WDATE DESC ";
		
		System.out.println("choice sql : " + sql);
		
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		lst = new ArrayList<DTOBbs>();
		
		try {
			con = DBConnection.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while( rs.next() ) {
				DTOBbs dto = new DTOBbs(rs.getInt(1), 
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
			lst = null;
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


	//게시글 삭제 == DEL을 0으로 수정, 완료하면 return true
	@Override
	public boolean deleteContent(DTOBbs dto) {
		// TODO Auto-generated method stub
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
			complete = true;
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
	
	//게시글 내용, 제목 수정, 완료하면 return true

	@Override
	public boolean updateContent(DTOBbs dto) {
		// TODO Auto-generated method stub
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
			complete = true;
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

	
	//조회수 ++, 완료하면 return true
	@Override
	public boolean updateReadCount(int seq) {
		// TODO Auto-generated method stub
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


	//시퀀스에 맞는 DTO를 찾는다. 완료하면 return DTOBbs
	@Override
	public DTOBbs selectContent(int seq) {
		// TODO Auto-generated method stub
		DTOBbs dto = null;
		
		String sql = " SELECT * FROM BBS WHERE SEQ = " + seq + " ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
				
		try {
			conn = DBConnection.getConnection();		
			psmt = conn.prepareStatement(sql);			
			rs = psmt.executeQuery();
			
			rs.next();
			
			dto = new DTOBbs(rs.getInt(1), 
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


	//입력받은 DTO의 내용대로 새 글을 DB에 Insert, 완료하면 return true
	@Override
	public boolean insertNewWrite(DTOBbs dto) {
		// TODO Auto-generated method stub
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

}
