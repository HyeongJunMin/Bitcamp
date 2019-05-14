package pracProject190514_operator;
import java.util.*;
public class prac8 {
	//단위환산 프로그램 작성
	// 1 inch =2.54cm
	// 1 yard = 0.3048
	//	1 mile = 1.6093km
	double result = 0;
	void input() {
		Scanner in = new Scanner(System.in);
		System.out.print("(1)inch->cm (2)yard->m (3)mile->km : ");
		int b=in.nextInt();
		switch(b) {
		case 1:{
			System.out.println("inch를 입력하면 cm로 변환합니다.");
			result = (double)in.nextInt();
			System.out.println(result*2.54+"cm");
			break;
		}
		case 2:{
			System.out.println("yard를 입력하면 m로 변환합니다.");
			result = (double)in.nextInt();
			System.out.println(result*0.3048+"m");
			break;
		}
		case 3:{
			System.out.println("mile을 입력하면 km로 변환합니다.");
			result = (double)in.nextInt();
			System.out.println(result*1.6093+"km");
			break;
		}
		default :{
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
		}
		System.out.println("프로그램 종료.");
	}
}
