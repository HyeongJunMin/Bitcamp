package std190528_Object_Calendar;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Lct2Tokenizer {
	public static void main(String[] args) {
		tok1();
	}
	
	static void tok1() {
		
		//split - ���ڿ��� ���ڷ� ���
		//StringTokenizer - ���ڿ� ����
		String str = "ȫ�浿-2001/03/14-�����";
		String[] spl = str.split("-");
		int index = 0;
		for(String sss : spl) {
			System.out.print(sss + " "  );
		}
		
		//str�� "-"�� �ڸ��ڴ�
		StringTokenizer st = new StringTokenizer(str, "-");
		int len = st.countTokens(); //�ڸ��� �ѱ� ���ڿ��� ����
		System.out.println("\n" + len);
		
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		
	}
}
