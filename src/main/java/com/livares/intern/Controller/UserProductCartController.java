package com.livares.intern.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.livares.intern.Model.Product;
import com.livares.intern.Model.UserProductCart;
import com.livares.intern.Service.UserProductCartServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userProductCarts")
public class UserProductCartController {

	@Autowired
	private UserProductCartServiceImpl userProductCartService;

	@GetMapping("/getAllProduct")
	public List<UserProductCart> getAllUserProductCarts() {
		return userProductCartService.getAllUserProductCarts();
	}

	@GetMapping("/getProductById/{id}")
	public Optional<UserProductCart> getUserProductCartById(@PathVariable Long id) {
		return userProductCartService.getUserProductCartById(id);
	}

	@PostMapping("/update")
	public UserProductCart saveUserProductCart(UserProductCart userProductCart) {
		return userProductCartService.saveUserProductCart(userProductCart);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUserProductCart(@PathVariable Long id) {
		userProductCartService.deleteUserProductCart(id);
	}

	@PostMapping("/addToCart")
	public void addToCart(@RequestParam Long userId, @RequestParam Long productId) {
		userProductCartService.addToCart(userId, productId);
	}

	@GetMapping("/getviewCartById/{id}")
	public List<Product> getViewCartById(@PathVariable Long id) {
		return userProductCartService.viewCart(id);
	}

}
