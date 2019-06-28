package lct1_JDBC_Basic;

import java.util.HashMap;
import java.util.Map;

public class JDBCMain {

	public static void main(String[] args) {
		
		JdbcTest j = new JdbcTest();
//		j.getConnection();
		
		UserDTO dto = new UserDTO("ab", "Joo", 31, null);
		
//		int cnf = j.insert(dto.getId(), dto.getName(), dto.getAge());
//		
//		if ( cnf > 0 ) {
//			System.out.println("Insert Complete.");
//		} else {
//			System.out.println("Insert Failed.");
//		}
		
//		j.update("ab", "Joo", 30);
//		j.select();
//		j.select("ab");
		
	}

}
