package std190516_condition_loop_2;

public class Work5 {
	void play() {
		//1~100사이 짝수의 합과 홀수의 합을 각각 출력
		
		int even = 0;
		int odd = 0;
		for (int i = 1; i <= 100; i++) {
			if( (i%2) == 0 )
				even+=i;
			else
				odd+=i;
		}
		System.out.println("1부터 100 사이 짝수의 합은 : " + even);
		System.out.println("1부터 100 사이 홀수의 합은 : " + odd);
	}
}
