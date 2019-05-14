package pracProject190514_operator;
import java.math.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ran;
		ran = (int)(Math.random() *10+1);
		System.out.println(ran);

		int n=5;

		//	논리연산자? 참이냐 거짓이냐
		//	||, &&, !
//		System.out.println(n == 5);
//		System.out.println(n > 5);
//		System.out.println(n < 5);
//		System.out.println(n >= 5);
//		System.out.println(n <= 5);
//		System.out.println(n >= 5 && n < 5);
//		System.out.println(n >= 5 || n < 5);
//		System.out.println(n != 6);
//		
//		prac6 p6 = new prac6();
//		p6.print();
//		prac7 p7 = new prac7();
//		p7.input();
//		p7.print();
//		prac8 p8 = new prac8();
//		p8.input();
//		prac9 p9 = new prac9();
//		p9.input();
//		p9.print();
		prac10 p10 = new prac10();
		p10.cal();
	}
}
