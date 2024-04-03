package com.livares.intern.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.livares.intern.Model.User;
import com.livares.intern.dto.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT * FROM User", nativeQuery = true)
	List<User> findAllUsers();

	Optional<User> findByUsername(String username);

	@Query("SELECT new com.livares.intern.dto.UserDTO(u.firstName,u.lastName) FROM User"
			+ " u WHERE u.username = :username")
	UserDTO getByUsername(@Param("username") String username);

}
