package com.livares.intern.Service;

import java.util.List;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.livares.intern.Model.Category;
import com.livares.intern.Model.Product;
import com.livares.intern.Repository.CategoryRepository;
import com.livares.intern.Repository.ProductRepository;
import com.livares.intern.dto.ProductDto;

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
	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
