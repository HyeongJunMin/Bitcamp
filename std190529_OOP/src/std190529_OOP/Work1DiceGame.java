package std190529_OOP;

import java.util.Scanner;

public class Work1DiceGame {
	private char chcCnt = 'Y';
	private int userCoin = 0;
	private int betCoin = 0;
	private int dice1 = 0;
	private int dice2 = 0;
	private int diceSum = 0;
	private int userInput = 0;
	private int chance = 0;
	private static Scanner in = new Scanner(System.in);
	
	public void runDiceGame() {
		System.out.println("주사위 도박 시작");
		
		this.userCoin = 20;
		
		while( chcCnt == 'Y') {
			this.betCoin = 0;
			this.chance = 0;
			this.initDices();
			
			System.out.println(this.diceSum);
			
			this.inputUserValue();
			this.calculateChance();
			System.out.println("주사위1:" + this.dice1 + "   주사위2:"+this.dice2);
			
			if(userCoin < 1) {
				System.out.println("코인이 없습니다. 도박 종료.");
				break;
			}
			
			System.out.println("남은 코인 : " + userCoin);
			chcCnt = isYOrN();
		}
		
		
		in.close();
		System.out.println("게임을 종료합니다.");
	}
	
	//다이스 숫자 초기화
	private void initDices() {
		this.dice1 = (int)(Math.random()*6 +1);
		this.dice2 = (int)(Math.random()*6 +1);
		this.diceSum = this.dice1 + this.dice2;
		return;
	}
	
	//사용자 입력
	private void inputUserValue() {
		System.out.print("두 육면체 주사위의 합을 입력하세요(3~11) : ");
		this.userInput = 0;
		while( this.userInput < 3 || this.userInput > 11) {
			this.userInput = in.nextInt();		
		}
		
		System.out.print("베팅할 코인의 수를 입력하세요. 현재 코인 : " + userCoin);
		this.betCoin=0;
		while(true) {
			this.betCoin = in.nextInt();
			if(betCoin < 1) {
				System.out.println("1보다 큰 수를 입력해야 합니다.");
			} else if(betCoin > userCoin){
				System.out.println("보유 코인보다 많은 코인을 배팅할 수 없습니다.");
			} else if(betCoin >= 0 && betCoin <= userCoin) {
				break;
			}
		}
		System.out.println(betCoin);
		this.userCoin -= this.betCoin;
		
		
		return;
	}
	
	//배당금 배율 계산
	private void calculateChance() {
		if( userInput == diceSum ) {	//맞춘 경우
			switch( userInput ) {
				case 3: case 11: this.chance = 18; break;
				case 4: case 10: this.chance = 12; break;
				case 5: case 9: this.chance = 9; break;
				case 6: case 8: this.chance = 7; break;
				case 7: this.chance = 6; break;
			}
			this.userCoin += betCoin * this.chance;
			System.out.println("정답입니다! 배율:"+this.chance);
		}else { //틀린 경우
			System.out.println("꽝!");
		}
		return;
	}
	
	//주사위 정보 출력
	public void printDiceInfo() {
		System.out.println("주사위1 : " + dice1 + "   주사위2 : " + dice2);
		return;
	}

	//게임 지속 여부
	private char isYOrN() {
		char ch = 'Y';
		System.out.println("계속하시겠습니까? (Y/N)");
		
		for(int i = 0 ; i < 15 ; i++ ) {
			ch = in.next().toUpperCase().charAt(0);
			if(ch == 'Y' || ch == 'N')
				break;
		}		
		return ch;
	}
}
