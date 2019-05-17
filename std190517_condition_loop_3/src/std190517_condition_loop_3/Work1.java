package std190517_condition_loop_3;
import java.util.*;
public class Work1 {
	//	[계산기 작성]
	//	1. START
	//	2. 1번째 수 입력
	//	3. 연산자 
	//	4. 2번째 수 입력
	//	5. 결과 출력
	//	6. 2~5 반복 or 종료
	//	문자 입력을 잘못 한 경우? == 다시입력하세욧!
	void play1() {
		Scanner in = new Scanner(System.in);
		
		int oprOk = 0, resetOk = 0 ;
		double num1 = 0, num2 = 0, result = 0;
		char opr = ' ', chc = 'Y';
		
		while( chc == 'Y' ) {
			System.out.println("사칙연산 계산기 프로그램을 시작합니다.");
			
			System.out.print("첫 번째 숫자 입력 : ");
			num1 = in.nextDouble();
			
			do{
				System.out.print("연산자 입력( +, -, *, / ) : ");
				opr = in.next().charAt(0);
				if( opr == '+' || opr == '-' || opr == '*' || opr == '/' )
					oprOk = 1;
				else
					System.out.println("잘못 입력 하셨습니다. 사칙연산의 연산자를 입력하세요. 입력한값 : "+opr);
			}while( oprOk == 0);
			
			num2 = 0;
			while( num2 == 0) {
				System.out.print("두 번째 숫자 입력 : ");
				num2 = in.nextDouble();
				
				if(opr == '/' && num2 == 0) {
					System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요.");
				} 
			}
			
			
			
			switch (opr) {
				case '+' :
					result = num1 + num2;
					break;
				case '-' :
					result = num1 - num2;
					break;
				case '*' :
					result = num1 * num2;
					break;
				case '/' :
					result = num1 / num2;
					break;
				default :
					System.out.println("오류입니다. 다시 시도하세요.");
					result = 0;
					break;	
			}
			System.out.println("연산 결과 : " + result );
			System.out.println(num1 + " " + opr + " " + num2 + " = " + result);
			
			
			do {
			System.out.print("계속 하시겠습니까? (Y,N) : ");
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
		System.out.println("프로그램을 종료합니다.");
	}
}
