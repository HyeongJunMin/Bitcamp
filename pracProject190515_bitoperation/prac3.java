package pracProject190515_bitoperation;
import java.util.*;
public class prac3 {
	void play() {
		Scanner in = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : " );
		int a = in.nextInt();
		String str = ( a > 0 )?"양수입니다.":"음수입니다.";
		System.out.println("입력하신 숫자는 "+str);		
	}
}
