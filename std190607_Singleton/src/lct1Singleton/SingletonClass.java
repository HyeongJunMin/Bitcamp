package lct1Singleton;

public class SingletonClass {
	//필드와 생성자가 싹 프라이빗이네요
	private static SingletonClass single = null;
	public static int num;
	public static String name;
	
	private SingletonClass() {
	}
	
	//많이 쓰이는 메소드 이름임. getInstance
	//스태틱 메소드이기 때문에 클래스명.getInstance()로 호출하면?
	//기능 : 첫 한번만 클래스가 호출되면? 인스턴스를 생성한다.
	//		두 번째 부터는?? 첫 번째에 생성된 인스턴스를 유지한다.
	public static SingletonClass getInstance() {
		if( single == null ) {
			single = new SingletonClass(); 
		}
		return single;
	}
}
