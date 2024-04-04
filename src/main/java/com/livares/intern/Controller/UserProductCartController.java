package com.livares.intern.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.livares.intern.Model.Product;
import com.livares.intern.Model.UserProductCart;
import com.livares.intern.Service.UserProductCartServiceImpl;
import com.livares.intern.response.ResponseHandler;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userProductCarts")
public class UserProductCartController {

	@Autowired
	private UserProductCartServiceImpl userProductCartService;

//	@GetMapping("/getAllProduct")
//	public List<UserProductCart> getAllUserProductCarts() {
//		return userProductCartService.getAllUserProductCarts();
//	}
//
//	@GetMapping("/getProductById/{id}")
//	public Optional<UserProductCart> getUserProductCartById(@PathVariable Long id) {
//		return userProductCartService.getUserProductCartById(id);
//	}
//
//	@PostMapping("/update")
//	public UserProductCart saveUserProductCart(UserProductCart userProductCart) {
//		return userProductCartService.saveUserProductCart(userProductCart);
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public void deleteUserProductCart(@PathVariable Long id) {
//		userProductCartService.deleteUserProductCart(id);
//	}
	 
	 
	 @PostMapping("/addtocart")
	    public ResponseEntity<Object> addToCart(@RequestParam Long userId, @RequestParam Long productId) {
	        userProductCartService.addToCart(userId, productId);
	        return ResponseHandler.generateResponse("Product added to cart successfully", HttpStatus.CREATED, productId);
	    }


	   @GetMapping("/getviewCartById/{id}")
	    public ResponseEntity<Object> getViewCartById(@PathVariable Long id) {
	        ResponseEntity<List<Product>> response = userProductCartService.viewCart(id);
	        
	        return ResponseHandler.generateResponse("view cart by id",HttpStatus.OK, response);
	    }
	 
	   @DeleteMapping("/removeFromCart/{productId}")
	    public ResponseEntity<Object> removeFromCart(@PathVariable Long productId) {
	        return userProductCartService.removeFromCart(productId);
	    }

}
