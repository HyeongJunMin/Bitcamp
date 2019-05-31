package std190531_Inheritance;

import animals.*;

public class Lct2Override {
	public static void main(String[] args) {
		Animal anm1 = new Cat("초록이");
		anm1.print();
		Animal anm2 = new Dog("별이");
		anm2.print();
		Animal anm3 = new Cow("누렁이");
		anm3.print();
		
		//나는 고양이 다섯마리 강아지 세마리 소 두마리와 함께 살고있어
		Cat Cats[] = new Cat[5];
		Dog Dogs[] = new Dog[3];
		Cow Cows[] = new Cow[2];
		
		//이렇게 사용하면 복잡도 경감
		Animal[] MyFriends = new Animal[9];
		MyFriends[0] = new Cat("사또");
		Cat c = (Cat)MyFriends[0];
		c.catMethod();
		
		//instance of == 객체의 클래스 확인 조건
		if( MyFriends[0] instanceof Cat ) {
			
		}else if( MyFriends[0] instanceof Dog) {
			
		}
	}
}
