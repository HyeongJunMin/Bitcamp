package lct1List;

import java.util.ArrayList;
import java.util.List;

public class ListMethods {
	public void play1() {
		//����Ʈ���� DAO�� ����
		List<Integer> lst = new ArrayList<Integer>();
		
		//����Ʈ�� ��� �߰�
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
