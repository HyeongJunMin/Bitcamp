package blackjackGameCanSave;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackjackClient {
	private static Scanner in = new Scanner(System.in);
	private int[] deckList = new int[52];
	private int[] rndNum = new int[52];
	private String[] cardChar = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	private String[] cardMark = {"�����̵�", "���̾�", "��Ʈ", "Ŭ�ι�"};
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
	
	//����� ������ �޾ƿ��� ������
	public BlackjackClient(int userCoin, int cnt, int userWins) {
		this.userCoin = userCoin;
		this.cnt = cnt;
		this.userWins = userWins;
	}
	
	
	//���� ���� ���� �� ���� ��� ����
	public int[] runBlackjack() {
		
		this.startAndEnd();
		
//		in.close();
		int[] re = {this.userCoin, this.cnt, this.userWins}; 
		
		return re;
	}
	
	//���� ���� ����
	private void startAndEnd() {
		char checkRestart = 'Y';
		
		while( checkRestart == 'Y') {
			//�� �ʱ�ȭ(����)
			this.initDeck();
			//�� �ε��� �ʱ�ȭ(0���� ����)
			this.turn = 0;
			System.out.println(this.intro());
			
			
			this.doDraw();
			cnt++;
			
			//��� �Ұ��� �׸� �Ұ��� �÷��̾� ����
			checkRestart = this.isYOrN();
			//this.printDeck();
		}	
		System.out.println("���α׷��� �����մϴ�.");
	}
	
	//���þ�Ȯ��
	private void bet() {
		nowBet = 0;
		
		System.out.print("���þ� �Է�(1~" + this.userCoin + ") :");
		
		this.nowBet = this.inputUntilInteger();	
	}
	
	//����� ���� ���� ���
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
	
	
	//���Ӿȳ�
	private String intro() {
		return "���� ������ �����մϴ�. ī�尡 ���� ������ �� ���� 21�̸� �¸��մϴ�.\n2~9�� ���� �״���� ������ ����մϴ�. A�� ��쿡 ���� 1�Ǵ� 10���� ����� �� �ֽ��ϴ�.\nJ, Q, K�� ��� 10���Դϴ�.";
	}
	
	//���� ����
	private void doDraw() {
		int w = 0;
		userSelect = '1';
		char decisionOfPlayer = '1';
		this.bet();
		this.initializeEachDeck();

		while( decisionOfPlayer != 'E' ) {
			
			//�������� �����̸�? break;
			if( this.isBlackjack() > 0 ) {
				if(dealerBlackjack == 1)
					System.out.println("���� �����Դϴ�!");
				if(userBlackjack == 1)
					System.out.println("���� �����Դϴ�!");
				this.printEachDecks();
				if( dealerBlackjack > userBlackjack ) {
					System.out.println("���� �¸�! ���� �� �� : "+ ++dealerWins);
				} else if( userBlackjack > dealerBlackjack) {
					this.userWin();
				} else {
					System.out.println("���º�!  ���� �� : " + userWins);
				}
				break;
			}
			
			userSelect = this.playerTurn();
			if(this.userScore > 21) {
				dealerWins++;
				System.out.println("���� ����Ʈ! ���� ��! ���� ���ھ� : " + userScore + " ���� ���ھ� : " + dealerScore);
				break;
			}
			//�÷��̾� ��ο� ���� ���� ��ο�
			this.dealerTurn();
			if(this.dealerScore > 21) {
				userWins++;
				System.out.println("���� ����Ʈ! ���� ��! ���� ���ھ� : " + userScore + " ���� ���ھ� : " + dealerScore);
				break;
			}
			
			System.out.println("����? : " + this.isBlackjack());
			
			//�÷��̾ �����Ѵ�? �ݺ�����
			if( userSelect == 'E' ) {
//				while( dealerScore <= 21)
//					this.dealerTurn();
				this.scoreOfEachPlayer();
				System.out.println("�������� : " + dealerScore + "   �������� : " + userScore);
				
				if( dealerScore > 21 ) {
					this.userWin();
				}else if ( userScore > 21 ) {
					this.dealerWin();
				}else if ( dealerScore > userScore ) {
					this.dealerWin();
				}else if ( userScore > dealerScore){
					this.userWin();					
				}else {
					System.out.println("���º�!");
				}
				break;				
			}

			//������ ������ �ƴ� ��� ���� ��
			this.scoreOfEachPlayer();
			System.out.println("�������� : " + dealerScore + "   �������� : " + userScore);

//			this.printEachDecks();
		}		
		this.resultOfGame();
		System.out.println("���� �� : " + this.userWins + "  ���� ���� Ƚ�� : " + this.cnt);
	}
	
	//�� ���� ī�� �ʱⰪ ����
	private int initializeEachDeck() {
		deckDealer.clear();
		deckUser.clear();
		deckDealer.add( rndNum[turn++] );
		deckUser.add( rndNum[turn++] );
		deckDealer.add( rndNum[turn++] );
		deckUser.add( rndNum[turn++] );
		String dealerInfo = cardMark[ (deckDealer.get(0)-1)/13 ] + " " + cardChar[  (deckDealer.get(0)-1)%13  ] + "   " +cardMark[ (deckDealer.get(1)-1)/13 ] + " " + cardChar[  (deckDealer.get(1)-1)%13  ];
		System.out.println("������ ī�� : " + dealerInfo);
				
		String userInfo = cardMark[ (deckUser.get(0)-1)/13 ] + " " + cardChar[  (deckUser.get(0)-1)%13  ] + "   " +cardMark[ (deckUser.get(1)-1)/13 ] + " " + cardChar[  (deckUser.get(1)-1)%13  ];
		System.out.println("������ ī�� : " + userInfo);
		
		
		//�÷��̾� ���� ���� �ʱ�ȭ
		this.dealerAce = 0;
		this.userAce = 0;
		this.dealerBlackjack = 0;
		this.userBlackjack = 0;
		this.dealerScore = 0;
		this.userScore = 0;
		
		return 0;
	}
	
	//��� �÷��̾��� ī�� ���� print
	private void printEachDecks(){
		String dealerInfo = "";
		for(int i = 0 ; i < deckDealer.size(); i++ ) {
			dealerInfo += cardMark[ (deckDealer.get(i)-1)/13 ] + " " + cardChar[  (deckDealer.get(i)-1)%13  ] + "   ";
		}		
		System.out.println("������ ī�� : " + dealerInfo);
				
		String userInfo = "";
		for(int i = 0 ; i < deckUser.size(); i++ ) {
			userInfo += cardMark[ (deckUser.get(i)-1)/13 ] + " " + cardChar[  (deckUser.get(i)-1)%13  ] + "   ";
		}		
		System.out.println("������ ī�� : " + userInfo);
	}
	
	//������ ����(stay, hit)
	private void dealerTurn() {
		if(this.dealerScore < 17) {
			System.out.println("������ ���� ī�� : " + cardMark[ (rndNum[turn]-1)/13 ] + " " + cardChar[  (rndNum[turn]-1)%13  ] + "   ");
			this.deckDealer.add( rndNum[turn++] );
		}
		this.scoreOfEachPlayer();
	}
	
	
	//������� ����(stay, hit, surrender)
	private char playerTurn() {
		char choice = '1';
		
		while( choice != 'E' && choice != 'D' ) {
			System.out.println("ī�带 �� �̴´�(D), ī�带 ���� �ʴ´�(E)");
			choice = in.next().toUpperCase().charAt(0);
		}	
		if(choice == 'D') {
			System.out.println("������ ���� ī�� : " + cardMark[ (rndNum[turn]-1)/13 ] + " " + cardChar[  (rndNum[turn]-1)%13  ] + "   ");
			deckUser.add( rndNum[turn++] );
		}//ī�带 ������ 1�� ����
			
		this.scoreOfEachPlayer();
		
		return choice; 
	}
	
	//���� ī�尡 �������� �Ǵ�
	private int isBlackjack(){
		int dealerAceInBlack = 0;
		int userAceInBlack = 0;
		int dealerScoreInBlack = 0;
		int userScoreInBlack = 0;
		
		//������ ���� �������� �Ǵ�
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
		if( dealerAceInBlack > 0) {	//������ ���� ACE�� �����̶� �ִ� ���
			switch( dealerAceInBlack ) {
			case 1: if( (dealerScoreInBlack+1) == 21 || (dealerScoreInBlack+11) == 21 ) { this.dealerBlackjack = 1; }  break;
			case 2: if( (dealerScoreInBlack+2) == 21 || (dealerScoreInBlack+11+1) == 21 ) { this.dealerBlackjack = 1; }  break;
			case 3:	if( (dealerScoreInBlack+3) == 21 || (dealerScoreInBlack+11+1+1) == 21 ) { this.dealerBlackjack = 1; }  break;
			case 4:	if( (dealerScoreInBlack+4) == 21 || (dealerScoreInBlack+11+1+1+1) == 21 ) { this.dealerBlackjack = 1; }  break;
			default :
			}
		}else {	//������ ���� ACE�� �� �嵵 ���� ���
			if(dealerScoreInBlack == 21) {	//������ ���ھ 21�̸�? ����!
				this.dealerScore = 21;
				this.dealerBlackjack = 1;
			}
		}
		
		//������ ���� �������� �Ǵ�
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
		if( userAceInBlack > 0) {	//������ ���� ACE�� �����̶� �ִ� ���
			switch( userAceInBlack ) {
			case 1: if( (userScoreInBlack+1) == 21 || (userScoreInBlack+11) == 21 ) { this.userBlackjack = 1; }  break;
			case 2: if( (userScoreInBlack+2) == 21 || (userScoreInBlack+11+1) == 21 ) { this.userBlackjack = 1; }  break;
			case 3:	if( (userScoreInBlack+3) == 21 || (userScoreInBlack+11+1+1) == 21 ) { this.userBlackjack = 1; }  break;
			case 4:	if( (userScoreInBlack+4) == 21 || (userScoreInBlack+11+1+1+1) == 21 ) { this.userBlackjack = 1; }  break;
			default :
			}
		}else {	//������ ���� ACE�� �� �嵵 ���� ���
			if(userScoreInBlack == 21) {	//������ ���ھ 21�̸�? ����!
				this.userScore = 21;
				this.userBlackjack = 1;
			}
		}
		//������ ������ �ƴϸ�? 0����
		return ((dealerBlackjack+userBlackjack)>0) ? 1 : 0 ;
	}
	
	//���� �� ���� ���ھ� �Ǵ�. ���� 21�̸� ���� ����
	private int scoreOfEachPlayer() {
		int numOfBlackjack = 0;
		this.dealerScore = 0;
		this.dealerAce = 0;
		this.userScore = 0;
		this.userAce = 0;

		// ������ �� ���� ���
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
		if (dealerAce > 0) { // ������ ���� ACE�� �����̶� �ִ� ���
//			switch (dealerAce) {
//				case 1:		if ( (dealerScore + 1) == 21 || (dealerScore + 11) == 21 ) {	this.dealerBlackjack = 1;	}	
//				case 2:		if ( (dealerScore + 2) == 21 || (dealerScore + 11 + 1) == 21 ) {	this.dealerBlackjack = 1;	}	break;
//				case 3:		if ( (dealerScore + 3) == 21 || (dealerScore + 11 + 1 + 1) == 21 ) {	this.dealerBlackjack = 1;	}	break;
//				case 4:		if ( (dealerScore + 4) == 21 || (dealerScore + 11 + 1 + 1 + 1) == 21 ) {	this.dealerBlackjack = 1;	}	break;
//				default:	break;
//			}
			// { (Ace���� * 1) + (Ace���� * 11) + Ace���ܽ��ھ� }�� 21���� �۰� 21�� ���� ����� �����϶��� Ace�� ���� Set ��ȯ
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
			
			
		} else { // ������ ���� ACE�� �� �嵵 ���� ���
			if (dealerScore == 21) { // ������ ���ھ 21�̸�? ����!
				this.dealerBlackjack = 1;
			}
		}

		// ������ ���� �������� �Ǵ�
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
		if (userAce > 0) { // ������ ���� ACE�� �����̶� �ִ� ���
//			switch (userAce) {
//				case 1:		if ( (userScore + 1) == 21 || (userScore + 11) == 21 ) {	this.userBlackjack = 1;		}	break;
//				case 2:		if ( (userScore + 2) == 21 || (userScore + 11 + 1) == 21 ) {	this.userBlackjack = 1;		}		break;
//				case 3:		if ( (userScore + 3) == 21 || (userScore + 11 + 1 + 1) == 21 ) {	this.userBlackjack = 1;		}	break;
//				case 4:		if ( (userScore + 4) == 21 || (userScore + 11 + 1 + 1 + 1) == 21 ) {	this.userBlackjack = 1;		}	break;
//				default:	break;
//			}
//		} else { // ������ ���� ACE�� �� �嵵 ���� ���
//			if (userScore == 21) { // ������ ���ھ 21�̸�? ����!
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
	
	//���� �¸�
	private void dealerWin() {
		this.dealerWins++;
		System.out.println("���� ��! ���� ���� : " + this.userScore + " ���� ���� : " + this.dealerScore);
	}
	
	//���� �¸�
	private void userWin() {
		this.userWins++;
		System.out.println("���� ��! ���� ���� : " + this.userScore + " ���� ���� : " + this.dealerScore);
	}
	
	//�Է°��� Y���� N���� �Ǵ�
	private char isYOrN() {
		char ch = '1';
		
		while( ch != 'Y' && ch != 'N') {
			System.out.println("����Ͻðڽ��ϱ�?(Y/N)");
			ch = in.next().toUpperCase().charAt(0);
		}		
		return ch;
	}
		
	//������ ���� �� �ʱ�ȭ
	private void initDeck() {
		//1~9 �� 4����, 10�� �� 16�� == 52�� 
		boolean[] rndSwit = new boolean[52];
		
		int w = 0;
		int rndTemp = 0;
		while (w < 52) {
			rndTemp = (int) (Math.random() * 52);
			if (rndSwit[rndTemp] == false) { // �������� index�� ���� r_swit�� false�̸�
				rndSwit[rndTemp] = true; // r_swit[rndTemp]�� true ����
				rndNum[w] = rndTemp + 1; // r_num[�ݺ�]
				w++; // �ݺ����� +1
			}
		}
	}
	
	//���� �� ����Ʈ ���
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
	
	// �Է°��� �������� �˻�
	private int inputUntilInteger() {
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
	
}
