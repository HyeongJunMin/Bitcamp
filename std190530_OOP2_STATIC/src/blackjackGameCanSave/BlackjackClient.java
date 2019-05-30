package blackjackGameCanSave;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackjackClient {
	private static Scanner in = new Scanner(System.in);
	private int[] deckList = new int[52];
	private int[] rndNum = new int[52];
	private String[] cardChar = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	private String[] cardMark = {"스페이드", "다이아", "하트", "클로버"};
	private List<Integer> deckDealer = new ArrayList<>();
	private List<Integer> deckUser = new ArrayList<>();
	
	private int nowBet = 0;
	private int cnt = 0;
	private int userCoin = 0;
	private int turn = 0;
	private int dealerScore = 0;
	private int userScore = 0;
	private int dealerAce = 0;
	private int userAce = 0;
	private int dealerBlackjack = 0;
	private int userBlackjack = 0;
	private int dealerWins = 0;
	private int userWins = 0;
	private char userSelect = 'a';
	
	//사용자 정보를 받아오는 생성자
	public BlackjackClient(int userCoin, int cnt, int userWins) {
		this.userCoin = userCoin;
		this.cnt = cnt;
		this.userWins = userWins;
	}
	
	
	//블랙잭 게임 시작 및 게임 결과 리턴
	public int[] runBlackjack() {
		
		this.startAndEnd();
		
//		in.close();
		int[] re = {this.userCoin, this.cnt, this.userWins}; 
		
		return re;
	}
	
	//블랙잭 게임 진행
	private void startAndEnd() {
		char checkRestart = 'Y';
		
		while( checkRestart == 'Y') {
			//덱 초기화(셔플)
			this.initDeck();
			//덱 인덱스 초기화(0부터 시작)
			this.turn = 0;
			System.out.println(this.intro());
			
			
			this.doDraw();
			cnt++;
			
			//계속 할건지 그만 할건지 플레이어 선택
			checkRestart = this.isYOrN();
			//this.printDeck();
		}	
		System.out.println("프로그램을 종료합니다.");
	}
	
	//베팅액확인
	private void bet() {
		nowBet = 0;
		
		System.out.print("배팅액 입력(1~" + this.userCoin + ") :");
		
		this.nowBet = this.inputUntilInteger();	
	}
	
	//결과에 따른 코인 계산
	private void resultOfGame() {
		if( dealerBlackjack < userBlackjack ) {
			this.userCoin += this.nowBet*1.5;
		}else if( dealerBlackjack > userBlackjack ) {
			this.userCoin -= this.nowBet;
		}else if( userScore <= 21 && userScore > dealerScore && dealerScore <=21 ) {
			this.userCoin += this.nowBet;
		}else if( dealerScore > 21 && userScore <= 21 ){
			this.userCoin += this.nowBet;
		}else {
			this.userCoin -= this.nowBet;
		}
	}
	
	
	//게임안내
	private String intro() {
		return "블랙잭 게임을 시작합니다. 카드가 가진 숫자의 총 합이 21이면 승리합니다.\n2~9는 숫자 그대로의 값으로 계산합니다. A는 경우에 따라 1또는 10으로 계산할 수 있습니다.\nJ, Q, K는 모두 10점입니다.";
	}
	
	//게임 진행
	private void doDraw() {
		int w = 0;
		userSelect = '1';
		char decisionOfPlayer = '1';
		this.bet();
		this.initializeEachDeck();

		while( decisionOfPlayer != 'E' ) {
			
			//누군가가 블랙잭이면? break;
			if( this.isBlackjack() > 0 ) {
				if(dealerBlackjack == 1)
					System.out.println("딜러 블랙잭입니다!");
				if(userBlackjack == 1)
					System.out.println("유저 블랙잭입니다!");
				this.printEachDecks();
				if( dealerBlackjack > userBlackjack ) {
					System.out.println("딜러 승리! 딜러 승 수 : "+ ++dealerWins);
				} else if( userBlackjack > dealerBlackjack) {
					this.userWin();
				} else {
					System.out.println("무승부!  유저 승 : " + userWins);
				}
				break;
			}
			
			userSelect = this.playerTurn();
			if(this.userScore > 21) {
				dealerWins++;
				System.out.println("유저 버스트! 딜러 승! 유저 스코어 : " + userScore + " 딜러 스코어 : " + dealerScore);
				break;
			}
			//플레이어 드로우 이후 딜러 드로우
			this.dealerTurn();
			if(this.dealerScore > 21) {
				userWins++;
				System.out.println("딜러 버스트! 유저 승! 유저 스코어 : " + userScore + " 딜러 스코어 : " + dealerScore);
				break;
			}
			
			System.out.println("블랙잭? : " + this.isBlackjack());
			
			//플레이어가 포기한다? 반복종료
			if( userSelect == 'E' ) {
//				while( dealerScore <= 21)
//					this.dealerTurn();
				this.scoreOfEachPlayer();
				System.out.println("딜러점수 : " + dealerScore + "   유저점수 : " + userScore);
				
				if( dealerScore > 21 ) {
					this.userWin();
				}else if ( userScore > 21 ) {
					this.dealerWin();
				}else if ( dealerScore > userScore ) {
					this.dealerWin();
				}else if ( userScore > dealerScore){
					this.userWin();					
				}else {
					System.out.println("무승부!");
				}
				break;				
			}

			//누구도 블랙잭이 아닌 경우 점수 비교
			this.scoreOfEachPlayer();
			System.out.println("딜러점수 : " + dealerScore + "   유저점수 : " + userScore);

//			this.printEachDecks();
		}		
		this.resultOfGame();
		System.out.println("유저 승 : " + this.userWins + "  누적 게임 횟수 : " + this.cnt);
	}
	
	//두 장의 카드 초기값 결정
	private int initializeEachDeck() {
		deckDealer.clear();
		deckUser.clear();
		deckDealer.add( rndNum[turn++] );
		deckUser.add( rndNum[turn++] );
		deckDealer.add( rndNum[turn++] );
		deckUser.add( rndNum[turn++] );
		String dealerInfo = cardMark[ (deckDealer.get(0)-1)/13 ] + " " + cardChar[  (deckDealer.get(0)-1)%13  ] + "   " +cardMark[ (deckDealer.get(1)-1)/13 ] + " " + cardChar[  (deckDealer.get(1)-1)%13  ];
		System.out.println("딜러의 카드 : " + dealerInfo);
				
		String userInfo = cardMark[ (deckUser.get(0)-1)/13 ] + " " + cardChar[  (deckUser.get(0)-1)%13  ] + "   " +cardMark[ (deckUser.get(1)-1)/13 ] + " " + cardChar[  (deckUser.get(1)-1)%13  ];
		System.out.println("유저의 카드 : " + userInfo);
		
		
		//플레이어 점수 정보 초기화
		this.dealerAce = 0;
		this.userAce = 0;
		this.dealerBlackjack = 0;
		this.userBlackjack = 0;
		this.dealerScore = 0;
		this.userScore = 0;
		
		return 0;
	}
	
	//모든 플레이어의 카드 정보 print
	private void printEachDecks(){
		String dealerInfo = "";
		for(int i = 0 ; i < deckDealer.size(); i++ ) {
			dealerInfo += cardMark[ (deckDealer.get(i)-1)/13 ] + " " + cardChar[  (deckDealer.get(i)-1)%13  ] + "   ";
		}		
		System.out.println("딜러의 카드 : " + dealerInfo);
				
		String userInfo = "";
		for(int i = 0 ; i < deckUser.size(); i++ ) {
			userInfo += cardMark[ (deckUser.get(i)-1)/13 ] + " " + cardChar[  (deckUser.get(i)-1)%13  ] + "   ";
		}		
		System.out.println("유저의 카드 : " + userInfo);
	}
	
	//딜러의 결정(stay, hit)
	private void dealerTurn() {
		if(this.dealerScore < 17) {
			System.out.println("딜러가 뽑은 카드 : " + cardMark[ (rndNum[turn]-1)/13 ] + " " + cardChar[  (rndNum[turn]-1)%13  ] + "   ");
			this.deckDealer.add( rndNum[turn++] );
		}
		this.scoreOfEachPlayer();
	}
	
	
	//사용자의 결정(stay, hit, surrender)
	private char playerTurn() {
		char choice = '1';
		
		while( choice != 'E' && choice != 'D' ) {
			System.out.println("카드를 더 뽑는다(D), 카드를 뽑지 않는다(E)");
			choice = in.next().toUpperCase().charAt(0);
		}	
		if(choice == 'D') {
			System.out.println("유저가 뽑은 카드 : " + cardMark[ (rndNum[turn]-1)/13 ] + " " + cardChar[  (rndNum[turn]-1)%13  ] + "   ");
			deckUser.add( rndNum[turn++] );
		}//카드를 뽑으면 1턴 증가
			
		this.scoreOfEachPlayer();
		
		return choice; 
	}
	
	//현재 카드가 블랙잭인지 판단
	private int isBlackjack(){
		int dealerAceInBlack = 0;
		int userAceInBlack = 0;
		int dealerScoreInBlack = 0;
		int userScoreInBlack = 0;
		
		//딜러의 덱이 블랙잭인지 판단
		for(int i = 0; i < deckDealer.size() ; i++ ) {
			switch(  cardChar[  (deckDealer.get(i)-1)%13  ]  ) {
			case "A":	
				dealerAceInBlack++; break;
				
			case "2":	case "3":	case "4":	case "5":	case "6":	case "7":	case "8":	case "9":	
				dealerScoreInBlack += Integer.parseInt(  cardChar[  (deckDealer.get(i)-1)%13  ]  ); break;
				
			case "10":	case "J":		case "Q":		case "K":	
				dealerScoreInBlack += 10 ; break;
				
			default : 	break;
			}
		}
		if( dealerAceInBlack > 0) {	//딜러의 덱에 ACE가 한장이라도 있는 경우
			switch( dealerAceInBlack ) {
			case 1: if( (dealerScoreInBlack+1) == 21 || (dealerScoreInBlack+11) == 21 ) { this.dealerBlackjack = 1; }  break;
			case 2: if( (dealerScoreInBlack+2) == 21 || (dealerScoreInBlack+11+1) == 21 ) { this.dealerBlackjack = 1; }  break;
			case 3:	if( (dealerScoreInBlack+3) == 21 || (dealerScoreInBlack+11+1+1) == 21 ) { this.dealerBlackjack = 1; }  break;
			case 4:	if( (dealerScoreInBlack+4) == 21 || (dealerScoreInBlack+11+1+1+1) == 21 ) { this.dealerBlackjack = 1; }  break;
			default :
			}
		}else {	//딜러의 덱에 ACE가 한 장도 없는 경우
			if(dealerScoreInBlack == 21) {	//딜러의 스코어가 21이면? 블랙잭!
				this.dealerScore = 21;
				this.dealerBlackjack = 1;
			}
		}
		
		//유저의 덱이 블랙잭인지 판단
		for(int i = 0; i < deckUser.size() ; i++ ) {
			switch(  cardChar[  (deckUser.get(i)-1)%13  ]  ) {
			case "A":	
				userAceInBlack++; break;
				
			case "2":	case "3":	case "4":	case "5":	case "6":	case "7":	case "8":	case "9":	
				userScoreInBlack += Integer.parseInt(  cardChar[  (deckUser.get(i)-1)%13  ]  ); break;
				
			case "10":	case "J":		case "Q":		case "K":	
				userScoreInBlack += 10 ; break;
				
			default : 	break;
			}
		}
		if( userAceInBlack > 0) {	//유저의 덱에 ACE가 한장이라도 있는 경우
			switch( userAceInBlack ) {
			case 1: if( (userScoreInBlack+1) == 21 || (userScoreInBlack+11) == 21 ) { this.userBlackjack = 1; }  break;
			case 2: if( (userScoreInBlack+2) == 21 || (userScoreInBlack+11+1) == 21 ) { this.userBlackjack = 1; }  break;
			case 3:	if( (userScoreInBlack+3) == 21 || (userScoreInBlack+11+1+1) == 21 ) { this.userBlackjack = 1; }  break;
			case 4:	if( (userScoreInBlack+4) == 21 || (userScoreInBlack+11+1+1+1) == 21 ) { this.userBlackjack = 1; }  break;
			default :
			}
		}else {	//유저의 덱에 ACE가 한 장도 없는 경우
			if(userScoreInBlack == 21) {	//딜러의 스코어가 21이면? 블랙잭!
				this.userScore = 21;
				this.userBlackjack = 1;
			}
		}
		//누구도 블랙잭이 아니면? 0리턴
		return ((dealerBlackjack+userBlackjack)>0) ? 1 : 0 ;
	}
	
	//현재 각 덱의 스코어 판단. 값이 21이면 블랙잭 리턴
	private int scoreOfEachPlayer() {
		int numOfBlackjack = 0;
		this.dealerScore = 0;
		this.dealerAce = 0;
		this.userScore = 0;
		this.userAce = 0;

		// 딜러의 덱 점수 계산
		for (int i = 0; i < deckDealer.size(); i++) {
			switch (cardChar[(deckDealer.get(i) - 1) % 13]) {
				case "A":	dealerAce++;	break;
				case "2":	case "3":	case "4":	case "5":	case "6":	case "7":	case "8":	case "9":
					dealerScore += Integer.parseInt(cardChar[(deckDealer.get(i) - 1) % 13]);		break;
				case "10":	case "J":	case "Q":	case "K":
					dealerScore += 10;	break;
				default:	break;
			}
		}
		if (dealerAce > 0) { // 딜러의 덱에 ACE가 한장이라도 있는 경우
//			switch (dealerAce) {
//				case 1:		if ( (dealerScore + 1) == 21 || (dealerScore + 11) == 21 ) {	this.dealerBlackjack = 1;	}	
//				case 2:		if ( (dealerScore + 2) == 21 || (dealerScore + 11 + 1) == 21 ) {	this.dealerBlackjack = 1;	}	break;
//				case 3:		if ( (dealerScore + 3) == 21 || (dealerScore + 11 + 1 + 1) == 21 ) {	this.dealerBlackjack = 1;	}	break;
//				case 4:		if ( (dealerScore + 4) == 21 || (dealerScore + 11 + 1 + 1 + 1) == 21 ) {	this.dealerBlackjack = 1;	}	break;
//				default:	break;
//			}
			// { (Ace개수 * 1) + (Ace개수 * 11) + Ace제외스코어 }가 21보다 작고 21과 가장 가까운 점수일때의 Ace의 개수 Set 반환
			int temp = 0;
			int temp2 = dealerAce*1 + dealerScore;
			for(int i = 1 ; i <= dealerAce ; i++ ) {
				temp =  ( (1 * i) + (11 * (dealerAce - i)) ) + dealerScore;
				if( temp == 21) {
					dealerBlackjack = 1;
					dealerScore = 21;
					break;
				}else if ( temp < 21 ) {
					if( temp > temp2) {
						temp2 = temp;
					}
				}
			}
			dealerScore = temp2;
			
			
		} else { // 딜러의 덱에 ACE가 한 장도 없는 경우
			if (dealerScore == 21) { // 딜러의 스코어가 21이면? 블랙잭!
				this.dealerBlackjack = 1;
			}
		}

		// 유저의 덱이 블랙잭인지 판단
		for (int i = 0; i < deckUser.size(); i++) {
			switch (cardChar[(deckUser.get(i) - 1) % 13]) {
				case "A":	userAce++;	break;
				case "2":	case "3":	case "4":	case "5":	case "6":	case "7":	case "8":	case "9":
					userScore += Integer.parseInt(cardChar[(deckUser.get(i) - 1) % 13]);		break;
					
				case "10":	case "J":	case "Q":	case "K":
					userScore += 10;			break;
				default:	break;
			}
		}
		if (userAce > 0) { // 유저의 덱에 ACE가 한장이라도 있는 경우
//			switch (userAce) {
//				case 1:		if ( (userScore + 1) == 21 || (userScore + 11) == 21 ) {	this.userBlackjack = 1;		}	break;
//				case 2:		if ( (userScore + 2) == 21 || (userScore + 11 + 1) == 21 ) {	this.userBlackjack = 1;		}		break;
//				case 3:		if ( (userScore + 3) == 21 || (userScore + 11 + 1 + 1) == 21 ) {	this.userBlackjack = 1;		}	break;
//				case 4:		if ( (userScore + 4) == 21 || (userScore + 11 + 1 + 1 + 1) == 21 ) {	this.userBlackjack = 1;		}	break;
//				default:	break;
//			}
//		} else { // 유저의 덱에 ACE가 한 장도 없는 경우
//			if (userScore == 21) { // 딜러의 스코어가 21이면? 블랙잭!
//				this.userBlackjack = 1;
//			}
			int temp = 0;
			int temp2 = userAce*1 + userScore;
			for(int i = 1 ; i <= userAce ; i++ ) {
				temp =  ( (1 * i) + (11 * (userAce - i)) ) + userScore;
				if( temp == 21) {
					userBlackjack = 1;
					userScore = 21;
					break;
				}else if ( temp < 21 ) {
					if( temp > temp2) {
						temp2 = temp;
					}
				}
			}
			userScore = temp2;
		}

		return numOfBlackjack;
	}
	
	//딜러 승리
	private void dealerWin() {
		this.dealerWins++;
		System.out.println("딜러 승! 유저 점수 : " + this.userScore + " 딜러 점수 : " + this.dealerScore);
	}
	
	//유저 승리
	private void userWin() {
		this.userWins++;
		System.out.println("유저 승! 유저 점수 : " + this.userScore + " 딜러 점수 : " + this.dealerScore);
	}
	
	//입력값이 Y인지 N인지 판단
	private char isYOrN() {
		char ch = '1';
		
		while( ch != 'Y' && ch != 'N') {
			System.out.println("계속하시겠습니까?(Y/N)");
			ch = in.next().toUpperCase().charAt(0);
		}		
		return ch;
	}
		
	//셔플을 통한 덱 초기화
	private void initDeck() {
		//1~9 각 4개씩, 10은 총 16개 == 52개 
		boolean[] rndSwit = new boolean[52];
		
		int w = 0;
		int rndTemp = 0;
		while (w < 52) {
			rndTemp = (int) (Math.random() * 52);
			if (rndSwit[rndTemp] == false) { // 랜덤값을 index로 갖는 r_swit가 false이면
				rndSwit[rndTemp] = true; // r_swit[rndTemp]에 true 저장
				rndNum[w] = rndTemp + 1; // r_num[반복]
				w++; // 반복변수 +1
			}
		}
	}
	
	//현재 덱 리스트 출력
	private void printDeck() {
		int charNum = 0;
		int markNum = 0;
		for(int i = 0 ; i < 52 ; i++ ) {
			charNum = (rndNum[i]-1)%13 ;
			markNum = ( (rndNum[i]-1)/13 );
//			System.out.printf("%d\t%d\n",charNum, markNum);
			System.out.printf("%d\t%s\t%s\t\n", i+1, cardChar[charNum], cardMark[markNum]);
		}
	}
	
	// 입력값이 정수인지 검사
	private int inputUntilInteger() {
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
	
}
