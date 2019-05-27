package std190527_Exception_OverLoad_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Lct2FrqExceptions {
	//���� �߻��ϴ� ���ܿ� ���� ���� ����
	static void nullPointEx() {
		//	NullPointerException
		//	������ �̾߱��ϸ�? new�� �����༭(�����Ҵ� �����༭)
		String str = null;
		
		try {
			System.out.println(str.length());	
		}catch(NullPointerException e) {
			e.printStackTrace();
		}		
	}
	
	public static void arrayIndexOutOfBoundsEx() {
		int arr[] = {1,2,3};
		try {
			System.out.println(arr[3]);
		}catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
	public static final void fileNotEx() {
		File file = new File("c:\\xxxxxx");
		FileInputStream is;
		try {
			is = new FileInputStream(file);
		}catch(FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("���� ���");
		}
	}
	
	static void stringIndexOutEx() {
		//���ڿ� �ε��� �ʰ�
		String str = "java";
		try {
			System.out.println(str.charAt(5));
		}catch(StringIndexOutOfBoundsException e) {
			System.out.println("���� �ʰ��ƾ");
		}
	}
	
	static void numFormatEx() {
		//	�������� �ȸ��� ��
		int i;
		try {
			i = Integer.parseInt("ddd1");
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
