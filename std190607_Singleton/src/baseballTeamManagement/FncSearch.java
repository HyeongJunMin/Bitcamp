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
		
		System.out.print("�������� �˻��� �����մϴ�. ������ ��ȸ�� ������ ��ȣ�� �Է��ϼ��� : ");
		
		while ( ch == 'N' ) {
			num = FncStatic.inputUntilInteger();
			System.out.println("��ȣ�� " + num + "�Դϴ�. ������ Y, Ʋ���� N�� �Է��ϼ���.");
			ch = FncStatic.isYOrN();
		}
		//�Է¹��� ������ ��ġ�ϴ� ������ �ִ��� �˻�
		for (i = 1; i < TeamDAOSingleton.team.size()+1; i++) {
			if( TeamDAOSingleton.team.get(i).getNum() == num ) {
				has = true;
				break;
			}
		}
		if( has ) {
			if(  TeamDAOSingleton.team.get(i) instanceof PitcherDTO   ) {	//�����̸�?
				System.out.print("������ȣ\t����\t�̸�\t����\t����\t��\t��\t�·�\n");
				PitcherDTO pdt = (PitcherDTO)TeamDAOSingleton.team.get(i);
				dfcOrHitRate = ((pdt.getWin() + pdt.getLose()) == 0) ? 0.0 : ((double) pdt.getWin()) / (pdt.getWin() + pdt.getLose());
				dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
				str = pdt.getNum() + "\t����\t" + pdt.getName() + "\t" + pdt.getAge() + "\t" + pdt.getHeight() + "\t" + pdt.getWin() + "\t" + pdt.getLose() + "\t" + dfcOrHitRate;
				System.out.println(str);
			}else {	//Ÿ���̸�?
				System.out.print("������ȣ\t����\t�̸�\t����\t����\tŸ��\t��ȿŸ\tŸ��\n");
				BatterDTO pdt = (BatterDTO)TeamDAOSingleton.team.get(i);
				dfcOrHitRate = ((pdt.getSwing() + pdt.getHit()) == 0) ? 0.0 : ((double) pdt.getHit()) / pdt.getSwing();
				dfcOrHitRate = (Math.round(dfcOrHitRate*100))/100.0;
				str = i+1 + "\tŸ��\t" + pdt.getName() + "\t" + pdt.getAge() + "\t" + pdt.getHeight() + "\t" + pdt.getSwing() + "\t" + pdt.getHit() + "\t" + dfcOrHitRate;
				System.out.println(str);
			}		
		}else {
			System.out.println("��ȣ " + num + " �� ã�� �� �����ϴ�.");
		}
		System.out.println("�������� �˻��� �����մϴ�.");
		
	}
}
