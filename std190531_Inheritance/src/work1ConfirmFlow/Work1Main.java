package work1ConfirmFlow;

public class Work1Main {
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println("x = " + c.getX());
		//Child 타입 변수 c 생성
		//Child 호출
		//-> 상위 클래스 Parent의 생성자 호출(Parent의 x=200)
		//-> 하위 클래스 Child의 생성자 호출
		System.out.println(c.getX());
	}
}
