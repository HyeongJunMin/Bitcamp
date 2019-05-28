package std190528_Object_Calendar;

public class Student {
	public String name ;
	public int ban ;
	public int no ;
	public int kor ;
	public int eng ;
	public int math ;
	
	public int getTotal(int korScore, int engScore, int mathScore) {
		return korScore + engScore + mathScore;
	}
	public double getAverage() {
		return Math.round( ( (this.kor + this.eng + this.math)/3.0 )*10 )/10.0;
	}
}
