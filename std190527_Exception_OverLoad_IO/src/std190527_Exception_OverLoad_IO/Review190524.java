package std190527_Exception_OverLoad_IO;
import java.util.Scanner;

public class Review190524 {
	public static void main(String[] args) {

		// �Է� 5���� �л��� ���� (��ȣ, �̸�, ����, ����, ����)
		// �迭(2����)
		// String students[][] = new String[5][5];
		String students[][];

		// input
		students = input();

		// sum
		int sum = allSum(students);
		System.out.println("�л� ������ ���հ�:" + sum);

		// �� �л��� ������ �հ� ȫ�浿 -> 1��
		int memSum = studentSum(1001, students);
		System.out.println(1001 + "�� �л��� ������ �հ�:" + memSum);

		// �� �л��� ������ ���
		double avg = studentAvg(1002, students);
		System.out.println(1002 + "�� �л��� ������ ���:" + avg);

		// ������ 1�� max -> ����, ����?
		int numOne[] = new int[students.length]; // 1���� ����?

		int max = numberOne("����", students, numOne);
		System.out.println("������ �ְ� ������ " + max + "�Դϴ�");

		for (int i = 0; i < numOne.length; i++) {
			if (numOne[i] != 0) {
				System.out.println("������ �ְ� ������ �л��� " + numOne[i] + "�� �л��Դϴ�");
			}
		}

		// all print
		allPrint(students);
	}

	static String[][] input() {
		Scanner sc = new Scanner(System.in);

		String students[][] = new String[5][5];
		// �� �׸�

		for (int i = 0; i < students.length; i++) {
			// ���ڸ� �Ҵ�
			String number = 1001 + i + "";
			students[i][0] = number;

			// �̸��� �Է�
			System.out.print("�̸�:");
			String name = sc.next();
			students[i][1] = name;

			// ��� �Է�
			System.out.print("����:");
			String lang = sc.next();
			students[i][2] = lang;

			// ��� �Է�
			System.out.print("����:");
			String eng = sc.next();
			students[i][3] = eng;

			// ������ �Է�
			System.out.print("����:");
			String math = sc.next();
			students[i][4] = math;
		}
		return students;
	}

	static int allSum(String students[][]) {
		int sum = 0;
		for (int i = 0; i < students.length; i++) {
			for (int j = 2; j < students[1].length; j++) {
				sum = sum + Integer.parseInt(students[i][j]);
			}
		}
		return sum;
	}

	static int studentSum(int no, String students[][]) {
		int sum = 0;
		/*
		 * for (int i = 0; i < students.length; i++) { int number =
		 * Integer.parseInt(students[i][0]); if(number == no) { for (int j = 2; j <
		 * students[0].length; j++) { sum = sum + Integer.parseInt(students[i][j]); } }
		 * }
		 */
		// �˻�
		int findIndex = -1;
		for (int i = 0; i < students.length; i++) {
			int number = Integer.parseInt(students[i][0]);
			if (number == no) {
				findIndex = i;
				break;
			}
		}

		if (findIndex == -1) {
			System.out.println("�л� ������ ã�� �� �����ϴ�");
			return 0;
		}

		// �հ�
		for (int i = 2; i < students[0].length; i++) {
			sum = sum + Integer.parseInt(students[findIndex][i]);
		}

		return sum;
	}

	static double studentAvg(int no, String students[][]) {
		int sum = studentSum(no, students);
		double avg = (double) sum / 3;
		return avg;
	}

	static int numberOne(String title, String students[][], int numOne[]) {
		int titleNum = 0;
		if (title.equals("����")) {
			titleNum = 2;
		} else if (title.equals("����")) {
			titleNum = 3;
		} else if (title.equals("����")) {
			titleNum = 4;
		}

		int max = Integer.parseInt(students[0][titleNum]);
		for (int i = 0; i < students.length; i++) {
			int number = Integer.parseInt(students[i][titleNum]);
			if (max < number) {
				max = number;
			}
		}

		// 1���� ����?
		int count = 0;
		for (int i = 0; i < numOne.length; i++) {
			int number = Integer.parseInt(students[i][titleNum]);
			if (number == max) {
				numOne[count] = Integer.parseInt(students[i][0]);
				count++;
			}
		}

		return max;
	}

	static void allPrint(String students[][]) {
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students[0].length; j++) {
				System.out.print(students[i][j] + " ");
			}
			System.out.println();
		}
	}
}
