package baseballTeamManagement;

import java.util.List;

public class FncPrint implements DAOInterface{
	// ���(printall)
	public void process() {
		System.out.println("\n��� ���������� ����մϴ�.");
		System.out.print("������ȣ\t����\t�̸�\t����\t����\t��\t��\t�·�\tŸ��\t��ȿŸ\tŸ��");
		TeamDAOSingleton t = TeamDAOSingleton.getInstance();
		int number = 0;
		String name = "";
		int age = 0;
		double height = 0;
		int winOrSwing = 0;
		int loseOrHit = 0;
		double dfcOrHitRate = 0.0;
		PitcherDTO ptc;
		BatterDTO btt;

		for (int i = 1; i < t.team.size()+1; i++) {
			if (t.team.get(i) instanceof PitcherDTO) { // ������ ���
				ptc = (PitcherDTO) t.team.get(i);
				number = ptc.getNum();
				name = ptc.getName();
				age = ptc.getAge();
				height = ptc.getHeight();
				winOrSwing = ptc.getWin();
				loseOrHit = ptc.getLose();
				dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) winOrSwing) / (winOrSwing + loseOrHit);
				dfcOrHitRate = (Math.round(dfcOrHitRate * 100)) / 100.0;
				System.out.print("\n" + number + "\t����\t" + name + "\t" + age + "\t" + height + "\t" + winOrSwing + "\t"
						+ loseOrHit + "\t" + dfcOrHitRate);
			} else { // Ÿ���� ���
				btt = (BatterDTO) t.team.get(i);
				number = btt.getNum();
				name = btt.getName();
				age = btt.getAge();
				height = btt.getHeight();
				winOrSwing = btt.getSwing();
				loseOrHit = btt.getHit();
				dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) loseOrHit) / (winOrSwing);
				dfcOrHitRate = (Math.round(dfcOrHitRate * 100)) / 100.0;
				System.out.print("\n" + number + "\tŸ��\t" + name + "\t" + age + "\t" + height + "\t\t\t\t" + winOrSwing
						+ "\t" + loseOrHit + "\t" + dfcOrHitRate);
			}

		}
	}
}
