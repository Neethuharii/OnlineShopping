package com.livares.intern.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.livares.intern.Model.Product;
import com.livares.intern.dto.ProductDto;

public interface ProductService {

	public List<Product> getAllProducts();

	public Product getProductById(Long id);

	public Product saveProduct(ProductDto productDto);

	public void deleteProduct(Long id);

	public List<Product> getAllProductsByCategory();
	 public Page<Product> getAllProductsByPage(int page, int size) ;

}
