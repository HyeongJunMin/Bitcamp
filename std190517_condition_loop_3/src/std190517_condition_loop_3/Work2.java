package std190517_condition_loop_3;
import java.math.*;
import java.util.*;

public class Work2 {
	//	[Random Number Game] - 1~100 랜덤하게 정해진 정수 맞추기
	//	1. random(1~100) answer 지정
	//	2. User로 부터 입력 받음
	//	3. 입력 받은 숫자와 ans 비교해서 "너무 큽니다", "너무 작습니다" 출력
	//	4. 입력 카운트 + 1
	//	5. 2~4 반복 종료조건 : 카운트 == 10 or 정답 
	
	void play1(){
		
		Scanner in = new Scanner(System.in);
		
		int answer = 0, inNum = 0, cnt = 0, resetOk = 0;
		char chc = 'Y';
		
		
		while( chc == 'Y') {	//	게임 지속 여부를 결정하는 변수 53번째 줄에서 y, n 설정
			System.out.println("Random Number Game을 시작합니다.");
			System.out.println("10번 안에 1~100까지 랜덤한 정수를 맞추면 성공입니다.");
			
			cnt = 1;		//	횟수 카운트 변수 초기화
			answer = (int)( Math.random() * 100 + 1);
			
			while( cnt <= 10 ) {	// 카운트가 10이 될 때 까지 10번 반복
				System.out.println(cnt + "번 째 숫자 입력 : ");
				inNum = in.nextInt();
				
				if( answer == inNum) {	//정답을 맞춘 경우 반복 종료
					System.out.println("정답입니다! 정답 : " + answer);
					break;	
				} else if( inNum > 100 || inNum < 0 ) {	//	입력값을 잘못 입력한 경우 
					System.out.println("정답은 1부터 100까지의 정수입니다. 정신차리세요.");
					cnt++;					
				}else if ( answer > inNum ) {	//	입력값이 정답보다 큰 경우 
					System.out.println("너무 작습니다! 다시 시도하세요!");
					cnt++;
				}else if( answer < inNum ) {	//	입력값이 정답보다 작은 경우 
					System.out.println("너무 큽니다! 다시 시도하세요!");
					cnt++;
				} 
				if(cnt > 10) {
					System.out.println("10회 초과. 게임 끝.");
					break;
				}
					
			}
			
			do {
				System.out.println("계속 하시겠습니까? (Y,N) : ");
				chc = in.next().toUpperCase().charAt(0);
				switch( chc ) {
					case 'Y': case 'N':
						resetOk = 1;
						break;
					default :
						System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");					
				}
			} while( resetOk == 0);
		}
		System.out.println("게임을 종료합니다.");
		
	}
}
