package com.livares.intern.Model;

import java.util.Locale.Category;

import org.hibernate.annotations.ManyToAny;
import org.springframework.context.annotation.Description;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Product - id, name, desc, price, categoryId, img, quantity
	private Long id;
	private String name;
	private String description;
	
	@ManyToAny
    @JoinColumn(name = "category_id")
	private Category category;    
	private int img;
	private int quantity;
	
	
}
