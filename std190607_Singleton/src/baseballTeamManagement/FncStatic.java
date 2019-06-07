package baseballTeamManagement;

import java.util.Scanner;

public class FncStatic {
	public static Scanner in = new Scanner(System.in);

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

		boolean isNotInteger = true;

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

	// �Է°��� �Ǽ����� �˻�
	public static double inputUntilDouble() {
		double num = 0.0;
		
		boolean isNotDouble = true;

		while (isNotDouble) {
			try {
				num = Double.parseDouble(in.next());
				isNotDouble = false;
			} catch (Exception e) {
				System.out.println("�Ǽ��� �ƴմϴ�. �Ǽ��� �Է��ϼ���.");
				isNotDouble = true;
			}
		}

		return num;
	}

}
