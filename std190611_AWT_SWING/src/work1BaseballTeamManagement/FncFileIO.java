package work1BaseballTeamManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

public class FncFileIO {

	// 파일->리스트 갱신
	public static void syncFileToList() {
		TeamDAOSingleton t = TeamDAOSingleton.getInstance();

		int count = 1;
		String name;
		int age;
		double height = 0;
		int winOrSwing = 0;
		int loseOrHit = 0;
		double dfcOrHitRate = 0.0;
		StringTokenizer st;

		BufferedReader bfReader;

		try {
			bfReader = new BufferedReader(new FileReader(t.teamData));
			String str;
			String tempTeamInfo[];

			while ((str = bfReader.readLine()) != null) {
				st = new StringTokenizer(str, "\t");
				tempTeamInfo = str.split("\t");
//					System.out.println(Arrays.toString(tempTeamInfo));

				if (tempTeamInfo[0].equals("선수번호")) {
				} else {
					st.nextToken();
					st.nextToken();
					name = st.nextToken();
					age = Integer.parseInt(st.nextToken());
					height = Double.parseDouble(st.nextToken());
					winOrSwing = Integer.parseInt(st.nextToken());
					loseOrHit = Integer.parseInt(st.nextToken());

					if (tempTeamInfo[1].equals("투수")) { // 투수인 경우
						dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0
								: ((double) winOrSwing) / (winOrSwing + loseOrHit);
						dfcOrHitRate = (Math.round(dfcOrHitRate * 100)) / 100.0;
						TeamDAOSingleton.team.put(count, (new PitcherDTO(count, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate)));
						count++;
					} else { // 타자인 경우
						dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) loseOrHit) / (winOrSwing);
						dfcOrHitRate = (Math.round(dfcOrHitRate * 100)) / 100.0;
						TeamDAOSingleton.team.put(count, (new BatterDTO(count, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate)));
						count++;
					}
				}
			}
			TeamDAOSingleton.tblTuple = new Object[TeamDAOSingleton.team.size()][11];
			
			Iterator it = TeamDAOSingleton.team.keySet().iterator();
			int key;
			PitcherDTO p;
			BatterDTO b;
			while( it.hasNext() ) {
				key = (int)it.next();
				if( TeamDAOSingleton.team.get(key) instanceof PitcherDTO) {
					p = (PitcherDTO)TeamDAOSingleton.team.get(key);
					TeamDAOSingleton.tblTuple[key-1][0] = p.getNum();
					TeamDAOSingleton.tblTuple[key-1][1] = "투수";
					TeamDAOSingleton.tblTuple[key-1][2] = p.getName();
					TeamDAOSingleton.tblTuple[key-1][3] = p.getAge();
					TeamDAOSingleton.tblTuple[key-1][4] = p.getHeight();
					TeamDAOSingleton.tblTuple[key-1][5] = p.getWin();
					TeamDAOSingleton.tblTuple[key-1][6] = p.getLose();
					TeamDAOSingleton.tblTuple[key-1][7] = p.getDefenceRate();
					TeamDAOSingleton.tblTuple[key-1][8] = " ";
					TeamDAOSingleton.tblTuple[key-1][9] = " ";
					TeamDAOSingleton.tblTuple[key-1][10] = " ";
				}else {
					b = (BatterDTO)TeamDAOSingleton.team.get(key);
					TeamDAOSingleton.tblTuple[key-1][0] = b.getNum();
					TeamDAOSingleton.tblTuple[key-1][1] = "타자";
					TeamDAOSingleton.tblTuple[key-1][2] = b.getName();
					TeamDAOSingleton.tblTuple[key-1][3] = b.getAge();
					TeamDAOSingleton.tblTuple[key-1][4] = b.getHeight();
					TeamDAOSingleton.tblTuple[key-1][5] = " ";
					TeamDAOSingleton.tblTuple[key-1][6] = " ";
					TeamDAOSingleton.tblTuple[key-1][7] = " ";
					TeamDAOSingleton.tblTuple[key-1][8] = b.getSwing();
					TeamDAOSingleton.tblTuple[key-1][9] = b.getHit();
					TeamDAOSingleton.tblTuple[key-1][10] = b.getHitRate();
				}
			}
			
			bfReader.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일 읽기 오류. 파일 검사 요망.");
		}
		return;

	}

	// 리스트->파일 갱신
	public static void syncListToFile() {
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

		try {
			FileWriter fileW = new FileWriter(t.teamData, false);
			fileW.write("선수번호\t구분\t이름\t나이\t신장\t승\t패\t승률\t타석\t유효타\t타율");

			for (int i = 1; i < TeamDAOSingleton.team.size()+1; i++) {
				if (TeamDAOSingleton.team.get(i) instanceof PitcherDTO) { // 투수인 경우
					ptc = (PitcherDTO) TeamDAOSingleton.team.get(i);
					number = ptc.getNum();
					name = ptc.getName();
					age = ptc.getAge();
					height = ptc.getHeight();
					winOrSwing = ptc.getWin();
					loseOrHit = ptc.getLose();
					dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0
							: ((double) winOrSwing) / (winOrSwing + loseOrHit);
					dfcOrHitRate = (Math.round(dfcOrHitRate * 100)) / 100.0;
					fileW.write("\n" + number + "\t투수\t" + name + "\t" + age + "\t" + height + "\t" + winOrSwing + "\t"
							+ loseOrHit + "\t" + dfcOrHitRate);
				} else { // 타자인 경우
					btt = (BatterDTO) TeamDAOSingleton.team.get(i);
					number = btt.getNum();
					name = btt.getName();
					age = btt.getAge();
					height = btt.getHeight();
					winOrSwing = btt.getSwing();
					loseOrHit = btt.getHit();
					dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) loseOrHit) / (winOrSwing);
					dfcOrHitRate = (Math.round(dfcOrHitRate * 100)) / 100.0;
					fileW.write("\n" + number + "\t타자\t" + name + "\t" + age + "\t" + height + "\t\t\t\t" + winOrSwing
							+ "\t" + loseOrHit + "\t" + dfcOrHitRate);
				}
			}
			fileW.close();

		} catch (Exception e) {

		}
	}

}
