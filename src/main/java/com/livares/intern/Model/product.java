package com.livares.intern.Model;

import org.springframework.context.annotation.Description;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Product - id, name, desc, price, categoryId, img, quantity
	private Long id;
	private String name;
	private String description;
	private int categoryId;     //Foreignkey 
	private int img;
	private int quantity;
	
	
}
