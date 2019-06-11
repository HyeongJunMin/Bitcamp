package work1BaseballTeamManagement;

public class HumanDTO implements Comparable<HumanDTO>{
	private int num;
	private String name;
	private int age;
	private double height;
	
	public HumanDTO() { } 
	public HumanDTO(int num, String name, int age, double height) {
		this.num = num;
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "HumanDTO [num=" + num + ", name=" + name + ", age=" + age + ", height=" + height + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	@Override
	public int compareTo(HumanDTO s) {
        if (this.age > s.getAge()) {
            return 1;
        } else if (this.age < s.getAge()) {
            return -1;
        }
        return 0;
	}
}
