package std190521_sort;

public class Work1 {
	//	2차원 배열을 1차원 배열에 담는 프로그램 작성
	//	{11,12,13,14}, {21,22,23,24}, {31,32,33,34}
	//	위 숫자를 1차원 배열에 ㄱ
	void play1() {
		//2차원 배열 선언
		int[][] arr1 = { {11,12,13,14}, {21,22,23,24}, {31,32,33,34} };
		int[] arr2 = new int[arr1.length * (arr1[0].length - 1)];
		
		int k = 0;
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				arr2[k++] = arr1[i][j]; 
				//	== arr2[ ( arr1[0] * i ) + j ] = arr1[i]][j];
			}
		}
		for(int l : arr2)
			System.out.print(l + " " );
		
	}
	
	
}
