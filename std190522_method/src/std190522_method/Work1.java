package std190522_method;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Work1 {
	// 두 점 간 거리 측정 메소드
	static double getDistance(int x, int y, int x1, int y1) {
		double distance = 0.0;
			
		distance =  Math.sqrt( Math.pow( Math.abs(x-x1), 2 ) + Math.pow( Math.abs(y - y1), 2 ) );
				
		return distance;		
	}
	
	// 배열의 값을 섞는 메소드
	int[] shuffle(int[] arr) {
		int arrLen = arr.length;
		int w = 0;
		int rndTemp = 0;
		
		boolean[] rnd_bool = new boolean[arrLen];
		
		while( w < arrLen ) {
			rndTemp = (int)( Math.random() * arrLen );
			if( rnd_bool[rndTemp] == false ) {
				rnd_bool[rndTemp] = true;
				arr[w] = rndTemp + 1;
				w++;
			}
		}	
		
		return arr;
	}
	
	// 배열의 값에 2배를 곱하여 반환하는 메소드
	int[] getDouble(int[] arr) {		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * 10;
		}		
		return arr;
	}
	
	int maxNum(int[] arr) {
		int max = 0;
		if( arr == null || arr.length == 0) {
			max = -999999;
		}else {
			for(int i : arr) {
				if( i > max) {
					max = i;
				}
			}	
		}
					
		
		return max;
	}
	
	//입력된 문자열 값이 정수인지 아닌지 판단하는 메소드 
	boolean isNumber(String str) {
		boolean isNum = false;
		
		if( str == null || str.length() == 0)
			return false;
				
		for (int i = 0; i < str.length(); i++) {
			if( str.charAt(i) < '0' || str.charAt(i) > '9') {
				isNum = false;
			}else
				isNum = true;
		}
		return isNum;
	}
	
	//입력된 문자열 값이 실수인지 아닌지 판단하는 메소드
	String isDoubleType(String str) {
		String isDouble = "똑바로하세요";
		
		if( str.contains(".") ) {
			isDouble = "실수입니다.";
		} else {
			isDouble = "정수입니다.";
		}
		
		return isDouble;
	}
	
	//암호화-복호화 프로그램
	//HashMap을 활용한암호화 메소드
	String encStrByHashMap(String str) {
		String thisStr = str.toUpperCase();
		String encStr = "";
		char[] abcCode =
			{ 	'`','~','!','@','#','$','%','^','&','*',
				'(',')','-','_','+','=','|','[',']','{',
				'}',';',':',',','.','/'};
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		
		for (int i = 0; i < str.length(); i++) {
			if( (int)thisStr.charAt(i) >= (int)'0' && (int)thisStr.charAt(i) <= (int)'9' ) {
				encStr += numCode[((int)thisStr.charAt(i))-48];
			} else if( thisStr.charAt(i) <= 'Z' && thisStr.charAt(i) >= 'A' ) {
				encStr += abcCode[ (int)(thisStr.charAt(i)) - 65];
			} else {
				encStr += "_";
			}
		}
		
		return encStr;
	}
	
	//HashMap을 활용한 복호화 메소드 
	String dcrStrByHashMap(String str) {
		int strLen = str.length();
		String dcrStr = "";
		
		char[] abcCode =
			{ 	'`','~','!','@','#','$','%','^','&','*',
				'(',')','-','_','+','=','|','[',']','{',
				'}',';',':',',','.','/', 'q','w','e','r','t','y','u','i','o','p'};;
		
		// HashMap 설정. key갑에 따라 value는 영 소문자 'a' ~ 'z'
		Map<Character, Character> abcCharMap = new HashMap<>();
		for(int i = 0 ; i < 26 ; i++) {
			abcCharMap.put(abcCode[i], (char)(i+(int)'a'));
		}
		
		// HashMap 설정 key값에 따라 value는 숫자 0~9까지 
		for(int i = 48 ; i < 58 ; i++) {
			abcCharMap.put(abcCode[i-22], (char)i);
		}
		
		for(int i = 0 ; i < strLen ; i++ ) {
			dcrStr += abcCharMap.get(str.charAt(i));
		}	
		return dcrStr;
	}
	
	//HashMap 없이 암호화
	String encStr(String str) {
		String result = "";
		int strLen = str.length();
		char chTemp = '1';
		String encStr = "";
		char[] abcCode =
			{ 	'`','~','!','@','#','$','%','^','&','*',
				'(',')','-','_','+','=','|','[',']','{',
				'}',';',':',',','.','/'};
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		
		if(str == null || strLen == 0 ) {
			str = "input right value";
		} else {
			for (int i = 0; i < strLen; i++) {
				chTemp = str.charAt(i);
				if(chTemp >= 'a' && chTemp <= 'z') {
					result += abcCode[((int)chTemp)-97];
					
				}else if(chTemp >= '0' && chTemp <= '9'){
					result += numCode[((int)chTemp)-48];					
				}
			}
		}	
		
		return result;
	}
	
	//HashMap 없이 복호화
	String dcrStr(String str) {
		String result = "";
		int strLen = str.length() ;
		char chTemp = '1';
		char[] abcCode =
			{ 	'`','~','!','@','#','$','%','^','&','*',
				'(',')','-','_','+','=','|','[',']','{',
				'}',';',':',',','.','/'};
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		
		//복호화 암호표 작성
//		int[] reverseAbcCode = new int[abcCode.length];
//		for(int i = 0 ; i < abcCode.length ; i++ ) {
//			reverseAbcCode[i] = (int)(abcCode[i]);
//		}	//96 126 33 64 35 36 37 94 38 42 40 41 45 95 43 61 124 91 93 123 125 59 58 44 46 47 
//		
//		int[] reverseNumCode = new int[numCode.length];
//		for(int i = 0 ; i < numCode.length ; i++ ) {
//			reverseNumCode[i] = (int)(numCode[i]);
//		}
		
		//알파벳으로 들어오면? reverseNumCode의 인덱스를 빼세요 == 숫자
		//특수문자로 들어요면? 
		if(str == null || strLen == 0 ) {
			result = "input right value";
		} else {
			for (int i = 0; i < strLen; i++) {
				chTemp = str.charAt(i);
				if(chTemp >= 'a' && chTemp <= 'z') {//charAt(i)가 알파벳이면?
					for(int j = 0 ; j < numCode.length ; j++) {
						if(chTemp == (char)numCode[j]) {
							result += j+"";							
							break;
						}//charAt(i)가 numCode 요소와 같을 때 ? 해당 요소의 index값을 결과 문자열에 누적
					}					
				}else {//charAt(i)가 알파벳이 아니라면? abcCode의 index값+97을 결과 문자열에 누적
					for(int j = 0 ; j < abcCode.length ; j++ ) {
						if(chTemp == abcCode[j]) {
							result += (char)(j+97);
							break;
						}
					}
				}
			}
		}	
		
		
		return result;
	}
	
}
