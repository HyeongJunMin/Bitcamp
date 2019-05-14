package pracProject190514_operator;
import java.util.*;

public class prac9 {
	//변수  x,y,z를 입력 받고, (x-y)/(z-y)연산을 출력하는 프로그램을 작성하라.
	double x=1,y=2,z=3;
	void input() {
		Scanner in = new Scanner(System.in);
		System.out.println("x 입력 : ");
		x=in.nextDouble();
		System.out.println("y 입력 : ");
		y=in.nextDouble();
		System.out.println("z 입력 : ");
		z=in.nextDouble();
	}
	void print() {
		System.out.print("결과값 : "+((x-y)/(z-y)));
	}
}
