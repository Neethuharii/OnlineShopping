package com.livares.intern.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.livares.intern.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

    @Query(value = "SELECT * FROM product p "
    		+ "JOIN category c ON p.category_id = c.id "
    		+ "WHERE c.categoryName = :categoryName", nativeQuery = true)
    List<Product> findAllProductsByCategory(@Param("categoryName") String categoryName);
}

