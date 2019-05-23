package std190523_method2;

import java.util.Scanner;

public class Lct2Method2Calculator {
	//	필드 선언
	double isInteger = 0;
	double num1 = 0;
	double num2 = 0;
	double result = 0.0;
	char oper = '+';
	Scanner in = new Scanner(System.in);
	
	//	프로그램 반복 메소드
	void myCalculator() {
		int cntRepeat = 0;
		char chcRepeat = 'Y';
		
		while(chcRepeat == 'Y') {
			this.inputValues();
			this.calculateValues();
			this.printResult();
			cntRepeat++;
			
			int resetOk = 0;
			do {
				System.out.print("계속 하시겠습니까? (Y,N) : ");
				chcRepeat = in.next().toUpperCase().charAt(0);
				switch (chcRepeat) {
					case 'Y':	case 'N':	
						resetOk = 1;	
						break;	//입력값이 Y 또는 N이면 반복 종료
					default:	//입력값이 Y 또는 N이 아니면 입력 반복
						System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				}
			} while (resetOk == 0);
		}
		System.out.println("\n프로그램종료");
		System.out.println("계산 횟수 : " + cntRepeat);
		
	}
	
	//	입력 메소드
	void inputValues() {

		
		int inputOk = 0;
		int operOk = 0;
		String input1 = "";
		String input2 = "";
		
		while (inputOk == 0) {
			System.out.print("첫 번째 숫자 입력 : ");
			input1 = in.next();
			if (isNumber(input1)) {
				inputOk = 1;
				num1 = Double.parseDouble(input1);
			} else
				System.out.println("숫자아님. 다시입력.");
		}
				
		do {
			System.out.print("연산자 입력( +, -, *, / ) : ");
			oper = in.next().charAt(0);
			if (oper == '+' || oper == '-' || oper == '*' || oper == '/')
				operOk = 1;
			else
				System.out.println("잘못 입력 하셨습니다. 사칙연산의 연산자를 입력하세요. 입력한값 : " + oper);
		} while (operOk == 0);
		
		inputOk = 0;
		num2 = 0;		//	반복 제어 변수 초기화
		while (inputOk == 0 ) {
			System.out.print("두 번째 숫자 입력 : ");
			input2 = in.next();
			if (isNumber(input2)) {
				inputOk = 1;
				num2 = Double.parseDouble(input2);
			}  else {
				System.out.println("숫자아님. 다시입력.");
				continue;
			}
			if(this.oper == '/' && input2.charAt(input2.length()-1) == '0') {
				System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요.");
				continue;
			}
		}		
	}

	//	계산 메소드
	void calculateValues() {
		switch (oper) {
		case '+':	result = num1 + num2;	break;
		case '-':	result = num1 - num2;	break;
		case '*':	result = num1 * num2;	break;
		case '/':	result = num1 / num2;	break;
		default:	System.out.println("오류입니다. 다시 시도하세요.");		result = 0;		break;
		}	//입력받은 연산 기호에 따라 연산
	}
	
	//	출력 메소드
	void printResult() {
		double doubleResult = 0.0;
		int integerResult = 0;
		
		System.out.println("계산 결과를 출력합니다.");
		
		isInteger = result - ( (int)result);
		
		// 결과 값이 정수이면 정수 값으로 출력
		if( isInteger == 0 ) {
			integerResult = (int)result;
			System.out.println((int)num1 + " " + oper + " " + (int)num2 + " = " + integerResult);
		} else {
			doubleResult = result;
			System.out.println(num1 + " " + oper + " " + num2 + " = " + doubleResult);
		}
		
		
	}
	
	boolean isNumber(String num) {
		try {
			double str = Double.parseDouble(num);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
