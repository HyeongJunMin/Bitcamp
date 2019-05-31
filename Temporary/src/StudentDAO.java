
public class StudentDAO {
	
	private Student std;
	
	public StudentDAO() {}
	
	public StudentDAO(Student std) {
		this.std = std;
	}


	public String toSQLInsertValueQuery(){
		String slt = "";
		
		
		return "";
	}
	
	public String toSQLInsertAttributeQuery(){
		String att = "";
		
		
		return "";
	}
	
	
	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}
}
