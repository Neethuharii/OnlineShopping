package com.livares.intern.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livares.intern.dto.LoginResponse;
import com.livares.intern.dto.UserDTO;
import com.livares.intern.dto.UserLoginDTO;
import com.livares.intern.model.User;
import com.livares.intern.repository.UserRepository;
import com.livares.intern.response.CustomResponse;
import com.livares.intern.response.CustomResponseHandler;
import com.livares.intern.service.AuthenticationService;
import com.livares.intern.service.JwtService;
import com.livares.intern.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	
	
	


	@GetMapping("/users")
    public ResponseEntity<Object> getAllUsers() {
        List<User> users = userRepository.findAll();
//        return new ResponseEntity<>(users, HttpStatus.OK);
        return CustomResponseHandler.generateResponse("All User", HttpStatus.OK, users);
    }
	
	 @GetMapping("/getUserById/{id}")
	 public ResponseEntity<Object> getUserById(@PathVariable Long id) {
	        ResponseEntity<User> responseEntity = userService.getUserById(id);
	        return CustomResponseHandler.generateResponse("All user by id", HttpStatus.OK,responseEntity);
	    }



	@PostMapping("/createUser")
    public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO) {
        User createdUser = userService.saveUser(userDTO);
       // return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        return CustomResponseHandler.generateResponse("Created the User", HttpStatus.CREATED, createdUser);
    }
	//Delete a user by there id
	
	@DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return CustomResponseHandler.generateResponse("Not Found", HttpStatus.NO_CONTENT,id);
    }

	
	
	// Register a user
	
	 @PostMapping("/registerUser")
	    public ResponseEntity<Object> registerUser(@RequestBody UserDTO userDTO) {
	        String response = userService.registerUser(userDTO);
	        HttpStatus status = HttpStatus.CREATED; 
	        
	        if (response.equals("username is exists")) {
	            status = HttpStatus.CONFLICT;
	        }

	        return CustomResponseHandler.generateResponse("user is registered",HttpStatus.OK, status);
	    }
}