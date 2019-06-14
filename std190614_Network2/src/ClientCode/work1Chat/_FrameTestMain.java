package work1Chat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _FrameTestMain {
	public static void main(String[] args) {
		new _ThreadTest().start();
		
		List<_ThreadTest> l = new ArrayList<>();
		
		l.add(new _ThreadTest());
		l.add(new _ThreadTest());
		l.add(new _ThreadTest());
		System.out.println(l.size());
		for (Iterator iterator = l.iterator(); iterator.hasNext();) {
			_ThreadTest _ThreadTest = (_ThreadTest) iterator.next();
			System.out.println(_ThreadTest.toString()+ "    " + _ThreadTest.hashCode());
			
		}
	}
}
