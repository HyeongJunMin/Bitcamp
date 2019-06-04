package lct1List;

import java.util.ArrayList;
import java.util.List;

public class ListMethods {
	public void play1() {
		//리스트에도 DAO가 있음
		List<Integer> lst = new ArrayList<Integer>();
		
		//리스트에 요소 추가
		Integer in = new Integer(11);
		lst.add(in);
		lst.add(222);
		lst.add(1, 9999);
		lst.add(333);
		lst.remove(2);
		for(int i : lst)
			System.out.print(i+"  ");
		
		
		
	}
}
