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
		System.out.println("���������� �����մϴ�. ������ ������ ��ȣ�� �Է��ϼ���.");
		while (ch == 'N') {
			num = FncStatic.inputUntilInteger();
			System.out.println("�Է��� ��ȣ�� " + num + "�Դϴ�. ������ Y, Ʋ���� N�� �Է��ϼ���.");
			ch = FncStatic.isYOrN();
		}
		// �Է¹��� ��ȣ�� ��ġ�ϴ� ������ �ִ��� �˻�
		for (i = 1; i < TeamDAOSingleton.team.size() + 1 ; i++) {
			if (TeamDAOSingleton.team.get(i).getNum() == num) {
				has = true;
				break;
			}
		}

		if (has) {
			if (TeamDAOSingleton.team.get(i) instanceof PitcherDTO) { // ����
				System.out.println("���������� �Է��� �ּ��� : ");

				while (chcOK != 'Y') {
					System.out.print("�̸� : ");
					name = FncStatic.in.next();
					System.out.print("���� : ");
					age = FncStatic.inputUntilInteger();
					System.out.print("���� : ");
					height = FncStatic.inputUntilDouble();
					System.out.print("�¸� : ");
					winOrSwing = FncStatic.inputUntilInteger();
					System.out.print("�й� : ");
					loseOrHit = FncStatic.inputUntilInteger();
					String strTemp = "�̸�:" + name + " ����:" + age + " ����:" + height + " �¸�:" + winOrSwing + " �й�:"
							+ loseOrHit;
					System.out.println("�Է��Ͻ� ������ " + strTemp + "�Դϴ�.");
					System.out.print("������ Y, Ʋ���� N�� �Է��ϼ���.");
					chcOK = FncStatic.isYOrN();
				}

				dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) winOrSwing) / loseOrHit;
				System.out.println("���� �Ϸ�!");
				TeamDAOSingleton.team.replace(i, new PitcherDTO(i + 1, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate));
			} else { // Ÿ��
				System.out.println("Ÿ�������� �Է��� �ּ��� : ");

				while (chcOK != 'Y') {
					System.out.print("�̸� : ");
					name = FncStatic.in.next();
					System.out.print("���� : ");
					age = FncStatic.inputUntilInteger();
					System.out.print("���� : ");
					height = FncStatic.inputUntilDouble();
					System.out.print("Ÿ�� : ");
					winOrSwing = FncStatic.inputUntilInteger();
					System.out.print("��ȿŸ : ");
					loseOrHit = FncStatic.inputUntilInteger();
					String strTemp = "�̸�:" + name + " ����:" + age + " ����:" + height + " Ÿ��:" + winOrSwing + " ��ȿŸ:"
							+ loseOrHit;
					System.out.println("�Է��Ͻ� ������ " + strTemp + "�Դϴ�.");
					System.out.print("������ Y, Ʋ���� N�� �Է��ϼ���.");
					chcOK = FncStatic.isYOrN();
				}
				dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) winOrSwing) / loseOrHit;
				System.out.println("���� �Ϸ�!");
				TeamDAOSingleton.team.replace(i, new BatterDTO(i + 1, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate));
			}
		} else {
			System.out.println("�Է��� ��ȣ�� �ش��ϴ� ������ ã�� �� �����ϴ�.");
		}
	}
}
