package std190531_Inheritance;

public class LectureMain {
	public static void main(String[] args) {
		//�ڽĻ�����(�Ű�����) -> �θ������(�Ű�����) -> �θ�������=�Ű�����
		Lct1Child c = new Lct1Child(11);
		int g = c.getpNum();
		System.out.println("get num : " + g);
		c.pMethod();
		
		Lct1Parents p1 = new Lct1Daughter();
		Lct1Parents p2 = new Lct1Child();
		Lct1Child p3 = new Lct1Child();
		
//		p2.fnc(); �θ� Ŭ������ ���� �޼ҵ��̱� ������ �޼ҵ� ȣ�� �Ұ�
		p3.fnc();
	}
}
