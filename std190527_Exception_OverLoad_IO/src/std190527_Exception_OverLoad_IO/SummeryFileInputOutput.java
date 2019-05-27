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
		File myFile = new File("D:\\tmp\\sub");	//파일 선언 및 불러오기
		myFile.mkdirs();	//폴더(디렉토리) 생성		
		myFile = new File("D:\\tmp\\qwe.txt");	//파일 불러오기
		try {//파일 읽어오기 BufferedReader + FileReader
			//BufferedReader 변수명 = new BufferedReader( new FileReader(파일변수) );
			BufferedReader bfReader = new BufferedReader(new FileReader(myFile));
			bfReader.close();
			
			//파일 쓰기 FileWriter or PrintWriter
			//FileWriter(파일변수, true==누적/false==새로쓰기)
			//변수.write("입력내용");
			FileWriter flWriter = new FileWriter(myFile, true);
			flWriter.close();
			//PrintWriter(new BufferedWriter( FileWriter변수 ))
			//변수.print("입력내용");	변수.println("입력내용");
			PrintWriter prWriter = new PrintWriter(new BufferedWriter(flWriter));
			prWriter.close();			
			
		}catch(Exception e){
			System.out.println("예외");
		}
	}
}
