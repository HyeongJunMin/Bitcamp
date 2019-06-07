package lct1Singleton;

public class HeClass {
	private String name;
	
	public HeClass() {
		this.name = "¿Ã∏ß";
		SingletonClass.name = this.name;
	}
	
}
