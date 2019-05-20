import java.util.Scanner;

public class Lct2_Array2 {
	//2차원 배열에 대한 내용
	void play1(){
		int arr2[][] = {	//	[행][열]
				{ 1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12}
		};
		
		int arr3[][] = new int[2][3];
		arr3[0][0] = 11;
		arr3[0][1] = 22;
		arr3[0][2] = 33;
		
		arr3[1][0] = 44;
		arr3[1][1] = 55;
		arr3[1][2] = 66;
		
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length; j++) {
				System.out.print("array[" + i + "][" + j + "] : " + arr3[i][j]);
				if(j<2)
					System.out.print(", ");
			}
			System.out.println();
		}		
	}
	//	국, 영, 수 점수를 입력받고 출력한다
	//	학생은 5명이고 각각 점수가 있다.
	//	각각 평균도 구해봅시다 :)
	void play2() {
		Scanner in = new Scanner(System.in);
		String[] iss = {"국어", "영어", "수학", "평균"};
		int arrScore[][] = new int[5][3];
		double avr = 0;
		
		//입력받는 대신 랜덤으로 초기화 ㄱ	
		for(int i = 0 ; i < arrScore.length ; i++ ) {
			System.out.print("학생 " + (i + 1) + "의 점수  [");
			for (int j = 0; j < arrScore[i].length; j++) {
				//	점수는 80점 ~ 99점
				arrScore[i][j] = ( ((int)(Math.random()*2))*10 + 80) + ( (int)(Math.random() *10) );
				avr += arrScore[i][j];
			}			
			for (int j = 0; j < arrScore[i].length; j++)
				System.out.printf("%s : %d \t",iss[j],arrScore[i][j]);
			System.out.println("평균 : " + (int)(avr/3) + "     ]");
			avr = 0;
		}
	}
	
	void play3() {
		// 교수님 작성본

		/*
		 * 배열 array : 같은 자료형 변수 묶음 관리 : index number 0 ~ n-1
		 * 
		 * 자료형 배열변수명[] = new 자료형[배열갯수];
		 * 
		 * int arr[] = new int[5]; int arr[] = { 1, 2, 3, 4, 5 }; arr[0] = 11;
		 * 
		 * int arr2[3][4] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, };
		 * 
		 * int arr2[][] = new int[3][4];
		 * 
		 * pointer -> C언어 array -> 쉽다 pointer -> 어렵다 pointer == array
		 * 
		 * int *p; == int p[]; int **p; == int p[][];
		 * 
		 * p[0][1] = 2; (*(p + 0) + 1) = 2;
		 */

		int arr2[][] = { // [행][열] == [3][4]
				{ 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		System.out.println(arr2[0][0]);
		System.out.println(arr2[1][2]);

		int array2[][] = new int[2][3];

		array2[0][0] = 11;
		array2[0][1] = 12;
		array2[0][2] = 13;

		array2[1][0] = 21;
		array2[1][1] = 22;
		array2[1][2] = 23;

		System.out.println("array2.length = " + array2.length);
		System.out.println("array2[0].length = " + array2[0].length);
		System.out.println("array2[1].length = " + array2[1].length);

		for (int i = 0; i < array2.length; i++) { // 2
			for (int j = 0; j < array2[0].length; j++) { // 3
				System.out.print("array[" + i + "][" + j + "] = " + array2[i][j] + " ");
			}
			System.out.println();
		}

		int _arr2[][] = { // [행][열] == [3][6]
				{ 1, 2, 3, 4 }, { 5, 6, 7, 8, 9 }, { 9, 10, 11, 12, 13, 14 } };

		System.out.println(_arr2.length);
		System.out.println(_arr2[0].length);
		System.out.println(_arr2[1].length);
		System.out.println(_arr2[2].length);

		Scanner sc = new Scanner(System.in);
		// 국어, 영어, 수학 점수를 입력 -> 출력 (학생5명) [][]
		int arrNum[][] = new int[5][3];
		String title[] = { "국어", "수학", "영어" };

		// 입력
		for (int i = 0; i < arrNum.length; i++) { // 5명의 for
			System.out.print((i + 1) + "번째 학생의 ");
			for (int j = 0; j < arrNum[0].length; j++) {
				System.out.print(title[j] + ":");
				arrNum[i][j] = sc.nextInt();
			}
		}
		// 출력
		for (int i = 0; i < arrNum.length; i++) {
			System.out.print((i + 1) + "번째 학생의 ");
			for (int j = 0; j < arrNum[0].length; j++) {
				System.out.print(title[j] + ":" + arrNum[i][j] + " ");
			}
			System.out.println();
		}

	}

}
