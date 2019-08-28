package com.aopexam_anno;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass_anno {
	public static void main(String[] args) {
		//java에서 xml 설정값을 가져오기 위한 코드
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("bean_anno.xml");
		
		//bean.xml에서 생성된 객체를 취득하기 위한 코드
		DogDto myDog = ctx.getBean("myDog", DogDto.class);
				
		System.out.println(myDog);
		
		System.out.println("\n\n");
		
		myDog.dogInfo();
	}
}	
