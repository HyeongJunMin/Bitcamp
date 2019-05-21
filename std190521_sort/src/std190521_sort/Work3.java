package std190521_sort;

public class Work3 {
	//과제1. 배열 : 합계 내주면 끝
	//과제2. 배열 : 총 합, 평균 
	//과제3. 거스름돈 주화 별 갯수 구하기 :
	//과제4. 암호표로 암호화 하기.
	//		a==', b==~, c==!, d==@, e==#...이런식임
	//		abc123을 변형하면? `~!wer이 되는거임
	
	void play1() {
		//과제1. 배열 합계 내기
		int arr[] = {10, 20, 30, 40, 50};
		int sum = 0;
		
		for(int i : arr)
			sum += i;
		
		System.out.println("sum = " + sum);
		
	}
	
	void play2() {
		//과제2. 총 합, 평균 구하기
		int[][] arr = { {5,5,5,5,5}, {10,10,10,10,10}, {20,20,20,20,20}, {30,30,30,30,30}};
		
		int total = 0;
		float average = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
			}
		}
		
		average = (float)total / (arr.length * arr[0].length);
		
		System.out.println("total = " + total);
		System.out.println("average = " + average);
	}
	
	void play3() {
		//과제3. 거스름돈 주화 별 갯수 구하기 :
		int[] coinUnit = {500, 100, 50, 10};
		int money=2680;
		
		System.out.println("Money = " + money);
		for (int i = 0; i < coinUnit.length; i++) {
			System.out.println(coinUnit[i]+"원:"+ (money/coinUnit[i]));
			money = money % coinUnit[i];
		}		
	}
	
	void play4() {
		//	알파벳과 숫자를 아래 주어진 암호표로 암호화하는 프로그램.
		//알파벳	a b c d e f g ... x y z
		//암호표	` ~ ! @ # $ % ... , . /
		//숫자	0 1 2 3 4 ... 8 9
		//암호표	q w e r t ... o p
		char[] abcCode = { '`', '~', '!', '@', '#', '$', '%', '^', '&', 
							'*', '(', ')', '-', '_', '+', '=', '|', '[',
							']', '{', '}', ';', ':', ',', '.', '/' };
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};

		String src = "abc123";
		String result = "";
		char ch = ' ';
		
		//문자열 src의 문자를 charAt()으로 하나씩 읽어서 변환 후 reslult에 저장
		for (int i = 0 ; i < src.length() ; i++) {
			ch = src.charAt(i);
			if(ch >= 'a') {
				result += abcCode[(int)ch-97];
			} else {
				result += numCode[(int)ch-48];
			}
		}
		
		System.out.println(result);
		
	}
}




