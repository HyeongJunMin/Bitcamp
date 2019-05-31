package std190531_Inheritance;

public class LectureMain {
	public static void main(String[] args) {
		//자식생성자(매개변수) -> 부모생성자(매개변수) -> 부모멤버변수=매개변수
		Lct1Child c = new Lct1Child(11);
		int g = c.getpNum();
		System.out.println("get num : " + g);
		c.pMethod();
		
		Lct1Parents p1 = new Lct1Daughter();
		Lct1Parents p2 = new Lct1Child();
		Lct1Child p3 = new Lct1Child();
		
//		p2.fnc(); 부모 클래스에 없는 메소드이기 때문에 메소드 호출 불가
		p3.fnc();
	}
}
