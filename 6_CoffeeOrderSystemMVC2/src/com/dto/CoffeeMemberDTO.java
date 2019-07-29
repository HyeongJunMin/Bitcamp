package com.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeMemberDTO {
	private String id;
	private String pw;
	private String name;
	private int age;
	private Date reg_date;
	private int auth;
}
