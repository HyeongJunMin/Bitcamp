package lct1Singleton;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass mcls = new MyClass();
		YouClass ycls = new YouClass();
		
		//YouClass 객체가 생성되고 toString 메소드를 호출할 때 MyClass의 값을 받아오게끔 설정할 것
//		int n = mcls.getMyNum();
//		ycls.setYouNum(n);
		
		System.out.println(ycls.toString());
		
		//싱글턴에서 값을 전해주고 전해받는 방법은 메모리를 통해 이루어진다.(게터 세터 아님)
		//MyClass-myMethod(싱글턴생성해서 싱클턴안으로 값 전달)-YouClass-youMethod(싱글턴인스턴스의 값을 받아옴)
		mcls.myMethod();
		ycls.youMethod();
		System.out.println(ycls.toString());
		
		HeClass h = new HeClass();
		ycls.youMethod2();
		System.out.println(ycls.toString());
		
	}

}
