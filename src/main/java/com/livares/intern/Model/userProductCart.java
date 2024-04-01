package com.livares.intern.Model;

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
public class userProductCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//UserProductCart - id, userId, productId
	private Long id;
	private Long userId;    //ForeignKey
	private Long productId; //ForeignKey

}
