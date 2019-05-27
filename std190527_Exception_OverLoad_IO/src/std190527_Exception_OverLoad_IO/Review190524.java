package std190527_Exception_OverLoad_IO;
import java.util.Scanner;

public class Review190524 {
	public static void main(String[] args) {

		// 입력 5명의 학생의 성적 (번호, 이름, 국어, 영어, 수학)
		// 배열(2차원)
		// String students[][] = new String[5][5];
		String students[][];

		// input
		students = input();

		// sum
		int sum = allSum(students);
		System.out.println("학생 성적의 총합계:" + sum);

		// 각 학생의 성적의 합계 홍길동 -> 1명
		int memSum = studentSum(1001, students);
		System.out.println(1001 + "번 학생의 성적의 합계:" + memSum);

		// 각 학생의 성적의 평균
		double avg = studentAvg(1002, students);
		System.out.println(1002 + "번 학생의 성적의 평균:" + avg);

		// 성적의 1등 max -> 점수, 누구?
		int numOne[] = new int[students.length]; // 1등은 누구?

		int max = numberOne("국어", students, numOne);
		System.out.println("국어의 최고 점수는 " + max + "입니다");

		for (int i = 0; i < numOne.length; i++) {
			if (numOne[i] != 0) {
				System.out.println("국어의 최고 점수의 학생은 " + numOne[i] + "번 학생입니다");
			}
		}

		// all print
		allPrint(students);
	}

	static String[][] input() {
		Scanner sc = new Scanner(System.in);

		String students[][] = new String[5][5];
		// 명 항목

		for (int i = 0; i < students.length; i++) {
			// 숫자를 할당
			String number = 1001 + i + "";
			students[i][0] = number;

			// 이름을 입력
			System.out.print("이름:");
			String name = sc.next();
			students[i][1] = name;

			// 국어를 입력
			System.out.print("국어:");
			String lang = sc.next();
			students[i][2] = lang;

			// 영어를 입력
			System.out.print("영어:");
			String eng = sc.next();
			students[i][3] = eng;

			// 수학을 입력
			System.out.print("수학:");
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
		// 검색
		int findIndex = -1;
		for (int i = 0; i < students.length; i++) {
			int number = Integer.parseInt(students[i][0]);
			if (number == no) {
				findIndex = i;
				break;
			}
		}

		if (findIndex == -1) {
			System.out.println("학생 정보를 찾을 수 없습니다");
			return 0;
		}

		// 합계
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
		if (title.equals("국어")) {
			titleNum = 2;
		} else if (title.equals("영어")) {
			titleNum = 3;
		} else if (title.equals("수학")) {
			titleNum = 4;
		}

		int max = Integer.parseInt(students[0][titleNum]);
		for (int i = 0; i < students.length; i++) {
			int number = Integer.parseInt(students[i][titleNum]);
			if (max < number) {
				max = number;
			}
		}

		// 1등은 누구?
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
