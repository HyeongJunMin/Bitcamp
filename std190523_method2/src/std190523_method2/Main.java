package std190523_method2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Lct2Method2Calculator l2 = new Lct2Method2Calculator();
//		
//		l2.myCalculator();
		
		int[] arr1 = {5,1,6,12,4,7};
		
		System.out.println(Arrays.toString(arr1));
		Lct3Method2Sort.sortIntegerArr(arr1, 0);
		System.out.println(Arrays.toString(arr1));
		Lct3Method2Sort.sortIntegerArr(arr1, 1);
		System.out.println(Arrays.toString(arr1));
		
		Lct3Method2Sort l3 = new Lct3Method2Sort();
		int[] arr2 = l3.sortIntegerArrWithReturn(arr1, 0);
		System.out.println(Arrays.toString(arr2));
		
		arr2 = l3.sortIntegerArrWithReturn(arr1, 1);
		
		System.out.println(Arrays.toString(arr2));
		
//		야구게임( 객체 )
//		Lct4Method2BaseballGame l4 = new Lct4Method2BaseballGame();
//		l4.runGame();
		
		
		//야구게임
		//사용자 입력 : 길이가 3인 정수배열
		//정답 : 길이가 3인 정수배열
		List<Integer> answer = Lct5Method2BaseballGameUsingStaticMethod.returnAnswerArr();
		List<Integer> userInputArr = new ArrayList<>();
		List<Integer> resultArr ;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("답  : " + answer.toString());
		
		Lct5Method2BaseballGameUsingStaticMethod.runBasballGame();
		
//		for(int i = 0 ; i < 10 ; i ++) {
//			for(int j = 0 ; j < 3 ; j ++) {
//				System.out.print(j+1+"번");
//				userInputArr.add(in.nextInt());
//			}
//			resultArr = Lct5Method2BaseballGameUsingStaticMethod.returnBSO(userInputArr, answer);
//			System.out.println(resultArr.toString());
//			if( resultArr.get(2) == 1) {
//				System.out.println("끝났단다");
//				break;
//			}
//			userInputArr.clear();	
//		}
	}

}
