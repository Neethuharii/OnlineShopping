package com.livares.intern.Model;

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
public class user {
 
	@Id
	@GeneratedValue(strategy =jakarta.persistence.GenerationType.IDENTITY)
	
	//User - id, firstName, lastName, username, password. 
	private Long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	
}
