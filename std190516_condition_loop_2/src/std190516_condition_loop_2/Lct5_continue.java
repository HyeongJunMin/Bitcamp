package std190516_condition_loop_2;
import java.util.*;
public class Lct5_continue {
	/*	주의사항 : 
	 * 
	 */
	void play() {
		for (int i = 0; i < 10 ; i++) {
			if(i==0)
				System.out.println("for start");

			System.out.println("i = " + 1);
						
			if(i < 9) 
				continue;
			
			System.out.println("for end");
		}
		
		Scanner in = new Scanner(System.in);
		
		int number = 0;
		
//		for (int i = 0; i < 3; i++) {
//			System.out.print("숫자를 입력해 주세요 : ");
//			number = in.nextInt();
//			if(number < 0) {
//				System.out.println("잘못 입력하셨습니다.");
//				continue;
//			}
//		}
		
		int w = 0 ;

		while (w < 3) {
			System.out.print("숫자를 입력해 주세요 : ");
			number = in.nextInt();
			if(number < 0) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			w++;
		}
		System.out.println("for와 while에서 continue의 차이점은?\nwhile문에서 조건에 따른 반복횟수 제어가 쉽다.\n못빠져나가게 하는 거지");
	}
}
