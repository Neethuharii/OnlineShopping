package com.livares.intern.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.livares.intern.Model.Product;
import com.livares.intern.Model.User;
import com.livares.intern.Model.UserProductCart;
import com.livares.intern.Repository.ProductRepository;
import com.livares.intern.Repository.UserProductCartRepository;

@Service
public class UserProductCartServiceImpl implements UserProductCartService {

	@Autowired
	private UserProductCartRepository userProductCartRepository;

	@Autowired
	ProductRepository productRepo;

	@Override

	public List<UserProductCart> getAllUserProductCarts() {
		return userProductCartRepository.findAll();
	}

	public Optional<UserProductCart> getUserProductCartById(Long id) {
		return userProductCartRepository.findById(id);
	}

	public UserProductCart saveUserProductCart(UserProductCart userProductCart) {
		return userProductCartRepository.save(userProductCart);
	}

	public void deleteUserProductCart(Long id) {
		userProductCartRepository.deleteById(id);
	}

	public void addToCart(Long userId, Long productId) {
		User user = new User();
		user.setId(userId);

		Product product = new Product();
		product.setId(productId);

		UserProductCart userProductCart = new UserProductCart();
		userProductCart.setUser(user);
		userProductCart.setProduct(product);

		userProductCartRepository.save(userProductCart);
	}

	public List<Product> viewCart(Long userId) {
		return productRepo.findByUser(userId);
	}

	//remove from cart
	public void removeFromCart(Long productId) {
		userProductCartRepository.removeById(productId);
	}
}
