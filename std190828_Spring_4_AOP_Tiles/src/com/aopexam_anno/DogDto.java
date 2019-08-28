package com.aopexam_anno;

import lombok.Data;

@Data
public class DogDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	private String color;
	
	public void dogInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("컬러 : " + color );
	}
}
