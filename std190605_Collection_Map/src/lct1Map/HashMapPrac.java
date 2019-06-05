package lct1Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HashMapPrac {
	//�߰�, ����, �˻�, ����, ������
	Map<Integer, String> m;
	Scanner in = new Scanner(System.in);
	public HashMapPrac () {
		m = new HashMap<Integer, String>();
	}
	
	public void sortMap() {
		
		
	}
	
	//�߰�
	public void putKV() {
		//in = new Scanner(System.in);
		
		int k = 0;
		String v = "";
		System.out.print("Ű : ");
		k = (int)in.nextInt();
		System.out.print("��� : ");
		v = in.next();
		System.out.println(k + "  " + v );
		
		System.out.println("��� : " + m.put(k, v) );
	}
	
	//����
	public void removeKV() {
		int k;
		
		this.printAll();
		System.out.print("������ ��ü�� Ű �Է� : ");
		k = in.nextInt();
		
		System.out.println("���ŵ� ���� ��� : " + m.remove(k));		
	}
	
	//�˻�
	public void searchKV() {
		int k;
		
		System.out.print("�˻��� Ű �Է� : ");
		k = in.nextInt();
		
		if( m.containsKey(k) ) {
			System.out.println(k + ", " + m.get(k));
		}else {
			System.out.println("�ش� Ű ����");
		}		
	}
	
	//����
	public void modKV() {
		int k;
		String v;
		
		System.out.print("���� ��� Ű �Է� : ");
		k = in.nextInt();
		System.out.print("�� value �Է� : ");
		v = in.next();
		
		if( m.containsKey(k) ) {
			System.out.println("��� : " + m.replace(k, v));
		}else {
			System.out.println("�ش� Ű ����");
		}
	}
	
	//������
	public void printAll() {
		Iterator it = m.keySet().iterator();
		
		while( it.hasNext() ) {
			int k = (int) it.next();
			System.out.println(k + ", " +m.get(k));
		}
		
		System.out.println("��� ����.");
	}
}
