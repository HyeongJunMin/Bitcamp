package pds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.BbsDto;

public class PdsDao implements iPdsDao{
	
	private static PdsDao single = null;
	
	private PdsDao() {}
	
	public static PdsDao getInstance() {
		if( single == null ) {
			single = new PdsDao();
		}		
		return single;
	}

	@Override
	public List<PdsDto> getPdsList() {
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, FILENAME, READCOUNT, DOWNCOUNT, REGDATE "
				+ " FROM PDS "
				+ " ORDER BY SEQ DESC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<PdsDto> list = new ArrayList<PdsDto>();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int i = 1;
				PdsDto dto = new PdsDto(rs.getInt(i++), 
										rs.getString(i++), 
										rs.getString(i++),
										rs.getString(i++),
										rs.getString(i++),
										rs.getInt(i++),
										rs.getInt(i++),
										rs.getString(i++)
						);
				list.add(dto);				
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);			
		}	
		
		return list;
	}	

	/**
	 * @param dto를 DB에 저장
	 * @return
	 */
	public boolean insertNewPds(PdsDto dto) {
		boolean isDone = false;
		
		String sql = " INSERT INTO PDS VALUES( SEQ_PDS.NEXTVAL, "
				+ " '" + dto.getId() + "', " 
				+ " '" + dto.getTitle() + "', "
				+ " '" + dto.getContent() + "', "
				+ " '" + dto.getFilename() + "', "
				+ " 0, 0, SYSDATE) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();				
			
			isDone = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);			
		}	
		
		return isDone;
	}


	/**
	 * seq값으로 dto를 하나 찾아서 리턴
	 */
	public PdsDto getOnePds(int seq) {
		PdsDto dto = null;
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, FILENAME, READCOUNT, DOWNCOUNT, REGDATE "
				+ " FROM PDS "
				+ " WHERE SEQ =" + seq + " ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
				
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			int i = 1;
			dto = new PdsDto(rs.getInt(i++), 
								rs.getString(i++), 
								rs.getString(i++),
								rs.getString(i++),
								rs.getString(i++),
								rs.getInt(i++),
								rs.getInt(i++),
								rs.getString(i++)
					);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);			
		}	
		
		return dto;
	}
	
	/**
	 * DB정보를 매개변수로 받은 dto정보로 변경
	 */
	public boolean updateOnePds(PdsDto dto) {
		boolean isDone = false;
		
		String filenameQuery = ( dto.getFilename() == null || dto.getFilename().length() < 1 ) ? "" : ", FILENAME='" + dto.getFilename() + "' " ;
		System.out.println("filenameQuery : " + filenameQuery);
		
		String sql = " UPDATE PDS SET TITLE='" + dto.getTitle() + "', "
				+ "CONTENT='" + dto.getContent() + "' " + filenameQuery
				+ " WHERE SEQ=" + dto.getSeq() + " ";
		
		//String sql = " UPDATE PDS SET TITLE='test1', CONTENT='test1test1test1tes1test1tes1' WHERE SEQ=1 ";
				
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();				
			isDone = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);			
		}			
		return isDone;
	}
	
	/**
	 * 	PDS 테이블에서 seq에 맞는 데이터를 찾아서
	 *	addRead가 true이면 readcount++
	 *  addDown이 true이면 addDown++
	 */
	public boolean addCount(int seq, boolean addRead, boolean addDown) {
		boolean isDone = false;
		
		String cntQuery = "";
		
		//addRead
		if( addRead == true ) {
			if( addDown == true ) {
				//둘 다 참인 경우
				cntQuery = " READCOUNT=READCOUNT+1, DOWNCOUNT=DOWNCOUNT+1 ";
			}else {
				//addRead만 참인 경우
				cntQuery = " READCOUNT=READCOUNT+1 ";
			}
		}else if( addDown == true ) {
			//addDown만 참인 경우
			cntQuery = " DOWNCOUNT=DOWNCOUNT+1 ";
		}
		
		String sql = " UPDATE PDS SET " + cntQuery + "WHERE SEQ=" + seq + " ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();				
			
			isDone = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);			
		}			
		return isDone;
	}

	
	/**
	 *	PDS 테이블에서 seq에 맞는 데이터를 삭제
	 */
	public boolean delOnePds(int seq) {
		boolean isDone = false;
						
		String sql = " DELETE FROM PDS WHERE SEQ=" + seq + " ";
				
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();				
			isDone = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);			
		}			
		return isDone;
	}
}

