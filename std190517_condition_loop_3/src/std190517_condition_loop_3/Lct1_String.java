package std190517_condition_loop_3;

public class Lct1_String {
	// Lecture 1. String
	// String : 문자열
	// Wrapper class
	void play1() {
		String str;
		// String 클래스명 == class template(형태)
		// 인스턴스 == 주체 == 실질적으로 내가 접근해야 할
		str = "안녕하세요";
		System.out.println(str);

		String str1 = new String("hi");
		// 생성자를 사용한 선언 및 초기화
		// new == 동적할당 == 포인터를 사용하는겁니다. 포인터를 쓰는 이유에 대해서는 나중에 말씀해주신대요 :)

		String str2 = " NTMY";
		String str3 = str1 + str2; // 문자열 합
		System.out.println(str3);

		// concat() 메서드 == 문자열 합치기 메서드
		String str4 = " hh";
		String str5 = str3.concat(str4);
		System.out.println(str5);

		char cdata[] = { 'h', 'e', 'l', 'l', 'o' };
		String str6 = new String(cdata);
		System.out.println(str6);

		String str7 = "hello";
		String str8 = "hello";
		if (str7 == str8)
			System.out.println("str7 == str8");
		else
			System.out.println("str7 != str8");

		str8 = "hell";
		str8 = str8 + "o";

		if (str7 == str8)
			System.out.println("str7 == str8");
		else
			System.out.println("str7 != str8");
		// String 변수의 ==연산은 초기화 내용만 비교되기 때문에 잘못된 결과값이 나옴.
		// 초기화 내용 외에 변수의 현재값을 적용하지 못함

		if (str7.equals(str8))
			System.out.println("str7 == str8");
		else
			System.out.println("str7 != str8");
		// 변수의 현재 값을 비교하기 위해서는 equals method를 사용해야 함.

		boolean b1 = str7.equals(str8);
		System.out.println(b1);

		String str9 = "asdasdasdasd";
		int n = str9.indexOf("d"); // 문자열의 앞부분 부터 입력받은 문자열 또는 문자 탐색해서 index return
		System.out.println("str9.indexOf() : " + n);

		n = str9.lastIndexOf("d"); // 문자열의 끝부분 부터 입력받은 문자열 또는 문자 탐색해서 index return
		System.out.println("str9.lastIndexOf() : " + n);

		int len = str9.length(); // 문자열의 길이 return
		System.out.println("str9.length() : " + len);

		String str10 = "A*B*C*D";
		String repStr = str10.replace("*", "-"); // 변수의 인수1을 인수2로 수정
		System.out.println("str10.replace(\"*\", \"-\") : " + repStr);
		str10 = "형용사형 methodless | methodical";
		repStr = str10.replace("|", "");
		System.out.println("str10.replace(\"|\", \"\") : " + repStr);

		// split == token을 이용해서 문자열을 자르는 작업을 수행
		// token은 뭡니까? 구분자입니다.
		String str11 = "홍길동-24-2001/01/13-서울시";
		String splStr11[] = str11.split("-");
		for (String a : splStr11)
			System.out.print(a + " ");
		System.out.println();

		// substring == beginIndex ~ endIndex 문자열 출력
		String subStr = str11.substring(1);
		System.out.println("str11.substring(1) : " + subStr);
		subStr = str11.substring(1, 3);
		System.out.println("str11.substring(2, 3) : " + subStr);

		// toUpperCase, toLowerCase
		String str12 = "abcABC";
		String upStr = str12.toUpperCase();
		String loStr = str12.toLowerCase();
		System.out.println("str12.toUpperCase() : " + upStr);
		System.out.println("str12.toLowerCase() : " + loStr);
		
		//	toString
		String str13 = "안녕하세요";
		System.out.println(str13.toString());
		
		//	trim	==	공백을 제거하는 메서드(앞부분과 뒷부분)
		String str14 = "              java java  java   ";
		String trimStr = str14.trim();
		System.out.println("str14 : " + str14);
		System.out.println("str14.trim() : " + trimStr);
		System.out.println("str14.replace(\" \", \"\") : "+str14.replace(" ", ""));
		
		//	valueOf	==	숫자를 문자열로, 문자열을 숫자로 형 변환
		int num = 1;
		long lo = 1234L;
		double d = 123.4567;
		String sNum = String.valueOf(num);
		String sLo = String.valueOf(lo);
		String sD = String.valueOf(d);
		System.out.println("sNum : " + sNum + num);
		System.out.println("sLo : " + sLo);
		System.out.println("sD : " + sD);
		String sNum2 = num + "";
		System.out.println("sNum2 : " + sNum2);
		
		//	contains	탐색(알고리즘 4대요소 중 하나)
		String str15 = "서울시 강남구";
		boolean b2 = str15.contains("서울");
		if(b2 == true)
			System.out.println("문자열을 찾았습니다.");
		else
			System.out.println("문자열을 찾지 못했습니다.");
		
		//	charAt		입력된 index에 맞는 문자를 리턴
		String str16 = "abcdefg";
		char ch2 = str16.charAt(5);
		System.out.println("str16.charAt(5) : " + ch2);
		
	}

}









//공백