package studentSingleton;

import java.util.List;

public class StudentSingleton {
	private static StudentSingleton single = null;
	public static List<StudentDto> lst;
	
	private StudentSingleton() {  }
	
	public static StudentSingleton getInstance() {
		if( single == null ) {
			single = new StudentSingleton();
		}		
		return single;
	}
}
