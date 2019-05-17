package std190517_condition_loop_3;

public class Review_190516 {
	void play1() {
		// 1~100 사이 정수를 받았을 때 10의 자리 범위 산출
		int inputNumber = 75;
		int num10 = 0;
		for (int i = 0; i < 10; i++) {
			num10 = 10 * i;
			if(inputNumber > num10 && inputNumber <= num10 + 10) {
				System.out.println(num10 + "보다 크고 " 
							+ (num10 + 10) + "보다 작거나 같은 범위에 있습니다");
			}
		}
	}

	void play2() {
		// 1~100 사이 짝수의 합과 홀수의 합 출력
		int sum1, sum2; // 선언
		int _num = 0;

		sum1 = sum2 = 0; // 초기화

		for (int i = 0; i < 100; i++) { // 처리
			_num++;
			if (_num % 2 == 1) { // 홀수
				sum1 = sum1 + _num;
			} else {
				sum2 = sum2 + _num;
			}

		}

		System.out.println(sum1 + " " + sum2); // 출력
	}
}
