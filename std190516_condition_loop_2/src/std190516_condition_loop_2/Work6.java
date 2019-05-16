package std190516_condition_loop_2;

public class Work6 {
	void play() {
		// 1, 3, 5, 7, 9, 7, 5, 3, 1
		// 4,3,2,1,0 1,2,3,4
		// 4,5,6,7,8 7,6,5,4
		int origin = 31;
		int a = origin;
		int b = 0;
		
		for (int i = 0; i < origin; i++) {
			for (int j = 0; j < b; j++)
				System.out.print(" ");
			for (int j = 0; j < a; j++)
				System.out.print("*");
			
			
			a = (i<(origin/2))?a-2:a+2;
			b = (i<(origin/2))?b+1:b-1;
			System.out.println();
		}
	}
}

