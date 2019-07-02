package lct2MVC2_DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lct2MVC2_DAO.MemberDAO;
import lct2MVC2_DB.DBConnection;
import lct2MVC2_model.DTOMem;


public class MemberDAOImpl implements MemberDAO {

	private static MemberDAOImpl single = null;
	public static Map<String, DTOMem> hm = null;
	public static Connection memCon = null;
	public static DBConnection d = null;
	public static String currId = null;
	
	public MemberDAOImpl() {
		hm = new HashMap<String, DTOMem>();
		d = new DBConnection();
		memCon = d.getConnection();
		this.syncDBToMap();
	}

	public boolean isAdmin(String id) {
		boolean isAd = false;
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			stmt = memCon.createStatement();
			sql = " SELECT * FROM MEMBER WHERE ID = '" + id + "' ";
			
			rs = stmt.executeQuery(sql);
			if( rs == null ) {
				
			}else {
				rs.next();
				
				int auth = rs.getInt(5);
				
				if(auth == 1) {
					isAd = true;
					System.out.println("이야관리자다!!!!!!!!!!!!!!!!!!!!");
				}				
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return isAd;
	}
	
	@Override
	public boolean addMem(DTOMem dto) {
		boolean complete = false;
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			stmt = memCon.createStatement();
			sql = " INSERT INTO MEMBER VALUES('" + dto.getId() + "', '" +
											dto.getPw() + "', '" +
											dto.getName() + "', '" +
											dto.getEmail() + "', 3) ";
			rs = stmt.executeQuery(sql);
			complete = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return complete;
	}

	//MEMBER DB에서 계정정보를 받아 Map에 저장하여 리턴
	public Map<String, DTOMem> getMap(){
		this.syncDBToMap();
		return hm;
	}
	
	//View_ModMem에서 수정내용을 MEMBER DB에 반영하는 메소드
	@Override
	public boolean updateMember(DTOMem dto) {
		boolean complete = false;
		
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			System.out.println("잘 받았다 dto는 " + dto.toString());
			sql = " UPDATE MEMBER SET PW = ?, NAME = ?, EMAIL = ?, AUTH = ?  WHERE ID = ? ";
			ptmt = memCon.prepareStatement(sql);
//			ptmt.setString(1, dto.getId());
			ptmt.setString(1, dto.getPw());
			ptmt.setString(2, dto.getName());
			ptmt.setString(3, dto.getEmail());
			ptmt.setInt(4, dto.getAuth());
			ptmt.setString(5, dto.getId());

			int n = ptmt.executeUpdate();

			if( n > 0) {
				complete = true;	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("wrong pw : MemberDAOImpl.getPw(String pw)");
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		return complete;
	}

	//View_Mgr에서 선택한 계정들을 MEMBER DB에서 삭제하는 메소드
	@Override
	public boolean deleteMembers(List<String> ids) {
		// TODO Auto-generated method stub
		boolean complete = false;
		
		Statement stmt = null;
		
		String sql;
		String id = "";
		
		try {
			stmt = memCon.createStatement();
			
			for( int i = 0 ; i < ids.size() ; i++ ) {
				id += "'"+ids.get(i)+"' ";
				if( (i+1) < ids.size() ) {
					id += ", ";
				}
			}
			sql = " DELETE FROM MEMBER WHERE ID IN ( " + id + " ) ";
			
			stmt.executeUpdate(sql);
			
			System.out.println("삭제 끝났습니다!!! 문자열:" + id);
			
			complete = true;	
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("wrong pw : MemberDAOImpl.getPw(String pw)");
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		return complete;
	}
	
	@Override
	public boolean getId(String id) {
		// TODO Auto-generated method stub
		boolean complete = false;
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			stmt = memCon.createStatement();
			sql = " SELECT * FROM MEMBER WHERE ID = '" + id + "' ";
			
			rs = stmt.executeQuery(sql);
			if( rs == null ) {
				
			}else {
				System.out.println(rs.toString());
				rs.next();
				System.out.println("getId result : " + rs.getString(2).equals(id));
				complete = true;
			}			
			
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("wrong id : MemberDAOImpl.getId(String id)");
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		return complete;
	}
	
	@Override
	public boolean getPw(String pw) {
		boolean complete = false;
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			stmt = memCon.createStatement();
			sql = " SELECT * FROM MEMBER WHERE PW = '" + pw + "' ";
			
			rs = stmt.executeQuery(sql);
			if( rs == null ) {
				
			}else {
				System.out.println(rs.toString());
				rs.next();
				System.out.println("getId result : " + rs.getString(2).equals(pw));
				complete = true;
			}			
			
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("wrong pw : MemberDAOImpl.getPw(String pw)");
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		return complete;
	}

	@Override
	public boolean syncDBToMap() {
		// TODO Auto-generated method stub
		boolean complete = false;
		
		hm = new HashMap<String, DTOMem>();
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM MEMBER ";
		
		String id;
		String pw;
		String name;
		String email;
		int auth;
		
		
		try {
			stmt = memCon.createStatement();
			rs = stmt.executeQuery(sql);
			
			while( rs.next() ) {
				id = rs.getString(1);
				pw = rs.getString(2);
				name = rs.getString(3);
				email = rs.getString(4);
				auth = rs.getInt(5);
				hm.put(id, new DTOMem(id, pw, name, email, auth));				
			}
			
			System.out.println("DAO Map bring data from DB.");
		} catch (SQLException e) {
			System.out.println("DB Connection Fail(Sync DB To Map)");
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		}
		
		return false;
	}

	//관리자권한 부여 및 회수 메소드
	@SuppressWarnings("resource")
	@Override
	public boolean alterAuth(String id) {
		boolean complete = false;
		
		int auth = 0;
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			stmt = memCon.createStatement();
			sql = " SELECT * FROM MEMBER WHERE ID = '" + id + "' ";
			rs = stmt.executeQuery(sql);
			
			rs.next();
			auth = rs.getInt(5);
			
			if(auth == 3) {
				auth = 1;
			}else {
				auth = 3;
			}
			
			sql = " UPDATE MEMBER SET AUTH = " + auth + " WHERE ID ='" + id + "' ";
			
			rs = stmt.executeQuery(sql);
			
			if( rs == null ) {
			}else {
				rs.next();
				complete = true;
			}			
			
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("wrong pw : MemberDAOImpl.getPw(String pw)");
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		return complete;
	}
}
