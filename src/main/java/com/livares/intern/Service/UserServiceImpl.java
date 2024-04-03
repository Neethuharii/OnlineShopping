package com.livares.intern.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.livares.intern.Model.User;
import com.livares.intern.Repository.UserRepository;
import com.livares.intern.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);

	}
	//To register a user to a database

	@Override
	public String registerUser(UserDTO userDTO) {

		if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
			return "username is  exists";
		}
		User newUser = new User();
		newUser.setFirstName(userDTO.getFirstName());
		newUser.setLastName(userDTO.getLastName());
		newUser.setUsername(userDTO.getUsername());
		newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));

		userRepository.save(newUser);
		return "User Created!!";
	}

	//For delete the user
	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User saveUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public User saveUser(UserDTO userDTO) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
