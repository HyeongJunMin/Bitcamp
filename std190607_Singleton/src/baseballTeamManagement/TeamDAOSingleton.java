package baseballTeamManagement;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TeamDAOSingleton {
	private static TeamDAOSingleton single = null;
	public static Map<Integer, HumanDTO> team;
	public File teamData;	
	
	private TeamDAOSingleton() {
		team = new HashMap<Integer, HumanDTO>();
		teamData = new File("D:\\tmp\\baseballteam.txt");
		
	}
	
	public static TeamDAOSingleton getInstance() {
		if( single == null ) {
			single = new TeamDAOSingleton();
		}
			
		return single;
	}
}
