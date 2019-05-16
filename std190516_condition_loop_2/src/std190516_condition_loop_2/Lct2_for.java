package std190516_condition_loop_2;
import java.util.*;
public class Lct2_for {
	/* 제어문 활용 빈도 2위! (1위 == if)
	 * 
	 * 형식		//조건문의 값이 true이면 반복 false이면 반복 종료
	 * for(  초기화+선언  ;  조건문  ;  연산식  ){
	 * 		
	 * }
	 * 
	 * /**/
	void play() {
		Scanner in = new Scanner(System.in);
		int sum=0;
		for(int i=1; i<=10; i++) {
			//	1~10 합계
			sum+=i;
		}
		System.out.println("1~10 총합 : " + sum);
		
		//문제1. 구구단 출력
		for(int i = 1; i < 10 ; i++ ) {
			for(int j = 1 ; j < 10 ; j++ ) {
				System.out.print(i + " * " + j + " = " + (i*j) + "\t");
			}
			System.out.println();
		}
		//문제2. 몇단인지 입력받고 입력받은 수에 맞는 구구단 출력
		System.out.print("몇단? : ");
		int num = in.nextInt();
		System.out.println(num + "단");
		for(int i = 1; i < 10 ; i++ ) {
			System.out.print(num + " * " + i + " = " + (num*i) + "  ");
		}
	}
}
