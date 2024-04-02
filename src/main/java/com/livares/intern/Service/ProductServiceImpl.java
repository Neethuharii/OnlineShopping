package com.livares.intern.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livares.intern.Model.Product;
import com.livares.intern.Model.User;
import com.livares.intern.Repository.ProductRepository;
import com.livares.intern.dto.ProductDto;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product>getAllProducts(){
		return productRepository.findAll();
		
	}
	@Override
	public Optional<Product>getProductById(Long id){
		return productRepository.findById(id);
		
	}
	@Override
	public Product saveProduct(ProductDto productDto) {
		
		Product newProduct = new Product();
		newProduct.setName(productDto.getName());
		newProduct.setDescription(productDto.getDescription());
		newProduct.setCategory(productDto.getCategory());
		newProduct.setImg(productDto.getImg());
		newProduct.setImg(productDto.getImg());
		
		return productRepository.save(newProduct);
		
	}
	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
