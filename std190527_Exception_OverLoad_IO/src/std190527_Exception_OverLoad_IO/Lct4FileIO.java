package std190527_Exception_OverLoad_IO;
import java.io.File;
import java.io.IOException;

public class Lct4FileIO {
	//	��������¿� ���� ����
	//	������ ������ ?? == �����ü == ��� == ���� �Ӹ����°� �ƴϰ� ������ ���°���
	//	DatabaseȰ�� ��� �� oracle���ǵ� �̰͵� �ᱹ ����������̾�
	

	static void play1() {
		File file = new File("C:\\");
//		����� ���� ���� ����
//		String[] fileList = file.list();
//		System.out.println(Arrays.toString(fileList));
		
		//����� ������ �״�� ������
//		File filelist[] = file.listFiles();
//		for( int i = 0 ; i < filelist.length ; i++ ) {
//			if( filelist[i].isFile() ) {
//				System.out.println("[����]"+filelist[i].getName());
//			}else if( filelist[i].isDirectory() ) {
//				System.out.println("[����]"+filelist[i].getName());
//			}else {
//				System.out.println("[?]"+filelist[i].getName());
//			}
//		}
	}
	
	static void play2(){
		//	���� �����
		File newFile = new File("d:\\tmp\\newFile.txt");
		System.out.println("ok");
				
		try {
			if ( newFile.createNewFile() ) {
				System.out.println("create ok");
			} else {
				System.out.println("create fail");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		//	���� ����
		String dirStr = "d:\\tmp1";
		File newDir = new File(dirStr);
		//mkdir�� �� �ϳ���
		//mkdirs�� ���� �ΰ� �̻�. ������ tmp1, sub �� 2�� ������ �Ǵϱ� mkdirs
		if( newDir.mkdir() ) {
			System.out.println("�������� ����");
		} else {
			System.out.println("�������� ����");
		}
		
		//	File ���� ����
		if( newFile.exists() ) {
			System.out.println(newFile.getName() + " ������ �ֳ׿�");
		}
		
		//	File ���� �˻�
		if( newFile.canWrite() )
			System.out.println(newFile.getName() + " ���� ���� �԰���");
		else
			System.out.println("����");
		
		//	File ����
		if( newFile.delete() )
			System.out.println(newFile.getName() + " ���� ���� �Ϸ�");
		else
			System.out.println(newFile.getName() + " ���� ���� ����");
		
	}
}