package studentSingleton;

import java.util.Scanner;

public class StaticFunction {
	private static StaticFunction single = null;
	private static Scanner in = new Scanner(System.in);

	public StaticFunction() {
	}

	// �Է°��� Y�Ǵ� N���� �˻�
	public static char isYOrN() {
		char ch = '1';

		while (ch != 'Y' && ch != 'N') {
			ch = in.next().toUpperCase().charAt(0);

			if (ch != 'Y' && ch != 'N') {
				System.out.println("Y�Ǵ� N�� �Է��ϼ���.");
			}
		}
		return ch;
	}

	// �Է°��� �������� �˻�
	public static int inputUntilInteger() {
		int num = 0;

		char ch = 'f';
		boolean isNotInteger = true;

//		while( isNotInteger ) {
//			ch = in.next().charAt(0);
//			if ( isNotInteger = ( ch >= '0' && ch <= '9') ) {
//				isNotInteger = false;
//			}else {
//				System.out.println("������ �ƴմϴ�. ������ �Է��ϼ���.");
//				isNotInteger = true;
//			}
//		}
		while (isNotInteger) {
			try {
				num = Integer.parseInt(in.next());
				isNotInteger = false;
			} catch (Exception e) {
				System.out.println("������ �ƴմϴ�. ������ �Է��ϼ���.");
				isNotInteger = true;
			}
		}
		return num;
	}
	
	public static StaticFunction getInstance() {
		if( single == null ) {
			single = new StaticFunction();
		}		
		return single;
	}

}
