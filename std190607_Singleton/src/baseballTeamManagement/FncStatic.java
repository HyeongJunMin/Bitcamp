package baseballTeamManagement;

import java.util.Scanner;

public class FncStatic {
	public static Scanner in = new Scanner(System.in);

	// 입력값이 Y또는 N인지 검사
	public static char isYOrN() {
		char ch = '1';

		while (ch != 'Y' && ch != 'N') {
			ch = in.next().toUpperCase().charAt(0);

			if (ch != 'Y' && ch != 'N') {
				System.out.println("Y또는 N을 입력하세요.");
			}
		}
		return ch;
	}

	// 입력값이 정수인지 검사
	public static int inputUntilInteger() {
		int num = 0;

		boolean isNotInteger = true;

		while (isNotInteger) {
			try {
				num = Integer.parseInt(in.next());
				isNotInteger = false;
			} catch (Exception e) {
				System.out.println("정수가 아닙니다. 정수를 입력하세요.");
				isNotInteger = true;
			}
		}
		return num;
	}

	// 입력값이 실수인지 검사
	public static double inputUntilDouble() {
		double num = 0.0;
		
		boolean isNotDouble = true;

		while (isNotDouble) {
			try {
				num = Double.parseDouble(in.next());
				isNotDouble = false;
			} catch (Exception e) {
				System.out.println("실수가 아닙니다. 실수를 입력하세요.");
				isNotDouble = true;
			}
		}

		return num;
	}

}
