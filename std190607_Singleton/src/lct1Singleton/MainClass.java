package lct1Singleton;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass mcls = new MyClass();
		YouClass ycls = new YouClass();
		
		//YouClass ��ü�� �����ǰ� toString �޼ҵ带 ȣ���� �� MyClass�� ���� �޾ƿ��Բ� ������ ��
//		int n = mcls.getMyNum();
//		ycls.setYouNum(n);
		
		System.out.println(ycls.toString());
		
		//�̱��Ͽ��� ���� �����ְ� ���ع޴� ����� �޸𸮸� ���� �̷������.(���� ���� �ƴ�)
		//MyClass-myMethod(�̱��ϻ����ؼ� ��Ŭ�Ͼ����� �� ����)-YouClass-youMethod(�̱����ν��Ͻ��� ���� �޾ƿ�)
		mcls.myMethod();
		ycls.youMethod();
		System.out.println(ycls.toString());
		
		HeClass h = new HeClass();
		ycls.youMethod2();
		System.out.println(ycls.toString());
		
	}

}
