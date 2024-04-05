package com.livares.intern.dto;

import com.livares.intern.model.Category;

import lombok.Data;

@Data

public class ProductDto {

	
	
	private String name;
	private String description;
	private Long categoryId;    
	private String img;
	private int quantity;
	
}
