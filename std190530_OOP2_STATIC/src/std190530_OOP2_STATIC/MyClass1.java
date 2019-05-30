package std190530_OOP2_STATIC;

public class MyClass1 {
	private int number;
	private String name;
	
	public static MyClass1 getInstance() {
		//��ü�� ����
		MyClass1 cls = new MyClass1();
		cls.method();
		cls.function();
		
		//������ ��ü�� ����
		return cls;
	}
	
	public void method() {
		System.out.println("MyClass1 Method");
	}
	
	public void function() {
		System.out.println("MyClass1 Function");
	}
}
