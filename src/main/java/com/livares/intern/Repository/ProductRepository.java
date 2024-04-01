package com.livares.intern.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livares.intern.Model.product;

public interface ProductRepository extends JpaRepository<product, Long>{
	

}
