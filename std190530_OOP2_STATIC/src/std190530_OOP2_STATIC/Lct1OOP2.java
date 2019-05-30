package std190530_OOP2_STATIC;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class Lct1OOP2 {
	public static void main(String[] args) {
		
		//�⺻���� ��ü ������ �޼ҵ� ȣ�� ���
		MyClass1 mycls = new MyClass1();
		mycls.method();
		mycls.function();
		
		//�۾����� ���ٸ�? class���� static �޼ҵ� Ȱ��
		MyClass1 mycls2 = MyClass1.getInstance();
		mycls2.function();
		
		//class array
		YouClass[] arrY = new YouClass[5];
		List<YouClass> lstY = new ArrayList<>();
		
//		for(YouClass y : arrY)
//			y = new YouClass();
		
		//�迭 �� ��ҿ� ��ü ����
		for(int i = 0 ; i < arrY.length ; i++ )
			arrY[i] = new YouClass();
		
		arrY[0].setNumber(0);
		arrY[0].method();
		
		lstY.add(new YouClass());
		System.out.println(lstY.toString());
		
		MemberVo[] member = new MemberVo[3];
		for (int i = 0; i < member.length; i++) {
			member[i] = new MemberVo();
			member[i].setAge((int) (Math.random()*9 )+10);
			member[i].setName("���"+i);
		}
		
		for (int i = 0; i < member.length; i++) {
			System.out.println(member[i].toString());
		}
			
		
	}
}
