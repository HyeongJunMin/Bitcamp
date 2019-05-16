package std190516_condition_loop_2;

public class Lct3_while {
	/*	while
	 *	
	 *	형식
	 *	[초기화]
	 *	while(조건식){
	 *		처리
	 *		연산식
	 *	} 
	 *
	 *	do~while
	 *
	 *	형식
	 *	[초기화]
	 *	do{
	 *		처리
	 *		연산식
	 *	}while(조건식);
	 *
	 * /**/
	void play() {
		int w = 0;			//초기화
		while (w < 10) {	//조건식
			w++;			//연산식
			System.out.println("while w : " + w);
		}
		
		w = 0;
		while (w <= 3 && w >= 0) {
			w++;
			System.out.println("while w : " + w);
		}
		
		w = 0;
		do {
			w++;
			System.out.println("do while w : " + w);
		}while(false);
	}
}
