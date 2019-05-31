import java.sql.*;

public class DBConnectionTest {
	public static void main(String[] args) {
		connectionDB();
		

	}
	public static void connectionDB() {
		Connection con = null;
		
		String user = "minhj";
		String pw = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:studyDB";
		String sql;
		sql ="INSERT INTO 학생 (학번) VALUES(1002)";
		//이름 입학일시 전공 단과대학
		String upd = "UPDATE 학생 SET 이름='만득', 입학일시='2009/03/02', 전공='컴퓨터공학', 단과대학='공대' WHERE 학번=1002";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("DB연결 성공!");
			Statement stmt = con.createStatement();
			stmt.executeQuery(upd);
			System.out.println("업데이트 성공!");
			
			doSelectQuery(stmt);
			
			stmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("실패");
		} finally {
			try {
				if( con != null)
					con.close();
			}catch(Exception e) {
				
			}
		}
	}
	
	public static void doSelectQuery(Statement s) {
		String slt = "SELECT * FROM 학생";
		ResultSet rs;
		try {
			rs = s.executeQuery(slt);
			
			while( rs.next() ) {
				int num = rs.getInt("학번");
				String name = rs.getString("이름");
				String time = rs.getString("입학일시");
				String major = rs.getString("전공");
				String clg = rs.getString("단과대학");
				System.out.println(num + "\t" + name + "\t" + time + "\t" + major + "\t" + clg);
				//전공, 단과대학
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
