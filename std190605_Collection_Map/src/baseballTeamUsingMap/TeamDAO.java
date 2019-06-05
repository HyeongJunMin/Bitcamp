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
	
	//�������� �ý��� �޴� ��� �� �ݺ�
	public void runSystem() {
		char ch = 'Y';
		int selectMenu = 0;
		
		System.out.println("������������ �ý����� �����մϴ�.");
		while( ch == 'Y' ) {
			System.out.println("�޴��� ������ �ּ���.");
			System.out.print("(1)�����߰�\t(2)��������\t(3)�����˻�\n(4)������������\t(5)��缱���������\t(6)����������\t(7)����");
			//�����߰�, ��������, �����˻�, ��������, ������, ����������
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
			
			System.out.println("\n����Ͻðڽ��ϱ�? (Y/N)");
			ch = isYOrN();
		}		
	}
	
	//����(insert) : �������� �߰�
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
		
		System.out.print("(1)����, (2)Ÿ�� : ");
		number = this.inputUntilInteger();
		
		if(number == 1) {	//����
			System.out.println("���������� �Է��� �ּ��� : ");
			
			while(chcOK != 'Y') {
				System.out.print("�̸� : ");
				name = in.next();
				System.out.print("���� : ");
				age = this.inputUntilInteger();
				System.out.print("���� : ");
				height = this.inputUntilDouble();
				System.out.print("�¸� : ");
				winOrSwing = this.inputUntilInteger();
				System.out.print("�й� : ");
				loseOrHit = this.inputUntilInteger();
				String strTemp = "�̸�:" + name + " ����:" + age + " ����:" + height + " �¸�:" + winOrSwing + " �й�:" + loseOrHit;
				System.out.println("�Է��Ͻ� ������ "+strTemp + "�Դϴ�.");
				System.out.print("������ Y, Ʋ���� N�� �Է��ϼ���.");
				chcOK = isYOrN();
			}
			
			int numOfMember = team.size() + 1;
			dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)winOrSwing)/loseOrHit;
			System.out.println("�Է� �Ϸ�!");
			PitcherDTO dto = new PitcherDTO(numOfMember, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate);
			team.add(dto);			
			
		}else {	//Ÿ��
			System.out.println("Ÿ�������� �Է��� �ּ��� : ");			
			
			while(chcOK != 'Y') {
				System.out.print("�̸� : ");
				name = in.next();
				System.out.print("���� : ");
				age = this.inputUntilInteger();
				System.out.print("���� : ");
				height = this.inputUntilDouble();
				System.out.print("Ÿ�� : ");
				winOrSwing = this.inputUntilInteger();
				System.out.print("��ȿŸ : ");
				loseOrHit = this.inputUntilInteger();
				String strTemp = "�̸�:" + name + " ����:" + age + " ����:" + height + " Ÿ��:" + winOrSwing + " ��ȿŸ:" + loseOrHit;
				System.out.println("�Է��Ͻ� ������ "+strTemp + "�Դϴ�.");
				System.out.print("������ Y, Ʋ���� N�� �Է��ϼ���.");
				chcOK = isYOrN();
			}
			
			int numOfMember = team.size() + 1;
			dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)winOrSwing)/loseOrHit;
			System.out.println("�Է� �Ϸ�!");
			BatterDTO dto = new BatterDTO(numOfMember, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate);
			team.add(dto);			
		}
		
		this.syncListToFile();
		
	}
	
	//����(delete)
	public void deletePlayer() {
		int stdNum = 0;
		char ch = 'N';
		int count = this.team.size();

		System.out.println("��ȣ\t�̸�");
		for (int i = 0; i < count; i++) {
			System.out.println(team.get(i).getNum() + "\t" + team.get(i).getName());
		}
		System.out.println(count + "���� ���� �� ������ ������ ��ȣ�� �Է��ϼ��� : ");
		
		stdNum = inputUntilInteger();

		while (ch == 'N') {
			System.out.println("�Է��Ͻ� ��ȣ " + stdNum + "�� ������ �����Ͻðڽ��ϱ�? (Y/N)");
			ch = isYOrN();
		}
		//�й��� �ش��ϴ� ���� ArrayList���� ����
		for (int i = 0; i < count; i++) {
			if( team.get(i).getNum() == stdNum ) {
				team.remove(i);
				break;
			}
		}		
		//������ �Ϸ�Ǿ��ٸ�?
		if (count > this.team.size()) {
			this.syncListToFile();
			System.out.println("���� ���� ����!");
		}
	}
	
	
	//�˻�(select)
	public void selectByNum() {
		char ch = 'N';
		int num = 0;
		int i = 0;
		boolean has = false;
		String str="";
		double dfcOrHitRate;
		
		System.out.print("�������� �˻��� �����մϴ�. ������ ��ȸ�� ������ ��ȣ�� �Է��ϼ��� : ");
		
		while ( ch == 'N' ) {
			num = inputUntilInteger();
			System.out.println("��ȣ�� " + num + "�Դϴ�. ������ Y, Ʋ���� N�� �Է��ϼ���.");
			ch = isYOrN();
		}
		//�Է¹��� ������ ��ġ�ϴ� ������ �ִ��� �˻�
		for (i = 0; i < this.team.size(); i++) {
			if( team.get(i).getNum() == num ) {
				has = true;
				break;
			}
		}
		if( has ) {
			if(  team.get(i) instanceof PitcherDTO   ) {	//�����̸�?
				System.out.print("������ȣ\t����\t�̸�\t����\t����\t��\t��\t�·�\n");
				PitcherDTO pdt = (PitcherDTO)team.get(i);
				dfcOrHitRate = ((pdt.getWin() + pdt.getLose()) == 0) ? 0.0 : ((double) pdt.getWin()) / (pdt.getWin() + pdt.getLose());
				dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
				str = i+1 + "\t����\t" + pdt.getName() + "\t" + pdt.getAge() + "\t" + pdt.getHeight() + "\t" + pdt.getWin() + "\t" + pdt.getLose() + "\t" + dfcOrHitRate;
				System.out.println(str);
			}else {	//Ÿ���̸�?
				System.out.print("������ȣ\t����\t�̸�\t����\t����\tŸ��\t��ȿŸ\tŸ��\n");
				BatterDTO pdt = (BatterDTO)team.get(i);
				dfcOrHitRate = ((pdt.getSwing() + pdt.getHit()) == 0) ? 0.0 : ((double) pdt.getHit()) / pdt.getSwing();
				dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
				str = i+1 + "\tŸ��\t" + pdt.getName() + "\t" + pdt.getAge() + "\t" + pdt.getHeight() + "\t" + pdt.getSwing() + "\t" + pdt.getHit() + "\t" + dfcOrHitRate;
				System.out.println(str);
			}		
		}else {
			System.out.println("��ȣ " + num + " �� ã�� �� �����ϴ�.");
		}
		System.out.println("�������� �˻��� �����մϴ�.");
	}
	
	//����(update)
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
		System.out.println("���������� �����մϴ�. ������ ������ ��ȣ�� �Է��ϼ���.");
		while ( ch == 'N' ) {
			num = inputUntilInteger();
			System.out.println("�Է��� ��ȣ�� " + num + "�Դϴ�. ������ Y, Ʋ���� N�� �Է��ϼ���.");
			ch = isYOrN();
		}
		//�Է¹��� ��ȣ�� ��ġ�ϴ� ������ �ִ��� �˻�
		for (i = 0; i < this.team.size(); i++) {
			if( team.get(i).getNum() == num ) {
				has = true;
				break;
			}
		}
		
		if( has ) {
			if( team.get(i) instanceof PitcherDTO ) {	//����
				System.out.println("���������� �Է��� �ּ��� : ");
				
				while(chcOK != 'Y') {
					System.out.print("�̸� : ");
					name = in.next();
					System.out.print("���� : ");
					age = this.inputUntilInteger();
					System.out.print("���� : ");
					height = this.inputUntilDouble();
					System.out.print("�¸� : ");
					winOrSwing = this.inputUntilInteger();
					System.out.print("�й� : ");
					loseOrHit = this.inputUntilInteger();
					String strTemp = "�̸�:" + name + " ����:" + age + " ����:" + height + " �¸�:" + winOrSwing + " �й�:" + loseOrHit;
					System.out.println("�Է��Ͻ� ������ "+strTemp + "�Դϴ�.");
					System.out.print("������ Y, Ʋ���� N�� �Է��ϼ���.");
					chcOK = isYOrN();
				}
				
				dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)winOrSwing)/loseOrHit;
				System.out.println("���� �Ϸ�!");
				team.set(i, new PitcherDTO(i+1, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate));
								
			}else {	//Ÿ��
				System.out.println("Ÿ�������� �Է��� �ּ��� : ");			
				
				while(chcOK != 'Y') {
					System.out.print("�̸� : ");
					name = in.next();
					System.out.print("���� : ");
					age = this.inputUntilInteger();
					System.out.print("���� : ");
					height = this.inputUntilDouble();
					System.out.print("Ÿ�� : ");
					winOrSwing = this.inputUntilInteger();
					System.out.print("��ȿŸ : ");
					loseOrHit = this.inputUntilInteger();
					String strTemp = "�̸�:" + name + " ����:" + age + " ����:" + height + " Ÿ��:" + winOrSwing + " ��ȿŸ:" + loseOrHit;
					System.out.println("�Է��Ͻ� ������ "+strTemp + "�Դϴ�.");
					System.out.print("������ Y, Ʋ���� N�� �Է��ϼ���.");
					chcOK = isYOrN();
				}
				dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)winOrSwing)/loseOrHit;
				System.out.println("���� �Ϸ�!");
				team.set(i, new BatterDTO(i+1, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate));
			}
			this.syncListToFile();
		}else {
			System.out.println("�Է��� ��ȣ�� �ش��ϴ� ������ ã�� �� �����ϴ�.");
		}
	}
	

	//���(printall)
	public void printAllTeammates() {
		System.out.println("\n��� ���������� ����մϴ�.");
		System.out.print("������ȣ\t����\t�̸�\t����\t����\t��\t��\t�·�\tŸ��\t��ȿŸ\tŸ��");
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
			if (team.get(i) instanceof PitcherDTO) { // ������ ���
				ptc = (PitcherDTO) team.get(i);
				number = ptc.getNum();
				name = ptc.getName();
				age = ptc.getAge();
				height = ptc.getHeight();
				winOrSwing = ptc.getWin();
				loseOrHit = ptc.getLose();
				dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) winOrSwing) / (winOrSwing + loseOrHit);
				dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
				System.out.print("\n" + number + "\t����\t" + name + "\t" + age  + "\t" + height + "\t" + winOrSwing + "\t" + loseOrHit + "\t" + dfcOrHitRate);
			} else { // Ÿ���� ���
				btt = (BatterDTO) team.get(i);
				number = btt.getNum();
				name = btt.getName();
				age = btt.getAge();
				height = btt.getHeight();
				winOrSwing = btt.getSwing();
				loseOrHit = btt.getHit();
	    		dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)loseOrHit) / (winOrSwing);
				dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
				System.out.print("\n" + number + "\tŸ��\t" + name + "\t" + age  + "\t" + height + "\t\t\t\t" + winOrSwing + "\t" + loseOrHit + "\t" + dfcOrHitRate);
			}

		}
	}
	
	// ��� �� ���� ����� �߰��� ����Ʈ
	public void printAndSort() {
		int sltSortClm = 0;
		
		System.out.println("���� ������ �����ϼ���.");
		System.out.println("(1)�·�, (2)Ÿ��, (3)����");
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
	
	
	//����Ʈ ���� ���Ͽ� ����(public)
	public void saveData() {
		this.syncListToFile();
		System.out.println("���� ���� �Ϸ�!");
	}
	
	//����Ʈ->���� ����
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
			fileW.write("������ȣ\t����\t�̸�\t����\t����\t��\t��\t�·�\tŸ��\t��ȿŸ\tŸ��");
			
			for(int i = 0 ; i < team.size() ; i++ ) {
				if( team.get(i) instanceof PitcherDTO ) {	//������ ���
					ptc = (PitcherDTO)team.get(i);
					number = ptc.getNum();
					name = ptc.getName();
					age = ptc.getAge();
					height = ptc.getHeight();
					winOrSwing = ptc.getWin();
					loseOrHit = ptc.getLose();
					dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)winOrSwing)/(winOrSwing + loseOrHit);
					dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
					fileW.write("\n" + number + "\t����\t" + name + "\t" + age  + "\t" + height + "\t" + winOrSwing + "\t" + loseOrHit + "\t" + dfcOrHitRate);
				}else {		//Ÿ���� ���
					btt = (BatterDTO)team.get(i);
					number = btt.getNum();
					name = btt.getName();
					age = btt.getAge();
					height = btt.getHeight();
					winOrSwing = btt.getSwing();
					loseOrHit = btt.getHit();
					dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)loseOrHit) / (winOrSwing);
					dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
					fileW.write("\n" + number + "\tŸ��\t" + name + "\t" + age  + "\t" + height + "\t\t\t\t" + winOrSwing + "\t" + loseOrHit + "\t" + dfcOrHitRate);
				}
			}			
			fileW.close();	
			return true;
		}catch(Exception e) {
			return false;
		}				
	}
	
	//����->����Ʈ ����
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
				
			    if( tempTeamInfo[0].equals("������ȣ")) {    }
			    else {
			    	st.nextToken();
			    	st.nextToken();
			    	name = st.nextToken();
					age = Integer.parseInt(st.nextToken());
					height = Double.parseDouble(st.nextToken());
					winOrSwing = Integer.parseInt(st.nextToken());
					loseOrHit = Integer.parseInt(st.nextToken());
					
			    	if(tempTeamInfo[1].equals("����")) { //������ ���
			    		dfcOrHitRate = ( (winOrSwing+loseOrHit) == 0 ) ? 0.0 : ((double)winOrSwing) / (winOrSwing + loseOrHit);
			    		dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
			    		team.add(new PitcherDTO(count, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate));
					    count++;
			    	}else {	//Ÿ���� ���
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
			System.out.println("���� �б� ����. ���� �˻� ���.");
		}		
		return true;
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

		char ch = 'f';
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
	
	//�Է°��� �Ǽ����� �˻�
	private double inputUntilDouble() {
		double num = 0.0;		

		char ch = 'f';
		boolean isNotInteger = true;
		
		while( isNotInteger ) {
		try {
			num = Double.parseDouble(in.next());
			isNotInteger = false;
		}catch (Exception e){
			System.out.println("�Ǽ��� �ƴմϴ�. �Ǽ��� �Է��ϼ���.");
			isNotInteger = true;
		}
		}		
		
		return num;
	}

	//Ÿ��-���� ������ ����Ʈ ����
	private void sortBatterToPitcher() {
		List<Integer> battersIndex = new ArrayList<>();
		List<Integer> pitcherIndex = new ArrayList<>();
		List<HumanDTO> newTeam =  new ArrayList<>();
		
		for(HumanDTO h : this.team) {
			if( h instanceof BatterDTO ) {		//Ÿ���� ���
				battersIndex.add(team.indexOf(h));
			} else {		//������ ���
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
	
	//����-Ÿ�� ������ ����Ʈ ����
	private void sortPitcherToBatter() {
		List<Integer> battersIndex = new ArrayList<>();
		List<Integer> pitcherIndex = new ArrayList<>();
		List<HumanDTO> newTeam =  new ArrayList<>();
		
		for(HumanDTO h : this.team) {
			if( h instanceof BatterDTO ) {		//Ÿ���� ���
				battersIndex.add(team.indexOf(h));
			} else {		//������ ���
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
	
	//���� �·� - Ÿ�� ������ ����Ʈ ����
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

	//TreeMap�� Ȱ���Ͽ� ���� �·� ������ ����Ʈ ���� �� ���
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
	
	//Ÿ�� Ÿ�� - ���� ������ ����Ʈ ����
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

	// HashMap�� Ȱ���Ͽ� Ÿ�� Ÿ�� ������ ����Ʈ ����
	public void sortByHitRateUsingHashMap() {
		BatterDTO p1;
		BatterDTO p2;
		this.sortBatterToPitcher();
		Map<Double, BatterDTO> m = new HashMap<>();

		for (int i = 0; i < team.size(); i++) {
			if (team.get(i) instanceof BatterDTO) { // Ÿ�ڸ� Map�� ������
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
//		}//�������� ����
	}
	
	//���� ������ ����Ʈ ����
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
	
	//��ȣ ������ ����Ʈ ����
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
