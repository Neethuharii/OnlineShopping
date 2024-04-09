package com.livares.intern.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.livares.intern.model.User;
import com.livares.intern.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
        User users = user.get();
        return org.springframework.security.core.userdetails.User.builder()
            .username(users.getUsername())
            .password(users.getPassword())
            .roles("USER")
            .build();

        } else {
            throw new UsernameNotFoundException("Not such user found!!");
        }

    }

}
