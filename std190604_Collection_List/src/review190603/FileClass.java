package review190603;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileClass {
	
	private String filename;
	private File myfile;
	
	public FileClass() {		
		myfile = new File("d:\\tmp\\baseballmember.txt");
		filename = "baseballmember.txt";		
		createFile();
	}
	
	public FileClass(String filename) {
		myfile = new File("d:\\tmp\\" + filename + ".txt");
		this.filename = filename;		
		createFile();
	}

	// �뙆�씪 �깮�꽦
	public File createFile() {
		try {
			if(myfile.createNewFile()) {
				System.out.println(filename + "�뙆�씪 �깮�꽦 �꽦怨�");
			}else {
				System.out.println(filename + "�뙆�씪 �깮�꽦 �떎�뙣");
			}			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return myfile;
	}
	
	
	// �벐湲�
	public void writeFile(String datas[]) {
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(myfile)));
			
			for (int i = 0; i < datas.length; i++) {
				pw.println(datas[i]);
			}
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(filename + ".txt �뙆�씪�뿉 �뜲�씠�꽣瑜� ���옣�븯���뒿�땲�떎");
	}
	
	
	// �씫湲�
	public String[] readFile() {
		
		String datas[] = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(myfile));
			
			// �뜲�씠�꽣�쓽 �닔瑜� 議곗궗
			int count = 0;
			String str;
			
			while((str = br.readLine())!= null) {
				count++;
			}
			br.close();
			
			// �뜲�씠�꽣�쓽 �닔留뚰겮 諛곗뿴�븷�떦
			datas = new String[count];
			System.out.println("�뜲�씠�꽣�쓽 媛��닔:" + datas.length);
			
			// 諛곗뿴�뿉 ���옣
			int w = 0;
			br = new BufferedReader(new FileReader(myfile));
			while((str = br.readLine())!= null) {
				datas[w] = str;
				w++;
			}
			br.close();			
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		System.out.println(filename + ".txt �뙆�씪濡쒕��꽣 �뜲�씠�꽣瑜� �젙�긽�쟻�쑝濡� �씫�뿀�뒿�땲�떎");
		
		return datas; 
	}
	
}








