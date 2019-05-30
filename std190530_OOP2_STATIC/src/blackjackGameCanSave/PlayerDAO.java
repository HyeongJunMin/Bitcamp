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
	//파일 정보 읽어오기(생성자)
	//파일 정보 갱신하기(게임종료)
	//파일 정보 출력하기
	File playerData = new File("d:\\tmp\\BlackjackPlayerData.txt");
	List<Player> players;
	Scanner in = new Scanner(System.in);
	private int userIndex = 0;
	
	//파일 정보 읽어오기(생성자)
	public PlayerDAO() {

		players = new ArrayList<>();
		
		this.syncDataFileToList();
	}
	
	//게임 메뉴 선택
	public void runGame() {
		char ch = 'Y';
		int selectMenu = 0;
		
		System.out.println("블랙잭 프로그램을 시작합니다.");
		while( ch == 'Y' ) {
			System.out.println("메뉴를 선택해 주세요.");
			System.out.print("(1)게임 시작\t(2)플레이어 정보\t(3)게임 종료\t(4)계정 생성");
			//게임시작, 플레이어정보 출력, 게임종료
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
			System.out.println("계속하시겠습니까? (Y/N)");
			ch = isYOrN();
		}
		System.out.println("게임을 종료합니다.");
	}
	
	//계정 비밀번호 검사
	private boolean login() {
		this.syncDataFileToList();
		this.userIndex = 0;
		boolean loginOK = false;
		String inputID;
		String inputPW;
		char loginAgain = 'Y';
		while( loginAgain == 'Y' ) {
			System.out.print("아이디 :");
			inputID = in.next();
			System.out.print("비밀번호 :");
			inputPW = in.next();
					
			for(Player p : players) {
				if( p.getId().equals(inputID) ) {
					if( p.getPw().equals(inputPW) ) {
						System.out.println("로그인 성공!");
						loginOK = true;
						//로그인에 성공하면 index를 해당 플레이어의 No로 설정
						this.userIndex = p.getNum()-1;
						return true;
					}else {
						System.out.println("비밀번호가 틀립니다.");
						break;
					}
				}else {
					System.out.println("아이디가 없습니다.");
					break;
				}
			}
			System.out.print("다시 시도(Y/N)");
			loginAgain = this.isYOrN();
		}		
		
		return loginOK;
	}
	
	//게임 시작(Blackjack Client)
	private void doGame() {
		if( login() ) {
			BlackjackClient bjc = new BlackjackClient(players.get(userIndex).getDeposit(), players.get(userIndex).getCnt(), players.get(userIndex).getWins());
			int[] result = bjc.runBlackjack();
			players.get(userIndex).setDeposit(result[0]);
			players.get(userIndex).setCnt(result[1]);
			players.get(userIndex).setWins(result[2]);
			this.syncListToDataFile();
		}else {
			System.out.println("로그인에 실패했습니다.");
			return;
		}
	}
	
	
	//새로운 계정 생성
	private void newAccount() {
		this.syncDataFileToList();
		
		System.out.println("새로운 계정을 생성합니다.");
		
		char chcOK = '0';
		int num = 0;
		String id = "";
		String pw = "";
		String name = "";
		
		System.out.println("학생정보를 입력해 주세요 : ");
		
		while(chcOK != 'Y') {
			num = this.players.size()+1;
			System.out.print("이름 : ");
			name = in.next();
			System.out.print("ID : ");
			id = in.next();
			System.out.print("PW : ");
			pw = in.next();
						
			String strTemp ="이름: " + name + "\tID: " + id + "\tPW: " + pw ;
			System.out.println("입력하신 정보는 "+strTemp + "입니다.");
			System.out.print("맞으면 Y, 틀리면 N을 입력하세요.");
			chcOK = isYOrN();
		}	
		
		try {
			Player playerTemp = new Player(num, name, id, pw, 1000, 0, 0, 0.0);
			
			players.add(playerTemp);
			this.syncListToDataFile();
			System.out.println("입력 완료!");
		}catch(Exception e) {
			
		}		
		
		
		
	}
	
	//파일 정보 출력하기
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
	
	//데이터파일 -> 리스트 동기화
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
//					System.out.println(strTemp+"  파일->리스트");
				}				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//리스트 -> 데이터파일 동기화
	public void syncListToDataFile() {
		try {
			FileWriter fileW = new FileWriter(playerData);

			// List students에 있는 정보를 파일에 덧씌우기(파일 출력)
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
//				System.out.println(s.toString() + "리스트->파일에서 리스트의 정보" + winrateTemp);
			}
			fileW.close();				
		} catch (Exception e) {
			System.out.println("파일 갱신 실패");
		}
	}
	
	//입력값이 Y또는 N인지 검사
	private char isYOrN() {
		char ch = '1';
		
		while( ch != 'Y' && ch != 'N') {
			ch = in.next().toUpperCase().charAt(0);
			
			if( ch != 'Y' && ch != 'N' ) {
				System.out.println("Y또는 N을 입력하세요.");
			}			
		}		
		return ch;
	}
		
	//입력값이 정수인지 검사
	private int inputUntilInteger() {
		int num = 0;		

		boolean isNotInteger = true;
		
		while( isNotInteger ) {
		try {
			num = Integer.parseInt(in.next());
			isNotInteger = false;
		}catch (Exception e){
			System.out.println("정수가 아닙니다. 정수를 입력하세요.");
			isNotInteger = true;
		}
		}
		
		
		return num;
	}
}
