package lct1Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HashMapPrac {
	//추가, 삭제, 검색, 수정, 모두출력
	Map<Integer, String> m;
	Scanner in = new Scanner(System.in);
	public HashMapPrac () {
		m = new HashMap<Integer, String>();
	}
	
	public void sortMap() {
		
		
	}
	
	//추가
	public void putKV() {
		//in = new Scanner(System.in);
		
		int k = 0;
		String v = "";
		System.out.print("키 : ");
		k = (int)in.nextInt();
		System.out.print("밸류 : ");
		v = in.next();
		System.out.println(k + "  " + v );
		
		System.out.println("결과 : " + m.put(k, v) );
	}
	
	//삯제
	public void removeKV() {
		int k;
		
		this.printAll();
		System.out.print("삭제할 객체의 키 입력 : ");
		k = in.nextInt();
		
		System.out.println("제거된 쌍의 밸류 : " + m.remove(k));		
	}
	
	//검색
	public void searchKV() {
		int k;
		
		System.out.print("검색할 키 입력 : ");
		k = in.nextInt();
		
		if( m.containsKey(k) ) {
			System.out.println(k + ", " + m.get(k));
		}else {
			System.out.println("해당 키 없음");
		}		
	}
	
	//수정
	public void modKV() {
		int k;
		String v;
		
		System.out.print("수정 대상 키 입력 : ");
		k = in.nextInt();
		System.out.print("새 value 입력 : ");
		v = in.next();
		
		if( m.containsKey(k) ) {
			System.out.println("결과 : " + m.replace(k, v));
		}else {
			System.out.println("해당 키 없음");
		}
	}
	
	//모두출력
	public void printAll() {
		Iterator it = m.keySet().iterator();
		
		while( it.hasNext() ) {
			int k = (int) it.next();
			System.out.println(k + ", " +m.get(k));
		}
		
		System.out.println("출력 종료.");
	}
}
