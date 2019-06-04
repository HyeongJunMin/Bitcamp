package review190603;

import java.util.Scanner;


public class MemberDAO {
	Scanner sc = new Scanner(System.in);
	
	private Human member[];
	private int sequence;	// +1 member�쓽 index瑜� 愿�由ы븯湲� �쐞�븳 蹂��닔
	private int memberCount;
	
	FileClass myfile;
	
	public MemberDAO() {
		member = new Human[10];
		sequence = 1001;
		memberCount = 0;
		myfile = new FileClass();
	}
	
	public MemberDAO(int count) {		
		member = new Human[count];		
				
		myfile = new FileClass("lions");	
		
		loadData();	// �뙆�씪濡쒕��꽣 諛곗뿴(member)�뿉 �뀑�똿
		
		int lastNum = 0;
		for (int i = 0; i < member.length; i++) {
			if(member[i] != null) {
				lastNum = i;
			}else {
				break;
			}
		}
				
		memberCount = lastNum + 1;
		sequence = 1000 + (member[lastNum].getNumber() % 1000 + 1);
		
		System.out.println("memberCount:" + memberCount);
		System.out.println("sequence:" + sequence);
	}
	
	public void insert() {
		
		System.out.println(">>�꽑�닔�벑濡�");
		System.out.println("�닾�닔(1)/���옄(2) 以� �벑濡앺븯怨� �떢�� �룷吏��뀡�쓣 �엯�젰�빐 二쇱떗�떆�삤.");
		System.out.print(">>");		
		int pos = sc.nextInt();
		
		// �씠由�
		System.out.print("�씠由� >>");	
		String name = sc.next();
		
		// �굹�씠
		System.out.print("�굹�씠 >>");
		int age = sc.nextInt();
		
		// �궎
		System.out.print("�궎 >>");
		double height = sc.nextDouble();
		
		Human human = null;
		// pitcher
		if(pos == 1) {
			// �듅
			System.out.print("�듅 >>");
			int win = sc.nextInt();
			
			// �뙣
			System.out.print("�뙣 >>");
			int lose = sc.nextInt();
			
			// 諛⑹뼱�쑉
			System.out.print("諛⑹뼱�쑉 >>");
			double defence = sc.nextDouble();
			
			human = new Pitcher(sequence, name, age, height, win, lose, defence);			
		}
		// batter
		else if(pos == 2){			
			// ���닔
			System.out.print("���닔 >>");
			int bat = sc.nextInt();
			
			// �븞���닔
			System.out.print("�븞���닔 >>");
			int hit = sc.nextInt();
			
			// ���쑉
			System.out.print("���쑉 >>");
			double hitAvg = sc.nextDouble();
						
			human = new Batter(sequence + 1000, name, age, height, bat, hit, hitAvg);	
		}	
		member[memberCount] = human;
		
		sequence++;
		memberCount++;
	}
	public void delete() {
		System.out.print("�궘�젣�븯怨� �떢�� �씠由� >>");
		String name = sc.next();
		
		int findIndex = search(name);		
		if(findIndex == -1) {
			System.out.println("�뜲�씠�꽣瑜� 李얠� 紐삵뻽�뒿�땲�떎");
			return;
		}
		
		member[findIndex].setNumber(0);
		member[findIndex].setName("");
		member[findIndex].setAge(0);
		member[findIndex].setHeight(0.0);
		
		if(member[findIndex] instanceof Pitcher) {
			Pitcher p = (Pitcher)member[findIndex];
			p.setWin(0);
			p.setLose(0);
			p.setDefence(0.0);
		}
		else if(member[findIndex] instanceof Batter){
			
		}		
	}
	public void select() {
		System.out.print("寃��깋�븯怨� �떢�� �씠由� >>");
		String name = sc.next();
		
		int findIndex = search(name);		
		if(findIndex == -1) {
			System.out.println("�뜲�씠�꽣瑜� 李얠� 紐삵뻽�뒿�땲�떎");
			return;
		}
		
		System.out.println("寃��깋�맂 �뜲�씠�꽣�뒗 >>");
		
		Human h = member[findIndex];
		System.out.println(h.toString());
	}
	public void update() {
		System.out.print("�닔�젙�븯怨� �떢�� �씠由� >>");
		String name = sc.next();
		
		int findIndex = search(name);		
		if(findIndex == -1) {
			System.out.println("�뜲�씠�꽣瑜� 李얠� 紐삵뻽�뒿�땲�떎");
			return;
		}
		
		System.out.println("�닔�젙�븷 �뜲�씠�꽣瑜� �엯�젰�빐 二쇱떗�떆�삤");
		if(member[findIndex] instanceof Pitcher) {
			// �듅
			System.out.print("�듅 >>");
			int win = sc.nextInt();
			
			// �뙣
			System.out.print("�뙣 >>");
			int lose = sc.nextInt();
			
			// 諛⑹뼱�쑉
			System.out.print("諛⑹뼱�쑉 >>");
			double defence = sc.nextDouble();
			
			Pitcher p = (Pitcher)member[findIndex];
			p.setWin(win);
			p.setLose(lose);
			p.setDefence(defence);			
		}
		else if(member[findIndex] instanceof Batter){
			
		}
	}
	public void allprint() {
		for (int i = 0; i < member.length; i++) {
			if(member[i] != null && !member[i].getName().equals("")) {
				Human h = member[i];
				System.out.println(h.toString());
			}
		}
	}
		
	public int search(String name) {
		int findIndex = -1;
		for (int i = 0; i < member.length; i++) {
			Human h = member[i];
			if(h != null && !h.getName().equals("")) {
				if(name.equals(h.getName())) {
					findIndex = i;
					break;
				}
			}
		}
		return findIndex;
	}
	
	public void saveData() {
		int datalength = 0;
		
		for (int i = 0; i < member.length; i++) {
			if(member[i] != null && !member[i].getName().equals("")) {
				datalength++;
			}
		}
		
		String datas[] = new String[datalength];	
		// 0
		// 1
		// 2	- �궘�젣
		// 3
		
		int len = 0;
		for (int i = 0; i < member.length; i++) {
			if(member[i] != null && !member[i].getName().equals("")) {
				datas[len] = member[i].toString();
				len++;
			}
		}
		
		for (int i = 0; i < datas.length; i++) {
			System.out.println(i + "datas:" + datas[i]);
		}
		
		myfile.writeFile(datas);
	}
	
	public void loadData() {
		// Human member[] <- String[]
		
		String datas[] = myfile.readFile();
		/*
		//  
		for (int i = 0; i < datas.length; i++) {
			System.out.println(datas[i]);
		}
		*/
		// 臾몄옄�뿴�쓣 �옄瑜� �썑�뿉 Pitcher, Batter�뿉 留욊쾶 �뜲�씠�꽣瑜� �꽔�뼱 以��떎
		
		for (int i = 0; i < datas.length; i++) {			
			String str = datas[i];			// 1001-hgd-1-1.0-1-1-1.0
			String data[] = str.split("-"); // 1001 hgd 1 1.0 1 1 1.0
											// 踰덊샇, �씠由�, �굹�씠, �궎, �듅, �뙣, 諛⑹뼱�쑉  	
			int number = Integer.parseInt(data[0]);	// �닾�닔/���옄
			if(number < 2000) {	// �닾�닔
				Pitcher p = new Pitcher(number, 
										data[1], 
										Integer.parseInt(data[2]), 
										Double.parseDouble(data[3]), 
										Integer.parseInt(data[4]), 
										Integer.parseInt(data[5]), 
										Double.parseDouble(data[6]));
				member[i] = p;	
			}
			else {				// ���옄
				Batter b = new Batter(number, 	// number
										data[1], 	// name
										Integer.parseInt(data[2]),	// age 
										Double.parseDouble(data[3]), // height
										Integer.parseInt(data[4]), 	// bat
										Integer.parseInt(data[5]), 	// hit
										Double.parseDouble(data[6])); // hitAvg
				member[i] = b;
			}			
		}		
	}	
}




