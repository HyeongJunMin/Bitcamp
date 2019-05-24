package std190524_method3;

public class Lct3ExplainLct2 {
	//10진수 -> 2진수 스태틱 메소드(교수님 코드)
	static String transDcmToBnrByTch(int num) {
		String result="";
		int tag=0;
		
		while(true) {
			tag = num % 2;
			result = tag + result;
			if( num / 2 == 0 ) {
				break;
			}
			num = num / 2;
		}
		
		return result;
	}
	
	//2진수 -> 10진수 스태틱 메소드(교수님 코드)
	static int transBnrToDcmByTch(String num) {
		int result = 0 ;
		int multiplicator = 0;
		int multiplier = 0;
		int numLen = num.length();
		char c;
		
		for(int i = 0 ; i < num.length() ; i++) {
			c = num.charAt(i);
			multiplicator = Integer.parseInt(c + "");
			multiplier = (int)Math.pow(2, numLen-1);
			multiplicator *= multiplier;
			numLen--;
			result += multiplicator;
		}			
		return result;
	}

	//10진수 -> 16진수 스태틱 메소드(교수님 코드)
	static String transDcmToHexByTch(int num) {
		int tag;
		String strHex = "";
		String str = " ";
		
		while(true) {
			tag = num % 16;
			
			switch(tag) {
			case 10:
				str = "A";
				break;
			case 11:
				str = "B";
				break;
			case 12:
				str = "C";
				break;
			case 13:
				str = "D";
				break;
			case 14:
				str = "E";
				break;
			case 15:
				str = "F";
				break;
			default :
				str = tag + "";
				break;
			}
			
			strHex = str + strHex;
			
			if( num / 16 == 0 ) {
				break;
			}
			num = num / 16;
		}
		
		return "0x" + strHex;
	}

	//16진수 -> 10진수 스태틱 메소드(교수님 코드)
	static int transHexToDcmByTch(String inputHex) {
		int result = 0;
		int strLen = inputHex.length();

		char chTemp = '0';
		
		for (int i = 0; i < strLen; i++) {
			
			chTemp = inputHex.charAt(i);
			if( chTemp == 'a' || chTemp == 'A') {

			}//이걸 F까지 다 하면 됨...;
			//너무 길어서 안쓰는거로...
		}
		
		
		return result;
	}
}
