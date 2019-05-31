
public class Student {
	private int num;
	private String name;
	private String time;
	private String major;
	private String college;
	public Student() {
		this.num = 0;
		this.name = "0";
		this.time = "0";
		this.major = "0";
		this.college = "0";		
	}
	public Student(int num, String name, String time, String major, String college) {
		this.num = num;
		this.name = name;
		this.time = time;
		this.major = major;
		this.college = college;
	}
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", time=" + time + ", major=" + major + ", college=" + college
				+ "]";
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
}
