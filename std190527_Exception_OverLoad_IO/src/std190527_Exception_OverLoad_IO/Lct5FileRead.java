package std190527_Exception_OverLoad_IO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lct5FileRead {
	static void play1() {
		//	���� ��ο��� ��������2��(\\) == ������1��(/)
		File file  = new File("d:\\tmp\\newFile.txt");
		if( checkBeforeReadFile(file) ) {
			try {
				/*
				FileReader fileReader = new FileReader(file);
				
				//�ѱ��� �� �о� ��
				int ch = fileReader.read();
				
				while( ch != -1 ) {	// -1 : �����ǳ�
					System.out.print( (char)(ch) );
					ch = fileReader.read();
				}
				*/
				
				//	���� ����� ���� �ȽΌ
				//	�ؿ� ����� �� ���뿹
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
			System.out.println("������ ã�� �� �����");
		}
	}
	
	//	utility �Լ�. == ����� �� �������� �˻��ϴ� ����. ���α׷������������� ������ ����.
	static boolean checkBeforeReadFile(File f) {
		if( f.exists() ) {
			if( f.isFile() && f.canRead() ) {
				return true;
			}
		}
		return false;
	}
}


