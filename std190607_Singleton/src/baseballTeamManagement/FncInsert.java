package baseballTeamManagement;

public class FncInsert implements DAOInterface{

	// 삽입(insert) : 선수정보 추가
	@Override
	public void process() {
		TeamDAOSingleton.getInstance();
		
		char chcOK = '0';
		int number = 0;
		String name = "";
		int age = 0;
		double height = 0;
		int winOrSwing = 0;
		int loseOrHit = 0;
		double dfcOrHitRate = 0.0;
		

		System.out.print("(1)투수, (2)타자 : ");
		number = FncStatic.inputUntilInteger();
		// FncStatic.inputUntilInteger();
		if (number == 1) { // 투수
			System.out.println("투수정보를 입력해 주세요 : ");

			while (chcOK != 'Y') {
				System.out.print("이름 : ");
				name = FncStatic.in.next();
				System.out.print("나이 : ");
				age = FncStatic.inputUntilInteger();
				System.out.print("신장 : ");
				height = FncStatic.inputUntilDouble();
				System.out.print("승리 : ");
				winOrSwing = FncStatic.inputUntilInteger();
				System.out.print("패배 : ");
				loseOrHit = FncStatic.inputUntilInteger();
				String strTemp = "이름:" + name + " 나이:" + age + " 신장:" + height + " 승리:" + winOrSwing + " 패배:"
						+ loseOrHit;
				System.out.println("입력하신 정보는 " + strTemp + "입니다.");
				System.out.print("맞으면 Y, 틀리면 N을 입력하세요.");
				chcOK = FncStatic.isYOrN();
			}

			int numOfMember = TeamDAOSingleton.team.size() + 1;
			dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) winOrSwing) / loseOrHit;
			System.out.println("입력 완료!");
			PitcherDTO dto = new PitcherDTO(numOfMember, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate);
			TeamDAOSingleton.team.put(numOfMember+1,(dto));

		} else { // 타자
			System.out.println("타자정보를 입력해 주세요 : ");

			while (chcOK != 'Y') {
				System.out.print("이름 : ");
				name = FncStatic.in.next();
				System.out.print("나이 : ");
				age = FncStatic.inputUntilInteger();
				System.out.print("신장 : ");
				height = FncStatic.inputUntilDouble();
				System.out.print("타석 : ");
				winOrSwing = FncStatic.inputUntilInteger();
				System.out.print("유효타 : ");
				loseOrHit = FncStatic.inputUntilInteger();
				String strTemp = "이름:" + name + " 나이:" + age + " 신장:" + height + " 타석:" + winOrSwing + " 유효타:"
						+ loseOrHit;
				System.out.println("입력하신 정보는 " + strTemp + "입니다.");
				System.out.print("맞으면 Y, 틀리면 N을 입력하세요.");
				chcOK = FncStatic.isYOrN();
			}

			int numOfMember = TeamDAOSingleton.team.size() + 1;
			dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) winOrSwing) / loseOrHit;
			System.out.println("입력 완료!");
			BatterDTO dto = new BatterDTO(numOfMember, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate);
			TeamDAOSingleton.team.put(numOfMember+1,(dto));
		}
	}
}
