package std190516_condition_loop_2;

public class Work2 {
	void play() {
		
//		for (int i = 0; i < 9; i++) {
//			if(i<5)
//				for (int j = 0; j <= i; j++)
//					System.out.print("*");
//			else
//				for (int j = i; j < 9; j++)
//					System.out.print("*");
//			System.out.println();
//		}
		int a=1;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < a; j++) {
				System.out.print("*");
			}
			a = (i<4) ? a+1 : a-1;
			System.out.println();
		}
		
	}
}
