package coffeeOrder_6_DTO;

public class DTOCfMem {
	
	private String id;
	private String pw;
	private String name;
	private int age;
	private String regDate;
	private int auth;
	
	public DTOCfMem() {}
	
	public DTOCfMem(String id, String pw, String name, int age, String regDate, int auth) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.regDate = regDate;
		this.auth = auth;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
}
