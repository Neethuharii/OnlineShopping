package com.livares.intern.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.livares.intern.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	 @Query(value = "SELECT * FROM User", nativeQuery = true)
	    List<User> findAllUsers();

}
