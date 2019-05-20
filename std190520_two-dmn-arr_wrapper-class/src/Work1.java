import java.util.*;
import java.math.*;

public class Work1 {
	//가위바위보 게임
	//몇승 몇패 표시
	//가위바위보 공식
	//가위=0, 바위=1, 보=2 일 때,
	//( 컴 - 유저 + 2 ) % 3 == 1   > 유저 승
	//( 컴 - 유저 + 2 ) % 3 == 0   > 컴 승
	//( 컴 - 유저 + 2 ) % 3 == 2   > 비김
	void play() {
		Scanner in = new Scanner(System.in);
		String[] choice = {"가위", "바위", "보","1","2"};
		
		int gameTimes = 0;
		int chc = 0;
		int cnt = 0;
		char userInput = '3'; 
		int userSelection = 3;
		int comSelection = 0;
		int same = 0, win = 0, lose = 0;
		double winRate = 0.0;
		char continueConfirm = '1';
		
		
		while( chc == 0) {
			System.out.println("가위 바위 보 게임을 시작합니다.");
			
			comSelection = (int)( Math.random()*3 );
			System.out.println("컴퓨터 : " + choice[comSelection]);
			
			do {
			System.out.println("가위, 바위, 보 에 해당하는 정수 1개를 입력하세요");
			System.out.print("가위(0), 바위(1), 보(2) : ");
			userInput = in.next().charAt(0);
			
			if( userInput < '0' || userInput > '2'  ) {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요. 입력값 : "+userInput);
			}
			}while( userInput < '0' || userInput > '2' );
			
			
			userSelection = Character.getNumericValue(userInput);
			
			if(userSelection == comSelection) {
				System.out.println("무승부 입니다! 비겼어요!");
				System.out.println("컴퓨터 : "+choice[comSelection]+"\t 유저 : "+choice[userSelection]);
				same++;
			} else if( ( comSelection == 0 && userSelection == 1 ) || 
					( comSelection == 1 && userSelection == 2 )  ||
					( comSelection == 2 && userSelection == 0 ) ) {
				System.out.println("이겼습니다! 이겼어요!");
				System.out.println("컴퓨터 : "+choice[comSelection]+"\t 유저 : "+choice[userSelection]);
				win++;
			} else {
				System.out.println("졌습니다! 졌어요!");
				System.out.println("컴퓨터 : "+choice[comSelection]+"\t 유저 : "+choice[userSelection]);
				lose++;
			}
			System.out.println("승 : " + win + " 패 : " + lose + " 무 : " + same);
			do {
				System.out.print("계속 하시겠습니까? (Y/N)");
				
				continueConfirm = in.next().toUpperCase().charAt(0);
				
				if( continueConfirm == 'N' ) {
					chc = 1;
					break;
				}else if(continueConfirm == 'Y') {
					break;
				}else {
					System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
				}
			}while( continueConfirm != 'N' || continueConfirm != 'Y' );
			cnt++;
		}
		System.out.println("프로그램을 종료합니다.");
		System.out.println("총 게임 횟수 : " + cnt);
		System.out.println("승 : " + win + " 패 : " + lose + " 무 : " + same);
		winRate = ( ( (double)win ) / cnt ) *100;
		System.out.println("승률 : " + winRate + "%");
	}
	
	void judgeGame(int userIn123, int comIn123) {
		int userIn112 = userIn123;
		int comIn112 = comIn123;
	}
}
