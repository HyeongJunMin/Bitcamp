package work1ConfirmFlow;

public class Work1Main {
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println("x = " + c.getX());
		//Child Ÿ�� ���� c ����
		//Child ȣ��
		//-> ���� Ŭ���� Parent�� ������ ȣ��(Parent�� x=200)
		//-> ���� Ŭ���� Child�� ������ ȣ��
		System.out.println(c.getX());
	}
}
