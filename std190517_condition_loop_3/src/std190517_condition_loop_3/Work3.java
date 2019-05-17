package std190517_condition_loop_3;

import java.util.*;

public class Work3 {
	// [계산기ver2 작성]
	// 1. START
	// 2. 1번째 수 입력 - 숫자가 아니면 다시입력해라!
	// 3. 연산자
	// 4. 2번째 수 입력 - 숫자가 아니면 다시입력해라!
	// 5. 결과 출력
	// 6. 2~5 반복 or 종료
	// 문자 입력을 잘못 한 경우? == 다시입력하세욧!
	void play1() {
		Scanner in = new Scanner(System.in);

		String inNum1 = " ", inNum2 = " ";
		int oprOk = 0, resetOk = 0, isInteger = 0, inputOk = 0;
		double num1 = 0, num2 = 0, result = 0, result2 = 0;
		char opr = ' ', chc = 'Y';

		while (chc == 'Y') {
			System.out.println("사칙연산 계산기 프로그램을 시작합니다.");

			inputOk = 0;
			while (inputOk == 0) {
				System.out.print("첫 번째 숫자 입력 : ");
				inNum1 = in.next();
				if (isNumber(inNum1)) {
					inputOk = 1;
					num1 = Double.parseDouble(inNum1);
				} else
					System.out.println("숫자아님. 다시입력.");
			}
			// 문자열로 입력받아서
			// 문자열이 숫자인지 확인한 다음
			// 숫자이면 반복을 종료하고 문자열을 숫자로 변환해서 저장

			do {
				System.out.print("연산자 입력( +, -, *, / ) : ");
				opr = in.next().charAt(0);
				if (opr == '+' || opr == '-' || opr == '*' || opr == '/')
					oprOk = 1;
				else
					System.out.println("잘못 입력 하셨습니다. 사칙연산의 연산자를 입력하세요. 입력한값 : " + opr);
			} while (oprOk == 0);
			
			inputOk = 0;
			num2 = 0;		//	반복 제어 변수 초기화
			while (inputOk == 0 || num2 == 0) {
				System.out.print("두 번째 숫자 입력 : ");
				inNum2 = in.next();
				if (isNumber(inNum2)) {
					inputOk = 1;
					num2 = Double.parseDouble(inNum2);
				}  else {
					System.out.println("숫자아님. 다시입력.");
					continue;
				}
				if(opr == '/' && inNum2.charAt(inNum2.length()-1) == '0') {
					System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요.");
					continue;
				}
			}
			
			
			switch (opr) {
				case '+':	result = num1 + num2;	break;
				case '-':	result = num1 - num2;	break;
				case '*':	result = num1 * num2;	break;
				case '/':	result = num1 / num2;	break;
				default:	System.out.println("오류입니다. 다시 시도하세요.");		result = 0;		break;
			}	//입력받은 연산 기호에 따라 연산
			System.out.println(result +" " + result2);
			result2 = result - ((int)result);
			//	정수인지 소수인지 판별하는 변수. 정수이면  0이고 실수이면 0과~1사이의 소수
			System.out.println(result +" " + result2);
			if (result2 == 0) {	//연산 결과값이 정수이면 정수로 출력
				isInteger = (int) result;
				System.out.println("연산 결과 : " + isInteger);
				System.out.println((int) num1 + " " + opr + " " + (int) num2 + " = " + isInteger);
			} else {			//연산 결과값이 실수이면 실수로 출력
				System.out.println("연산 결과 : " + result);
				System.out.println(num1 + " " + opr + " " + num2 + " = " + result);
			}

			do {
				System.out.print("계속 하시겠습니까? (Y,N) : ");
				chc = in.next().toUpperCase().charAt(0);
				switch (chc) {
					case 'Y':	case 'N':	
						resetOk = 1;	
						break;	//입력값이 Y 또는 N이면 반복 종료
					default:	//입력값이 Y 또는 N이 아니면 입력 반복
						System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				}
			} while (resetOk == 0);
		}
		System.out.println("프로그램을 종료합니다.");
	}

	boolean isNumber(String num) {
		try {
			double str = Double.parseDouble(num);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	boolean isNumber2(String num) {
		char ch = num.charAt(num.length()-1);
		if(ch >=  0 && ch <= 9) {
			return true;
		} else {
			return false;
		}
	}

}
