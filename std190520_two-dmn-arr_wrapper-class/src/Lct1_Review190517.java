import java.util.*;
import java.math.*;

public class Lct1_Review190517 {
	/*
	 * 	190517(금) 복습내용
	 * 	java는 OOP 입니다(Object Oriented Program)
	 * 	
	 * 	java의 기본 자료형?	(1byte == 8bit)
	 * 	숫자	-	byte(1byte), short(2byte), int(4byte), long(8byte) 
	 * 			float(4byte), double(8byte)
	 *	문자	-	char(2byte), String(? byte)
	 *	기타	-	boolean(1byte)
	 *
	 *	Array(배열)
	 *	int iArr[] = new int[10];  == 동적할당을 잡아줬다. 동적할당이란게 무슨말이지
	 *		메모리 동적 할당 == 어떤 특정 메모리 주소를 사용하라고 지정하는게 아니고 알아서(동적으로) 메모리 주소 할당
	 *
	*/
	
	void play() {	
		//영어 대-소문자 변환
		//소문자+32 == 대문자
		char c = 'A';
		int n = c;
		System.out.println("c = " + c);
		System.out.println("n = " + n);
		
		n = c + 32;
		c = (char)n;
		System.out.println("c = " + c);
	}
	
	void play2() {
		//	조건분기?
		//	if와 else if
		int num = 45;
		if( num > 0 && num <= 10) {		// 10의자리 판단하기
		} else if( num > 10 && num <= 20) {			
		} else if( num > 20 && num <= 30) {			
		}	
		
		for( int i = 0 ; i < 100 ; i = i + 10 ) {	//요롷게 하면 되지요
			if( num > i && num <= ( i + 10 ) ) {
				System.out.println("num = " + i + " ~ " + (i + 10));
			}
		}
		
		switch( num ) {	// num에는 값이 들어간다
			case 45 : 	// num의 값이 45면? 아래 코드를 수행하고 break를 만날 때 switch를 종료
				System.out.println(num);
				break;	
			case 50 : 
				System.out.println("?");
				break;
			default :	// 위 case들에 모두 해당되지 않았으면 
				break;	// default 수행하고 break 만날 떄 switch 종료
		}
		//	조건문 반복문 기초 하는중.. 노잼사 직전
		//	얼른 재미있고 머리아픈 내용을 알려주세요 :D
		
	}
	
	void play3() {
		//	continue에 대한 내용
		
		Scanner in = new Scanner(System.in);
		int w = 0;
		int myNum;
		
		while( w < 5 ) {
			System.out.print( ( w + 1 ) + "번 째 수");
			myNum = in.nextInt();
			if( myNum < 0 ) {
				System.out.println("음수입력. 재시도");
				continue;
			}
			w++;
		}
		
		System.out.println("프로그램 종료.");
		
		in.close();
	}
	
	void play4() {
		//	지난 주 과제 숫자맞추기 게임에 대한 내용
		Scanner in = new Scanner(System.in);
		int rand_num = 0;
		int user_num = 0;
		boolean clear = false;
		
		rand_num = (int) (Math.random() * 100) + 1 ;	//1~100 정수 랜덤 설정
		System.out.println("랜덤 숫자 : " + rand_num);		
		
		int w = 0;
		while (w < 10) {

			while (true) {
				System.out.print( (w + 1) + "번째 숫자를 입력해 주세요(1~100) : ");
				user_num = in.nextInt();
				if (user_num < 1 || user_num > 100) {
					System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
					continue;
				}
				break;
			}

			int msg = 0;
			if (user_num > rand_num) {
				msg = 1;
			} else if (user_num < rand_num) {
				msg = 2;
			} else {
				clear = true;
				break;
			}

			switch (msg) {
			case 1:
				System.out.println("너무 큽니다.");
				break;
			case 2:
				System.out.println("너무 작습니다.");
				break;
			}
			
			w++;
		}
		
		if(clear) {
			System.out.println("Game Clear ! ");
		} else {
			System.out.println("실패!");
		}
		
	}
}
