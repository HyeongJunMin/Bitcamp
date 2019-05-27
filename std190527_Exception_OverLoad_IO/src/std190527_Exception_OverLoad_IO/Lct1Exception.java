package std190527_Exception_OverLoad_IO;

import java.io.FileNotFoundException;

public class Lct1Exception {
	void play1() throws FileNotFoundException {
		try {
			// 예외 발생 가능성이 있는 코드
		} catch (ArrayIndexOutOfBoundsException e) {
			// catch는 2개 이상 작성 가능
			return;
		} finally {
			// try-catch 결과가 어떻든 무조건 실행하는 블록
			// 보통 되돌림(undo)과 rollback 수행
		}
	}
	
	public static void play2() {
		try {
			int[] a = {1, 2};
			for(int i = 0 ; i < 5 ; i++ ) {
				System.out.println(a[i]);
			}
			
		}catch(ArrayIndexOutOfBoundsException e) {
			//메시지를 미리 작성해서 해당 내용을 출력하는 방법
			System.out.println("배열범위초과");
			
			//예외에 대한 정보를 출력하는 방법
			e.printStackTrace();
			
			//예외가 발생한 부분을 단순히 출력하는 방법
			System.out.println(e.getMessage());
		}catch (NumberFormatException e) {
			System.out.println("잘못된 형식입니다.");
		}finally {
			//finally는 왜써요?
			//try쪽에 return이 있어서 프로그램이 끝나도 finally부분은 항상 실행됩니다
			System.out.println("Finally");
		}
		System.out.println("프로그램 끝");
	}
	
	//throw : 이 함 수 내에 해당 예외 발생 가능성이 있다
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
			System.out.println("예외지롱");
			return;
		}		
	}
}
