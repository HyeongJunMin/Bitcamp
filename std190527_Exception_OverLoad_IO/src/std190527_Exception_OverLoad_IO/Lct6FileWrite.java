package std190527_Exception_OverLoad_IO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Lct6FileWrite {
	//Write ���� : ���� ���Ͽ� �������� == ���� ���� ����� ����
	//
	
	static void play1() {
		File file  = new File("d:\\tmp\\newFile.txt");
		
		//	readOnly ����
//		file.setReadOnly();
		//	readOnly ����
//		file.setWritable(true);
		
		try {
			//���������Ϸ���? file �ڿ� true �Ű����� �߰�
			FileWriter fileW = new FileWriter(file, true);
			
			fileW.write("�ȳ��ϻ��!\n");
			fileW.write("�ȳ��ϻ�� �޾�ġ��!\n");
			fileW.close();
			//	���� �߿���! > write �ϰ� ������? Ŭ��� �� ���־����
			//	close ���ϸ�? �ۼ��� ����ĥ ���� ���ܴ�...
			
//			PrintWriter prW = new PrintWriter(new BufferedWriter(fileW));
//			prW.print("����");
//			prW.println("����");
//			prW.print("����2");
//			prW.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("11!");
		} 
		
	}
}




