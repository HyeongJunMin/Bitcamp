package std190531_Inheritance;

public class Lct1Child extends Lct1Parents {
	
	public Lct1Child() {
		
	}
	
	public Lct1Child(int num) {
		super(num);
	}
	
	public void fnc() {
		System.out.println("fnc");
	}
	
	@Override
	public void pMethod() {
		// TODO Auto-generated method stub
		System.out.println("Overrided");
		super.pMethod();
	}

}
