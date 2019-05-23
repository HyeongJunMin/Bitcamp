package std190523_method2;

public class Lct3Method2Sort {
	//정렬해주는 메소드 Sort 작성
	//numberInput 
	//	1. 몇 개의 숫자를 받을건지 정해서 입력받으세요
	//	2. 숫자를 입력받으세요
	//	3. 오름차순/내림차순 정하세요
	//sorting(배열, 올림/내림)
	//	swap
	//result(배열, 올림/내림)
	
	int[] sortIntegerArrWithReturn( int[] arr, int setDirection) {
		switch( setDirection ) {
		case 0:
			sortRightDirection(arr);
			break;
		case 1:
			sortReverseDirection(arr);
			break;
		default : 
			break;			
		}		
		return arr;
	}
	
	static void sortIntegerArr(int[] arr, int setDirection) {
		switch( setDirection ) {
		case 0:
			sortRightDirection(arr);
			break;
		case 1:
			sortReverseDirection(arr);
			break;
		default : 
			break;			
		}
	}
	
	static void sortRightDirection(int[] arr) {
		int temp = 0;
		int arrLen = arr.length;
		
		for (int i = 0; i < arrLen; i++) {
			for (int j = i; j < arrLen; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	static void sortReverseDirection(int[] arr) {
		int temp = 0;
		int arrLen = arr.length;
		
		for (int i = 0; i < arrLen; i++) {
			for (int j = i; j < arrLen; j++) {
				if(arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
