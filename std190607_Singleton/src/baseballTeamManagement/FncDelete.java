package baseballTeamManagement;

public class FncDelete implements DAOInterface{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		TeamDAOSingleton.getInstance();
		int stdNum = 0;
		char ch = 'N';
		int count = TeamDAOSingleton.team.size();

		System.out.println("��ȣ\t�̸�");
		for (int i = 0; i < count; i++) {
			System.out.println(TeamDAOSingleton.team.get(i).getNum() + "\t" + TeamDAOSingleton.team.get(i).getName());
		}
		System.out.println(count + "���� ���� �� ������ ������ ��ȣ�� �Է��ϼ��� : ");
		
		stdNum = FncStatic.inputUntilInteger();

		while (ch == 'N') {
			System.out.println("�Է��Ͻ� ��ȣ " + stdNum + "�� ������ �����Ͻðڽ��ϱ�? (Y/N)");
			ch = FncStatic.isYOrN();
		}
		//�й��� �ش��ϴ� ���� ArrayList���� ����
		for (int i = 0; i < count; i++) {
			if( TeamDAOSingleton.team.get(i).getNum() == stdNum ) {
				TeamDAOSingleton.team.remove(i);
				break;
			}
		}		
		//������ �Ϸ�Ǿ��ٸ�?
		if (count > TeamDAOSingleton.team.size()) {
			System.out.println("���� ���� ����!");
		}
	}

}
