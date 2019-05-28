package std190528_Object_Calendar;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Lct2Tokenizer {
	public static void main(String[] args) {
		tok1();
	}
	
	static void tok1() {
		
		//split - 빈문자열도 문자로 취급
		//StringTokenizer - 빈문자열 무시
		String str = "홍길동-2001/03/14-서울시";
		String[] spl = str.split("-");
		int index = 0;
		for(String sss : spl) {
			System.out.print(sss + " "  );
		}
		
		//str을 "-"로 자르겠다
		StringTokenizer st = new StringTokenizer(str, "-");
		int len = st.countTokens(); //자르고 넘긴 문자열의 길이
		System.out.println("\n" + len);
		
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		
	}
}
