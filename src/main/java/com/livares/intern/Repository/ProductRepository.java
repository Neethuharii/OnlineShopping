package com.livares.intern.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livares.intern.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	

}
