package std190516_condition_loop_2;

public class Lct1_switch {
	/*
	 * switch 조건문
	 * 
	 * 형식 : 
	 * switch(대상이되는 변수){
	 * 	case 값1(value) : 
	 * 		처리
	 * 		break;
	 * 	case 값2(value) : 
	 * 		처리
	 * 		break;
	 * 	default : 		//==else에 해당. break;는 의미 없음.
	 * }
	 * 
	 * value에는 값만 들어가야 한다. 조건식은 들어갈 수 없다.
	 * 
	 * /**/
	void play() {
		int num = 1;
		
		switch (num) {
			case 1:
				System.out.println("num == 1");
				break;
			case 2:
				System.out.println("num == 2");
				break;
			default:
				System.out.println();
		}
	}
}
