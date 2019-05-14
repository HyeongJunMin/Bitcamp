package pracProject190514_operator;
import java.util.*;
public class prac7 {
	int a=1,b=1;
	
	void input() {
		Scanner in = new Scanner(System.in);
		System.out.print("a입력 : ");
		a=in.nextInt();
		System.out.println("");
		System.out.print("b입력 : ");
		b=in.nextInt();
		System.out.println("");
	}
	void print() {
		System.out.print("a+b= "+(a+b)+"\n");
		System.out.print("a-b= "+(a-b)+"\n");
		System.out.print("a*b= "+(a*b)+"\n");
		System.out.print("a/b= "+(a/b)+"\n");
		System.out.print("a%b= "+(a%b)+"\n");
	}
}
