package com.livares.intern.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livares.intern.Model.Product;
import com.livares.intern.Service.ProductService;
import com.livares.intern.dto.ProductDto;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/getAllProduct")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();

	}

	@GetMapping("/getAllProductsByCategory")
	public List<Product> getAllProductsByCategory() {
		return productService.getAllProductsByCategory();

	}

	@GetMapping("getProductById/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	@PostMapping("/update")
	public Product createProduct(@RequestBody ProductDto productDto) {
		return productService.saveProduct(productDto);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
