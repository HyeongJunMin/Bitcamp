package std190521_sort;

import java.util.Scanner;

public class Lct2_SelectSort {
	void play1() {
		/*
		 * 선택정렬
		 * -숫자를 교환해야 하기 때문에 Swap 알고리즘이 필요
		 * 
		 * 초기값	5	1	8	3	2 일때
		 * 1회전	[1]	[5]	8	3	2
		 * 2회전	1	[2]	8	3	[5]	
		 * 3회전	1	2	[3]	[8]	5
		 * 4회전	1	2	3	[5]	[8]
		 * 
		 * */
		
		int num[] = {5, 1, 8, 3, 2};
		int temp=0;
		
		for (int i = 0; i < num.length-1; i++) {
			for (int j = (i + 1) ; j < num.length; j++) {
				if( num[i] > num[j] ) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;					
				}
			}
			for(int k : num) {
				System.out.print(k + " ");				
			}
			System.out.println();
		}
		
		for(int i : num)
			System.out.println(i);
	}
	
	void play2() {
		//	[유저 입력]
		//	1. 몇 개를 정렬하겠냐? == 배열 길이
		//	2. 오름차순으로 할래 내림차순으로 할래?
		//	3. 정렬
		//	4. 출력
		Scanner in = new Scanner(System.in);
		
		String input="";
		
		int arrLen = 0;
		int arr[] = {1};
		int judgeUpDown = 0;
		int cnt = 0;
		
		do {
		
		
		System.out.println("배열 정렬 프로그램을 시작합니다.");
		
		
		
		//입력부
		while(!isContainNumber(input, 2, 100)) {
			
			System.out.print("배열 길이 입력(2~100) : ");
			input = in.next();
			
			if(isContainNumber(input, 2, 100)) {
				System.out.println("입력된 숫자는 " + input + "입니다.");
				arrLen = Integer.parseInt(input);
				arr = new int[arrLen];
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
		}
		
		//초기화부
		int w = 0, rndTemp = 0;
		boolean r_swit[] = new boolean[arrLen];
		while ( w < arrLen ) {
			rndTemp = (int)( Math.random() * arrLen );
			if(r_swit[rndTemp] == false) {	//랜덤값을 index로 갖는 r_swit가 false이면
				r_swit[rndTemp] = true;		//r_swit[rndTemp]에 true 저장
				arr[w] = rndTemp + 1;		//r_num[반복]
				w++;						//반복변수 +1
			}
		}
		
		
		
		while(!isContainNumber(input, 1, 2)) {
			
			System.out.println("오름차순은 1, 내림차순은 2를 입력해 주세요.");
			input = in.next();
			
			if(isContainNumber(input, 1, 2)) {
				System.out.println("입력된 숫자는 " + input + "입니다.");
				judgeUpDown = Integer.parseInt(input);
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
		}
		
		System.out.println("정렬 전");
		for(int k : arr)
			System.out.print(k + " ");
		
		System.out.println();
		System.out.println("정렬 후");
		
		if( judgeUpDown == 1 ) {
			arr = sortSelectionUp(arr);
		}else {
			arr = sortSelectionDown(arr);
		}
		
		for(int k : arr)
			System.out.print(k + " ");
		
		cnt++;
		
		
		System.out.println("계속 하시겠습니까? (Y/N");
		input = in.next().toUpperCase();
		if ( !isContainYOrN(input) ) {
			while( !isContainYOrN(input) ) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요");
				input = in.next().toUpperCase();
			}
		} else {
			if( input.charAt(0) == 'Y' ) {
				
			}else {
				break;
			}
		}
		
		
		}while(true);
	}
	
	
    boolean isContainNumber(String strIn, int min, int max) {
        // 입력받은 문자열 strIn이 정수인지 판별하고
        // 정수인 경우 min값 이상 max값 이하이면 true 리턴
        boolean isThat = true;
        try {
            int num = Integer.parseInt(strIn);
            if (num < min || num > max) {
                isThat = false;
            } else {
                isThat = true;
            }
 
        } catch (NumberFormatException e) {
            isThat = false;
        }
 
        return isThat;
    }// 메서드 중괄호
    
    boolean isContainYOrN(String strIn) {
        // 입력받은 문자열 strIn의 첫 글자가 Y 또는 N인지 확인
        boolean isThat = true;
        try {
            char chInYOrN = strIn.toUpperCase().charAt(0);
            if (chInYOrN == 'Y'  || chInYOrN == 'N') {
                isThat = false;
            } else {
                isThat = true;
            }
 
        } catch (NumberFormatException e) {
            isThat = false;
        }
 
        return isThat;
    }// 메서드 중괄호

	int[] sortSelectionUp(int[] arr) {
    	int[] arrThis = arr;
    	int arrThisLen = arrThis.length;
    	int tempInMethod = 0;
    	
    	
		for (int i = 0; i < arrThisLen-1; i++) {
			for (int j = (i + 1) ; j < arrThisLen; j++) {
				if( arrThis[i] > arrThis[j] ) {
					tempInMethod = arrThis[i];
					arrThis[i] = arrThis[j];
					arrThis[j] = tempInMethod;					
				}
			}
							
		}
		return arrThis;
	}
	
	int[] sortSelectionDown(int[] arr) {
    	int[] arrThis = arr;
    	int arrThisLen = arrThis.length;
    	int tempInMethod = 0;
    	
    	
		for (int i = 0; i < arrThisLen-1; i++) {
			for (int j = (i + 1) ; j < arrThisLen; j++) {
				if( arrThis[i] < arrThis[j] ) {
					tempInMethod = arrThis[i];
					arrThis[i] = arrThis[j];
					arrThis[j] = tempInMethod;					
				}
			}
							
		}
		return arrThis;
	}

		
}
