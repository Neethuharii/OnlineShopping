package com.livares.intern.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.livares.intern.dto.ProductDto;
import com.livares.intern.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public Product getProductById(Long id);

	public Product saveProduct(ProductDto productDto);

	public List<Product> getAllProductsByCategory();

	public Page<Product> getAllProductsByPage(int page, int size);

	public ResponseEntity<Object> deleteProduct(Long id);

}
