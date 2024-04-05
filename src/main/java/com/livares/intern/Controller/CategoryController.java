package com.livares.intern.controller;

import org.aspectj.weaver.patterns.IScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.livares.intern.exception.CustomException;
import com.livares.intern.exception.ErrorCode;
import com.livares.intern.model.Category;
import com.livares.intern.response.ResponseHandler;
import com.livares.intern.service.implementation.CategoryServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/getAllCategory")
    public ResponseEntity<Object> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
       
        return ResponseHandler.generateResponse("All Category", HttpStatus.OK, categories);
    }
    @GetMapping("/getCategoryById/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.getCategoryById(id);
        
        if (categoryOptional.isPresent()) {
            return ResponseHandler.generateResponse("category is present ", HttpStatus.OK, categoryOptional);
        } else {
        	return ResponseHandler.generateResponse("category is not present ", HttpStatus.OK, categoryOptional);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.saveCategory(category);
       
        return ResponseHandler.generateResponse("Created", HttpStatus.OK, createdCategory);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
     
        return ResponseHandler.generateResponse("Deleted category", HttpStatus.OK, id);
    }
}

