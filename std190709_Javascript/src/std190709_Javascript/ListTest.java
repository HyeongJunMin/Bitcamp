package std190709_Javascript;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> lstBbsTable = new ArrayList<List<String>>();
		List<String> lst = new ArrayList<String>();
		
		lst.add("1");
		lst.add("2");
		lst.add("3");
		lst.add("4");
		lst.add("5");
		
		lstBbsTable.add(lst);
		lst.clear();
		
		lst.add("6");
		lst.add("7");
		lst.add("8");
		lst.add("9");
		lst.add("0");
		
		lstBbsTable.add(lst);
		lst.clear();
		
		lst.add("a");
		lst.add("b");
		lst.add("c");
		lst.add("d");
		lst.add("e");
		
		lstBbsTable.add(lst);
		lst.clear();
		
		for(int i = 0 ; i < lstBbsTable.size(); i++) {
			for(int j = 0 ; j < lstBbsTable.get(i).size(); j++) {
				System.out.print(lstBbsTable.get(i).get(j));
			}
			System.out.println();
		}
	}

}
