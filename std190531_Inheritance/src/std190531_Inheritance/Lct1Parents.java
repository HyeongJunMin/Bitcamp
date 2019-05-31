package std190531_Inheritance;

public class Lct1Parents {
	private int pNum;
	
	public Lct1Parents() {
		
	}
	
	public Lct1Parents(int num) {
		this.pNum = num;
	}		
	
	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public void pMethod() {
		System.out.println("pMethod");
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
