package baseballTeamManagement;

public class FncInsert implements DAOInterface{

	// ����(insert) : �������� �߰�
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
		

		System.out.print("(1)����, (2)Ÿ�� : ");
		number = FncStatic.inputUntilInteger();
		// FncStatic.inputUntilInteger();
		if (number == 1) { // ����
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

			int numOfMember = TeamDAOSingleton.team.size() + 1;
			dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) winOrSwing) / loseOrHit;
			System.out.println("�Է� �Ϸ�!");
			PitcherDTO dto = new PitcherDTO(numOfMember, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate);
			TeamDAOSingleton.team.put(numOfMember+1,(dto));

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

			int numOfMember = TeamDAOSingleton.team.size() + 1;
			dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) winOrSwing) / loseOrHit;
			System.out.println("�Է� �Ϸ�!");
			BatterDTO dto = new BatterDTO(numOfMember, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate);
			TeamDAOSingleton.team.put(numOfMember+1,(dto));
		}
	}
}
