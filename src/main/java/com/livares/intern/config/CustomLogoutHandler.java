package com.livares.intern.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.livares.intern.model.Token;
import com.livares.intern.repository.TokenRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class CustomLogoutHandler implements LogoutHandler {

    @Autowired
    TokenRepository tokenRepository;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }

        String token = authHeader.substring(7);
        Token storedToken = tokenRepository.findByToken(token).orElse(null);

        if (storedToken != null) {
            storedToken.setLoggedOut(true);
            tokenRepository.save(storedToken);
        }

    }

}