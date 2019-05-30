package std190530_OOP2_STATIC;

public class YouClass {
	//객체배열 이해를 위한 클래스
	
	public static void main(String[] args) {
		System.out.println(1.1);
		double ji = 0.0;
		System.out.println(ji);
		ji=3/1.0;
		System.out.println(ji);
		ji = Math.round( (5 / 3.0)*100.0 )/100.0;
		System.out.println( 0.0/2);
				
	}
	
	private int number;
	
	public void method() {
		System.out.println("YouClass method()");
		System.out.println("number = " + this.number);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
