package com.livares.intern.Service;

import java.util.List;
import java.util.Optional;

import com.livares.intern.Model.Category;

public interface CategoryService {
	
	public List<Category> getAllCategories(); 
    public Optional<Category> getCategoryById(Long id); 
    public Category saveCategory(Category category);
    public void deleteCategory(Long id);
}
