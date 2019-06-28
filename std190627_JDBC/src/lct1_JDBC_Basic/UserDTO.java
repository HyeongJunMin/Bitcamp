package lct1_JDBC_Basic;

import java.io.Serializable;

public class UserDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private int age;
	private String joinDate;
			
	public UserDTO(String id, String name, int age, String joinDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.joinDate = joinDate;
	}
	
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", age=" + age + ", joinDate=" + joinDate + "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
}
