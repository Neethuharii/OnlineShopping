package com.livares.intern.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.livares.intern.model.Product;
import com.livares.intern.model.User;
import com.livares.intern.model.UserProductCart;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT * FROM product p " + "JOIN category c ON p.category_id = c.id "
			+ "WHERE c.categoryName = :categoryName", nativeQuery = true)
	List<Product> findAllProductsByCategory(@Param("categoryName") String categoryName);

	@Query(value = "SELECT p.* from product p" + " JOIN user_product_cart upc ON p.id=upc.product_id"
			+ " join user u on u.id=upc.user_id where u.id=:userId", nativeQuery = true)
	List<Product> findByUser(@Param("userId") Long userId);
	
	Page<Product>findAll(Pageable pageable);
	
}
