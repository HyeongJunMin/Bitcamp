package baseballTeamManagement;

public class FncDelete implements DAOInterface{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		TeamDAOSingleton.getInstance();
		int stdNum = 0;
		char ch = 'N';
		int count = TeamDAOSingleton.team.size();

		System.out.println("번호\t이름");
		for (int i = 0; i < count; i++) {
			System.out.println(TeamDAOSingleton.team.get(i).getNum() + "\t" + TeamDAOSingleton.team.get(i).getName());
		}
		System.out.println(count + "명의 선수 중 삭제할 선수의 번호를 입력하세요 : ");
		
		stdNum = FncStatic.inputUntilInteger();

		while (ch == 'N') {
			System.out.println("입력하신 번호 " + stdNum + "의 정보를 삭제하시겠습니까? (Y/N)");
			ch = FncStatic.isYOrN();
		}
		//학번에 해당하는 정보 ArrayList에서 삭제
		for (int i = 0; i < count; i++) {
			if( TeamDAOSingleton.team.get(i).getNum() == stdNum ) {
				TeamDAOSingleton.team.remove(i);
				break;
			}
		}		
		//삭제가 완료되었다면?
		if (count > TeamDAOSingleton.team.size()) {
			System.out.println("선수 삭제 성공!");
		}
	}

}
