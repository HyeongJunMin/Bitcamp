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
		System.out.print("(1)선수입력\t(2)선수삭제\t(3)선수검색\n(4)정렬및출력\t(5)선수정보수정\t(6)전체정보출력");
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
		
		System.out.print("\n계속?(Y/N)");
		ch = FncStatic.isYOrN();
		}
	}
}
