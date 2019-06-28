package lct1_JDBC_Basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class JdbcTest {
	
	public JdbcTest() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC Oracle Driver Found.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		Connection con = null;
		
		String url = "jdbc:oracle:thin:@192.168.0.29:1521:xe";
		String id = "hr";
		String pw = "hr";
		
		try {			
			con = DriverManager.getConnection(url , id, pw);
			System.out.println("DB Connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public int insert(String id, String name, int age) {
		
		String sql = " INSERT INTO USERDTO(ID, NAME, AGE, JOINDATE) "
						+ " VALUES('" + id + "', '" + name + "', " + age + ", SYSDATE) ";
		
		Connection con = getConnection();
		Statement stmt = null;
		
		int count = 0;	//리턴변수
		
		System.out.println("SQL : " + sql);	//query 확인
		
		try {
			stmt = con.createStatement();	//DB연결
			
			count = stmt.executeUpdate(sql);	//sql 수행, 성공했으면 1 실패는 0
			
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {	stmt.close();	}
				if ( con != null ) { con.close();	}
			} catch (SQLException e) {	e.printStackTrace();	}
		}

		return count;
	}
	
	public int update(String id, String name, int age) {
		//UPDATE USERDTO SET NAME = 'CHANGED' WHERE ID = 'ab';
		String sql = " UPDATE USERDTO SET NAME = '" + name + "', AGE = " + age
				+ " WHERE ID = '" + id + "' ";
		
		Connection con = getConnection();
		Statement stmt = null;
		
		int count = 0;	//리턴변수
		
		System.out.println("SQL : " + sql);	//query 확인
		
		try {
			stmt = con.createStatement();	//DB연결
			
			count = stmt.executeUpdate(sql);	//sql 수행, 성공했으면 1 실패는 0
			
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {	stmt.close();	}
				if ( con != null ) { con.close();	}
			} catch (SQLException e) {	e.printStackTrace();	}
		}

		return count;
	}
	
	public int delete(String id) {
		//DELETE FROM USERDTO WHERE ID = 'bb';
		String sql = " DELETE FROM USERDTO WHERE ID = '" + id + "' ";
		
		Connection con = getConnection();
		Statement stmt = null;
		
		int count = 0;	//리턴변수
		
		System.out.println("SQL : " + sql);	//query 확인
		
		try {
			stmt = con.createStatement();	//DB연결
			
			count = stmt.executeUpdate(sql);	//sql 수행, 성공했으면 1 실패는 0
			
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {	stmt.close();	}
				if ( con != null ) { con.close();	}
			} catch (SQLException e) {	e.printStackTrace();	}
		}

		return count;
	}
	
	public int select() {
		
		String sql = " SELECT * FROM USERDTO ";
		
		Connection con = getConnection();
		Statement stmt = null;
		
		int count = 0;	//리턴변수
		
		System.out.println("SQL : " + sql);	//query 확인
		
		try {
			stmt = con.createStatement();	//DB연결
			
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("NO\tID\tNAME\tAGE\tJOINDATE");
			
			int no=1;
			String id;
			String name;
			int age;
			Date joindate;
			String tuple;
			
			while( rs.next() ) {
				id = rs.getString(1);
				name = rs.getString(2);
				age = rs.getInt(3);
				joindate = rs.getDate(4);
				System.out.println(no++ + "\t" + id + "\t" + name + "\t" + age + "\t" + joindate.toString());
			}
			
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {	stmt.close();	}
				if ( con != null ) { con.close();	}
			} catch (SQLException e) {	e.printStackTrace();	}
		}
		
		
		return 1;
	}
	
	public int select(String id) {
		
		//Question mark 활용
		String sql = " SELECT * FROM USERDTO WHERE ID = ? ";
		
		Connection con = getConnection();
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDTO user = null;
		
		int count = 0;	//리턴변수
		
		System.out.println("SQL : " + sql);	//query 확인
		
		try {
			ps = con.prepareStatement(sql);	//DB연결 및 SQL 전달
			ps.setString(1, id); //id변수가 1번째(DB니까) Question Mark에 대입된다.
			rs = ps.executeQuery();	//위에서 sql 이미 전달했음
			
			System.out.println("NO\tID\tNAME\tAGE\tJOINDATE");
			
			int no=1;
			String uid;
			String name;
			int age;
			Date joindate;
			String tuple;
			
			while( rs.next() ) {
				uid = rs.getString(1);
				name = rs.getString(2);
				age = rs.getInt(3);
				joindate = rs.getDate(4);
				System.out.println(no++ + "\t" + uid + "\t" + name + "\t" + age + "\t" + joindate.toString());
			}
			
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {	stmt.close();	}
				if ( con != null ) { con.close();	}
			} catch (SQLException e) {	e.printStackTrace();	}
		}
		
		
		return 1;
	}

}
