package baseballTeamUsingMap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TeamManageMain {
	public static void main(String[] args) {
		HumanDTO h = new PitcherDTO(1, "นฮวüมุ", 29, 175.5, 1, 1, 50.0);

		
//		TeamDAO tt = new TeamDAO();
//		tt.printAllTeammates();
//		
//		tt.printAllTeammates();
//		tt.sortByHitRateUsingHashMap();
//		tt.sortByWinRateUsingTreeMap();
//		tt.sortByWinRateUsingTreeMap();
		
		String ab = "qwe\tqweqwe\tdfg\tdfcvb\tdfv";
		File f = new File("d:\\tmp\\tttttt.xls");
		try {
			FileWriter fw = new FileWriter( f , true );
			
			String[] abb = ab.split("\t");
			
			for(String s : abb) {
				fw.write(s);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
