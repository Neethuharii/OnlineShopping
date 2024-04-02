package com.livares.intern.Service;

import java.util.List;
import java.util.Optional;

import com.livares.intern.Model.Product;
import com.livares.intern.dto.ProductDto;

public interface ProductService {
	
	public List<Product>getAllProducts();
	public Optional<Product>getProductById(Long id);
	public Product saveProduct(ProductDto productDto);
	public void deleteProduct(Long id) ;
		
}
