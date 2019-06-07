package lct1Singleton;

public class MyClass {
	private int myNum;
	
	
	public MyClass() {  
		myNum = 1234;
	}

	public int getMyNum() {
		return myNum;
	}

	public void setMyNum(int myNum) {
		this.myNum = myNum;
	}
	
	public void myMethod() {
		SingletonClass.num = myNum;
		
	}
	
}
