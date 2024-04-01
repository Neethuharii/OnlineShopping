package com.livares.intern.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
public class User {
 
	@Id
	@GeneratedValue(strategy =jakarta.persistence.GenerationType.IDENTITY)
	
	
	private Long id;
	private String firstName;
	private String lastName;
	  @Column(unique = true)
	private String userName;
	private String password;
	
	
}
