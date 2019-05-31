package work1ConfirmFlow;

public class Parent {
	int x = 100;

	Parent() {
		this(200);
		System.out.println("parent");
	}

	Parent(int x) {
		System.out.println("parentx");
		this.x = x;
	}

	int getX() {
		return x;
	}

}
