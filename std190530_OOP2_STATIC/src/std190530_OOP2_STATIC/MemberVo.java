package std190530_OOP2_STATIC;

public class MemberVo {
	//vo가 뭐에요?
	//Value Object
	//값에 의한 객체
	
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "이름 : " + this.name + "  나이 : " + this.age;
	}
}
