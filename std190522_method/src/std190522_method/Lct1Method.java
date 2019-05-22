package std190522_method;

import java.util.List;

public class Lct1Method {
	/*
	 * function : 함수
	 * 			: 특정 처리를 하기 위한 프로세스
	 * 
	 * 구성 : return값( 자료형 ), 매개변수( 인수, 인자, parameter ) = 자료형
	 * 
	 * 형태 : 
	 * return값 함수명(매개변수1, 매개변수2, ... ) {
	 * 		처리영역
	 * 
	 * 		return 값;
	 * }
	 * 
	 * void : 형태가 없는 자료형
	 * 
	 * */
	
	char alterBetweenCharAndInt(int a) {
		char b = (char)a;
		return b;
	}
	int alterBetweenCharAndInt(char c) {
		int d = (int)c;
		return d;
	}
	
	char toUpperChar(char e) {
		return (char)((int)e-32); 
	}
	
	List timesTen(List<Integer> a) {
		for(Integer i : a )
			a.set( a.indexOf(i) , i*10 );		
		return a; 
	}	
}
