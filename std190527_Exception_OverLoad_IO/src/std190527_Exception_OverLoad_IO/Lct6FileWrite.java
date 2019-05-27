package std190527_Exception_OverLoad_IO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Lct6FileWrite {
	//Write 조심 : 기존 파일에 덧씌워짐 == 파일 생성 기능을 가짐
	//
	
	static void play1() {
		File file  = new File("d:\\tmp\\newFile.txt");
		
		//	readOnly 설정
//		file.setReadOnly();
		//	readOnly 해제
//		file.setWritable(true);
		
		try {
			//누적쓰기하려면? file 뒤에 true 매개변수 추가
			FileWriter fileW = new FileWriter(file, true);
			
			fileW.write("안녕하살법!\n");
			fileW.write("안녕하살법 받아치기!\n");
			fileW.close();
			//	아주 중요해! > write 하고 나서는? 클로즈를 꼭 해주어야함
			//	close 안하면? 작성을 끝마칠 수가 없단다...
			
//			PrintWriter prW = new PrintWriter(new BufferedWriter(fileW));
//			prW.print("ㅎㅇ");
//			prW.println("하이");
//			prW.print("ㅎㅇ2");
//			prW.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("11!");
		} 
		
	}
}




