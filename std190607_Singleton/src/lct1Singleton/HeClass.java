package lct1Singleton;

public class HeClass {
	private String name;
	
	public HeClass() {
		this.name = "�̸�";
		SingletonClass.name = this.name;
	}
	
}
