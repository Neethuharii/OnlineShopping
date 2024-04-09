package com.livares.intern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.livares.intern.dto.UserDTO;
import com.livares.intern.dto.UserLoginDTO;

@Service
public class AuthenticationService {

    @Autowired
    com.livares.intern.repository.UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    public com.livares.intern.model.User authenticate(UserLoginDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(input.getUsername(), input.getPassword()));

        return userRepository.findByUsername(input.getUsername()).orElseThrow();
    }

}