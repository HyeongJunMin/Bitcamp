package std190527_Exception_OverLoad_IO;

import java.io.FileNotFoundException;

public class Lct1Exception {
	void play1() throws FileNotFoundException {
		try {
			// ���� �߻� ���ɼ��� �ִ� �ڵ�
		} catch (ArrayIndexOutOfBoundsException e) {
			// catch�� 2�� �̻� �ۼ� ����
			return;
		} finally {
			// try-catch ����� ��� ������ �����ϴ� ���
			// ���� �ǵ���(undo)�� rollback ����
		}
	}
	
	public static void play2() {
		try {
			int[] a = {1, 2};
			for(int i = 0 ; i < 5 ; i++ ) {
				System.out.println(a[i]);
			}
			
		}catch(ArrayIndexOutOfBoundsException e) {
			//�޽����� �̸� �ۼ��ؼ� �ش� ������ ����ϴ� ���
			System.out.println("�迭�����ʰ�");
			
			//���ܿ� ���� ������ ����ϴ� ���
			e.printStackTrace();
			
			//���ܰ� �߻��� �κ��� �ܼ��� ����ϴ� ���
			System.out.println(e.getMessage());
		}catch (NumberFormatException e) {
			System.out.println("�߸��� �����Դϴ�.");
		}finally {
			//finally�� �ֽ��?
			//try�ʿ� return�� �־ ���α׷��� ������ finally�κ��� �׻� ����˴ϴ�
			System.out.println("Finally");
		}
		System.out.println("���α׷� ��");
	}
	
	//throw : �� �� �� ���� �ش� ���� �߻� ���ɼ��� �ִ�
	public static void play3() throws Exception{
//		try {
			int[] a = {11, 22, 33};
			for(int i = 0 ; i < 4 ; i++ ) {
				System.out.println(a[i]);
			}			
//		}catch(IndexOutOfBoundsException e) {
//			e.printStackTrace();
//		}		
	}
	
	static void play4() {
		try {
			int[] a = {1,2,3,4};
			System.out.println(a[4]);	
		}catch(Exception e) {
			System.out.println("��������");
			return;
		}		
	}
}
