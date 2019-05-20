
public class Lct3_Wrapper {
	/*
	 * Wrapper Class
	 * 
	 * 일반 자료형(char, int, double)을 클래스화 한 것
	 * 
	 * 일반 자료형 wrapper class 중요 boolean Boolean byte Byte short Short int Integer ***
	 * long Long float Float double Double *** char Charactor char[] String ***
	 */
	void play1() {
		// String
		System.out.println(String.valueOf(123123));

		// Integer
		int i = 12;
		Integer iObj = 34;
		Integer iObj2 = new Integer(i);
		System.out.println("syso Integer + Integer = " + iObj + iObj2.intValue());
		System.out.println("syso (Integer + Integer) = " + (iObj + iObj2.intValue()));
		String numStr = "234";
		int strNum = Integer.parseInt(numStr);

		// Double
		Double d = 234.5678;
		Double d1 = new Double(345.6789);
		double dd = d;

		// 문자열 -> 실수
		String dblStr2 = "56.78";
		double d2 = Double.parseDouble(dblStr2);
		System.out.println("d2 + 2 : " + (d + 2));
		System.out.println("d2.toString() : " + d.toString() + 2);
	}

	void memo1() {
		//교수님 작성본
		/*
		 * Wrapper class 일반 자료형(char, int, double)을 클래스화 한것
		 * 
		 * 일반 자료형 wrapper class boolean Boolean
		 * 
		 * byte Byte short Short int Integer ------------------------- long Long
		 * 
		 * float Float double Double -------------------------
		 * 
		 * char Character char[] String -------------------------
		 * 
		 * String 숫자 ==> 문자열 String.valueOf('1') -> "1" String.valueOf(12) -> "12"
		 * String.valueOf(12.345) -> "12.345"
		 * 
		 * 12 + ""; 12.345 + "";
		 */

		// Integer == int
		int i = 12;
		Integer iObj = 34;
		Integer _iObj = new Integer(i);
		int num = iObj.intValue();
		int _num = iObj;
		System.out.println("_num = " + _num);

		// 숫자 -> 문자열 toString()
		String nstr = iObj.toString(); // 34 -> "34"
		nstr = iObj + "";

		// 문자열 -> 숫자
		String numStr = "234";
		int number = Integer.parseInt(numStr);
		System.out.println(number + 11);

		// 실수
		Double d = 234.5678;
		Double d1 = new Double(345.6789);
		double dd = d;

		// 실수 -> 문자열
		String sd = d.toString();
		sd = d + "";

		// 문자열 -> 실수
		String dStrNum = "56.78";
		double d2 = Double.parseDouble(dStrNum);

		System.out.println("d2 = " + (d2 + 11));
	}
}
