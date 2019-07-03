package coffeeOrder_4_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import coffeeOrder_5_DB.DBConnection;
import coffeeOrder_6_DTO.DTOCfMem;


public class MemDAOImpl implements MemDAO {

	public Map<String, DTOCfMem> hm = null;
	public static Connection memCon = null;
	public static DBConnection d = null;
	
	public MemDAOImpl() {
//		memCon = DBConnection.getConnection();		
	}
	
	//COFFEE_MEM DB의 값을 가져와서 Map에 저장하고 리턴해주는 메소드
	@Override
	public Map<String, DTOCfMem> getMembersFromDB() {
		// TODO Auto-generated method stub		
		this.syncDBToMap();
		return this.hm;
	}	
	
	//COFFEE_MEM DB의 값을 가져와서 Map에 저장하는 메소드
	@Override
	public boolean syncDBToMap() {
		// TODO Auto-generated method stub
		boolean complete = false;
		
		hm = new HashMap<String, DTOCfMem>();
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM COFFEE_MEM ";
		
		String id;
		String pw;
		String name;
		int age;
		String regDate;
		int auth;
		
		
		try {
			stmt = DBConnection.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while( rs.next() ) {
				id = rs.getString(1);
				pw = rs.getString(2);
				name = rs.getString(3);
				age = rs.getInt(4);
				regDate = rs.getString(5);
				auth = rs.getInt(6);
				hm.put(id, new DTOCfMem(id, pw, name, age, regDate, auth));	
			}
			
			complete = true;
//			System.out.println("DAO Map bring data from DB.");
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
		
		return complete;
	}


	//회원가입 뷰에서 받은 DTO를 COFFEE_MEM에 추가(INSERT)
	@Override
	public boolean regNewMember(DTOCfMem dto) {
		// TODO Auto-generated method stub
		boolean complete = false;
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			stmt = DBConnection.getConnection().createStatement();
			sql = " INSERT INTO COFFEE_MEM VALUES('" + dto.getId() + "', '" +
											dto.getPw() + "', '" +
											dto.getName() + "', '" +
											dto.getAge() + "', SYSDATE, 3) ";
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

	
	//View2Signin에서 입력된 ID의 중복여부 검사
	@Override
	public boolean idChk(String id) {
		// TODO Auto-generated method stub
		boolean complete = false;
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			stmt = DBConnection.getConnection().createStatement();
			sql = " SELECT * FROM COFFEE_MEM WHERE ID = '" + id + "' ";
			
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


	//View1Login에서 입력한 ID정보를 DB에서 가져와 DTO로 리턴
	@Override
	public String[] chcAccount(String id) {
		// TODO Auto-generated method stub
		String[] account = {null, null};
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			stmt = DBConnection.getConnection().createStatement();
			sql = " SELECT * FROM COFFEE_MEM WHERE ID = '" + id + "' ";
			
			rs = stmt.executeQuery(sql);
			if( rs == null ) {
				
			}else {
				System.out.println(rs.toString());
				rs.next();
				System.out.println("chcAccount result : " + rs.getString(1).equals(id));
				
				account[0] = rs.getString(1);
				account[1] = rs.getString(2);
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
		return account;
	}
	
	
	
}
