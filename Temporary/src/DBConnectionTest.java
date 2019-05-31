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
		sql ="INSERT INTO �л� (�й�) VALUES(1002)";
		//�̸� �����Ͻ� ���� �ܰ�����
		String upd = "UPDATE �л� SET �̸�='����', �����Ͻ�='2009/03/02', ����='��ǻ�Ͱ���', �ܰ�����='����' WHERE �й�=1002";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("DB���� ����!");
			Statement stmt = con.createStatement();
			stmt.executeQuery(upd);
			System.out.println("������Ʈ ����!");
			
			doSelectQuery(stmt);
			
			stmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����");
		} finally {
			try {
				if( con != null)
					con.close();
			}catch(Exception e) {
				
			}
		}
	}
	
	public static void doSelectQuery(Statement s) {
		String slt = "SELECT * FROM �л�";
		ResultSet rs;
		try {
			rs = s.executeQuery(slt);
			
			while( rs.next() ) {
				int num = rs.getInt("�й�");
				String name = rs.getString("�̸�");
				String time = rs.getString("�����Ͻ�");
				String major = rs.getString("����");
				String clg = rs.getString("�ܰ�����");
				System.out.println(num + "\t" + name + "\t" + time + "\t" + major + "\t" + clg);
				//����, �ܰ�����
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
