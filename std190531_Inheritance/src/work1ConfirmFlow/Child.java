package work1ConfirmFlow;

public class Child extends Parent {
	int x = 3000;

	Child() {
		this(1000);
		System.out.println("child");
	}

	Child(int x) {
		System.out.println("childx");
		this.x = x;
	}
	
//	public int getX() {
//		return x;
//	}

}
