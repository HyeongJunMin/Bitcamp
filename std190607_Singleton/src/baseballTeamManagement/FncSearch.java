package baseballTeamManagement;

public class FncSearch implements DAOInterface{
	public void process() {
		TeamDAOSingleton.getInstance();
		char ch = 'N';
		int num = 0;
		int i = 0;
		boolean has = false;
		String str="";
		double dfcOrHitRate;
		
		System.out.print("선수정보 검색을 시작합니다. 정보를 조회할 선수의 번호를 입력하세요 : ");
		
		while ( ch == 'N' ) {
			num = FncStatic.inputUntilInteger();
			System.out.println("번호는 " + num + "입니다. 맞으면 Y, 틀리면 N을 입력하세요.");
			ch = FncStatic.isYOrN();
		}
		//입력받은 선수와 일치하는 선수가 있는지 검사
		for (i = 1; i < TeamDAOSingleton.team.size()+1; i++) {
			if( TeamDAOSingleton.team.get(i).getNum() == num ) {
				has = true;
				break;
			}
		}
		if( has ) {
			if(  TeamDAOSingleton.team.get(i) instanceof PitcherDTO   ) {	//투수이면?
				System.out.print("선수번호\t구분\t이름\t나이\t신장\t승\t패\t승률\n");
				PitcherDTO pdt = (PitcherDTO)TeamDAOSingleton.team.get(i);
				dfcOrHitRate = ((pdt.getWin() + pdt.getLose()) == 0) ? 0.0 : ((double) pdt.getWin()) / (pdt.getWin() + pdt.getLose());
				dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
				str = pdt.getNum() + "\t투수\t" + pdt.getName() + "\t" + pdt.getAge() + "\t" + pdt.getHeight() + "\t" + pdt.getWin() + "\t" + pdt.getLose() + "\t" + dfcOrHitRate;
				System.out.println(str);
			}else {	//타자이면?
				System.out.print("선수번호\t구분\t이름\t나이\t신장\t타석\t유효타\t타율\n");
				BatterDTO pdt = (BatterDTO)TeamDAOSingleton.team.get(i);
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
}
