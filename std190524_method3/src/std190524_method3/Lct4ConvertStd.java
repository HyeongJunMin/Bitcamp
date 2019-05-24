package std190524_method3;

import java.util.Scanner;

public class Lct4ConvertStd {
	// 수치 변환 프로그램 작성
	//	반복 기능 추가하는듯...
	
	static void runConvertProgram() {
		
		int choice = 0;
		
		while(true) {
			
			System.out.println("1. 10진수 -> 2진수");
			System.out.println("2. 2진수 -> 10진수");
			System.out.println("3. 10진수 -> 16진수");
			System.out.println("4. 16진수 -> 10진수");
			System.out.println("5. 10진수 -> 8진수");
			System.out.println("6. 8진수 -> 10진수");
			
			System.out.print("어떤 수치를 변환하시겠습니까?");
			Scanner in = new Scanner(System.in);
			choice = in.nextInt();
			
			switch ( choice ) {
				case 1:
					System.out.print("10진수 입력 : ");
					int num = in.nextInt();
					String num2 = Lct2TransBinaryAndDecimal.transDcmToBnr(num);
					System.out.println("2진수는 " + num2 + "입니다.");
					break;
				case 2:
					System.out.print("2진수 입력 : ");
					int str = Integer.parseInt(in.next(),2);
					System.out.println("10진수는 " + str + "입니다.");
					break;
				case 3:
					System.out.println("10진수 입력 : ");
					String strHex = Integer.toHexString(in.nextInt());
					System.out.println("16진수는 " + strHex + "입니다.");
					break;
				case 4:
					System.out.print("16진수 입력 : ");
					int str2 = Lct2TransBinaryAndDecimal.transHexToDcm(in.next());
					System.out.println("10진수는 " + str2 + "입니다.");
					break;
				case 5:
					System.out.println("10진수 입력 : ");
					String strOct = Integer.toOctalString(in.nextInt());
					System.out.println("8진수는 " + strOct + "입니다.");
					break;
				case 6:
					System.out.print("8진수 입력 : ");
					int str3 = Integer.parseInt(in.next(),8);
					System.out.println("10진수는 " + str3 + "입니다.");
					break;
				default :
					System.out.println("wrong input");
					break;
			}
			
			System.out.println("계속? 1/2");
			if( in.nextInt() == 2)
				break;
		}
		
	}
	
}
