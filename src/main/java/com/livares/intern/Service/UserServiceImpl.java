package com.livares.intern.Service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	
	//get all user there id
	@Override
	 public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
	
	@Override
	public ResponseEntity<User> getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	//To register a user to a database

	@Override
	 public String registerUser(UserDTO userDTO) {
        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            return "username is exists";
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
	 public ResponseEntity<Void> deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
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
