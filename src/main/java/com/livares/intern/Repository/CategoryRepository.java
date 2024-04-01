package com.livares.intern.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livares.intern.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}