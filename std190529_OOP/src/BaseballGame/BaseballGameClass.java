package BaseballGame;

import java.util.Scanner;

public class BaseballGameClass {
	public static Scanner in = new Scanner(System.in);

	private int chc = 0;
	private int cnt = 0;
	private int cntHits = 0;
	private int cntGames = 1;
	private int result[] = { 0, 0, 0 };
	private int answer[] = { 999, 999, 999 };
	private int userInput[] = { 999, 999, 999 };
	private int userSelection = '3';
	private char continueConfirm = '1';
	private String comData = "000";
	
	int[] getAnswer() {
		return this.answer;
	}
	
	public void play1() {

		while (chc == 0) {
			System.out.println("�߱������� �����մϴ�.");
			System.out.println("����ڴ� 10���� ��ȸ ���� ������ �ִ� 3���� ������ ���߾�� �մϴ�.");
			System.out.println("3���� ������ ���� 1~10 ������ �����̸�, �ߺ��Ǵ� ���ڴ� �����ϴ�.");

			// �ߺ��� ���ŵ� ���� Ȯ��
			answer = this.setAnswer();
			cnt = 0;

			while (cnt < 15) {
				//����� �Էº� �迭 �ʱ�ȭ
				for(int i : userInput)
					i = 999;
				
				System.out.println((cnt + 1) + "�� ° �õ��Դϴ�.");
				for (int i = 0; i < answer.length; i++)
					System.out.print((i + 1) + "�� ° ���� : " + answer[i] + "   ");
				System.out.println();
			
				// ����� �Էºκ�
				System.out.println("3���� ������ �Է��ϼ��� ! ");
				for (int i = 0; i < userInput.length; i++) {
					System.out.print((i + 1) + "�� ° ���� : ");
					do {
						userSelection = Character.getNumericValue(in.next().charAt(0));
						if (userSelection < 0 || userSelection > 9) {
							System.out.println("�߸� �Է��ϼ̾�� ; ");
						} else {
							userInput[i] = (int) (userSelection);
						}
					} while (userSelection < 0 || userSelection > 9);

					if(i>=1) {
					for (int j = 0; j < userInput.length; j++) {
						if (i == j)
							continue;
						while (userInput[i] == userInput[j]) {
							System.out.println((i + 1) + "�� ° ���ڿ� �ߺ��Դϴ�. �ٽ� �Է��ϼ��� : ");
							userInput[i] = Character.getNumericValue(in.next().charAt(0));
						}
					} // �ߺ� ����
					}
				}
				System.out.println("�Է¼���");

				// �� �˻� �κ�
				comData = answer[0] + " " + answer[1] + " " + answer[2] + " ";

				System.out.println(comData);
				result = ballStrikeOut(userInput, answer);

				System.out.println(result[0] + "��, " + result[1] + "��Ʈ����ũ,  " + result[2] + "�ƿ�");

				cnt++;

				if (result[2] != 0) {
					System.out.println("�����մϴ�! �����Դϴ�!");
					cntHits += cnt;// ����Ƚ�� ����
					break;
				} else if (cnt > 9) {
					System.out.println("���� ! ����Ƚ�� �ʰ�! " + (cnt) + "ȸ.");
					cntHits += cnt;// ����Ƚ�� ����
					break;
				}

				// �Է°� �ʱ�ȭ
				for (int k : answer)
					k = 999;

			}

			do {
				System.out.print("��� �Ͻðڽ��ϱ�? (Y/N)");

				continueConfirm = in.next().toUpperCase().charAt(0);

				if (continueConfirm == 'N') {
					chc = 1;
					break;
				} else if (continueConfirm == 'Y') {
					cntGames++;
					break;
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				}
			} while (continueConfirm != 'N' || continueConfirm != 'Y');
		}
		System.out.println("���α׷��� �����մϴ�.");
		System.out.println("�� ���� Ƚ�� : " + cntHits);
		System.out.println("�� ���� Ƚ�� : " + cntGames);
		System.out.println("1���� �� ��� ���� Ƚ�� : " + ((double) cnt / (cntGames)));
	}

	int[] setAnswer() { // 3���� ���� ���� �迭 ����(0~9)
		int[] answerArr = { 0, 0, 0 };
		for (int i = 0; i < answerArr.length; i++) {
			answerArr[i] = ((int) (Math.random() * 10));	//i��° ���� �������� ����
			for (int j = 0; j < answerArr.length; j++) {
				if (i == j)		//index i�� j�� ������ �� ����
					continue;
				while (answerArr[i] == answerArr[j]) {	//i��° ���� j��° ���� ������
					answerArr[i] = ((int) (Math.random() * 10));	//i��° ���� �������� ����
				}
			} // �ߺ� ����
		}

		return answerArr;
	}

	int[] ballStrikeOut(int[] userAnswer111, int[] comAnswer111) {
		int[] userAnswer22 = userAnswer111;
		int[] comAnswer22 = comAnswer111;

		int ball1 = 0, strike1 = 0, out1 = 0;

		for (int i = 0; i < userAnswer22.length; i++) {
			for (int j = 0; j < comAnswer22.length; j++) {
				if (userAnswer22[i] == comAnswer22[i]) {
					strike1++;
					break;
				} else if (userAnswer22[i] == comAnswer22[j]) {
					ball1++;
				}
			}
		}
		if (strike1 == comAnswer111.length)
			out1 = 1;
		int[] ballStrikeOut = { ball1, strike1, out1 };
		return ballStrikeOut;
	}
}
