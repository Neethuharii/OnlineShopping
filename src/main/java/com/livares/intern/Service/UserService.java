package com.livares.intern.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.livares.intern.Model.User;
import com.livares.intern.dto.UserDTO;

@Service
public interface UserService {

	 public ResponseEntity<List<User>> getAllUsers();

		public ResponseEntity<User> getUserById(Long id);

	public User saveUser(UserDTO userDTO);

	 public ResponseEntity<Void> deleteUser(Long id);
	 
	public String registerUser(UserDTO userDTO);
		
}
