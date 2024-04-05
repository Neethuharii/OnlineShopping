package com.livares.intern.model;

//import java.util.Locale.Category;

import org.hibernate.annotations.ManyToAny;
import org.springframework.context.annotation.Description;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product extends BaseEntity {

	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "image")
	private String img ;
	
	@ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
	private Category category; 
	
	@Column(name = "quantity")
	private int quantity;
	
	
	
}
