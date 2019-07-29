package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.BbsDto;

public class BbsDao implements iBbsDao{
	
	private static BbsDao bbsdao = new BbsDao();
	
	private BbsDao() {}
	
	public static BbsDao getInstance() {
		return bbsdao;
	}
	
	public List<BbsDto> getBbsList(){
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE, PARENT, "
				+ " DEL, READCOUNT "
				+ " FROM BBS190729 "
				+ "ORDER BY REF DESC, STEP ASC, SEQ DESC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<BbsDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 get BbsList suc");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 get BbsList suc");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 get BbsList suc");
			
			while( rs.next() ) {
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
								rs.getInt(11)	);
				list.add(dto);
			}
			
			System.out.println("4/6 get BbsList suc");
			
		}catch(Exception e) {
			System.out.println("getBbsList fail in BbsDao " + e.getMessage());
		}finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return list;
	}
	
	//새 글 저장
	public int insertBbs(BbsDto dto) {
		int isDone = 0;
		
		String sql = " INSERT INTO BBS190729 VALUES ( SEQ_BBS190729.NEXTVAL, '" 
					+ dto.getId() + "', 0, 0, 0, '" +
						dto.getTitle() + "', '" + 
						dto.getContent() + "', SYSDATE, 0, 0, 0 ) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			System.out.println("0/6 insertBbs suc");
			
			conn = DBConnection.getConnection();
			System.out.println("1/6 insertBbs suc");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 insertBbs suc");
			
			psmt.executeUpdate();
			System.out.println("3/6 insertBbs suc");
						
			System.out.println("4/6 insertBbs suc");
			
			isDone = 1;
		}catch(Exception e) {
			System.out.println("insertBbs fail in BbsDao " + e.getMessage());
		}finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return isDone;
	}

	//seq로 글 검색
	public BbsDto getOnePost(int seq) {
		BbsDto dto = null;
		
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE, PARENT, "
				+ " DEL, READCOUNT "
				+ " FROM BBS190729 "
				+ "WHERE SEQ = " + seq + " ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 get BbsList suc");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 get BbsList suc");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 get BbsList suc");
			
			while( rs.next() ) {
				dto = new BbsDto(rs.getInt(1), 
								rs.getString(2), 
								rs.getInt(3), 
								rs.getInt(4), 
								rs.getInt(5), 
								rs.getString(6), 
								rs.getString(7), 
								rs.getString(8), 
								rs.getInt(9), 
								rs.getInt(10), 
								rs.getInt(11)	);
			}
			
			System.out.println("4/6 get BbsList suc");
			
		}catch(Exception e) {
			System.out.println("getBbsList fail in BbsDao " + e.getMessage());
		}finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return dto;
	}

	//bbs 내용 업데이트
	public int updateOnePost(BbsDto dto) {
		int isDone = 0;
		
		String sql = " UPDATE BBS190729 SET TITLE='" + dto.getTitle() + "', "
					+ "CONTENT='" + dto.getContent() + "' WHERE SEQ=" + dto.getSeq() + " ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			System.out.println("0/6 insertBbs suc");
			
			conn = DBConnection.getConnection();
			System.out.println("1/6 insertBbs suc");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 insertBbs suc");
			
			psmt.executeUpdate();
			System.out.println("3/6 insertBbs suc");
						
			System.out.println("4/6 insertBbs suc");
			
			isDone = 1;
		}catch(Exception e) {
			System.out.println("insertBbs fail in BbsDao " + e.getMessage());
		}finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return isDone;
	}

}
