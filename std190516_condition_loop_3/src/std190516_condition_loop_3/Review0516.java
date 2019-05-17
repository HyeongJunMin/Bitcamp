package std190516_condition_loop_3;
import java.util.*;

public class Review0516 {
	void play() {
		int inputNum = 75;
		int num10 = 0;
		for (int i = 0; i < 10; i++) {
			num10 = 10 * i ;
			if(inputNum > num10 && inputNum <= num10 + 10 ) {
				System.out.println(num10 + "보다 크고 " + 
									+ (num10 + 10) + "보다 작은 값 사이에 있습니다.");
			}
		}
	}
}
