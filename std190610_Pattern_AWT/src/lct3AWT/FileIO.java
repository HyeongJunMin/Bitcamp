package lct3AWT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FileIO {
	private static FileIO single = null;
	public static Map<Integer, HumanDTO> team;
	public static File teamData;
	
	private FileIO() {
		team = new HashMap<Integer, HumanDTO>();
		teamData = new File("D:\\tmp\\baseballteam.txt");
		FileIO.syncFileToList();
	}
	
	public static FileIO getInstance() {
		if(single == null) {
			single = new FileIO();
		}		
		return single;
	}
	
	public static void syncFileToList() {
		
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
			bfReader = new BufferedReader(new FileReader(teamData));
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
						team.put(count, (new PitcherDTO(count, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate)));
						count++;
					} else { // 타자인 경우
						dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) loseOrHit) / (winOrSwing);
						dfcOrHitRate = (Math.round(dfcOrHitRate * 100)) / 100.0;
						team.put(count, (new BatterDTO(count, name, age, height, winOrSwing, loseOrHit, dfcOrHitRate)));
						count++;
					}
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
			FileWriter fileW = new FileWriter(teamData, false);
			fileW.write("선수번호\t구분\t이름\t나이\t신장\t승\t패\t승률\t타석\t유효타\t타율");

			for (int i = 1; i < team.size()+1; i++) {
				if (team.get(i) instanceof PitcherDTO) { // 투수인 경우
					ptc = (PitcherDTO) team.get(i);
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
					btt = (BatterDTO) team.get(i);
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
