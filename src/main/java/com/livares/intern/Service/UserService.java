package com.livares.intern.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livares.intern.Model.User;
import com.livares.intern.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User>getUserById(Long id){
		return userRepository.findById(id);
		
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	  public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }

}