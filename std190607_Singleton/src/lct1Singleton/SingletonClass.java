package lct1Singleton;

public class SingletonClass {
	//�ʵ�� �����ڰ� �� �����̺��̳׿�
	private static SingletonClass single = null;
	public static int num;
	public static String name;
	
	private SingletonClass() {
	}
	
	//���� ���̴� �޼ҵ� �̸���. getInstance
	//����ƽ �޼ҵ��̱� ������ Ŭ������.getInstance()�� ȣ���ϸ�?
	//��� : ù �ѹ��� Ŭ������ ȣ��Ǹ�? �ν��Ͻ��� �����Ѵ�.
	//		�� ��° ���ʹ�?? ù ��°�� ������ �ν��Ͻ��� �����Ѵ�.
	public static SingletonClass getInstance() {
		if( single == null ) {
			single = new SingletonClass(); 
		}
		return single;
	}
}
