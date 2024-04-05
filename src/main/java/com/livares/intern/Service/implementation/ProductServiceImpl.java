package com.livares.intern.service.implementation;

import java.util.List;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.livares.intern.dto.ProductDto;
import com.livares.intern.exception.CustomException;
import com.livares.intern.exception.ErrorCode;
import com.livares.intern.model.Category;
import com.livares.intern.model.Product;
import com.livares.intern.repository.CategoryRepository;
import com.livares.intern.repository.ProductRepository;
import com.livares.intern.response.ResponseHandler;
import com.livares.intern.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<Product>getAllProducts(){
		return productRepository.findAll();
		
	}
	public List<Product>getAllProductsByCategory(){
//		return productRepository.findAllProductsByCategory();
		return null;
	}
	
	
	@Override
	public Product getProductById(Long id){
		return productRepository.findById(id).get();
		
	}
	@Override
	public Product saveProduct(ProductDto productDto) {
		
		Category category = categoryRepository.findById(productDto.getCategoryId()).get();
		
		Product newProduct = new Product();
		newProduct.setName(productDto.getName());
		newProduct.setDescription(productDto.getDescription());
		newProduct.setImg(productDto.getImg());
		newProduct.setCategory(category);
		
		return productRepository.save(newProduct);
	}
	
		 public Page<Product> getAllProductsByPage(int page, int size) {
		        PageRequest pageRequest = PageRequest.of(page, size);
		        return productRepository.findAll(pageRequest);
		    
	}
		  public ResponseEntity<Object> deleteProduct(Long id) {
		        try {
		            productRepository.deleteById(id);
		            return ResponseHandler.generateResponse("Deleted", HttpStatus.NO_CONTENT, id);
		        } catch (Exception e) {
		            throw new CustomException(ErrorCode.NOT_FOUND, "Failed to delete product with ID: " + id);
		        }
		    }
}
