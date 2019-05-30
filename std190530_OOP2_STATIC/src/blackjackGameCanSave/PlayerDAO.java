package blackjackGameCanSave;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.StudentDto;

public class PlayerDAO {
	//���� ���� �о����(������)
	//���� ���� �����ϱ�(��������)
	//���� ���� ����ϱ�
	File playerData = new File("d:\\tmp\\BlackjackPlayerData.txt");
	List<Player> players;
	Scanner in = new Scanner(System.in);
	private int userIndex = 0;
	
	//���� ���� �о����(������)
	public PlayerDAO() {

		players = new ArrayList<>();
		
		this.syncDataFileToList();
	}
	
	//���� �޴� ����
	public void runGame() {
		char ch = 'Y';
		int selectMenu = 0;
		
		System.out.println("���� ���α׷��� �����մϴ�.");
		while( ch == 'Y' ) {
			System.out.println("�޴��� ������ �ּ���.");
			System.out.print("(1)���� ����\t(2)�÷��̾� ����\t(3)���� ����\t(4)���� ����");
			//���ӽ���, �÷��̾����� ���, ��������
			selectMenu = this.inputUntilInteger();
			
			switch( selectMenu ) {
				case 1: this.doGame(); break;
				case 2: this.printAllPlayer(); break;
				case 3: break;
				case 4: this.newAccount(); break;
				default : break;
			}
			if( selectMenu == 3 )
				break;
			System.out.println("����Ͻðڽ��ϱ�? (Y/N)");
			ch = isYOrN();
		}
		System.out.println("������ �����մϴ�.");
	}
	
	//���� ��й�ȣ �˻�
	private boolean login() {
		this.syncDataFileToList();
		this.userIndex = 0;
		boolean loginOK = false;
		String inputID;
		String inputPW;
		char loginAgain = 'Y';
		while( loginAgain == 'Y' ) {
			System.out.print("���̵� :");
			inputID = in.next();
			System.out.print("��й�ȣ :");
			inputPW = in.next();
					
			for(Player p : players) {
				if( p.getId().equals(inputID) ) {
					if( p.getPw().equals(inputPW) ) {
						System.out.println("�α��� ����!");
						loginOK = true;
						//�α��ο� �����ϸ� index�� �ش� �÷��̾��� No�� ����
						this.userIndex = p.getNum()-1;
						return true;
					}else {
						System.out.println("��й�ȣ�� Ʋ���ϴ�.");
						break;
					}
				}else {
					System.out.println("���̵� �����ϴ�.");
					break;
				}
			}
			System.out.print("�ٽ� �õ�(Y/N)");
			loginAgain = this.isYOrN();
		}		
		
		return loginOK;
	}
	
	//���� ����(Blackjack Client)
	private void doGame() {
		if( login() ) {
			BlackjackClient bjc = new BlackjackClient(players.get(userIndex).getDeposit(), players.get(userIndex).getCnt(), players.get(userIndex).getWins());
			int[] result = bjc.runBlackjack();
			players.get(userIndex).setDeposit(result[0]);
			players.get(userIndex).setCnt(result[1]);
			players.get(userIndex).setWins(result[2]);
			this.syncListToDataFile();
		}else {
			System.out.println("�α��ο� �����߽��ϴ�.");
			return;
		}
	}
	
	
	//���ο� ���� ����
	private void newAccount() {
		this.syncDataFileToList();
		
		System.out.println("���ο� ������ �����մϴ�.");
		
		char chcOK = '0';
		int num = 0;
		String id = "";
		String pw = "";
		String name = "";
		
		System.out.println("�л������� �Է��� �ּ��� : ");
		
		while(chcOK != 'Y') {
			num = this.players.size()+1;
			System.out.print("�̸� : ");
			name = in.next();
			System.out.print("ID : ");
			id = in.next();
			System.out.print("PW : ");
			pw = in.next();
						
			String strTemp ="�̸�: " + name + "\tID: " + id + "\tPW: " + pw ;
			System.out.println("�Է��Ͻ� ������ "+strTemp + "�Դϴ�.");
			System.out.print("������ Y, Ʋ���� N�� �Է��ϼ���.");
			chcOK = isYOrN();
		}	
		
		try {
			Player playerTemp = new Player(num, name, id, pw, 1000, 0, 0, 0.0);
			
			players.add(playerTemp);
			this.syncListToDataFile();
			System.out.println("�Է� �Ϸ�!");
		}catch(Exception e) {
			
		}		
		
		
		
	}
	
	//���� ���� ����ϱ�
	public void printAllPlayer() {
		this.syncDataFileToList();
		System.out.println("No\tID\tPW\tName\tDeposit\tCnt\tWins\tWinrate");
		double winrateTemp;
		for( Player s : this.players ) {
			winrateTemp = 0.0;
			if( s.getCnt() != 0  ) {
				winrateTemp = (Math.round( ( ( (double)s.getWins() ) / ((double)s.getCnt())  )*100.0   ) /100.0  );
//				System.out.println("!!!"+winrateTemp+ " no:" + s.getNum());
			}			
			System.out.println(s.getNum() + "\t" + s.getId() + "\t" + s.getPw()	+ "\t" + s.getName() + "\t" + 
					s.getDeposit() + "\t" + s.getCnt() + "\t" + s.getWins() + "\t" + winrateTemp + "\t");
		}
		
	}
	
	//���������� -> ����Ʈ ����ȭ
	public void syncDataFileToList() {
		this.players.clear();
		String strTemp = "";
		String[] strArr;
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(playerData));
			//public Player(int num, String id, String pw, String name, int deposit, int cnt, int wins, double winRate) {
			
			while( (strTemp = bf.readLine()) != null ) {
				if(strTemp.charAt(0) == 'N') {
					
				}else {
					strArr = strTemp.split("\t");
					players.add(new Player(	Integer.parseInt(strArr[0]),//num
											strArr[1],//id
											strArr[2],//pw
											strArr[3],//name
											Integer.parseInt(strArr[4]),//deposit
											Integer.parseInt(strArr[5]),//cnt
											Integer.parseInt(strArr[6]),//wins
											Double.parseDouble(strArr[7]) 
//											(  Math.round(( Integer.parseInt(strArr[5])/( Double.parseDouble(strArr[6])*10)  )    )  )*10.0//winRate
											//(Math.round(  (this.wins / (this.cnt*1.0) )*10 ))/10.0
							));
//					System.out.println(strTemp+"  ����->����Ʈ");
				}				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//����Ʈ -> ���������� ����ȭ
	public void syncListToDataFile() {
		try {
			FileWriter fileW = new FileWriter(playerData);

			// List students�� �ִ� ������ ���Ͽ� �������(���� ���)
			fileW.write("No\tID\tPW\tName\tDeposit\tCnt\tWins\tWinrate\n");
			
			double winrateTemp = 0.0;
			for (Player s : this.players) {
				
				winrateTemp = 0.0;
				if( s.getCnt() != 0  ) {
					winrateTemp = (Math.round( ( ( (double)s.getWins() ) / ((double)s.getCnt())  )*100.0   ) /100.0  );
//					System.out.println("!!!"+winrateTemp+ " no:" + s.getNum());
				}				
				fileW.write(s.getNum() + "\t" + s.getId() + "\t" + s.getPw()	+ "\t" + s.getName() + "\t" + 
						s.getDeposit() + "\t" + s.getCnt() + "\t" + s.getWins() + "\t" + (winrateTemp) + "\t\n");
//				System.out.println(s.toString() + "����Ʈ->���Ͽ��� ����Ʈ�� ����" + winrateTemp);
			}
			fileW.close();				
		} catch (Exception e) {
			System.out.println("���� ���� ����");
		}
	}
	
	//�Է°��� Y�Ǵ� N���� �˻�
	private char isYOrN() {
		char ch = '1';
		
		while( ch != 'Y' && ch != 'N') {
			ch = in.next().toUpperCase().charAt(0);
			
			if( ch != 'Y' && ch != 'N' ) {
				System.out.println("Y�Ǵ� N�� �Է��ϼ���.");
			}			
		}		
		return ch;
	}
		
	//�Է°��� �������� �˻�
	private int inputUntilInteger() {
		int num = 0;		

		boolean isNotInteger = true;
		
		while( isNotInteger ) {
		try {
			num = Integer.parseInt(in.next());
			isNotInteger = false;
		}catch (Exception e){
			System.out.println("������ �ƴմϴ�. ������ �Է��ϼ���.");
			isNotInteger = true;
		}
		}
		
		
		return num;
	}
}
