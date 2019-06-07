package baseballTeamManagement;

public class FncUpdate implements DAOInterface {
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
		boolean isPitcher = false;
		int num = 0;
		int i = 0;
		boolean has = false;

		char ch = 'N';
		System.out.println("선수정보를 수정합니다. 수정할 선수의 번호를 입력하세요.");
		while (ch == 'N') {
			num = FncStatic.inputUntilInteger();
			System.out.println("입력한 번호는 " + num + "입니다. 맞으면 Y, 틀리면 N을 입력하세요.");
			ch = FncStatic.isYOrN();
		}
		// 입력받은 번호과 일치하는 선수가 있는지 검사
		for (i = 1; i < TeamDAOSingleton.team.size() + 1 ; i++) {
			if (TeamDAOSingleton.team.get(i).getNum() == num) {
				has = true;
				break;
			}
		}

		if (has) {
			if (TeamDAOSingleton.team.get(i) instanceof PitcherDTO) { // 투수
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

				dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) winOrSwing) / loseOrHit;
				System.out.println("수정 완료!");
				TeamDAOSingleton.team.replace(i, new PitcherDTO(i + 1, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate));
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
				dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) winOrSwing) / loseOrHit;
				System.out.println("수정 완료!");
				TeamDAOSingleton.team.replace(i, new BatterDTO(i + 1, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate));
			}
		} else {
			System.out.println("입력한 번호에 해당하는 선수를 찾을 수 없습니다.");
		}
	}
}
