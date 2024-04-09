package com.livares.intern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.livares.intern.dto.UserLoginDTO;
import com.livares.intern.model.User;
import com.livares.intern.response.CustomResponseHandler;
import com.livares.intern.service.AuthenticationService;
import com.livares.intern.service.JwtService;

@RestController
public class LoginController {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private JwtService jwtService;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserLoginDTO userDto) {
		User authenticatedUser = authenticationService.authenticate(userDto);

		if (authenticatedUser != null) {
			String jwtToken = jwtService.generateToken(authenticatedUser);
			return CustomResponseHandler.generateResponse("Login successful", HttpStatus.OK, jwtToken);
		} else {
			return CustomResponseHandler.generateResponse("Invalid credentials", HttpStatus.UNAUTHORIZED, null);
		}
	}
}
