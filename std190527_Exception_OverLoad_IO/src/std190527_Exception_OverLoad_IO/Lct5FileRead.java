package std190527_Exception_OverLoad_IO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lct5FileRead {
	static void play1() {
		//	파일 경로에서 역슬래시2번(\\) == 슬래시1번(/)
		File file  = new File("d:\\tmp\\newFile.txt");
		if( checkBeforeReadFile(file) ) {
			try {
				/*
				FileReader fileReader = new FileReader(file);
				
				//한글자 씩 읽어 옴
				int ch = fileReader.read();
				
				while( ch != -1 ) {	// -1 : 파일의끝
					System.out.print( (char)(ch) );
					ch = fileReader.read();
				}
				*/
				
				//	위에 방법은 보통 안써예
				//	밑에 방법이 더 좋대예
				BufferedReader bfReader = new BufferedReader(new FileReader(file));
				
				String str ; 
				
				while( (str = bfReader.readLine()) != null ) {
					System.out.println(str);
				}
				
				bfReader.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("파일을 찾을 수 없어요");
		}
	}
	
	//	utility 함수. == 제대로 된 파일인지 검사하는 역할. 프로그램에직접영향을 주지는 않음.
	static boolean checkBeforeReadFile(File f) {
		if( f.exists() ) {
			if( f.isFile() && f.canRead() ) {
				return true;
			}
		}
		return false;
	}
}


