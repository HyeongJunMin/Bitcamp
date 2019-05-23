package std190523_method2;

public class Lct1Review190522 {
	//190523 강의내용 복습 - 메소드
	/*
	 * 메소드 == function
	 * 
	 * [메소드의 목적]
	 * 1. 데이터 처리
	 * 2. 소스코드 간략화
	 * 3. 분산
	 * 
	 * [메소드 형식] == [function template]
	 * 자료형 함수이름(매개변수1, 매개변수2, ... ) {
	 * 		처리
	 * 		return 값;
	 * }
	 * 
	 * [메소드 호출 방법]
	 * static인 경우
	 * static이 아닌 경우
	 * 	- void인 경우
	 *  - return값이 있는 경우
	 * 
	 */
	
	//두 수의 몫과 나머지 구하기
	//제한 : 메소드는 하나만 사용해야 함
	static int divProcess(int num1, int num2, int remain[]) {
		int re;
		re = num1 / num2;

		//remain 배열은 주소가 들어오기 때문에 아래처럼 연산해도 매개변수로 입력된 배열이 갖는 값이 수정됨
		remain[0] = num1 % num2;
		
		return re;
	}
	
	//swap 처리를 하는 메소드 제작
	static void swapTwoDecimalNumbers(int num[]) {
		int temp = num[0];
		num[0] = num[1];
		num[1] = temp;
	}
	
	
	
	//	아래는 교수님 작성 내용

	
	
	public static void main(String[] args) {
		/*
		char[] abcCode ={ 	
				'`','~','!','@','#','$','%','^','&','*',
				'(',')','-','_','+','=','|','[',']','{',
				'}',';',':',',','.','/'
		};
							// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		*/
		String src = "bcd234";	
		String result = "";		// `~!wer
		
		result = encode(src);
		
		/*
		for(int i = 0; i < src.length();i++) {
			char ch = src.charAt(i);	// 'a'
			
			int num = (int)ch;	// 아스키 코드를 취득
			
			// 알파벳일 경우 -> 숫자	123
			if(num >= 97 && num <= 122) {
				num = num - 97;	// 'a' == 0으로 셋팅하기 위해서				
				result = result + abcCode[num];
			}
			// 알파벳이 아닐 경우 -> 문자 abc
			else {
				num = num - 48;	// '0' == 0으로 셋팅하기 위해서
				result = result + numCode[num];
			}
		}	
		*/
		System.out.println(src + " 의 암호화는 " + result + " 입니다");	
		
		String originalStr = "";
		
		// result <- 암호화 된 문자열
		char[] abcCode ={ 	
				'`','~','!','@','#','$','%','^','&','*',
				'(',')','-','_','+','=','|','[',']','{',
				'}',';',':',',','.','/'
		};
							// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		
		
		for (int i = 0; i < result.length(); i++) {
			
			// 한문자씩 산출
			char c = result.charAt(i);
			// ASCII code로 변환
			int ascCode = (int)c;
			
			// 알파벳 경우 --> 숫자
			if(ascCode >= 97 && ascCode <= 122) {
				
				int index = 0;
				// 암호표를 대조하면서 몇번째 있는지
				for (int j = 0; j < numCode.length; j++) {
					if(c == numCode[j]) {
						index = j;
						break;
					}
				}
				// 아스키 코드로 맞춰준다
				index = index + 48;	// 2 -> "2"
				// 원본의 문자를 추가한다.
				originalStr = originalStr + (char)index;
			}
			// 아닌 경우 --> 문자
			else {
				int index = 0;
				for (int j = 0; j < abcCode.length; j++) {
					if(c == abcCode[j]) {
						index = j;
						break;
					}
				}
				index = index + 97;
				originalStr = originalStr + (char)index;				
			}			
		}
		System.out.println("복호화된 문자열은 " + originalStr + " 입니다");
		
		
	}
	
	// 암호화
	static String encode(String src) {
		char[] abcCode ={ 	
				'`','~','!','@','#','$','%','^','&','*',
				'(',')','-','_','+','=','|','[',']','{',
				'}',';',':',',','.','/'
		};
							// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
				
		String result = "";	// return으로 넘길 문자열
		
		for(int i = 0; i < src.length();i++) {
			char ch = src.charAt(i);	// 'a'
			
			int num = (int)ch;	// 아스키 코드를 취득
			
			// 알파벳일 경우 -> 숫자	123
			if(num >= 97 && num <= 122) {
				num = num - 97;	// 'a' == 0으로 셋팅하기 위해서				
				result = result + abcCode[num];
			}
			// 알파벳이 아닐 경우 -> 문자 abc
			else {
				num = num - 48;	// '0' == 0으로 셋팅하기 위해서
				result = result + numCode[num];
			}
		}		
		return result;
	}
	
	static String oricode(String src) {
		
	
		return "";
	}
}
