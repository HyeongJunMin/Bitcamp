package baseballTeamManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FncSort implements DAOInterface{
	public void process() {
		int sltSortClm = 0;
		
		System.out.println("정렬 기준을 선택하세요.");
		System.out.println("(1)승률, (2)타율, (3)나이");
		sltSortClm = FncStatic.inputUntilInteger();
		
		switch( sltSortClm ) {
			case 1: this.sortByWinRateUsingTreeMap();  break;
			case 2: this.sortByHitRateUsingHashMap();  break;
			case 3: this.sortByAge();  break;
			default : break;
		}		
		
		
	}
	
	//타자-투수 순서로 리스트 정렬
		private void sortBatterToPitcher() {
			List<Integer> battersIndex = new ArrayList<>();
			List<Integer> pitcherIndex = new ArrayList<>();
			List<HumanDTO> newTeam =  new ArrayList<>();
			
			Iterator it = TeamDAOSingleton.team.keySet().iterator();
			
			while( it.hasNext() ) {
				HumanDTO h = (HumanDTO) TeamDAOSingleton.team.get(it.next());
				
				if( h instanceof BatterDTO ) {		//타자의 경우
					battersIndex.add(TeamDAOSingleton.team.get(h).getNum());
				} else {		//투수의 경우
					pitcherIndex.add(TeamDAOSingleton.team.get(h).getNum());
				}
			}
			
			battersIndex.addAll(pitcherIndex);
			for( int i : battersIndex) {
				newTeam.add(TeamDAOSingleton.team.get(i));
			}					
		}

		//TreeMap을 활용하여 투수 승률 순서로 리스트 정렬 및 출력
		public void sortByWinRateUsingTreeMap() {
			
			PitcherDTO p1 ;
			PitcherDTO p2;

			TreeMap<Double, PitcherDTO> m = new TreeMap<>();
			
			for(int i = 1 ; i < TeamDAOSingleton.team.size()+1; i++ ) {
				if( TeamDAOSingleton.team.get(i) instanceof PitcherDTO ) {
					p1 = (PitcherDTO)TeamDAOSingleton.team.get(i);
					m.put(p1.getDefenceRate(), p1);
				}
			}
			
			Iterator it = m.descendingKeySet().iterator();
			double wr;
			while( it.hasNext() ) {
				wr = (double)it.next();
				for (int i = 1; i < TeamDAOSingleton.team.size() + 1; i++) {					
					if( TeamDAOSingleton.team.get(i) instanceof PitcherDTO ) {
						p2 = (PitcherDTO)TeamDAOSingleton.team.get(i);
						if(p2.getDefenceRate() == wr) {
							System.out.println(p2.toString());
							break;
						}				
					}
				}
			}
		}
		
		// HashMap을 활용하여 타자 타율 순서로 리스트 정렬
		public void sortByHitRateUsingHashMap() {
			TeamDAOSingleton.getInstance();
			
			BatterDTO p1;
			BatterDTO p2;

			Map<Double, BatterDTO> m = new HashMap<>();

			for (int i = 1; i < TeamDAOSingleton.team.size() + 1 ; i++) {
				if (TeamDAOSingleton.team.get(i) instanceof BatterDTO) { // 타자만 Map에 모으기
					p1 = (BatterDTO) TeamDAOSingleton.team.get(i);
					m.put(p1.getHitRate(), new BatterDTO(p1.getNum(), p1.getName(), p1.getAge(), p1.getHeight(), p1.getSwing(),
							p1.getHit(), p1.getHitRate()));
				}
			}

			Iterator it = m.keySet().iterator();
			double[] aa = new double[m.size()];
			
			int w=0;
			while( it.hasNext() ) {
				aa[w++] = (double)it.next();
			}
			
			it = m.keySet().iterator();
			double check;

		for (int i = aa.length; i > 0; i--) {

			for (int j = 1; TeamDAOSingleton.team.size() + 1 > j; j++) {
				if (TeamDAOSingleton.team.get(j) instanceof BatterDTO) {
					p1 = (BatterDTO) TeamDAOSingleton.team.get(j);

					if (p1.getHitRate() == aa[i - 1]) {
						System.out.println(p1.toString());
						break;
					}
				}
			}
		}			
			
		}
		
		//나이 순서로 리스트 정렬
		public void sortByAge() {
			TreeMap<Integer, HumanDTO> m = new TreeMap<>();
			
			for(int i = 1 ; i < TeamDAOSingleton.team.size()+1; i++ ) {
				m.put(TeamDAOSingleton.team.get(i).getAge(), TeamDAOSingleton.team.get(i));
			}
			
			Iterator it = m.descendingKeySet().iterator();
			int age;
			while( it.hasNext() ) {
				age = (int)it.next();
				System.out.println(m.get(age));
			}					
		}
		
}
