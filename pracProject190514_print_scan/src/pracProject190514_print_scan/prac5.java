package pracProject190514_print_scan;
import java.util.*;
public class prac5 {
	Scanner in = new Scanner(System.in);
	int x=0;
	int y=0;
	int temp=0;
	void input(){
		System.out.print("숫자1 입력 : ");
		x=in.nextInt();
		System.out.print("숫자2 입력 : ");
		y=in.nextInt();
	}
	void print() {
		temp=x;
		x=y;
		y=temp;
		System.out.println("x = "+this.x+" y = "+this.y);
	}
}
