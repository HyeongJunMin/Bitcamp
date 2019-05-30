package std190530_OOP2_STATIC;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class Lct1OOP2 {
	public static void main(String[] args) {
		
		//기본적인 객체 생성과 메소드 호출 방법
		MyClass1 mycls = new MyClass1();
		mycls.method();
		mycls.function();
		
		//작업량이 많다면? class내에 static 메소드 활용
		MyClass1 mycls2 = MyClass1.getInstance();
		mycls2.function();
		
		//class array
		YouClass[] arrY = new YouClass[5];
		List<YouClass> lstY = new ArrayList<>();
		
//		for(YouClass y : arrY)
//			y = new YouClass();
		
		//배열 각 요소에 객체 생성
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
			member[i].setName("사랑"+i);
		}
		
		for (int i = 0; i < member.length; i++) {
			System.out.println(member[i].toString());
		}
			
		
	}
}
