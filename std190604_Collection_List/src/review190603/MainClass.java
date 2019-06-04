package review190603;


import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MemberDAO DAO = new MemberDAO(20);
		
		while(true) {
			
			int choice = -1;			
			System.out.println("�뼱�뒓 �옉�뾽�쓣 �븯�떆寃좎뒿�땲源�?");
			System.out.println("1. �꽑�닔 �벑濡�");
			System.out.println("2. �꽑�닔 �궘�젣");
			System.out.println("3. �꽑�닔 寃��깋");
			System.out.println("4. �꽑�닔 �닔�젙");
			System.out.println("5. �꽑�닔 紐낅떒 紐⑤몢 異쒕젰");
			System.out.println("6. �꽑�닔 紐낅떒 ���옣");
			System.out.println("7. 醫낅즺");
			
			System.out.print(">>");
			choice = sc.nextInt();
			
			switch (choice) {
				case 1:		
					DAO.insert();
					break;
				case 2:			
					DAO.delete();
					break;
				case 3:		
					DAO.select();
					break;
				case 4:			
					DAO.update();
					break;
				case 5:		
					DAO.allprint();
					break;
				case 6:	
					DAO.saveData();
					break;
				default:
					break;
			}
		}
		

	}

}




