package std190524_method3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lct2TransBinaryAndDecimal {
	/*
	 * 10진수 -> 2진수 변환 메소드 작성
	 * 2진수 -> 10진수 변환 메소드 작성
	 * 
	 * 10진수 -> 16진수 변환 메소드 작성 ( 0x11 )
	 * */
	
	
	//10진수 -> 2진수 스태틱 메소드(내꺼)
	static String transDcmToBnr(int num) {
		String strBinary = "";
		int inputNum = num;
		int multiplier = 0;
		String[] baseStr;
							
		//승수 계산
		while(inputNum > 1) {
			inputNum /= 2;
			multiplier++;
		}
		
		//2진수 배열 초기화
		baseStr=new String[(multiplier/4+1)*4];
		for(int i = 0 ; i < baseStr.length ; i++ ){
			baseStr[i] = "0";
		}
		
		//이진수 계산
		inputNum = num;
		while( multiplier > -1 ) {
			//만약 2의 multiplier승으로 나눈 몫이 1이라면 1 아니면 0 
			if( inputNum / (int)(Math.pow(2, multiplier)) == 1 ) {
				strBinary += "1";
				inputNum -= (int)(Math.pow(2, multiplier));
			}else {
				strBinary += "0";	
			}			
			multiplier--;
		}

		

		//100을 받았다?
		//2^6(64) 1개  2^5(32) 1개, 2^2(4) 1개
		//50-25-12-6-3-1	
		//21-10-5-2-1
		return strBinary;
	}
	
	//2진수 -> 10진수 스태틱 메소드
	static int transBnrToDcm(String bnrStr) {
		int dcm = 0;
		int index = 0 ;
		int strLen = bnrStr.length();
		// length -1 승 부터 계산
		
		for( int i = strLen ; i > 0 ; i-- ) {
			if(bnrStr.charAt(index) == '1') {
				dcm += (int)Math.pow(2, i-1);	
			}			
			index++;
		}
		//1000 들어왔을 때
		//strLen == 4
		//반복은 총 4번되어야 함(8,4,2,1)
		//bnrStr(0) == '1'	0-1-2-3
		
//		while(strLen > -1) {
//			
//			dcm += (int)Math.pow(2, strLen-1);
//			
//			strLen--;
//		}
		
		return dcm;
	}
	
	//10진수 -> 16진수 스태틱 메소드	
	static String transDcmToHex(int num) {
		String strHex = "0x";
		int inputNum = num;
		int multiplier = 0;
		String[] strCharHex = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
				
		//승수 계산
		while(inputNum > 1) {
			inputNum /= 16;
			multiplier++;
		}
		
		//16진수 계산
		inputNum = num;
		while( multiplier > -1 ) {
			//만약 16의 multiplier승으로 나눈 몫이 1이라면 1 아니면 0
			if( inputNum / (int)(Math.pow(16, multiplier)) > 0 ) {
				strHex += strCharHex[ (inputNum / (int)(Math.pow(16, multiplier))) - 1];
				//다음 계산 할 숫자는 기존 숫자를 16^multiplier로 나눈 나머지값 
				inputNum %= (int)(Math.pow(16, multiplier));
			}else if(strHex == "0x"){
					
			}else {
				strHex += "0";
			}
			multiplier--;
		}
		
		return strHex;
	}
	
	
	
	//16진수 -> 10진수 스태틱 메소드
	static int transHexToDcm(String strHex) {
		int dcm = 0;
		int strLen = strHex.length();
		int index = strLen ;
		List<Character> strCharOfHex = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'));
		
		
		// 2AC인 경우
		// 16^2 * 2, 
		for( int i = 0 ; i < strLen ; i++ ) {
			if(strCharOfHex.contains(strHex.charAt(i))) {
				dcm += (int)Math.pow(16, index-1) * (strCharOfHex.indexOf(strHex.charAt(i))+1);	
			}			
			index--;
		}
		
		return dcm;
	}

	//10진수 -> 8진수 스태틱 메소드
	static String transDcmToOct(int num) {
		String strOct = "0";
		int multiplier = 0;
		int inputNum = num;

		// 승수 계산
		while (inputNum > 1) {
			inputNum /= 8;
			multiplier++;
		}

		// 이진수 계산
		inputNum = num;
		while (multiplier > -1) {
			// 매개변수로 받은 수를 8의 multiplier승으로 나눈 몫이 0보다 크면
			// 해당 몫을 문자열에 누적
			// 다음 계산값을 산출하기 위해 매개변수로 받은 수 - (8^n * 몫)
			if (inputNum / (int) (Math.pow(8, multiplier)) > 0) {
				strOct += (inputNum / (int) (Math.pow(8, multiplier)));
				inputNum -= ((int) (Math.pow(8, multiplier)) * (inputNum / (int) (Math.pow(8, multiplier)))) ;
			}else if(strOct == "0") {
				
			}else {
				strOct += "0";
			}
			multiplier--;
		}

		return strOct;
	}

	//8진수 -> 10진수 스태틱 메소드
	static int transOctToDcm(String strOct) {
		int dcm = 0;
		int strLen = strOct.length();
		int index = strLen-2;
		
		for(int i = 1 ; i < strLen ; i++) {
			if( strOct.charAt(i) == '0') {
				index--;
			}else {
				dcm += ((int)(Math.pow(8, index--)) * ( ( (int)strOct.charAt(i))-48 ) );
			}
		}
		
		
		return dcm;
	}
	
}
