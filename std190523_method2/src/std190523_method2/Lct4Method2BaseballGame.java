package std190523_method2;

import java.util.Scanner;

public class Lct4Method2BaseballGame {
	// 야구게임 만들기
	// static 없이 객체로 굴리기
	// 선언부
	int chc = 0;
	int cnt = 0;
	int cntHits = 0;
	int cntGames = 1;
	int result[] = { 0, 0, 0 };
	int answer[] = { 999, 999, 999 };
	int userInput[] = { 999, 999, 999 };
	int userSelection = '3';
	char continueConfirm = '1';
	String comData = "000";
	Scanner in = new Scanner(System.in);

	//게임 실행 메소드
	void runGame() {
		while (chc == 0) {

			// 중복이 제거된 정답 확정
			answer = this.setAnswer();
			cnt = 0;

			while (cnt < 15) {

				System.out.println((cnt + 1) + "번 째 시도입니다.");
				for (int i = 0; i < answer.length; i++)
					System.out.print((i + 1) + "번 째 숫자 : " + answer[i] + "   ");
				System.out.println();


				// 사용자 입력부분
				System.out.println("3개의 정수를 입력하세요 ! ");
				for (int i = 0; i < userInput.length; i++) {
					System.out.print((i + 1) + "번 째 숫자 : ");
					do {						
						userSelection = Character.getNumericValue(in.next().charAt(0));
						if (userSelection < 0 || userSelection > 9) {
							System.out.println("잘못 입력하셨어요 ; ");
						} else {
							userInput[i] = (int) (userSelection);
						}
					} while (userSelection < 0 || userSelection > 9);

					for (int j = 0; j < userInput.length; j++) {
						if (i == j)
							continue;
						while (userInput[i] == userInput[j]) {
							System.out.println((i + 1) + "번 째 숫자와 중복입니다. 다시 입력하세요 : ");
							userInput[i] = Character.getNumericValue(in.next().charAt(0));
						}
					} // 중복 제거
				}
				System.out.println("입력성공");

				// 답 검사 부분
				comData = answer[0] + " " + answer[1] + " " + answer[2] + " ";

				System.out.println(comData);
				result = ballStrikeOut(userInput, answer);

				System.out.println(result[0] + "볼, " + result[1] + "스트라이크,  " + result[2] + "아웃");
				for(int k = 0 ; k < userInput.length; k++)
					userInput[k] = 999;

				cnt++;

				if (result[2] != 0) {
					System.out.println("축하합니다! 정답입니다!");
					cntHits += cnt;// 도전횟수 누적
					break;
				} else if (cnt > 9) {
					System.out.println("실패 ! 도전횟수 초과! " + (cnt) + "회.");
					cntHits += cnt;// 도전횟수 누적
					break;
				}

				// 입력값 초기화
				for (int k : answer)
					k = 999;

			}
		}
	}
	
	//입력값이 Y인지 N인지 판단
	void confirmYOrN() {
		
		do {
			System.out.print("계속 하시겠습니까? (Y/N)");

			continueConfirm = in.next().toUpperCase().charAt(0);

			if (continueConfirm == 'N') {
				chc = 1;
				break;
			} else if (continueConfirm == 'Y') {
				cntGames++;
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
		} while (continueConfirm != 'N' || continueConfirm != 'Y');
	}
	
	//인트로 프린트(SYSO)
	void printIntro() {
		System.out.println("야구게임을 시작합니다.");
		System.out.println("사용자는 10번의 기회 동안 순서가 있는 3개의 정수를 맞추어야 합니다.");
		System.out.println("3개의 정수는 각각 1~10 사이의 정수이며, 중복되는 숫자는 없습니다.");
	}

	//아웃트로 프린트(SYSO)
	void printOutro() {
		System.out.println("프로그램을 종료합니다.");
		System.out.println("총 도전 횟수 : " + cntHits);
		System.out.println("총 게임 횟수 : " + cntGames);
		System.out.println("1게임 당 평균 도전 횟수 : " + ((double) cnt / (cntGames)));
	}
	
	int[] setAnswer() { // 3개의 랜덤 정수 배열 리턴(0~9)
		int[] answerArr = { 0, 0, 0 };
		for (int i = 0; i < answerArr.length; i++) {
			answerArr[i] = ((int) (Math.random() * 10));	//i번째 값에 랜덤숫자 저장
			for (int j = 0; j < answerArr.length; j++) {
				if (i == j)		//index i가 j와 같으면 비교 생략
					continue;
				while (answerArr[i] == answerArr[j]) {	//i번째 값과 j번째 값이 같으면
					answerArr[i] = ((int) (Math.random() * 10));	//i번째 값에 랜덤숫자 갱신
				}
			} // 중복 제거
		}

		return answerArr;
	}

	//길이가 3인 정수배열 2개( 사용자 입력값, 정답 )를 매개변수로 받음
	//길이가 3인 정수배열 ( 볼의 개수, 스트라이크의 개수, 아웃의 개수 ) 리턴 
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
