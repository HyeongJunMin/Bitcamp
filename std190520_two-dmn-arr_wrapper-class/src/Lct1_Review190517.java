import java.util.*;
import java.math.*;

public class Lct1_Review190517 {
	/*
	 * 190517(금) 복습내용 java는 OOP 입니다(Object Oriented Program)
	 * 
	 * java의 기본 자료형? (1byte == 8bit) 숫자 - byte(1byte), short(2byte), int(4byte),
	 * long(8byte) float(4byte), double(8byte) 문자 - char(2byte), String(? byte) 기타 -
	 * boolean(1byte)
	 *
	 * Array(배열) int iArr[] = new int[10]; == 동적할당을 잡아줬다. 동적할당이란게 무슨말이지 메모리 동적 할당 ==
	 * 어떤 특정 메모리 주소를 사용하라고 지정하는게 아니고 알아서(동적으로) 메모리 주소 할당
	 *
	 *
	 *
	 */

	void play() {
		// 영어 대-소문자 변환
		// 소문자+32 == 대문자
		char c = 'A';
		int n = c;
		System.out.println("c = " + c);
		System.out.println("n = " + n);

		n = c + 32;
		c = (char) n;
		System.out.println("c = " + c);
	}

	void play2() {
		// 조건분기?
		// if와 else if
		int num = 45;
		if (num > 0 && num <= 10) { // 10의자리 판단하기
		} else if (num > 10 && num <= 20) {
		} else if (num > 20 && num <= 30) {
		}

		for (int i = 0; i < 100; i = i + 10) { // 요롷게 하면 되지요
			if (num > i && num <= (i + 10)) {
				System.out.println("num = " + i + " ~ " + (i + 10));
			}
		}

		switch (num) { // num에는 값이 들어간다
		case 45: // num의 값이 45면? 아래 코드를 수행하고 break를 만날 때 switch를 종료
			System.out.println(num);
			break;
		case 50:
			System.out.println("?");
			break;
		default: // 위 case들에 모두 해당되지 않았으면
			break; // default 수행하고 break 만날 떄 switch 종료
		}
		// 조건문 반복문 기초 하는중.. 노잼사 직전
		// 얼른 재미있고 머리아픈 내용을 알려주세요 :D

	}

	void play3() {
		// continue에 대한 내용

		Scanner in = new Scanner(System.in);
		int w = 0;
		int myNum;

		while (w < 5) {
			System.out.print((w + 1) + "번 째 수");
			myNum = in.nextInt();
			if (myNum < 0) {
				System.out.println("음수입력. 재시도");
				continue;
			}
			w++;
		}

		System.out.println("프로그램 종료.");

		in.close();
	}

	void play4() {
		// 지난 주 과제 숫자맞추기 게임에 대한 내용
		Scanner in = new Scanner(System.in);
		int rand_num = 0;
		int user_num = 0;
		boolean clear = false;

		rand_num = (int) (Math.random() * 100) + 1; // 1~100 정수 랜덤 설정
		System.out.println("랜덤 숫자 : " + rand_num);

		int w = 0;
		while (w < 10) {

			while (true) {
				System.out.print((w + 1) + "번째 숫자를 입력해 주세요(1~100) : ");
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

		if (clear) {
			System.out.println("Game Clear ! ");
		} else {
			System.out.println("실패!");
		}

	}

	void play5() {
		// 교수님 작성본
		/*
		 * java == OOP(Object Oriented Program)
		 * 
		 * 기본 자료형 숫자 정수: byte 1 byte == 8 bit 0000 0000 short 2 byte int 4 byte long 8
		 * byte
		 * 
		 * 실수: float 4 byte double 8 byte
		 * 
		 * 문자 char 2 byte String ? byte length()
		 * 
		 * true/false boolean 1 byte
		 * 
		 * Array(배열) : 같은 자료형 변수의 묶음
		 * 
		 * int iArr[] = new int[10]; 동적할당 10
		 * 
		 * int iArr[]; iArr = new int[5]; 동적할당 5 정적사용 -> 0 ~ 4 -> 5X
		 * 
		 * 자료형 변환 char -> int char ch = 'A'; -> A System.out.println(ch); -> A
		 * System.out.println((int)ch); -> 65
		 * 
		 * int num = (int)ch; 자동 변환 byte by = (byte)num; 강제(cast)변환
		 * 
		 * int num1 = 3, num2 = 2; double avg = num1 / num2; -> 1.0 double avg =
		 * (double)num1 / num2; -> 1.5
		 */

		// 영어 대문자 -> 영어 소문자
		// A == 65, a == 97
		char c = 'A';
		int n = c;
		System.out.println("n = " + n);
		n = n + 32;

		c = (char) n;
		System.out.println("c = " + c);

		// toUpperCase, toLowerCase

		String str = "abc";

		for (int i = 0; i < str.length(); i++) {
			int cn = (int) str.charAt(i);
			System.out.println((char) (cn - 32));
		}

		// if
		int number = 5;
		if (number > 0) { // 논리연산 ture/false
			// 조건이 true인 경우, 이 블록안에 처리가 실시된다.
		}

		// &&(AND) ||(OR) !(NOT)
		if (number > 0 && number < 10) {
		}

		if (!(number < 0 || number > 10)) {
		}
		if (number >= 0 && number <= 10) {
		}

		boolean b = true;

		if (b == true) {
		}
		if (b) {
		}

		b = false;
		if (b == false) {
		}
		if (!b) {
		} else {
		}

		// if else if
		if (number > 0 && number <= 10) { // 1 ~ 10
		} else if (number > 10 && number <= 20) { // 10 ~ 20
		} else if (number > 20 && number <= 30) { // 20 ~ 30
		} else {
		}

		// switch
		switch (number) {
		case 1: // number == 1
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			break;
		}

		// loop (for while do while)
		for (int i = 0; i < 10; i++) {
		}
		for (int i = 1; i <= 10; i++) {
		}
		for (int i = 5; i <= 10; i++) {
		}
		for (int i = 10; i > 0; i--) {
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
			}
		}

		int w;
		w = 0;
		while (w < 10) {
			// 처리
			w++;
		}

		int w1, w2;
		w1 = w2 = 0;
		while (w1 < 10) {

			w2 = 0;
			while (w2 < 5) {

				w1++;
			}
			w2++;
		}

		// do while
		int w3 = 0;
		do {
			// 처리
			w3++;
		} while (w3 > 10);

		while (w3 > 10) {
		}

		// Application

		// initialize(초기화)

		// loop(프로그램 실제 처리)
		// while(true) {
		// }

		// release(해방) - 동적할당 -> delete

		int arr[] = new int[3];
		// delete arr; -> 가비지(쓰레기) 컬렉터

		// break + for, while

		int _number[] = { 11, 22, 33, 44, 55 };
		for (int i = 0; i < _number.length; i++) {
			if (_number[i] == 33) {
				break;
			}
		}

		// loop -> break
		boolean bo = false;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == 5 && j == 3) {
					bo = true;
				}
				if (bo) {
					break;
				}
			}
			if (bo) {
				break;
			}
		}

		loopout: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 5 && j == 3) {
					break loopout;
				}
			}
		}

		// continue (skip == 생략)
		Scanner sc = new Scanner(System.in);

		// num < 0 는 다시 입력
		w = 0;
		int myNum;
		while (w < 5) {
			System.out.print((w + 1) + "번째 수:");
			myNum = sc.nextInt();
			if (myNum < 0) {
				System.out.println("음수를 입력하셨습니다. 다시 입력해 주십시오");
				continue;
			}
			w++;
		}
	}

	void play6() {
		// 교수님 작성본
		Scanner sc = new Scanner(System.in);
		// random number 찾기
		// 선언부
		int rand_num, user_num;
		boolean clear;

		// init
		clear = false;

		// 1. random number setting (1 ~ 100)
		rand_num = (int) (Math.random() * 100) + 1;
		System.out.println("rand_num = " + rand_num);

		///////////////////////////////// loop 10번
		int w = 0;
		while (w < 10) {

			// 2. user input
			while (true) {
				System.out.print("숫자를 입력(1 ~ 100):");
				user_num = sc.nextInt();

				if (user_num < 1 || user_num > 100) {
					System.out.println("범위를 벗어 났습니다. 다시 입력해 주십시오 ");
					continue;
				}
				break;
			}

			// 3. finding
			int msg = 0;
			if (user_num > rand_num) {
				msg = 1;
			} else if (user_num < rand_num) {
				msg = 2;
			} else {
				clear = true;
				break;
			}

			// 4. printing
			switch (msg) {
			case 1:
				System.out.println("너무 큽니다");
				break;
			case 2:
				System.out.println("너무 작습니다");
				break;
			}
			w++;
		}
		/////////////////////////////////

		// 5. result printing
		if (clear) {
			System.out.println("축하합니다. Game Clear입니다");
		} else {
			System.out.println("아쉽습니다. 다시 도전해 보십시오");
		}
	}
}
