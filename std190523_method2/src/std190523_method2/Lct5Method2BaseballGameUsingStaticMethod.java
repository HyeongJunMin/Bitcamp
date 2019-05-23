package std190523_method2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lct5Method2BaseballGameUsingStaticMethod {
		// 야구게임 만들기
		// static 메소드로 바꾸기
	
	//테스트용 메소드
	static int[] returnIntarr(int argArrLen) {
		int arrLen = argArrLen;
		int[] a = new int[arrLen];
		
		for (int i = 0; i < argArrLen; i++) {
			a[i] = arrLen++;
		}				
		return a;
	}
	
	//입력받은 문자열의 첫 글자가 Y 또는 N인지 확인해서 맞으면 Y 또는 N을 반환하는 메소드
	static char isYOrN () {
		Scanner in = new Scanner(System.in);
		char continueConfirm = '1';
		do {
			System.out.print("계속 하시겠습니까? (Y/N)");

			continueConfirm = in.next().toUpperCase().charAt(0);

			if (continueConfirm == 'N') {
				
				break;
			} else if (continueConfirm == 'Y') {
				
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
		} while (continueConfirm != 'N' || continueConfirm != 'Y');
		
		return continueConfirm;
	}
	
	//문자열을 길이가 3인 정수 List로 변환해주는 메소드
	static List<Integer> toIntegerList(String str){
		List<Integer> integerText = new ArrayList<Integer>();
		
		//검사 반복문. str 문자열이 정수가 아니면 List값을 9로 초기화
		for(int i = 0 ; i < 3 ; i++ ) {
			if(str.charAt(i) < '0' || str.charAt(i) > '9' ) {
				integerText.clear();
				for(int j = 0 ; j < str.length() ; j++ ) {
					integerText.add(9);
				}
				break;
			}
			integerText.add((int)str.charAt(i)-48);
		}		
		
		return integerText;
	}
	
	//야구게임 정답 배열을 리턴하는 메소드
	static List<Integer> returnAnswerArr() {

		int w = 0;
		int rndNumber = 0 ;
		List<Integer> answerList = new ArrayList<>();
				
		while( w < 3) {
			rndNumber = (int)(Math.random()*10);
			if( answerList.contains(rndNumber) ) {	
			}else {	//rndNumber를 포함하고 있지 않으면?
				answerList.add(rndNumber);
				w++;
			}
		}			
		return answerList;
	}
	
	//사용자 입력값과 정답을 비교해서 B/S/O 배열을 리턴하는 메소드
	static List<Integer> returnBSO(List<Integer> userInputArr, List<Integer> answerArr){
		List<Integer> arrBSO = new ArrayList<>();
		int answerBall = 0 ;
		int answerStrike = 0 ;
		int answerOut = 0 ;
		
		for(int i = 0 ; i < 3 ; i++ ) {
			if( answerArr.get(i) == userInputArr.get(i) ) { //두 리스트의 i번째 값이 같으면?
				answerStrike++;//Strike +1
			} else if( answerArr.contains( userInputArr.get(i) )  ) {//위치만 다르고 갖고있으면?
				answerBall++;//Ball+1
			}
		}
		if(answerStrike == 3) {
			answerOut++;
		}
		
		arrBSO.add(answerBall);
		arrBSO.add(answerStrike);
		arrBSO.add(answerOut);
		
		return arrBSO;
	}

	//게임 반복 메소드
	static void runBasballGame() {
		Scanner in = new Scanner(System.in);
		int w = 0;
		int cnt = 0;
		char chc = 'Y';
		List<Integer> answer;
		List<Integer> userInputArr;
		List<Integer> resultArr;
		
		while ( chc == 'Y' ) {
			answer = returnAnswerArr();
			System.out.println("답  : " + answer.toString());
			while (w < 10) {
				System.out.println(w + 1 + " 번 째 시도.");
				System.out.print("값 입력 : ");
				userInputArr = toIntegerList(in.next());
				resultArr = returnBSO(userInputArr, answer);
				System.out.println("볼 : " + resultArr.get(0) + " 스 : " + resultArr.get(1) + " 아 : " + resultArr.get(2));
				if (resultArr.get(2) == 1) {
					System.out.println("정답!");
					break;
				} else {
					w++;
				}
				if (w == 10) {
					System.out.println("실패");
				}
			}
			
			chc = isYOrN();
			cnt++;
		}
		
		System.out.println("게임종료. 반복횟수:"+cnt);
		
		
	}
}