package com.livares.intern.Service;

import java.util.List;
import java.util.Optional;

import com.livares.intern.Model.User;
import com.livares.intern.dto.UserDTO;

public interface UserService {

	public List<User> getAllUsers();

	public Optional<User> getUserById(Long id);

	public User saveUser(UserDTO userDTO);

	public void deleteUser(Long id);
}
