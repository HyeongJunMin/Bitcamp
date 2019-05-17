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
	}

}
