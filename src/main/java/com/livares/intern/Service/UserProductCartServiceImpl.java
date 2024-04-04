package com.livares.intern.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//	public List<UserProductCart> getAllUserProductCarts() {
//		return userProductCartRepository.findAll();
//	}
//
//	public Optional<UserProductCart> getUserProductCartById(Long id) {
//		return userProductCartRepository.findById(id);
//	}
//
//	public UserProductCart saveUserProductCart(UserProductCart userProductCart) {
//		return userProductCartRepository.save(userProductCart);
//	}

//	public void deleteUserProductCart(Long id) {
//		userProductCartRepository.deleteById(id);
//	}
	
//Add To Cart
	
	public ResponseEntity<Object> addToCart(Long userId, Long productId) {
        User user = new User();
        user.setId(userId);

        Product product = new Product();
        product.setId(productId);

        UserProductCart userProductCart = new UserProductCart();
        userProductCart.setUser(user);
        userProductCart.setProduct(product);

        userProductCartRepository.save(userProductCart);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
	
	//view Cart
	 public ResponseEntity<List<Product>> viewCart(Long userId) {
	        List<Product> products = productRepo.findByUser(userId);
	        if (!products.isEmpty()) {
	            return ResponseEntity.ok(products);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	    }

	//remove from cart
	  public ResponseEntity<Object> removeFromCart(Long productId) {
	        try {
	            userProductCartRepository.removeById(productId);
	            return ResponseEntity.ok("Product removed from cart successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to remove product from cart");
	        }
	    }
	@Override
	public void deleteUserProductCart(Long id) {
		// TODO Auto-generated method stub
		
	}
}
