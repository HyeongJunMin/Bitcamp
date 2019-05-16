package std190516_condition_loop_2;
import java.util.*;
public class Work4 {
	void play() {
		//하나의 수를 입력 받고 10의 배수로 입력 받은 수는 어느 범위에 있는지 출력되는 프로그램을 작성하라
		//조건분기
		//입력 예) 45
		//출력 예) 입력한 수는 40보다 크고 50보다 작다.
		
		int low=0,high=0;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = in.nextInt();
		
		low = num - (num%10);	//입력받은값 - (입력받은값%10) == 
		high = low + 10;		//40 + 10
		
		System.out.println("입력한 수 " + num + "은(는) " + low + "보다 크고 " + high + "보다 작다.");
		
		in.close();
	}
}
