package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.CalendarDto;

public class CalendarDao implements iCalendar{
	private static CalendarDao dao = new CalendarDao();

	private CalendarDao() {
	}
	
	public static CalendarDao getInstance() {
		return dao;
	}
	
	/**
	 * @param id의 일정만 보여줌
	 * @param yyyyMM년월의 일정만 보여줌
	 * @return
	 */
	public List<CalendarDto> getCalendarList(String id, String yyyyMM){
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, RDATE, WDATE " + 
				" FROM (SELECT ROW_NUMBER() OVER( PARTITION BY SUBSTR(RDATE, 1, 8) ORDER BY RDATE ASC )	RNUM, " + 
				" SEQ, ID, TITLE, CONTENT, RDATE, WDATE " + 
				" FROM CALENDAR " + 
				" WHERE ID=? AND SUBSTR(RDATE, 1, 6)=? ) " + 
				" WHERE RNUM BETWEEN 1 AND 5  ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<CalendarDto> list = new ArrayList<CalendarDto>();
		
		try {
			conn = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			
			// WHERE ID=? AND SUBSTR(RDATE, 1, 6)=? ) 
			psmt.setString(1, id);
			psmt.setString(2, yyyyMM.trim() );
			
			rs = psmt.executeQuery();
			
			
			
			while( rs.next() ) {
				int i = 1;
				CalendarDto dto = new CalendarDto(
						rs.getInt(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
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
	 * 새 일정 등록
	 */
	@Override
	public boolean writeNewSch(CalendarDto dto) {
		boolean isDone = false;
				
		String sql = " INSERT INTO CALENDAR VALUES( " + 
				" SEQ_CAL.NEXTVAL, ?, ?, ?, ?, SYSDATE ) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
						
			psmt = conn.prepareStatement(sql);
						
			// WHERE ID=? AND SUBSTR(RDATE, 1, 6)=? ) 
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle() );
			psmt.setString(3, dto.getContent() );
			psmt.setString(4, dto.getRdate() );
			
			psmt.executeUpdate();
			
			isDone = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return isDone;
	}
	
	
	/**
	 *	1개의 일정 데이터 DB에서 seq값으로 검색하여 리턴
	 */
	public CalendarDto getOneSch(int seq) {
		CalendarDto dto = null;
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, RDATE, WDATE " + 
				" FROM CALENDAR " + 
				" WHERE SEQ=" + seq + " ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<CalendarDto> list = new ArrayList<CalendarDto>();
		
		try {
			conn = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
						
			rs = psmt.executeQuery();
						
			rs.next();
			int i = 1;
			dto = new CalendarDto(
						rs.getInt(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
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
	 * @param seq값으로 DB에서 내용을 검색하고 해당 스케쥴 삭제
	 * @return
	 */
	public boolean deleteOneSch(int seq) {
		boolean isDone = false;
		
		String sql = " DELETE FROM CALENDAR WHERE SEQ=" + seq + " ";
		
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
	 * @param dto에 해당하는 글을 수정
	 * @return
	 */
	public boolean modOneSch(CalendarDto dto) {
		boolean isDone = false;
		
		String sql = " UPDATE CALENDAR SET TITLE='" + dto.getTitle() + "', " +
					"CONTENT='" + dto.getContent() + "' " + 
					"WHERE seq=" + dto.getSeq() + " ";
		
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
