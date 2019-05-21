package std190521_sort;

import java.util.Scanner;

public class Lct1_Review190520 {
	void play1() {
		//	셔플 알고리즘
		//	정수 배열에 랜덤한 값을 입력
		
		//배열 길이
		int arrLen = 5;
		
		//배열 선언
		int r_num[] = new int[arrLen];
		boolean r_swit[] = new boolean[arrLen];
		
		//초기화
		for(boolean b : r_swit)
			b = false;
		
		//반복제어 변수 선언 및 초기화
		int w = 0;
		int rndTemp = 0;
		
		while ( w < arrLen ) {
			rndTemp = (int)( Math.random() * 5 );
			if(r_swit[rndTemp] == false) {	//랜덤값을 index로 갖는 r_swit가 false이면
				r_swit[rndTemp] = true;		//r_swit[rndTemp]에 true 저장
				r_num[w] = rndTemp + 1;		//r_num[반복]
				w++;						//반복변수 +1
			}
		}
		
		for(int i : r_num)
			System.out.print(i + " ");
		
	}
	
	void teacher() {
		Scanner sc = new Scanner(System.in);
		
		// baseball
		
		// 선언부
		int r_num[], u_num[];
		boolean clear;
		
		/////////////////////////////////// replay
		
		// 초기화		
		r_num = new int[3];
		u_num = new int[3];
		clear = false;		
		
		// 1. random number(1 ~ 10) -> 3개 
		//		n1 != n2 != n3
		/*
		while(true) {
			r_num[0] = (int)(Math.random() * 10) + 1;
			r_num[1] = (int)(Math.random() * 10) + 1;
			r_num[2] = (int)(Math.random() * 10) + 1;			
			
			if(r_num[0] != r_num[1] && r_num[0] != r_num[2]
					&& r_num[1] != r_num[2]) {
				break;
			}
		}
		
		for (int i = 0; i < r_num.length; i++) {
			System.out.println("r_num[" + i + "] = " + r_num[i]);
		}
		
		*/
		
		/*
		int rnum[] = { 1, 2, 3, 4, 5,  6, 7, 8, 9, 10 };
		int temp;
		
		int n1, n2;
		for (int i = 0; i < 100; i++) {
			n1 = (int)(Math.random() * 10);	// 0 ~ 9
			n2 = (int)(Math.random() * 10);	// 0 ~ 9
			
			temp = rnum[n1];
			rnum[n1] = rnum[n2];
			rnum[n2] = temp;			
		}
		
		for (int i = 0; i < rnum.length; i++) {
			System.out.println("rnum[" + i + "] = " + rnum[i]);
		}
		*/
		
		/*
			00000 00000
			random number -> 3
			00010 00000	
			random number -> 5
			00010 10000		
		*/
		boolean swit[] = new boolean[10];	
		int r, w;
		
		for (int i = 0; i < swit.length; i++) {
			swit[i] = false;		// 00000 00000
		}		
		w = 0;
				
		while(w < u_num.length) {		
			r = (int)(Math.random() * 10);	// 0 ~ 9
			if(swit[r] == false) {
				swit[r] = true;
				r_num[w] = r + 1;	// 1 ~ 10
				w++;
			}
		}
		
		for (int i = 0; i < r_num.length; i++) {
			System.out.println("r_num[" + i + "] = " + r_num[i]);
		}
		
		w = 0;
		//////////////////////////////////	loop 10회
		while(w < 10) {
			
			// 2. user input(1 ~ 10) -> 3개
			//		u1 != u2 != u3
			while(true) {			
				for(int i = 0;i < u_num.length; i++) {
					System.out.print((i + 1) + "번째 수:");
					u_num[i] = sc.nextInt();
				}			
				if(u_num[0] != u_num[1] 
						&& u_num[0] != u_num[2]
						&& u_num[1] != u_num[2]) {
					break;
				}			
				System.out.println("같은 숫자가 있습니다. 다시 입력하십시오");
			}
			
			int strike, ball;
			// 3. finding(strike, ball)
			//		strike : 자리O, 숫자O 
			//		ball : 자리X, 숫자O
			
			strike = 0;
			ball = 0;
			// ball
			for (int i = 0; i < u_num.length; i++) {			
				for (int j = 0; j < u_num.length; j++) {
					if(u_num[i] == r_num[j] && i != j) {
						ball++;
					}
				}			
			}
			
			// strike
			for (int i = 0; i < u_num.length; i++) {
				if(u_num[i] == r_num[i]) {
					strike++; 
				}
			}
			
			if(strike > u_num.length - 1) {
				clear = true;
				break;
			}
			
			// 4. message(printing)
			System.out.println(strike + "스트라이크 " + ball + "볼 입니다");
			
			w++;
		}
		//////////////////////////////////
		
		// 5. result(clear, no good)
		if(clear) {
			System.out.println("축하합니다");
		}
		else {
			System.out.println("아쉽습니다. 다시 도전하세요");
		}
	}
}
