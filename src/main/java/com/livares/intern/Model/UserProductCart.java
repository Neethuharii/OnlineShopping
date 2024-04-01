package com.livares.intern.Model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class UserProductCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//UserProductCart - id, userId, productId
	private Long id;
	
	 @ManyToAny
	  @JoinColumn(name = "user_id")
	private User user;  
	 
	 @ManyToAny
	    @JoinColumn(name = "product_id")
	private Product product; 

}
