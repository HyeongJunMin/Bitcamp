package com.dto;


import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeMenuDTO {
	private int seq;
	private String name;
	private int priceShort;
	private int priceTall;
	private int priceGrande;
}
