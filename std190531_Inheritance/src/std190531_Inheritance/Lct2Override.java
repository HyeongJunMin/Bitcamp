package std190531_Inheritance;

import animals.*;

public class Lct2Override {
	public static void main(String[] args) {
		Animal anm1 = new Cat("�ʷ���");
		anm1.print();
		Animal anm2 = new Dog("����");
		anm2.print();
		Animal anm3 = new Cow("������");
		anm3.print();
		
		//���� ����� �ټ����� ������ ������ �� �θ����� �Բ� ����־�
		Cat Cats[] = new Cat[5];
		Dog Dogs[] = new Dog[3];
		Cow Cows[] = new Cow[2];
		
		//�̷��� ����ϸ� ���⵵ �氨
		Animal[] MyFriends = new Animal[9];
		MyFriends[0] = new Cat("���");
		Cat c = (Cat)MyFriends[0];
		c.catMethod();
		
		//instance of == ��ü�� Ŭ���� Ȯ�� ����
		if( MyFriends[0] instanceof Cat ) {
			
		}else if( MyFriends[0] instanceof Dog) {
			
		}
	}
}
