package std190527_Exception_OverLoad_IO;

public class Lct3OverLoad {
	//	Over Load 
	//	이게뭐에요?
	//	function의 명칭은 동일하지만 
	//	매개변수(인수, 인자, Parameter)의 자료형이나 개수가 다른 것
	//	==다형성
	
	//가변인수 가능 == 인수 1개 ~ 여러개를 배열 형태로 받음
	void intdisp(int... n) {
		
	}
	
	static int disp(String str, int... num) {
		int sum = 0 ;
		for(int i = 0 ; i < num.length ; i++) {
			sum+=num[i];
		}
		System.out.println("String : " + str + "\t" + sum);
		return sum;
	}
	
	public static void main(String[] args) {
		disp("ggggg", 30,1,2,3,4);
	}
}
