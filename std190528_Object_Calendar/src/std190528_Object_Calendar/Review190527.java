package std190528_Object_Calendar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Review190527 {
	//0528�߰� : �̸����� �˻�
	
	//����
	//1. ���� ����
	//	���� �� �Է¹޾Ƽ�
	//2. ���� ����
	//	���� �� �Է¹޾Ƽ�
	//3. ���� ����
	//	���� �� + �� ���ڿ� �Է¹޾Ƽ�
	//4. ���� �б�
	//	���� �� �Է¹޾Ƽ� �ҷ����� ���ڿ��� String�� �������ּ���~
	//5. ���� �߰�����(����)
	//	���� �� �Է¹޾Ƽ� 
	//6. ��� ���
	//	�о� �� ������ ��� ���
	//7. ���α׷� ���� �޴�
	public static Scanner in = new Scanner(System.in);
	void runFileIOSystem() {
		char continueSystem = 'Y';
		
		String intro = "���� ����� �ý��� ����.\n�޴��� �����ϼ���.\n(1)���ϻ���\t(2)���ϻ���\t(3)���Ͼ���\t(4)�����б�\n(5)�����߰�����\t(6)������\t(7)���α׷� ����\t(8)�����Ͱ˻�";
		
		while( continueSystem == 'Y' ) {
			System.out.println(intro);			
			
			
			
			//inputRightValue �Լ��� ���� 1~7���� ����ڷ� ���� �Է¹���
			//1~7�� �ش��ϴ� �޴��� ����
			switch( inputRightValue() ) {
				case '1': mkFile(); break;
				case '2': dltFile(); break;
				case '3': wrtFile(); break;
				case '4': rdFile(); break;
				case '5': wrtToExsFile(); break;
				case '6': printAll(); break;
				case '7': continueSystem = '7'; break;
				case '8': searchData(); break;
				default : break;
			}
			
			
			
			
			//���α׷� �������� ����� �Է�
//			if (continueSystem != '7') {
//				System.out.println("����Ͻðڽ��ϱ�? (Y/N)");
//				continueSystem = endOrContinueSystem();
//			}
		}
		
		System.out.println("���α׷��� �����մϴ�.");
		
		in.close();
	}
	
		
	//�����̸� �Է¹޾� �ش� �̸����� ������ �����ϴ� �޼ҵ�
	void mkFile() {
		String str="";
		char strChc = 'N';
		
		System.out.println("���� ������ �����մϴ�. ���� �̸��� �Է��ϼ��� : ");
		
		//Y �Ǵ� N�� �ԷµǸ� ����
		while(strChc != 'Y') {
			str = in.next();
			System.out.println("�Է��Ͻ� ���ϸ��� " + str + " �Դϴ�. ������ Y, �ٽ��Է��Ϸ��� N�� �Է��ϼ���.");
			strChc = in.next().toUpperCase().charAt(0);
			if( strChc != 'Y' )
				System.out.print("���ϸ��� �ٽ� �Է��� �ּ��� : ");
		}
		
		String fileName = "d:\\tmp\\" + str + ".txt";
		
		
		File file  = new File(fileName);
		try {
			FileWriter fileW = new FileWriter(file, true);
			fileW.close();
			System.out.println("���ϻ��� �Ϸ� (" + str + ".txt)");
		}catch (Exception e){
			System.out.println("���� ���� ����");			
		}
	}
	
	
	//���� ����� ������ְ� ���� �̸��� �Է¹޾Ƽ� �ش� �̸��� ������ �����ϴ� �޼ҵ�
	void dltFile() {
		String str="";
		char strChc = 'N';
		
		//���ϸ�� view �κ�
		
		System.out.println("���� ������ �����մϴ�. ���� ������ ���� ����� �Ʒ��� �����ϴ�.");
		File fileL = new File("D:\\tmp");
		String[] fileList = fileL.list();
		if( fileList.length < 1) {
			System.out.println("������ �����ϴ�. ���� ���� ����� �����մϴ�.");
			return;
		}else {
			System.out.println(Arrays.toString(fileList));
		}
				
		
		
		//���ϻ��� �κ�
		System.out.print("�����Ͻ� ���ϸ��� �Է� �� �ּ���(Ȯ��������) : ");
		//Y �Ǵ� N�� �ԷµǸ� ����
		while(strChc != 'Y') {
			str = in.next();
			System.out.println("�Է��Ͻ� ���ϸ��� " + str + " �Դϴ�. ������ Y, �ٽ��Է��Ϸ��� N�� �Է��ϼ���.");
			strChc = in.next().toUpperCase().charAt(0);
			if( strChc != 'Y' )
				System.out.print("���ϸ��� �ٽ� �Է��� �ּ��� : ");
		}
		
		String fileName = "d:\\tmp\\" + str + ".txt";
		
		
		File file  = new File(fileName);
		try {
			file.delete();
			System.out.println("���ϻ��� �Ϸ� (" + str + ".txt)");
		}catch (Exception e){
			System.out.println("���� ���� ����");			
		}
	}
	
	//���Ͼ���
	void wrtFile() {
		String str="";
		String strWarn = "�� �̹� �����ϴ� �����Դϴ�.\n����Ͻø� ���Ͽ� �ִ� ������ �����ǰ� ������ �Էµ� �������� ��ü�˴ϴ�.\n����Ͻðڽ��ϱ�?(Y/N)";
		char strChc = 'N';
		
		//���ϸ�� view �κ�
		
		System.out.println("���� ���� �Է��� �����մϴ�. ���� ������ ���� ����� �Ʒ��� �����ϴ�.");
		File fileL = new File("D:\\tmp");
		String[] fileList = fileL.list();
		System.out.println(Arrays.toString(fileList));
		
		
		//�����Է� �κ�
		System.out.print("������ �Է��� ���ϸ��� �Է� �� �ּ���(Ȯ��������) : ");
		//Y �Ǵ� N�� �ԷµǸ� ����
		while(strChc != 'Y') {
			str = in.next();
			System.out.println("�Է��Ͻ� ���ϸ��� " + str + " �Դϴ�. ������ Y, �ٽ��Է��Ϸ��� N�� �Է��ϼ���.");
			strChc = in.next().toUpperCase().charAt(0);
			if( strChc != 'Y' )
				System.out.print("���ϸ��� �ٽ� �Է��� �ּ��� : ");
			for(int i = 0 ; i < fileList.length ; i++ ) {
				if(fileList[i].equals(str+".txt")) {
					System.out.println(str + strWarn);
				}
			}
			strChc = in.next().toUpperCase().charAt(0);
		}
		

		
		String fileName = "d:\\tmp\\" + str + ".txt";
		String inputStr ="";
		
		System.out.print("���� ���ο� ������ ���� �Է� : ");
		
		strChc = 'n';
		//���Ͽ� ������ �ؽ�Ʈ �Է��ϰ� Ȯ��
		while(strChc != 'Y') {
			inputStr = in.next();
			System.out.println("�Է��Ͻ� ������ " + inputStr + " �Դϴ�. ������ Y, �ٽ��Է��Ϸ��� N�� �Է��ϼ���.");
			strChc = in.next().toUpperCase().charAt(0);
			if( strChc != 'Y' )
				System.out.print("���ϸ��� �ٽ� �Է��� �ּ��� : ");
		}
		
		try {
			FileWriter fileW = new FileWriter(fileName);
			
			fileW.write(inputStr);
			System.out.println("���ϳ����Է� �Ϸ� (" + str + ".txt)");
			fileW.close();
		} catch (Exception e) {
			System.out.println("���� �Է½���!");
		} 
	}
	
	//���� ���� �б�
	void rdFile() {
		String str="";
		char strChc = 'N';
		
		//���ϸ�� view �κ�
		System.out.println("���ϳ��� �б⸦ �����մϴ�. ���� ������ ���� ����� �Ʒ��� �����ϴ�.");
		File fileL = new File("D:\\tmp");
		String[] fileList = fileL.list();
		if( fileList.length < 1) {
			System.out.println("������ �����ϴ�. ���ϳ��� �б� ����� �����մϴ�.");
			return;
		}else {
			System.out.println(Arrays.toString(fileList));
		}

		//���ϼ��� �κ�
		System.out.print("�о���� ���ϸ��� �Է� �� �ּ���(Ȯ��������) : ");
		//Y �Ǵ� N�� �ԷµǸ� ����
		while(strChc != 'Y') {
			str = in.next();
			System.out.println("�Է��Ͻ� ���ϸ��� " + str + " �Դϴ�. ������ Y, �ٽ��Է��Ϸ��� N�� �Է��ϼ���.");
			strChc = in.next().toUpperCase().charAt(0);
			if( strChc != 'Y' )
				System.out.print("���ϸ��� �ٽ� �Է��� �ּ��� : ");
		}


		
		String fileName = "d:\\tmp\\" + str + ".txt";
		File fileToRead = new File(fileName);
		
		if( checkBeforeReadFile(fileToRead) ) {
			try {
				BufferedReader bfReader = new BufferedReader(new FileReader(fileToRead));
				System.out.println("���� ���� : ");
				while( (str = bfReader.readLine()) != null ) {
					System.out.println(str);
				}
				
				bfReader.close();
				System.out.println("���� �б� ����.");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		
		} else {
			System.out.println("������ ã�� �� �����");
		}
	}
	
	//���� ���뿡 �������� ����
	void wrtToExsFile() {
		String str="";
//		String strWarn = "�� �̹� �����ϴ� �����Դϴ�.\n����Ͻø� ���Ͽ� �ִ� ������ �����ǰ� ������ �Էµ� �������� ��ü�˴ϴ�.\n����Ͻðڽ��ϱ�?(Y/N)";
		char strChc = 'N';
		
		//���ϸ�� view �κ�
		
		System.out.println("���� ���� �Է��� �����մϴ�. ���� ������ ���� ����� �Ʒ��� �����ϴ�.");
		File fileL = new File("D:\\tmp");
		String[] fileList = fileL.list();
		System.out.println(Arrays.toString(fileList));
		
		
		//�����Է� �κ�		
		System.out.print("������ �Է��� ���ϸ��� �Է� �� �ּ���(Ȯ��������) : ");
		//Y �Ǵ� N�� �ԷµǸ� ����
		while(strChc != 'Y') {
			str = in.next();
			System.out.println("�Է��Ͻ� ���ϸ��� " + str + " �Դϴ�. ������ Y, �ٽ��Է��Ϸ��� N�� �Է��ϼ���.");
			strChc = in.next().toUpperCase().charAt(0);
			if( strChc != 'Y' )
				System.out.print("���ϸ��� �ٽ� �Է��� �ּ��� : ");
//			for(int i = 0 ; i < fileList.length ; i++ ) {
//				if(fileList[i].equals(str+".txt")) {
//					System.out.println(str + strWarn);
//				}
//			}
			strChc = in.next().toUpperCase().charAt(0);
		}
		

		
		String fileName = "d:\\tmp\\" + str + ".txt";
		String inputStr ="";
		
		System.out.print("���� ���ο� �߰��� ���� �Է� : ");
		
		strChc = 'n';
		//���Ͽ� ������ �ؽ�Ʈ �Է��ϰ� Ȯ��
		while(strChc != 'Y') {
			inputStr = in.next();
			System.out.println("�Է��Ͻ� ������ " + inputStr + " �Դϴ�. ������ Y, �ٽ��Է��Ϸ��� N�� �Է��ϼ���.");
			strChc = in.next().toUpperCase().charAt(0);
			if( strChc != 'Y' )
				System.out.print("�ٽ� �Է��� �ּ��� : ");
		}
		
		inputStr  = "\n" + inputStr;
		
		try {
			FileWriter fileW = new FileWriter(fileName, true);
			
			fileW.write(inputStr);
			System.out.println("���ϳ����Է� �Ϸ� (" + str + ".txt)");
			fileW.close();
		} catch (Exception e) {
			System.out.println("���� �Է½���!");
		} 
		
	}
	
	//��� ���� ���
	void printAll() {
		String str = "";
		//���ϸ�� view �κ�
		System.out.println("���ϳ��� ����� �����մϴ�. ���� ������ ���� ����� �Ʒ��� �����ϴ�.");
		File fileL = new File("D:\\tmp");
		String[] fileList = fileL.list();
		
		
		//���� ��ο� ������ �ƹ��͵� ������ ��� �ߴ�
		if( fileList.length < 1) {
			System.out.println("������ �����ϴ�. ���ϳ��� �б� ����� �����մϴ�.");
			return;
		}else {
			System.out.println(Arrays.toString(fileList)+"\n");
		}
		
		
		

		try {
			
			for( int i = 0 ; i < fileList.length ; i++) {
				str = fileList[i];
				System.out.println("���ϸ� : " + str);
				String fileName = "d:\\tmp\\" + str;
				File fileToRead = new File(fileName);
				BufferedReader bfReader = new BufferedReader(new FileReader(fileToRead));
				System.out.println("���� ���� : ");
				while ((str = bfReader.readLine()) != null) {
					System.out.println(str);
				}
				System.out.println(fileName + " �Ϸ�\n");
				bfReader.close();
			}
			
			System.out.println("���� �б� ����.\n");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�̸����� �˻�
	void searchData() {
		
			String str="";
			char strChc = 'N';
			
			//���ϸ�� view �κ�
			System.out.println("���� �˻��� �����մϴ�. ���� ������ ���� ����� �Ʒ��� �����ϴ�.");
			File fileL = new File("D:\\tmp");
			String[] fileList = fileL.list();
			if( fileList.length < 1) {
				System.out.println("������ �����ϴ�. ���ϰ˻� ����� �����մϴ�.");
				return;
			}else {
				System.out.println(Arrays.toString(fileList));
			}

			//���ϼ��� �κ�
			System.out.print("�˻� ��� ���ϸ��� �Է� �� �ּ���(Ȯ��������) : ");
			//Y �Ǵ� N�� �ԷµǸ� ����
			while(strChc != 'Y') {
				str = in.next();
				System.out.println("�Է��Ͻ� ���ϸ��� " + str + " �Դϴ�. ������ Y, �ٽ��Է��Ϸ��� N�� �Է��ϼ���.");
				strChc = in.next().toUpperCase().charAt(0);
				if( strChc != 'Y' )
					System.out.print("���ϸ��� �ٽ� �Է��� �ּ��� : ");
			}

			//�˻� ��� ������ ����
			String fileName = "d:\\tmp\\" + str + ".txt";
			File fileToRead = new File(fileName);
			
			//�˻� ��� ������ ���ڿ��� ����� �迭
			String[] fileData = new String[100];
			
			//�˻��� ���� ����
			String userInputDataForSearch = "";
			
			
			if( checkBeforeReadFile(fileToRead) ) {
				try {
					strChc = 'Y';
					while(strChc == 'Y') {
						System.out.print("�˻��� �����մϴ�. �̸��� �Է��� �ּ��� : ");
						userInputDataForSearch = in.next();
						System.out.println("�Է��Ͻ� �˻���� " + userInputDataForSearch + " �Դϴ�.");

						
						//���� ������ ���ڿ� �迭�� ����
						BufferedReader bfReader = new BufferedReader(new FileReader(fileToRead));

						//�ݺ������
						int w = 0;
						while( (str = bfReader.readLine()) != null ) {
							fileData = str.split("-");
							w++;
							for( int i = 0 ; i < fileData.length; i++ ) {
								if( fileData[0].equals(userInputDataForSearch) ) {
									System.out.println("����\t������");
									System.out.println(fileData[1]+"\t"+fileData[2]);
									w = 100;
									break;
								}
							}
							if(w == 100)
								break;
						}
						if(w != 100)
							System.out.println("�˻� ����� �����ϴ�.");
						//�˻���
//						for( int i = 0 ; i < fileData.length; i++ ) {
//							if( fileData[i][0].equals(userInputDataForSearch) ) {
//								System.out.println(fileData[i][1]+"\t"+fileData[i][2]);
//								break;
//							}
//						}
						if (strChc == 'Y') {
							System.out.println("��� �˻��Ͻðڽ��ϱ�? (Y/N)");
							strChc = endOrContinueSystem();
						}
					}			
					System.out.println("���� �˻� ����.");

					
				} catch (Exception e) {
					e.printStackTrace();
				}
					
			
			} else {
				System.out.println("������ ã�� �� �����");
			}
		
	}
		
	char inputRightValue() {
		char a = 'a';
		
		while(a < '1' || a > '8') {
			a = in.next().charAt(0);
			if( a < '1' || a > '8' )
				System.out.println("�߸��� ���� �Է��߽��ϴ�. �ٽ� �Է��� �ּ���. (1~7)");
		}		
		
		return a;
	}

	char endOrContinueSystem() {
		char a=0;
		
		//Y �Ǵ� N�� �ԷµǸ� ����
		while(a != 'Y' && a != 'N') {
			a = in.next().toUpperCase().charAt(0);
			if( a != 'Y' && a != 'N' )
				System.out.println("�߸��� ���� �Է��߽��ϴ�. �ٽ� �Է��� �ּ���. (Y, N)");
		}
		
		return a;
	}
	
	//������ �о�� �� ������ �����ϴ��� ���� Ȯ��
	static boolean checkBeforeReadFile(File f) {
		if( f.exists() ) {
			if( f.isFile() && f.canRead() ) {
				return true;
			}
		}
		return false;
	}

	

}
