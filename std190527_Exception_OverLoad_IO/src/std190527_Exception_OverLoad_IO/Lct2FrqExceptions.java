package std190527_Exception_OverLoad_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Lct2FrqExceptions {
	//자주 발생하는 예외에 대한 내용 정리
	static void nullPointEx() {
		//	NullPointerException
		//	간단히 이야기하면? new를 안해줘서(동적할당 안해줘서)
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
			System.out.println("파일 없어예");
		}
	}
	
	static void stringIndexOutEx() {
		//문자열 인덱스 초과
		String str = "java";
		try {
			System.out.println(str.charAt(5));
		}catch(StringIndexOutOfBoundsException e) {
			System.out.println("범위 초과됐어예");
		}
	}
	
	static void numFormatEx() {
		//	숫자포맷 안맞을 때
		int i;
		try {
			i = Integer.parseInt("ddd1");
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
