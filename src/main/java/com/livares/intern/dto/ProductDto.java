package com.livares.intern.dto;

import com.livares.intern.Model.Category;

import lombok.Data;

@Data

public class ProductDto {

	
	
	private String name;
	private String description;
	
	
	private Category category;    
	private int img;
	private int quantity;
	
}
