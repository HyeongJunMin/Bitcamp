package std190516_condition_loop_2;

public class Lct4_break {
	void play() {
		/*	break == 탈출(escape) == return
		 *	break는 독립적으로 사용할 수 없다.
		 * 	
		 * 	break의 주 용도 : 반복문 탈출(for, while, do~while)
		 * /**/
		
		int num = 1;
		switch( num ) {
			case 1:
				System.out.println("num = 1");
				break;
			case 2:
				System.out.println("num = 2");
				break;
		}
		
		for( int i = 0 ; i < 10 ; i++ ) {
			System.out.println("i = "+i);
			if(i == 5)
				break;			
		}
		
		char cArray[] = { 'a', 'b', 'c' };
		
		for( int i = 0 ; i < cArray.length ; i++ ) {
			System.out.println("char = " + cArray[i]);
			if( cArray[i] == 'b' ) {
				System.out.println("탈출!");
				break;
			}
		}
		
		int iArray[] = { 1, 2, 3, -1, 7 };
		for (int i = 0; i < iArray.length; i++) {
			System.out.println("iArray[" + i + "] = " + iArray[i]);
		}
		
		for (int i = 0; i < iArray.length; i++) {
			System.out.println("i = "+i);
			for (int j = 0; j < iArray.length; j++) {
				System.out.println("\t j = " + j );
				if(i == 3 && j == 4) {
					break ;
				}
			}
		}
		out:for (int i = 0; i < iArray.length; i++) {
			System.out.println("i = "+i);
			for (int j = 0; j < iArray.length; j++) {
				System.out.println("\t j = " + j );
				if(i == 3 && j == 4) {
					break out;
				}
			}
		}
	}
}
