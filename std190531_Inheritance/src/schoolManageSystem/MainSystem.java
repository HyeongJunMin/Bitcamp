package schoolManageSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainSystem {
	public static void main(String[] args) {
		Map<String, Double> gradeOfEachSubject = new LinkedHashMap<String, Double>();
		Map<String, Double> gradeOfEachSubject2 = new LinkedHashMap<String, Double>();
		List<Map> grades = new ArrayList<>();
		
		//학생1의 성적 입력 키:과목, 밸류:점수
		gradeOfEachSubject.put("Java", 4.0);
		gradeOfEachSubject.put("c", 3.0);
		gradeOfEachSubject.put("전산영어", 3.5);

		//학생1의 성적이 담긴 LinkedHashMap을 ArrayList grades에 저장(add)
		grades.add(gradeOfEachSubject);
		
		//학생2의 성적 입력 키:과목, 밸류:점수
		gradeOfEachSubject2.put("Java", 2.0);
		gradeOfEachSubject2.put("c", 2.0);
		gradeOfEachSubject2.put("전산영어", 2.5);

		//학생1의 성적이 담긴 LinkedHashMap을 ArrayList grades에 저장(add)
		grades.add(gradeOfEachSubject2);
		
//		for( int i = 0 ; i < grades.size() ; i++ ) {
//			Set<String> subject = grades.get(i).keySet();
//			Iterator<String> iter = subject.iterator();
//			String str;
//			while( iter.hasNext() ) {
//				str = iter.next()+"";
//				System.out.print("과목: " + str +"  점수: " + grades.get(i).get(str)+"  ");
//			}
//			System.out.println();
//		}
		
		for(Map<String, Double> m : grades) {
			Set<String> subjects = m.keySet();
			Iterator<String> iter = subjects.iterator();
			String str;
			while(iter.hasNext()) {
				str = iter.next()+"";
				System.out.print("과목: " + str +"  점수: " + m.get(str)+"  ");
			}
			System.out.println();
		}
	}
}
