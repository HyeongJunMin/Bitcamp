package baseballTeamUsingMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TeamDAO {
	List<HumanDTO> team;
	Scanner in;
	File teamData;
	
	public TeamDAO() {
		team = new ArrayList<>();
		in = new Scanner(System.in);
		teamData = new File("D:\\tmp\\baseballteam.txt");
		this.syncFileToList();
		
		this.runSystem();
		
		this.syncListToFile();
	}
	
	//선수정보 시스템 메뉴 출력 및 반복
	public void runSystem() {
		char ch = 'Y';
		int selectMenu = 0;
		
		System.out.println("선수정보관리 시스템을 시작합니다.");
		while( ch == 'Y' ) {
			System.out.println("메뉴를 선택해 주세요.");
			System.out.print("(1)선수추가\t(2)선수삭제\t(3)선수검색\n(4)선수정보수정\t(5)모든선수정보출력\t(6)데이터저장\t(7)정렬");
			//선수추가, 선수삭제, 선수검색, 선수수정, 모두출력, 데이터저장
			selectMenu = this.inputUntilInteger();
			
			switch( selectMenu ) {
				case 1: this.insert(); break;
				case 2: this.deletePlayer(); break;
				case 3: this.selectByNum(); break;
				case 4: this.updatePlayerInfo(); break;
				case 5: this.printAllTeammates(); break;
				case 6: this.saveData(); break;
				case 7: this.printAndSort(); break;
				default : break;
			}
			
			System.out.println("\n계속하시겠습니까? (Y/N)");
			ch = isYOrN();
		}		
	}
	
	//삽입(insert) : 선수정보 추가
	public void insert() {
		char chcOK = '0';
		int number = 0;
		String name = "";
		int age = 0;
		double height = 0;
		int winOrSwing = 0;
		int loseOrHit = 0;
		double dfcOrHitRate = 0.0;
		boolean isPitcher = false;
		
		System.out.print("(1)투수, (2)타자 : ");
		number = this.inputUntilInteger();
		
		if(number == 1) {	//투수
			System.out.println("투수정보를 입력해 주세요 : ");
			
			while(chcOK != 'Y') {
				System.out.print("이름 : ");
				name = in.next();
				System.out.print("나이 : ");
				age = this.inputUntilInteger();
				System.out.print("신장 : ");
				height = this.inputUntilDouble();
				System.out.print("승리 : ");
				winOrSwing = this.inputUntilInteger();
				System.out.print("패배 : ");
				loseOrHit = this.inputUntilInteger();
				String strTemp = "이름:" + name + " 나이:" + age + " 신장:" + height + " 승리:" + winOrSwing + " 패배:" + loseOrHit;
				System.out.println("입력하신 정보는 "+strTemp + "입니다.");
				System.out.print("맞으면 Y, 틀리면 N을 입력하세요.");
				chcOK = isYOrN();
			}
			
			int numOfMember = team.size() + 1;
			dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)winOrSwing)/loseOrHit;
			System.out.println("입력 완료!");
			PitcherDTO dto = new PitcherDTO(numOfMember, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate);
			team.add(dto);			
			
		}else {	//타자
			System.out.println("타자정보를 입력해 주세요 : ");			
			
			while(chcOK != 'Y') {
				System.out.print("이름 : ");
				name = in.next();
				System.out.print("나이 : ");
				age = this.inputUntilInteger();
				System.out.print("신장 : ");
				height = this.inputUntilDouble();
				System.out.print("타석 : ");
				winOrSwing = this.inputUntilInteger();
				System.out.print("유효타 : ");
				loseOrHit = this.inputUntilInteger();
				String strTemp = "이름:" + name + " 나이:" + age + " 신장:" + height + " 타석:" + winOrSwing + " 유효타:" + loseOrHit;
				System.out.println("입력하신 정보는 "+strTemp + "입니다.");
				System.out.print("맞으면 Y, 틀리면 N을 입력하세요.");
				chcOK = isYOrN();
			}
			
			int numOfMember = team.size() + 1;
			dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)winOrSwing)/loseOrHit;
			System.out.println("입력 완료!");
			BatterDTO dto = new BatterDTO(numOfMember, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate);
			team.add(dto);			
		}
		
		this.syncListToFile();
		
	}
	
	//삭제(delete)
	public void deletePlayer() {
		int stdNum = 0;
		char ch = 'N';
		int count = this.team.size();

		System.out.println("번호\t이름");
		for (int i = 0; i < count; i++) {
			System.out.println(team.get(i).getNum() + "\t" + team.get(i).getName());
		}
		System.out.println(count + "명의 선수 중 삭제할 선수의 번호를 입력하세요 : ");
		
		stdNum = inputUntilInteger();

		while (ch == 'N') {
			System.out.println("입력하신 번호 " + stdNum + "의 정보를 삭제하시겠습니까? (Y/N)");
			ch = isYOrN();
		}
		//학번에 해당하는 정보 ArrayList에서 삭제
		for (int i = 0; i < count; i++) {
			if( team.get(i).getNum() == stdNum ) {
				team.remove(i);
				break;
			}
		}		
		//삭제가 완료되었다면?
		if (count > this.team.size()) {
			this.syncListToFile();
			System.out.println("선수 삭제 성공!");
		}
	}
	
	
	//검색(select)
	public void selectByNum() {
		char ch = 'N';
		int num = 0;
		int i = 0;
		boolean has = false;
		String str="";
		double dfcOrHitRate;
		
		System.out.print("선수정보 검색을 시작합니다. 정보를 조회할 선수의 번호를 입력하세요 : ");
		
		while ( ch == 'N' ) {
			num = inputUntilInteger();
			System.out.println("번호는 " + num + "입니다. 맞으면 Y, 틀리면 N을 입력하세요.");
			ch = isYOrN();
		}
		//입력받은 선수와 일치하는 선수가 있는지 검사
		for (i = 0; i < this.team.size(); i++) {
			if( team.get(i).getNum() == num ) {
				has = true;
				break;
			}
		}
		if( has ) {
			if(  team.get(i) instanceof PitcherDTO   ) {	//투수이면?
				System.out.print("선수번호\t구분\t이름\t나이\t신장\t승\t패\t승률\n");
				PitcherDTO pdt = (PitcherDTO)team.get(i);
				dfcOrHitRate = ((pdt.getWin() + pdt.getLose()) == 0) ? 0.0 : ((double) pdt.getWin()) / (pdt.getWin() + pdt.getLose());
				dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
				str = i+1 + "\t투수\t" + pdt.getName() + "\t" + pdt.getAge() + "\t" + pdt.getHeight() + "\t" + pdt.getWin() + "\t" + pdt.getLose() + "\t" + dfcOrHitRate;
				System.out.println(str);
			}else {	//타자이면?
				System.out.print("선수번호\t구분\t이름\t나이\t신장\t타석\t유효타\t타율\n");
				BatterDTO pdt = (BatterDTO)team.get(i);
				dfcOrHitRate = ((pdt.getSwing() + pdt.getHit()) == 0) ? 0.0 : ((double) pdt.getHit()) / pdt.getSwing();
				dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
				str = i+1 + "\t타자\t" + pdt.getName() + "\t" + pdt.getAge() + "\t" + pdt.getHeight() + "\t" + pdt.getSwing() + "\t" + pdt.getHit() + "\t" + dfcOrHitRate;
				System.out.println(str);
			}		
		}else {
			System.out.println("번호 " + num + " 을 찾을 수 없습니다.");
		}
		System.out.println("선수정보 검색을 종료합니다.");
	}
	
	//수정(update)
	public void updatePlayerInfo() {
		char chcOK = '0';
		int number = 0;
		String name = "";
		int age = 0;
		double height = 0;
		int winOrSwing = 0;
		int loseOrHit = 0;
		double dfcOrHitRate = 0.0;
		boolean isPitcher = false;
		int num = 0;
		int i = 0;
		boolean has = false;
		
		char ch = 'N';
		System.out.println("선수정보를 수정합니다. 수정할 선수의 번호를 입력하세요.");
		while ( ch == 'N' ) {
			num = inputUntilInteger();
			System.out.println("입력한 번호는 " + num + "입니다. 맞으면 Y, 틀리면 N을 입력하세요.");
			ch = isYOrN();
		}
		//입력받은 번호과 일치하는 선수가 있는지 검사
		for (i = 0; i < this.team.size(); i++) {
			if( team.get(i).getNum() == num ) {
				has = true;
				break;
			}
		}
		
		if( has ) {
			if( team.get(i) instanceof PitcherDTO ) {	//투수
				System.out.println("투수정보를 입력해 주세요 : ");
				
				while(chcOK != 'Y') {
					System.out.print("이름 : ");
					name = in.next();
					System.out.print("나이 : ");
					age = this.inputUntilInteger();
					System.out.print("신장 : ");
					height = this.inputUntilDouble();
					System.out.print("승리 : ");
					winOrSwing = this.inputUntilInteger();
					System.out.print("패배 : ");
					loseOrHit = this.inputUntilInteger();
					String strTemp = "이름:" + name + " 나이:" + age + " 신장:" + height + " 승리:" + winOrSwing + " 패배:" + loseOrHit;
					System.out.println("입력하신 정보는 "+strTemp + "입니다.");
					System.out.print("맞으면 Y, 틀리면 N을 입력하세요.");
					chcOK = isYOrN();
				}
				
				dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)winOrSwing)/loseOrHit;
				System.out.println("수정 완료!");
				team.set(i, new PitcherDTO(i+1, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate));
								
			}else {	//타자
				System.out.println("타자정보를 입력해 주세요 : ");			
				
				while(chcOK != 'Y') {
					System.out.print("이름 : ");
					name = in.next();
					System.out.print("나이 : ");
					age = this.inputUntilInteger();
					System.out.print("신장 : ");
					height = this.inputUntilDouble();
					System.out.print("타석 : ");
					winOrSwing = this.inputUntilInteger();
					System.out.print("유효타 : ");
					loseOrHit = this.inputUntilInteger();
					String strTemp = "이름:" + name + " 나이:" + age + " 신장:" + height + " 타석:" + winOrSwing + " 유효타:" + loseOrHit;
					System.out.println("입력하신 정보는 "+strTemp + "입니다.");
					System.out.print("맞으면 Y, 틀리면 N을 입력하세요.");
					chcOK = isYOrN();
				}
				dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)winOrSwing)/loseOrHit;
				System.out.println("수정 완료!");
				team.set(i, new BatterDTO(i+1, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate));
			}
			this.syncListToFile();
		}else {
			System.out.println("입력한 번호에 해당하는 선수를 찾을 수 없습니다.");
		}
	}
	

	//출력(printall)
	public void printAllTeammates() {
		System.out.println("\n모든 선수정보를 출력합니다.");
		System.out.print("선수번호\t구분\t이름\t나이\t신장\t승\t패\t승률\t타석\t유효타\t타율");
		int number = 0;
		String name = "";
		int age = 0;
		double height = 0;
		int winOrSwing = 0;
		int loseOrHit = 0;
		double dfcOrHitRate = 0.0;
		PitcherDTO ptc;
		BatterDTO btt;

		for (int i = 0; i < team.size(); i++) {
			if (team.get(i) instanceof PitcherDTO) { // 투수인 경우
				ptc = (PitcherDTO) team.get(i);
				number = ptc.getNum();
				name = ptc.getName();
				age = ptc.getAge();
				height = ptc.getHeight();
				winOrSwing = ptc.getWin();
				loseOrHit = ptc.getLose();
				dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) winOrSwing) / (winOrSwing + loseOrHit);
				dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
				System.out.print("\n" + number + "\t투수\t" + name + "\t" + age  + "\t" + height + "\t" + winOrSwing + "\t" + loseOrHit + "\t" + dfcOrHitRate);
			} else { // 타자인 경우
				btt = (BatterDTO) team.get(i);
				number = btt.getNum();
				name = btt.getName();
				age = btt.getAge();
				height = btt.getHeight();
				winOrSwing = btt.getSwing();
				loseOrHit = btt.getHit();
	    		dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)loseOrHit) / (winOrSwing);
				dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
				System.out.print("\n" + number + "\t타자\t" + name + "\t" + age  + "\t" + height + "\t\t\t\t" + winOrSwing + "\t" + loseOrHit + "\t" + dfcOrHitRate);
			}

		}
	}
	
	// 요소 별 정렬 기능이 추가된 프린트
	public void printAndSort() {
		int sltSortClm = 0;
		
		System.out.println("정렬 기준을 선택하세요.");
		System.out.println("(1)승률, (2)타율, (3)나이");
		sltSortClm = this.inputUntilInteger();
		
		switch( sltSortClm ) {
			case 1: this.sortByWinRateUsingTreeMap();  break;
			case 2: this.sortByHitRateUsingHashMap();  break;
			case 3: this.sortByAge();  break;
			default : break;
		}
		
//		this.printAllTeammates();
		
		
		this.sortByNum();
	}
	
	
	//리스트 내용 파일에 저장(public)
	public void saveData() {
		this.syncListToFile();
		System.out.println("내용 저장 완료!");
	}
	
	//리스트->파일 갱신
	private boolean syncListToFile() {
		int number = 0;
		String name = "";
		int age = 0;
		double height = 0;
		int winOrSwing = 0;
		int loseOrHit = 0;
		double dfcOrHitRate = 0.0;
		PitcherDTO ptc;
		BatterDTO btt;
		
		try {
			FileWriter fileW = new FileWriter(teamData, false);
			fileW.write("선수번호\t구분\t이름\t나이\t신장\t승\t패\t승률\t타석\t유효타\t타율");
			
			for(int i = 0 ; i < team.size() ; i++ ) {
				if( team.get(i) instanceof PitcherDTO ) {	//투수인 경우
					ptc = (PitcherDTO)team.get(i);
					number = ptc.getNum();
					name = ptc.getName();
					age = ptc.getAge();
					height = ptc.getHeight();
					winOrSwing = ptc.getWin();
					loseOrHit = ptc.getLose();
					dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)winOrSwing)/(winOrSwing + loseOrHit);
					dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
					fileW.write("\n" + number + "\t투수\t" + name + "\t" + age  + "\t" + height + "\t" + winOrSwing + "\t" + loseOrHit + "\t" + dfcOrHitRate);
				}else {		//타자인 경우
					btt = (BatterDTO)team.get(i);
					number = btt.getNum();
					name = btt.getName();
					age = btt.getAge();
					height = btt.getHeight();
					winOrSwing = btt.getSwing();
					loseOrHit = btt.getHit();
					dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)loseOrHit) / (winOrSwing);
					dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
					fileW.write("\n" + number + "\t타자\t" + name + "\t" + age  + "\t" + height + "\t\t\t\t" + winOrSwing + "\t" + loseOrHit + "\t" + dfcOrHitRate);
				}
			}			
			fileW.close();	
			return true;
		}catch(Exception e) {
			return false;
		}				
	}
	
	//파일->리스트 갱신
	private boolean syncFileToList() {
		team = new ArrayList<>();
		int count = 1;		
		String name;
		int age;
		double height = 0;
		int winOrSwing = 0;
		int loseOrHit = 0;
		double dfcOrHitRate = 0.0;
		StringTokenizer st;	
		
		BufferedReader bfReader;
		
		try {
			bfReader = new BufferedReader(new FileReader(teamData));
			String str ; 
			String tempTeamInfo[];
			 
			while( (str = bfReader.readLine()) != null ) {
				st = new StringTokenizer(str,"\t");
				tempTeamInfo = str.split("\t");
//				System.out.println(Arrays.toString(tempTeamInfo));
				
			    if( tempTeamInfo[0].equals("선수번호")) {    }
			    else {
			    	st.nextToken();
			    	st.nextToken();
			    	name = st.nextToken();
					age = Integer.parseInt(st.nextToken());
					height = Double.parseDouble(st.nextToken());
					winOrSwing = Integer.parseInt(st.nextToken());
					loseOrHit = Integer.parseInt(st.nextToken());
					
			    	if(tempTeamInfo[1].equals("투수")) { //투수인 경우
			    		dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)winOrSwing) / (winOrSwing + loseOrHit);
			    		dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
			    		team.add(new PitcherDTO(count, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate));
					    count++;
			    	}else {	//타자인 경우
			    		dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)loseOrHit) / (winOrSwing);
			    		dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
			    		team.add(new BatterDTO(count, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate));
					    count++;
			    	}			    
			    }
			}			 
			bfReader.close();			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일 읽기 오류. 파일 검사 요망.");
		}		
		return true;
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

		char ch = 'f';
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
	
	//입력값이 실수인지 검사
	private double inputUntilDouble() {
		double num = 0.0;		

		char ch = 'f';
		boolean isNotInteger = true;
		
		while( isNotInteger ) {
		try {
			num = Double.parseDouble(in.next());
			isNotInteger = false;
		}catch (Exception e){
			System.out.println("실수가 아닙니다. 실수를 입력하세요.");
			isNotInteger = true;
		}
		}		
		
		return num;
	}

	//타자-투수 순서로 리스트 정렬
	private void sortBatterToPitcher() {
		List<Integer> battersIndex = new ArrayList<>();
		List<Integer> pitcherIndex = new ArrayList<>();
		List<HumanDTO> newTeam =  new ArrayList<>();
		
		for(HumanDTO h : this.team) {
			if( h instanceof BatterDTO ) {		//타자의 경우
				battersIndex.add(team.indexOf(h));
			} else {		//투수의 경우
				pitcherIndex.add(team.indexOf(h));
			}
		}
		battersIndex.addAll(pitcherIndex);
		for( int i : battersIndex) {
			newTeam.add(team.get(i));
		}
		team.clear();
		team = newTeam;						
	}
	
	//투수-타자 순서로 리스트 정렬
	private void sortPitcherToBatter() {
		List<Integer> battersIndex = new ArrayList<>();
		List<Integer> pitcherIndex = new ArrayList<>();
		List<HumanDTO> newTeam =  new ArrayList<>();
		
		for(HumanDTO h : this.team) {
			if( h instanceof BatterDTO ) {		//타자의 경우
				battersIndex.add(team.indexOf(h));
			} else {		//투수의 경우
				pitcherIndex.add(team.indexOf(h));
			}
		}
		pitcherIndex.addAll(battersIndex);
		for( int i : pitcherIndex) {
			newTeam.add(team.get(i));
		}
		team.clear();
		team = newTeam;			
	}
	
	//투수 승률 - 타자 순서로 리스트 정렬
	public void sortByWinRate() {
		PitcherDTO p1;
		PitcherDTO p2;
		this.sortPitcherToBatter();
		
		for(int i = 0 ; i < team.size()-1; i++ ) {
			if( team.get(i) instanceof PitcherDTO ) {
				if( team.get(i+1) instanceof PitcherDTO ) {
					p1 = (PitcherDTO)team.get(i);
					p2 = (PitcherDTO)team.get(i+1);
					if( p1.getDefenceRate() < p2.getDefenceRate() ) {
						PitcherDTO p3 = p1;
						team.set(i, p2);
						team.set(i+1 , p3);						
					}
				}
			}
		}
	}

	//TreeMap을 활용하여 투수 승률 순서로 리스트 정렬 및 출력
	public void sortByWinRateUsingTreeMap() {
		
		PitcherDTO p1 ;
		PitcherDTO p2;
		this.sortPitcherToBatter();
		TreeMap<Double, PitcherDTO> m = new TreeMap<>();
		
		for(int i = 0 ; i < team.size()-1; i++ ) {
			if( team.get(i) instanceof PitcherDTO ) {
				p1 = (PitcherDTO)team.get(i);
				m.put(p1.getDefenceRate(), p1);
			}
		}
		
		Iterator it = m.descendingKeySet().iterator();
		double wr;
		while( it.hasNext() ) {
			wr = (double)it.next();
			for (HumanDTO h : team) {
				if( h instanceof PitcherDTO ) {
					p2 = (PitcherDTO)h;
					if(p2.getDefenceRate() == wr) {
						System.out.println(p2.toString());
						break;
					}				
				}
			}
		}
	}
	
	//타자 타율 - 투수 순서로 리스트 정렬
	public void sortByHitRate() {
		BatterDTO p1;
		BatterDTO p2;
		this.sortBatterToPitcher();
		
		for(int i = 0 ; i < team.size()-1; i++ ) {
			if( team.get(i) instanceof BatterDTO ) {
				if( team.get(i+1) instanceof BatterDTO ) {
					p1 = (BatterDTO)team.get(i);
					p2 = (BatterDTO)team.get(i+1);
		    		double p1Hit = ( (p1.getSwing()+p1.getHit()) == 0 ) ? 0.0 : ((double)p1.getHit()) / (p1.getSwing());
		    		double p2Hit = ( (p2.getSwing()+p2.getHit()) == 0 ) ? 0.0 : ((double)p2.getHit()) / (p2.getSwing());
					if( p1Hit < p2Hit ) {
						BatterDTO p3 = p1;
						team.set(i, p2);
						team.set(i+1 , p3);						
					}
				}
			}
		}
	}

	// HashMap을 활용하여 타자 타율 순서로 리스트 정렬
	public void sortByHitRateUsingHashMap() {
		BatterDTO p1;
		BatterDTO p2;
		this.sortBatterToPitcher();
		Map<Double, BatterDTO> m = new HashMap<>();

		for (int i = 0; i < team.size(); i++) {
			if (team.get(i) instanceof BatterDTO) { // 타자만 Map에 모으기
				p1 = (BatterDTO) team.get(i);
				m.put(p1.getHitRate(), new BatterDTO(p1.getNum(), p1.getName(), p1.getAge(), p1.getHeight(), p1.getSwing(),
						p1.getHit(), p1.getHitRate()));
			}
		}

		Iterator it = m.keySet().iterator();
		double[] aa = new double[m.size()];
		
		int w=0;
		while( it.hasNext() ) {
			aa[w++] = (double)it.next();
		}
		
		it = m.keySet().iterator();
		double check;
		
		for(int i = aa.length ; i > 0 ; i --) {
			for(HumanDTO h : team) {
				p1 = (BatterDTO)h;
				if(p1.getHitRate() == aa[i-1]) {
					System.out.println(p1.toString());
					break;
				}					
			}
		}
//		while (it.hasNext()) {
//			check = (double)it.next();
//			for(HumanDTO h : team) {
//				p1 = (BatterDTO)h;
//				if(p1.getHitRate() == check) {
//					System.out.println(p1.toString());
//					break;
//				}					
//			}
//		}//오름차순 정렬
	}
	
	//나이 순서로 리스트 정렬
	public void sortByAge() {
		Collections.sort(team, new Comparator<HumanDTO>() {
			@Override
			public int compare(HumanDTO o1, HumanDTO o2) {
				if( o1.getAge() < o2.getAge() ) {
					return -1;
				}else if( o1.getAge() > o2.getAge() ){
					return 1;
				}
				return 0;
			}
		});
		this.printAllTeammates();
	}
	
	//번호 순서로 리스트 정렬
	public void sortByNum() {
		Collections.sort(team, new Comparator<HumanDTO>() {
			@Override
			public int compare(HumanDTO o1, HumanDTO o2) {
				if( o1.getNum() < o2.getNum() ) {
					return -1;
				}else if( o1.getNum() > o2.getNum() ){
					return 1;
				}
				return 0;
			}
		});
	}
	
}
