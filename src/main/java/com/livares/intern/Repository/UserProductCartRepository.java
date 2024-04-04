package com.livares.intern.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.livares.intern.Model.User;
import com.livares.intern.Model.UserProductCart;

public interface UserProductCartRepository extends JpaRepository<UserProductCart, Long>{
	
	List<UserProductCart>findByUser(User user);
	void removeById(long productId);
}
