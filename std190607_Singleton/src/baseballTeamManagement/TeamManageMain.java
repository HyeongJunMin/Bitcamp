package baseballTeamManagement;

public class TeamManageMain {
	public static void main(String[] args) {
//		int num=1;
//		String name= "sd";
//		int age = 13;
//		double height = 130.3;
//		int win = 2;
//		int lose = 3;
//		double defenceR = 1.4;
		char ch = 'Y';
		
				
		TeamDAOSingleton.getInstance();
		
		FncFileIO.syncFileToList();

		while( ch == 'Y' ) {
		DAOInterface i;		
		System.out.print("(1)�����Է�\t(2)��������\t(3)�����˻�\n(4)���Ĺ����\t(5)������������\t(6)��ü�������");
		int a = FncStatic.in.nextInt();
		switch (a) {
			case 1:	i = new FncInsert();	break;
			case 2:	i = new FncDelete();	break;
			case 3: i = new FncSearch();	break;
			case 4: i = new FncSort();		break;
			case 5: i = new FncUpdate();	break;
			default:i = new FncPrint();		break;			
		}		
	
		i.process();
		
		System.out.print("\n���?(Y/N)");
		ch = FncStatic.isYOrN();
		}
	}
}
