import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReviewTemp {
	public static void main(String[] args) {
		List<String> lst = new ArrayList<>();
		
		Map<Integer, String> m = new HashMap<>();
		
		m.put(1, "1111");
		m.put(2, "22222");
		m.put(3, "3333");
		m.put(4, "4444");
		
		Iterator it = m.keySet().iterator();
		
		for( ; it.hasNext() ; ) {
			System.out.println(it.next().toString());
		}
		
		for (int i = 0; i < 50; i++) {
			m.put(i, i+i+i+i+"");
		}
		
		it = m.keySet().iterator();
		
		for( ; it.hasNext() ; ) {
			System.out.println(it.next().getClass());
		}
	}
}
