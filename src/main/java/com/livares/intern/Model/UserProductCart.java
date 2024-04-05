package com.livares.intern.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserProductCart extends BaseEntity{
	
	
	@ManyToOne
	@JoinColumn(name = "user_id",referencedColumnName = "id")
	private User user;  
	@OneToOne
	@JoinColumn(name = "product_id",referencedColumnName = "id")
	private Product product; 

}
