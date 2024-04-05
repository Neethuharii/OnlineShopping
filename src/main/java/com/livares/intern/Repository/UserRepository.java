package com.livares.intern.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.livares.intern.dto.UserDTO;
import com.livares.intern.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	@Query(value = "SELECT * FROM User", nativeQuery = true)
	List<User> findAllUsers();

	Optional<User> findByUsername(String username);

	@Query("SELECT new com.livares.intern.dto.UserDTO(u.firstName,u.lastName) FROM User"
			+ " u WHERE u.username = :username")
	UserDTO getByUsername(@Param("username") String username);

}
