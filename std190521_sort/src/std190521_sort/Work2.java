package std190521_sort;

public class Work2 {
	//	Fibonnaci 수열 작성
	//	0 1 1 2 3 5 8
	//	30회 까지 반복하는것
	//	0	1
	//		1	1[0+1]
	//			1	3[1+2]
	//				3	5[2+3]
	//					5	8[3+5]
	void play() {
		//초기값 2개가 정해진 피보나치 수열
		
		//반복횟수 지정 변수
		int itrTimes = 30;
		
		//결과값 저장 배열
		int[] result = new int[itrTimes];
		
		result[0] = 0;
		result[1] = 1;
		
		for(int i = 2 ; i < itrTimes ; i++ ) {
			result[i] = result[i-1]+result[i-2];
		}
		
		for(int j : result)
			System.out.print(j + " ");
	}
	
	void play2() {
		//초기값이 없는 피보나치 수열
		
		int itrTimes = 10;
		int temp1 = 0;
		int temp2 = 0;
		int tempSum = 0;
		
		//결과값 저장 배열
		int[] result = new int[itrTimes];
		
		for(int i = 0 ; i < itrTimes ; i++) {
			result[i] = tempSum;
			temp2++;
			temp1 = temp2 + temp1;
						
		}
		
		for(int j : result)
			System.out.print(j + " ");
		
	}
}
