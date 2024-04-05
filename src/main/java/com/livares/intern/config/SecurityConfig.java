package com.livares.intern.config;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import com.livares.intern.model.User;

@Configuration
@EnableWebSecurity
/**=====================================================
 * Authorization
 =======================================================*/
public class SecurityConfig {
	
	@Autowired
	RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.authorizeHttpRequests(registry -> {
			registry.requestMatchers("/home").permitAll();
			registry.requestMatchers("/admin/**").hasRole("ADMIN");
			registry.requestMatchers("/user/**").hasRole("USER");
			registry.anyRequest().authenticated();

		}).httpBasic(auth->auth.authenticationEntryPoint(restAuthenticationEntryPoint))
                .build();
				//

	}
	
	/**==========================================================
	 * Authentication Credential for User and Admin 
	 * @return
	============================================================ */
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails normalUser = org.springframework.security.core.userdetails.User.builder()
			.username("neethuhari")
			.password("$2a$12$.5hZoFuhkJVgEw4y4EmCGOAal3t8LXZU1xGkr6SNPX0EUxcBzx.b2")
			.roles("ADMIN","USER")
			.build();
		
		UserDetails adminUser=org.springframework.security.core.userdetails.User.builder()
				.username("hari")
				.password("$2a$12$zDYHNuBTX2uZr5OLOFeoheu3plHYAMJaOhxNmWeZ67OiUYOqLAvwi")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(normalUser,adminUser);
		
	}
/**=========================================================================
 * Password Encryption
 * @return
 ===========================================================================*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
