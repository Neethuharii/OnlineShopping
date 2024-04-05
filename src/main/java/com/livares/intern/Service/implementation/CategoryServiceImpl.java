package com.livares.intern.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livares.intern.exception.CustomException;
import com.livares.intern.exception.ErrorCode;
import com.livares.intern.model.Category;
import com.livares.intern.repository.CategoryRepository;
import com.livares.intern.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories() {
        return categoryRepository.findAllCategories();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
    
    @Override
    public void deleteCategory(Long id) {
        Optional<Category> categoryid = categoryRepository.findById(id);
       if(categoryid.isPresent()){
        categoryRepository.deleteById(id);
       }else {
           throw new CustomException(ErrorCode.NOT_FOUND,"This "+id+" not found");
       }
    }
}
