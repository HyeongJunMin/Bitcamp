package com.aopexam_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//java에서 xml 설정값을 가져오기 위한 코드
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("bean.xml");
		
		//bean.xml에서 생성된 객체를 취득하기 위한 코드
		CatDto myCat = ctx.getBean("myCat", CatDto.class);
		
		System.out.println(myCat);
		
		System.out.println("\n\n");
		
		myCat.catInfo();
		
		System.out.println("\n\n");
		
		CatDto myCat2 = new CatDto("애옹2", 1, "검정");
		myCat2.catInfo();
	}

}
