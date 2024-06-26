package com.livares.intern.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.livares.intern.model.User;
import com.livares.intern.model.UserProductCart;

public interface UserProductCartRepository extends JpaRepository<UserProductCart, Long>{
	
	List<UserProductCart>findByUser(User user);

	void removeById(Long productId);
	
	
}
