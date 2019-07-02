package lct2MVC2_single;

import lct2MVC2_controller.MemberController;

public class Singleton {
	private static Singleton s = null;
	
	//Controller는 어디서든지 접근할 수 있어야 하기 때문에 싱글턴에 포함시켜야 함
	public MemberController memCtrl;
	public String sessionId = "";
	
	private Singleton() {
		memCtrl = new MemberController();
	}
	
	public static Singleton getInstance() {
		if( s == null ) {
			s = new Singleton();
		}
		
		return s;
	}
}
