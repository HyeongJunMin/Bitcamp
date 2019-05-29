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
		System.out.println("�ֻ��� ���� ����");
		
		this.userCoin = 20;
		
		while( chcCnt == 'Y') {
			this.betCoin = 0;
			this.chance = 0;
			this.initDices();
			
			System.out.println(this.diceSum);
			
			this.inputUserValue();
			this.calculateChance();
			System.out.println("�ֻ���1:" + this.dice1 + "   �ֻ���2:"+this.dice2);
			
			if(userCoin < 1) {
				System.out.println("������ �����ϴ�. ���� ����.");
				break;
			}
			
			System.out.println("���� ���� : " + userCoin);
			chcCnt = isYOrN();
		}
		
		
		in.close();
		System.out.println("������ �����մϴ�.");
	}
	
	//���̽� ���� �ʱ�ȭ
	private void initDices() {
		this.dice1 = (int)(Math.random()*6 +1);
		this.dice2 = (int)(Math.random()*6 +1);
		this.diceSum = this.dice1 + this.dice2;
		return;
	}
	
	//����� �Է�
	private void inputUserValue() {
		System.out.print("�� ����ü �ֻ����� ���� �Է��ϼ���(3~11) : ");
		this.userInput = 0;
		while( this.userInput < 3 || this.userInput > 11) {
			this.userInput = in.nextInt();		
		}
		
		System.out.print("������ ������ ���� �Է��ϼ���. ���� ���� : " + userCoin);
		this.betCoin=0;
		while(true) {
			this.betCoin = in.nextInt();
			if(betCoin < 1) {
				System.out.println("1���� ū ���� �Է��ؾ� �մϴ�.");
			} else if(betCoin > userCoin){
				System.out.println("���� ���κ��� ���� ������ ������ �� �����ϴ�.");
			} else if(betCoin >= 0 && betCoin <= userCoin) {
				break;
			}
		}
		System.out.println(betCoin);
		this.userCoin -= this.betCoin;
		
		
		return;
	}
	
	//���� ���� ���
	private void calculateChance() {
		if( userInput == diceSum ) {	//���� ���
			switch( userInput ) {
				case 3: case 11: this.chance = 18; break;
				case 4: case 10: this.chance = 12; break;
				case 5: case 9: this.chance = 9; break;
				case 6: case 8: this.chance = 7; break;
				case 7: this.chance = 6; break;
			}
			this.userCoin += betCoin * this.chance;
			System.out.println("�����Դϴ�! ����:"+this.chance);
		}else { //Ʋ�� ���
			System.out.println("��!");
		}
		return;
	}
	
	//�ֻ��� ���� ���
	public void printDiceInfo() {
		System.out.println("�ֻ���1 : " + dice1 + "   �ֻ���2 : " + dice2);
		return;
	}

	//���� ���� ����
	private char isYOrN() {
		char ch = 'Y';
		System.out.println("����Ͻðڽ��ϱ�? (Y/N)");
		
		for(int i = 0 ; i < 15 ; i++ ) {
			ch = in.next().toUpperCase().charAt(0);
			if(ch == 'Y' || ch == 'N')
				break;
		}		
		return ch;
	}
}
