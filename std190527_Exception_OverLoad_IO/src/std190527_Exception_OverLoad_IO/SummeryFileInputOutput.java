package std190527_Exception_OverLoad_IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class SummeryFileInputOutput {
	public static void main(String[] args) {
		String strTemp;
		File myFile = new File("D:\\tmp\\sub");	//���� ���� �� �ҷ�����
		myFile.mkdirs();	//����(���丮) ����		
		myFile = new File("D:\\tmp\\qwe.txt");	//���� �ҷ�����
		try {//���� �о���� BufferedReader + FileReader
			//BufferedReader ������ = new BufferedReader( new FileReader(���Ϻ���) );
			BufferedReader bfReader = new BufferedReader(new FileReader(myFile));
			bfReader.close();
			
			//���� ���� FileWriter or PrintWriter
			//FileWriter(���Ϻ���, true==����/false==���ξ���)
			//����.write("�Է³���");
			FileWriter flWriter = new FileWriter(myFile, true);
			flWriter.close();
			//PrintWriter(new BufferedWriter( FileWriter���� ))
			//����.print("�Է³���");	����.println("�Է³���");
			PrintWriter prWriter = new PrintWriter(new BufferedWriter(flWriter));
			prWriter.close();			
			
		}catch(Exception e){
			System.out.println("����");
		}
	}
}
