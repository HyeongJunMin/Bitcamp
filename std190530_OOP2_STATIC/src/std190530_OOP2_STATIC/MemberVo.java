package std190530_OOP2_STATIC;

public class MemberVo {
	//vo�� ������?
	//Value Object
	//���� ���� ��ü
	
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
		return "�̸� : " + this.name + "  ���� : " + this.age;
	}
}
