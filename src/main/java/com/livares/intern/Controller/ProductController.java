package com.livares.intern.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.livares.intern.dto.ProductDto;
import com.livares.intern.model.Product;
import com.livares.intern.repository.ProductRepository;
import com.livares.intern.response.ResponseHandler;
import com.livares.intern.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductRepository productRepository;
	
	//get all product
	
	 @GetMapping("/getAllProduct")
	    public ResponseEntity<Object> getAllProducts() {
	        List<Product> products = productService.getAllProducts();
	     
	        return ResponseHandler.generateResponse("All Product", HttpStatus.OK, products);
	    }
	 
	 //get all product by Category

	 @GetMapping("/getAllProductsByCategory")
	    public ResponseEntity<Object> getAllProductsByCategory() {
	        List<Product> products = productService.getAllProductsByCategory();
	      
	        return ResponseHandler.generateResponse("All Product By Category", HttpStatus.OK, products);
	    }
	 
	 //Get Product By Id
	 
	 @GetMapping("getProductById/{id}")
	    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
	        Product product = productService.getProductById(id);
	        if (product != null) {
	            return ResponseHandler.generateResponse("product exist",HttpStatus.OK,product);
	        } else {
	            return  ResponseHandler.generateResponse("product is not exist",HttpStatus.OK,product);
	        }
	    }

	 // create the product
	 
	 @PostMapping("/CREATED")
	    public ResponseEntity<Object> createProduct(@RequestBody ProductDto productDto) {
	        Product createdProduct = productService.saveProduct(productDto);
	       // return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
	        return ResponseHandler.generateResponse("created", HttpStatus.CREATED, createdProduct);
	    }

	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	        return  ResponseHandler.generateResponse("delete Product",HttpStatus.NO_CONTENT, id);
	    }
	
	 @GetMapping("/viewAllproductsByPage")
	    public ResponseEntity<Object> getAllProductsByPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
	        PageRequest pageRequest = PageRequest.of(page, size);
	        Page<Product> productPage = productRepository.findAll(pageRequest);
	      
	        return ResponseHandler.generateResponse("view product ",HttpStatus.OK,productPage);
	    }
	 
}
