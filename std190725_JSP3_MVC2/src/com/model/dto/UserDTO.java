package com.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private String id;
	private String name;
	private String address;
}

/*
 * CREATE TABLE CUSTOMERS_USER( 
 * 	ID VARCHAR2(50) PRIMARY KEY, 
 * 	NAME VARCHAR2(50) NOT NULL, 
 * 	ADDRESS VARCHAR2(50) NOT NULL 
 * );
 * 
 * SELECT * FROM CUSTOMERS_USER;
 */