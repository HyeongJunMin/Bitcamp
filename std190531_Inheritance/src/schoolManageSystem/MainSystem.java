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
		
		//�л�1�� ���� �Է� Ű:����, ���:����
		gradeOfEachSubject.put("Java", 4.0);
		gradeOfEachSubject.put("c", 3.0);
		gradeOfEachSubject.put("���꿵��", 3.5);

		//�л�1�� ������ ��� LinkedHashMap�� ArrayList grades�� ����(add)
		grades.add(gradeOfEachSubject);
		
		//�л�2�� ���� �Է� Ű:����, ���:����
		gradeOfEachSubject2.put("Java", 2.0);
		gradeOfEachSubject2.put("c", 2.0);
		gradeOfEachSubject2.put("���꿵��", 2.5);

		//�л�1�� ������ ��� LinkedHashMap�� ArrayList grades�� ����(add)
		grades.add(gradeOfEachSubject2);
		
//		for( int i = 0 ; i < grades.size() ; i++ ) {
//			Set<String> subject = grades.get(i).keySet();
//			Iterator<String> iter = subject.iterator();
//			String str;
//			while( iter.hasNext() ) {
//				str = iter.next()+"";
//				System.out.print("����: " + str +"  ����: " + grades.get(i).get(str)+"  ");
//			}
//			System.out.println();
//		}
		
		for(Map<String, Double> m : grades) {
			Set<String> subjects = m.keySet();
			Iterator<String> iter = subjects.iterator();
			String str;
			while(iter.hasNext()) {
				str = iter.next()+"";
				System.out.print("����: " + str +"  ����: " + m.get(str)+"  ");
			}
			System.out.println();
		}
	}
}
